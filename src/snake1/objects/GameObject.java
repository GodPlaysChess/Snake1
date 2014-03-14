package snake1.objects;

import snake1.data.Arena;
import snake1.data.GameData;

import java.awt.*;

public abstract class GameObject {
    protected int x;
    protected int y;
    private Color color;

    public GameObject(Color color) {
        this.color = color;
        this.x = (int) (Math.random() * GameData.MAP_LENGTH);
        this.y = (int) (Math.random() * GameData.MAP_WIDTH);
    }

    public abstract void event(Arena arena);

    public abstract void collide(Snake snake);

    protected Color findColor() {
        return color.brighter().brighter();
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(Arena.ALIGN_X + x * 15, Arena.ALIGN_Y + y * 15, 15, 15);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void incX() {
        x++;
       /* if (x == Arena.getSizeX()) {
            x = 0;
        }*/
    }

    protected void decX() {
        x--;
      /*  if (x == -1) {
            x = Arena.getSizeX() - 1;
        }*/
    }

    protected void incY() {
        y++;
     /*   if (y == Arena.getSizeY()) {
            y = 0;
        }*/
    }

    protected void decY() {
        y--;
        /*if (y == -1) {
            y = Arena.getSizeY() - 1;
        }*/
    }
}
