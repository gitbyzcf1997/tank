package tank.strategy;

import tank.Tank;

import java.io.Serializable;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-26-22:10
 * @Description: tank.strategy
 * @version: 1.0
 */
public interface   FireStrategy  extends Serializable {
    void fire(Tank t);
}
