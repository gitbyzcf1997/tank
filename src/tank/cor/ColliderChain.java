package tank.cor;

import tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-28-5:43
 * @Description: tank.cor
 * @version: 1.0
 */

/**
 * 责任链
 */
public class ColliderChain implements Collider{
    private List<Collider> colliders=new LinkedList<>();
    public void add(Collider collider){
        colliders.add(collider);
    }

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for(int i=0;i<colliders.size();i++){
            if(!colliders.get(i).collide(o1,o2))return false;
        }
        return true;
    }
}
