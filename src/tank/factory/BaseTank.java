package tank.factory;

import tank.Dir;
import tank.strategy.FourDirFireStrategy;

import java.awt.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-27-21:11
 * @Description: tank.factory
 * @version: 1.0
 */
public abstract class BaseTank{
    public abstract void paint(Graphics g);

    public abstract void setMoving(boolean b);

    public abstract void setDir(Dir left);

    public abstract void fire();

    public abstract void setFireStrategy(FourDirFireStrategy instance);
}
