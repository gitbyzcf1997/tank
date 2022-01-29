package tank.decorator;

import tank.GameObject;

import java.awt.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-29-19:57
 * @Description: tank.decorator
 * @version: 1.0
 */
public abstract class GODecorator extends GameObject {
    GameObject go;
    public GODecorator(GameObject go){
        this.go=go;
    }
    @Override
    public abstract void paint(Graphics g);

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
