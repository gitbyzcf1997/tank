package tank;

import util.Audio;
import util.PropertMgr;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-24-21:40
 * @Description: tank
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        new Thread(()->{new Audio("audio/war1.wav").loop();}).start();
        while (true){
            Thread.sleep(500);
            tankFrame.repaint();
        }
    }
}
