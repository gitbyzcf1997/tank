package tank.cor;

import tank.GameObject;
import tank.Tank;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-28-5:09
 * @Description: tank.cor
 * @version: 1.0
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank&& o2 instanceof Tank){
            Tank t1=(Tank)o1;
            Tank t2=(Tank)o2;
            if(t1.getRect().intersects(t2.getRect())){
                t1.resetXY();
                t2.resetXY();
            }
        }
        return true;
    }
}
