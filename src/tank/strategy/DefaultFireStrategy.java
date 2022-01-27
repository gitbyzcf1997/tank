package tank.strategy;

import tank.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-26-22:11
 * @Description: tank.strategy
 * @version: 1.0
 */
public class DefaultFireStrategy implements FireStrategy {
    private static final  DefaultFireStrategy INSTANCE=new DefaultFireStrategy();

    private DefaultFireStrategy() {
    }

    @Override
    public void fire(Tank t) {
        int bX=t.getX()+Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY=t.getY()+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        new Bullet(bX,bY,t.getDir(),t.getTf(),t.getGroup());
        //if(t.getGroup()==Group.GOOD)new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public static DefaultFireStrategy getINSTANCE() {
        return INSTANCE;
    }
}
