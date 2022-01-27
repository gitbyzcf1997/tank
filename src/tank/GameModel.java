package tank;

import util.PropertMgr;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-28-3:25
 * @Description: tank
 * @version: 1.0
 */
public class GameModel {
    //主坦克
    Tank myTank=new Tank(200,400,Dir.DOWN,this,Group.GOOD);
    //Explode e=new Explode(100,100,this);
    //爆炸合集
    public List<Explode> explodes=new ArrayList<>();
    //子弹合集
    public List<Bullet> bulletList=new ArrayList<>();
    //敌方坦克
    public List<Tank> tanks=new ArrayList<>();
    public ExecutorService executor = Executors.newFixedThreadPool(16);
    public Tank getMainTank() {
        return this.myTank;
    }

    private static class GameModelHandle{
        static final GameModel INSTANCE=new GameModel();
    }
    private GameModel() {
        int initTankCount= PropertMgr.getInstance().getInt("initTankCount");
        //初始化敌方坦克
        for(int i=0;i<initTankCount;i++){
            this.tanks.add(new Tank((i*ResourceMgr.badtankU.getWidth())*2,150,Dir.DOWN,this,Group.BAD));
        }
    }
    public static GameModel getINSTANCE() {
        return GameModelHandle.INSTANCE;
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:"+bulletList.size(),10,60);
        g.drawString("敌人的数量:"+tanks.size(),10,80);
        g.setColor(c);
        //Graphics 画笔类
        //填充一个矩形
        if(myTank!=null){
            myTank.paint(g);
        }
        for(int i=0;i<bulletList.size();i++){
            bulletList.get(i).paint(g);
        }
        for(int i=0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }
        for(int i=0;i<bulletList.size();i++){
            for(int j=0;j<tanks.size();j++) {
                bulletList.get(i).collideWith(tanks.get(j));
            }
        }
        for (int i=0;i<explodes.size();i++){
            explodes.get(i).paint(g);
        }
    }
}
