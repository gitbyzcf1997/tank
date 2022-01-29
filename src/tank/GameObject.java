package tank;

import java.awt.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-28-4:19
 * @Description: tank
 * @version: 1.0
 */
public abstract class GameObject {
    //TODO：需要加入一些常量了
    public int x,y;
    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}
