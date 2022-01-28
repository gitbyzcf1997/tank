package tank.cor;

import tank.GameObject;
import tank.Square;
import tank.Tank;

/**
 *调停者(Media)
 * @Auther:ZhenCF
 * @Date: 2022-01-28-18:47
 * @Description: tank.cor
 * @version: 1.0
 */
public class SquareTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Square && o2 instanceof Tank){
            Square square = (Square) o1;
            Tank tank = (Tank) o2;
            if(square.getRect().intersects(tank.getRect())){
                tank.resetXY();
            }
        }else if(o1 instanceof Tank &&o2 instanceof Square){
            collide(o2,o1);
        }
        return true;
    }
}
