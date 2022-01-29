package tank.decorator;

import tank.GameObject;

import java.awt.*;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-29-19:59
 * @Description: tank.decorator
 * @version: 1.0
 */
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }
    @Override
    public void paint(Graphics g){
        //因为子弹的x，y是动态的 需要时刻更新x，y
        this.x=go.x;
        this.y=go.y;
        //因为父类聚合了GameObject
        go.paint(g);

        //画想要的装饰
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(go.x,go.y,getWidth()+2,getHeight()+2);
        g.setColor(c);
    }
}
