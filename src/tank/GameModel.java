package tank;

import tank.cor.BulletTankCollider;
import tank.cor.Collider;
import tank.cor.ColliderChain;
import tank.cor.TankTankCollider;
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
    //游戏元素集合
    private List<GameObject> objects=new ArrayList<>();
    ColliderChain colliderChain=new ColliderChain();
    public ExecutorService executor = Executors.newFixedThreadPool(16);
    private static class GameModelHandle{

        static final GameModel INSTANCE=new GameModel();
    }
    private GameModel() {
        int initTankCount= PropertMgr.getInstance().getInt("initTankCount");
        //初始化敌方坦克
        for(int i=0;i<initTankCount;i++){
            this.add(new Tank((i*ResourceMgr.badtankU.getWidth())*2,150,Dir.DOWN,this,Group.BAD));
        }
    }
    public static GameModel getINSTANCE() {
        return GameModelHandle.INSTANCE;
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量:"+bulletList.size(),10,60);
//        g.drawString("敌人的数量:"+tanks.size(),10,80);
        g.setColor(c);
        //Graphics 画笔类
        //填充一个矩形
        if(myTank!=null){
            myTank.paint(g);
        }
        for(int i=0;i<objects.size();i++){
            objects.get(i).paint(g);
        }
//        for(int i=0;i<bulletList.size();i++){
//            for(int j=0;j<tanks.size();j++) {
//                bulletList.get(i).collideWith(tanks.get(j));
//            }
//        }
        //互相碰撞
        for(int i=0;i<objects.size();i++){
            for(int j=i+1;j<objects.size();j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1,o2);
            }
        }
    }
    public Tank getMainTank() {
        return this.myTank;
    }
    public void add(GameObject go){
        this.objects.add(go);
    }
    public void remove(GameObject go){
        this.objects.remove(go);
    }
}
