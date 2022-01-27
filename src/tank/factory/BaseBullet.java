package tank.factory;

import tank.Tank;

import java.awt.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-27-21:14
 * @Description: tank.factory
 * @version: 1.0
 */

/**
 * 抽象的产品
 * 具体产品继承此类
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(Tank tank);
}
