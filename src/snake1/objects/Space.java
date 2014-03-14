package snake1.objects;

import snake1.data.Arena;

import java.awt.*;

public class Space extends GameObject {

    public final static Space INSTANCE = new Space();

    private Space() {
        super(Color.WHITE);

    }

    public int getX() {
        throw new UnsupportedOperationException("Space does not have a position");
    }

    public int getY() {
        throw new UnsupportedOperationException("Space does not have a position");
    }

    @Override
    public void event(Arena arena) {

    }

    @Override
    public void collide(Snake snake) {
        snake.moveTail();
    }
}
