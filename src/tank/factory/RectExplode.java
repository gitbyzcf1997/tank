package tank.factory;

import tank.Audio;
import tank.ResourceMgr;
import tank.TankFrame;

import java.awt.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-27-21:38
 * @Description: tank.factory
 * @version: 1.0
 */
public class RectExplode extends BaseExplode {
    //图片宽高
    public static int WIDTH=ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT=ResourceMgr.explodes[0].getHeight();
    //坐标
    private int x,y;
    private boolean living=true;
    TankFrame tf=null;
    private int step=0;
    public Thread audio=null;
    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        if(audio==null) {
            tf.executor.submit(()->{new Audio("audio/explode.wav").play();});
        }
    }
    @Override
    public void paint(Graphics g){
        //g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillRect(x,y,10*step,10*step);
        step++;
        if(step>=15)tf.explodes.remove(this);
        g.setColor(c);
    }
}
