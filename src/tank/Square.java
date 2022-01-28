package tank;

import util.PropertMgr;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-28-18:33
 * @Description: tank
 * @version: 1.0
 */
public class Square extends GameObject {
    private int x,y;
   // private int WIDTH=ResourceMgr.square.getWidth();
    //private int HEIGHT=ResourceMgr.square.getHeight();
    private int WIDTH=50;
    private int HEIGHT=50;
    private Rectangle rect=new Rectangle();
    @Override
    public void paint(Graphics g) {
        BufferedImage square = ResourceMgr.square;
        Color c = g.getColor();
        g.drawImage(square,x,y,WIDTH,HEIGHT,null);
    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        rect.x=x;
        rect.y=y;
        rect.width=WIDTH;
        rect.height=HEIGHT;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void setHeight(int height) {
        HEIGHT = height;
    }

    public Rectangle getRect() {
        return rect;
    }
}
