package tank.strategy;

import tank.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-26-22:40
 * @Description: tank.strategy
 * @version: 1.0
 */
public class FourDirFireStrategy implements FireStrategy {
    private static final FourDirFireStrategy INSTANCE=new FourDirFireStrategy();

    private FourDirFireStrategy() {
    }

    @Override
    public void fire(Tank t) {
        int bX=t.getX()+Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY=t.getY()+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        Dir[] dis = Dir.values();
        for (Dir dir : dis) {
            new Bullet(bX,bY, dir,t.getTf(),t.getGroup());
        }

        //if(t.getGroup()==Group.GOOD)new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public static FourDirFireStrategy getINSTANCE() {
        return INSTANCE;
    }
}
