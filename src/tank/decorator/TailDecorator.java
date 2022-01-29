package tank.decorator;

import tank.GameObject;

import java.awt.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-29-19:59
 * @Description: tank.decorator
 * @version: 1.0
 */
public class TailDecorator extends GODecorator {

    public TailDecorator(GameObject go) {
        super(go);
    }
    @Override
    public void paint(Graphics g){
        this.x=go.x;
        this.y=go.y;
        //因为父类聚合了GameObject
        go.paint(g);

        //画想要的装饰
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawLine(super.go.x,super.go.y,super.go.x+super.getWidth(),super.go.y+super.getHeight());
        g.setColor(c);
    }
}
