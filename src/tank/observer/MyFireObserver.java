package tank.observer;

import tank.GameModel;
import tank.Group;
import tank.Tank;
import tank.strategy.DefaultFireStrategy;
import tank.strategy.FourDirFireStrategy;

import java.util.Date;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-30-23:46
 * @Description: tank.observer
 * @version: 1.0
 */
public class MyFireObserver implements FireObserver {
    @Override
    public void fire(FireEvent e) {
        int size = GameModel.getINSTANCE().getObjects().size();
        if(e.getSource() instanceof Tank){
            Tank myTank = (Tank) e.getSource();
            if(myTank.getGroup()==Group.GOOD&& size>15){
                FourDirFireStrategy fourDirFireStrategy = FourDirFireStrategy.getINSTANCE();
                myTank.setFireStrategy(fourDirFireStrategy);
                myTank.fire();
            }else{
                DefaultFireStrategy defaultFireStrategy = DefaultFireStrategy.getINSTANCE();
                myTank.setFireStrategy(defaultFireStrategy);
                myTank.fire();
            }
        }
    }
}
