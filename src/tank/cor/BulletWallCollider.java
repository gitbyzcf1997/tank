package tank.cor;

import tank.Bullet;
import tank.GameObject;
import tank.Group;
import tank.Wall;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-29-17:53
 * @Description: tank.cor
 * @version: 1.0
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet) o1;
            Wall wall=(Wall)o2;
            if(bullet.getGroup()== Group.GOOD)return true;
            if(bullet.getRect().intersects(wall.getRect())){
                bullet.die();
                return false;
            }
        }else if(o1 instanceof Wall && o2 instanceof Bullet){
           return collide(o2,o1);
        }
        return true;
    }
}
