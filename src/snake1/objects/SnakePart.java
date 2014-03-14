package snake1.objects;

import snake1.data.Arena;

import java.awt.*;

public class SnakePart extends GameObject {

    public SnakePart(int x, int y, Color color) {
        super(color);
        this.x = x;
        this.y = y;
    }

    public void set(int newX, int newY) {
        x = newX;
        y = newY;
    }

    @Override
    public void event(Arena arena) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void collide(Snake snake) {
        snake.destroy();
    }
}
