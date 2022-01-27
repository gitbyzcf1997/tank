package tank;

import tank.strategy.DefaultFireStrategy;
import tank.strategy.FireStrategy;
import tank.strategy.FourDirFireStrategy;
import util.PropertMgr;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-24-23:32
 * @Description: tank
 * @version: 1.0
 */

/***
 * 坦克类  提供属性和方法
 */
public class Tank {
    //坐标
    private int x,y;
    //方向
    private Dir dir=Dir.DOWN;
    //移动速度
    private int SPEED=5;
    //移动状态： true 移动 false 停止
    private boolean moving=true;
    //窗口
    private  TankFrame tf=null;
    public static  int WIDTH =ResourceMgr.goodtankU.getWidth();
    public static int HEIGHT =ResourceMgr.goodtankU.getHeight();
    //存活
    private boolean liveing=true;
    //随机数
    private Random random=new Random();
    private Audio tank_move=new Audio("audio/tank_move.wav");
    //那一方的
    private Group group=Group.BAD;
    //默认开火方式
    private FireStrategy fireStrategy=DefaultFireStrategy.getINSTANCE();
    private Rectangle rect=new Rectangle();
    int count=0;
    public ExecutorService executor;
    public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
        this.group=group;
        rect.x=x;
        rect.y=y;
        rect.width= WIDTH;
        rect.height= HEIGHT;
        SPEED=PropertMgr.getInt("tankSpeed");
    }

    /***
     * 画图方法
     * @param g 画笔
     */
    public void paint(Graphics g) {
        if(!liveing){
            tf.tanks.remove(this);
        }
        //获取原先画笔的颜色
        Color c = g.getColor();
        //将画笔的颜色改为黄色
        g.setColor(Color.yellow);
        //画一个矩形
        //g.fillRect(x,y,50,50);//坐标 和宽度高度
        //根据方向获取图片
        BufferedImage image=inDirGetImage(dir);
        WIDTH =image.getWidth();
        HEIGHT =image.getHeight();
        //画图片
        g.drawImage(image,x,y,null);
        //将画笔还原为原先的颜色
        g.setColor(c);
        move();

    }

    private BufferedImage inDirGetImage(Dir dir) {
        BufferedImage image=null;
            switch (dir) {
                case LEFT:
                    image = this.group==Group.BAD?ResourceMgr.badtankL:ResourceMgr.goodtankL;
                    break;
                case UP:
                    image = this.group==Group.BAD?ResourceMgr.badtankU:ResourceMgr.goodtankU;
                    break;
                case RIGHT:
                    image = this.group==Group.BAD?ResourceMgr.badtankR:ResourceMgr.goodtankR;
                    break;
                case DOWN:
                    image = this.group==Group.BAD?ResourceMgr.badtankD:ResourceMgr.goodtankD;
                    break;
            }
        return image;
    }

    /**
     * 移动方法
     */
    private void move() {
       // if(!liveing)return;
        //如果移动状态为停止 直接返回不做任何动作
        if(!moving)return;
        //根据方向状态进行移动
        switch (dir){
            case LEFT:x=x-SPEED;break;
            case UP:y=y-SPEED;break;
            case RIGHT:x=x+SPEED;break;
            case DOWN:y=y+SPEED;break;
        }

        //update rect:
        rect.x=this.x;
        rect.y=this.y;

        if(this.group==Group.BAD&&random.nextInt(100)>95)this.fire();
        randomDir();
        boundsCheck();
        count++;
        if(this.getGroup()==Group.GOOD&&count>3){
            tf.executor.submit(()->{new Audio("audio/tank_move.wav").play();});
            count=0;
        }
    }

    private void boundsCheck() {
        if(this.x<0)x=0;
        if(this.y<Tank.HEIGHT -2) y=Tank.HEIGHT -2;
        if(this.x>TankFrame.GAMEWIDTH-Tank.WIDTH -2) x=TankFrame.GAMEWIDTH-Tank.WIDTH -2;
        if(this.y>TankFrame.GAMEHEIGHT-Tank.HEIGHT -2)y=TankFrame.GAMEHEIGHT-Tank.HEIGHT -2;
    }

    private void randomDir() {
        if(this.group==Group.GOOD)return;
        if(random.nextInt(100)>95){
            this.dir =Dir.values()[random.nextInt(4)];
        }
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void fire() {
        //if(!liveing)return;
        //tf.bulletList.add(new Bullet(this.x+ WIDTH /2, this.y+ HEIGHT /2, this.dir,tf,group));
        fireStrategy.fire(this);
        if(this.getGroup()==Group.GOOD){
            tf.executor.submit(()->{new Audio("audio/tank_fire.wav").play();});
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSPEED() {
        return SPEED;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    public int getImageWidth() {
        return WIDTH;
    }

    public void setImageWidth(int imageWidth) {
        this.WIDTH = imageWidth;
    }

    public int getImageHeight() {
        return HEIGHT;
    }

    public void setImageHeight(int imageHeight) {
        this.HEIGHT = imageHeight;
    }

    public void die() {
        this.liveing=false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRect() {
        return rect;
    }

    public FireStrategy getFireStrategy() {
        return fireStrategy;
    }

    public void setFireStrategy(FireStrategy fireStrategy) {
        this.fireStrategy = fireStrategy;
    }
}
