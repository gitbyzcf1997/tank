package tank.factory;

import tank.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-27-21:16
 * @Description: tank.factory
 * @version: 1.0
 */

/***
 * 默认的游戏工厂
 * 默认的游戏元素的创建在此
 */
public class DefalutFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x,y,dir,tf,group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y,Dir dir, TankFrame tf,Group group)
    {
        return new Bullet(x,y,dir,tf,group);
    }
}
