package tank;



import util.Audio;

import java.awt.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-26-3:45
 * @Description: tank
 * @version: 1.0
 */

/**
 * 爆炸效果类
 */
public class Explode  extends GameObject{
    //图片宽高
    public static int WIDTH=ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT=ResourceMgr.explodes[0].getHeight();
    //坐标
    private int x,y;
    private boolean living=true;
    private int step=0;
    public Thread audio=null;
    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
       if(audio==null) {
            GameModel.getINSTANCE().executor.submit(()->{new Audio("audio/explode.wav").play();});
        }
        GameModel.getINSTANCE().add(this);
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step>=ResourceMgr.explodes.length)GameModel.getINSTANCE().remove(this);
    }
}
