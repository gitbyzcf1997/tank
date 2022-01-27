package tank.factory;

import tank.Dir;
import tank.Group;
import tank.TankFrame;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-27-21:09
 * @Description: tank.factory
 * @version: 1.0
 */

/***
 * 抽象的游戏工厂
 */
public abstract class  GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y,Dir dir, TankFrame tf,Group group);
}
