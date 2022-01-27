package tank.cor;

import tank.Bullet;
import tank.Explode;
import tank.GameObject;
import tank.Tank;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-28-4:53
 * @Description: tank.cor
 * @version: 1.0
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet&&o2 instanceof Tank){
            Tank tank=(Tank)o2;
            Bullet bullet=(Bullet) o1;
            if(collideWith(bullet,tank)){
                return false;
            };
        }else if(o1 instanceof Tank&&o2 instanceof Bullet){
           return collide(o2,o1);
        }
        return true;
    }
    private boolean collideWith(Bullet bullet,Tank tank){
        if(bullet.getGroup()==tank.getGroup())return false;
        //TODO：用一个rect来记录子弹的位置
        //判断是否相交
        if(tank.getRect().intersects(bullet.getRect())){
            tank.die();
            bullet.die();
            int ex=tank.getX()+Tank.WIDTH /2-Explode.WIDTH/2;
            int ey=tank.getY()+Tank.HEIGHT /2-Explode.HEIGHT/2;
            bullet.getGm().add(new Explode(ex,ey,bullet.getGm()));
            return true;
        }
        return false;
    }
}
