package tank.observer;

import java.io.Serializable;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-30-23:44
 * @Description: tank.observer
 * @version: 1.0
 */
public interface FireObserver extends Serializable {
    void fire(FireEvent e);
}
