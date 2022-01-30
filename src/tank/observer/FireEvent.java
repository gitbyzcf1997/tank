package tank.observer;

import java.util.Date;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-30-23:42
 * @Description: tank.observer
 * @version: 1.0
 */
public class FireEvent {
    long fireTimeout;
    Object source;
    public FireEvent(long fireTimeout, Object source) {
        this.fireTimeout = fireTimeout;
        this.source = source;
    }

    public long getFireTimeout() {
        return fireTimeout;
    }

    public Object getSource() {
        return source;
    }
}
