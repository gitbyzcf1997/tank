package tank.factory;

import tank.Bullet;
import tank.Dir;
import tank.Group;
import tank.TankFrame;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-27-21:37
 * @Description: tank.factory
 * @version: 1.0
 */
public class RectFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x,y,dir,tf,group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y,Dir dir, TankFrame tf,Group group) {
        return new RectFBullet(x,y,dir,tf,group);
    }
}
