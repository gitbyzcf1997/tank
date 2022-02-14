package tank;

import tank.cor.ColliderChain;
import util.PropertMgr;

import java.awt.*;
import java.io.*;
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
    Tank myTank;
    //游戏元素集合
    private List<GameObject> objects=new ArrayList<>();
    ColliderChain colliderChain=new ColliderChain();
    public ExecutorService executor = Executors.newFixedThreadPool(16);

    private static class GameModelHandle{
        private final static GameModel INSTANCE=new GameModel();
    }
    private GameModel() {
    }
    //初始化元素
    public void initialize(){
        myTank=new Tank(200,400,Dir.DOWN,this,Group.GOOD);
        int initTankCount= PropertMgr.getInstance().getInt("initTankCount");
        int initSquareCount= PropertMgr.getInstance().getInt("initSquareCount");
        //初始化敌方坦克
        for(int i=0;i<initTankCount;i++){
            new Tank((i*ResourceMgr.badtankU.getWidth())*2,150,Dir.DOWN,this,Group.BAD);
        }
        //初始墙体
        for(int i=0;i<initSquareCount;i++){
            new Wall((i*80*2),300);
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

    public List<GameObject> getObjects() {
        return objects;
    }
    public void save(){
        File file = new File("c:/zcf/tank.data");
        ObjectOutputStream oos=null;
        try {
             oos=new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(myTank);
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try{
                    oos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void load() {
        File file = new File("c:/zcf/tank.data");
        ObjectInputStream ois=null;
        try{
            ois=new ObjectInputStream(new FileInputStream(file));
            myTank=(Tank)ois.readObject();
            objects=(List)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
