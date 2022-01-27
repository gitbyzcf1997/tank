package tank.cor;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-28-4:49
 * @Description: tank.cor
 * @version: 1.0
 */

import tank.GameObject;

/**
 * 碰撞器
 * 负责两个物体间的碰撞
 */
public interface Collider {
    void collide(GameObject o1,GameObject o2);
}
