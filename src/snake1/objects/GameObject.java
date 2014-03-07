package snake1.objects;

import snake1.data.Map;

import java.awt.*;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected Color color;
    protected GameObjectType type;

    public GameObjectType getType() {
        return type;
    }

    public abstract void event();

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(Map.ALIGN_X + x * 15, Map.ALIGN_Y + y * 15, 15, 15);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void incX() {
        x++;
        if (x == Map.getSizeX()) {
            x = 0;
        }
    }

    protected void decX() {
        x--;
        if (x == -1) {
            x = Map.getSizeX() - 1;
        }
    }

    protected void incY() {
        y++;
        if (y == Map.getSizeY()) {
            y = 0;
        }
    }

    protected void decY() {
        y--;
        if (y == -1) {
            y = Map.getSizeY() - 1;
        }
    }
}
