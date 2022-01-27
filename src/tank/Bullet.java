package tank;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-25-0:29
 * @Description: tank
 * @version: 1.0
 */

/**
 * 普通子弹类  提供子弹的属性和方法
 */
public class Bullet  extends GameObject{
    //移动速度
    private static final int SPEED=10;
    //坐标
    private int  x,y;
    //方向
    private Dir dir;
    //存活状态 true 存在 false 消失
    private boolean liveing=true;
    //图片宽高
    public static int WIDTH =ResourceMgr.bulletU.getWidth();
    public static int HEIGHT =ResourceMgr.bulletU.getHeight();
    //rect
    private Rectangle rect=new Rectangle();
    private Group group=Group.BAD;
    private GameModel gm;
    public Bullet(int x, int y, Dir dir,GameModel gm,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm=gm;
        this.group=group;
        rect.x=x;
        rect.y=y;
        rect.width= WIDTH;
        rect.height= HEIGHT;
        gm.add(this);
    }

    /***
     * 画图
     * @param g 画笔
     */
    public void paint(Graphics g) {
        //判断子弹是否存在
        if(!liveing){
            //如果不存在删除子弹
            gm.remove(this);
        }
        //获取画笔原先颜色
        Color c=g.getColor();
        //设置画笔颜色为红色
        g.setColor(Color.RED);
        //画一个圆
        //g.fillOval(x,y,WIGHT,HEIGHT);//坐标 和宽度高度
        //根据方向获取图片
        BufferedImage image=inDirGetImage(dir);
        WIDTH =image.getWidth();
        HEIGHT =image.getHeight();
        //画图片
        g.drawImage(image,x,y,null);
        //移动
        move();
    }

    /**
     * 移动方法
     * 根据方向状态进行移动
     */
    private void move() {
        switch (dir){
            case LEFT:x-=SPEED;break;
            case UP:y-=SPEED;break;
            case RIGHT:x+=SPEED;break;
            case DOWN:y+=SPEED;break;
        }
        //update rect:
        rect.x=x;
        rect.y=y;

        //如果子弹移出窗口就被销毁 画笔不在进行绘制此子弹
        if(x<0||y<0||x>TankFrame.GAMEWIDTH||y>TankFrame.GAMEHEIGHT)liveing=false;
    }
    private BufferedImage inDirGetImage(Dir dir) {
        BufferedImage image=null;
        switch (dir){
            case LEFT: image = ResourceMgr.bulletL;break;
            case UP: image = ResourceMgr.bulletU;break;
            case RIGHT: image = ResourceMgr.bulletR;break;
            case DOWN: image = ResourceMgr.bulletD;break;
        }
        return image;
    }

    /**
     * 碰撞检测
     * @param tank
     */
    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup())return;
        //TODO：用一个rect来记录子弹的位置
        //判断是否相交
        if(tank.getRect().intersects(this.rect)){
            tank.die();
            this.die();
            int ex=tank.getX()+Tank.WIDTH /2-Explode.WIDTH/2;
            int ey=tank.getY()+Tank.HEIGHT /2-Explode.HEIGHT/2;
            gm.add(new Explode(ex,ey,gm));
        }
    }

    public void die() {
        this.liveing = false;
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

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public GameModel getGm() {
        return gm;
    }
}
