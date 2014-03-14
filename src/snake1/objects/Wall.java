package snake1.objects;

import snake1.data.Arena;

import java.awt.*;

public class Wall extends GameObject {

    public static Wall INSTANCE = new Wall();

    private Wall() {
        super(Color.DARK_GRAY);
    }

    @Override
    public void event(Arena arena) {
    }

    @Override
    public void collide(Snake snake) {
        snake.destroy();
    }

}

