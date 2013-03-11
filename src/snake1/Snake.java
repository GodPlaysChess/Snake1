package snake1;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake extends RandomlyLocatedObject {
    private int direction = KeyEvent.VK_0;
    private int last_direction;
    private int traceX;
    private int traceY;

    private boolean is_destroyed = false;
    private boolean stopped = false;


    private ArrayList<Integer> snakeposX = new ArrayList<Integer>();
    private ArrayList<Integer> snakeposY = new ArrayList<Integer>();

    public Snake(int maxX, int maxY, Map m) {                                              //Creating head and writing the snake position into an array
        super(maxX, maxY, m);
        snakeposX.add(getX());
        snakeposY.add(getY());
    }

    private void setStateCollision() {
        is_destroyed = true;
    }

    public void stop() {
        stopped = true;
    }

    public void move() {
        if (direction - last_direction != 2 && direction - last_direction != -2) {           //Prevents the snake to make pi-turns
            _move(direction);
        } else _move(last_direction);
    }

    private void _move(int direction) {
        if (!stopped) {
            switch (direction) {                                           //Moving the head
                case KeyEvent.VK_UP:
                    decY();
                    break;
                case KeyEvent.VK_DOWN:
                    incY();
                    break;
                case KeyEvent.VK_LEFT:
                    decX();
                    break;
                case KeyEvent.VK_RIGHT:
                    incX();
                    break;
            }
            last_direction = direction;

            if (direction != KeyEvent.VK_0) {                                                              //Shifting the whole snake
                update_pos();
            }
        }

    }

    public void tracksnake() {
        map.setPoint(getX(), getY(), Map.SNAKE_HEAD);

        for (int i = 1; i < snakeposX.size(); i++) {                           //was 0 without head
            map.setPoint(snakeposX.get(i), snakeposY.get(i), Map.SNAKE);
        }
        map.setPoint(traceX, traceY, 0);

    }

    private void update_pos() {
        traceY = snakeposY.get(snakeposX.size() - 1);                                  //Last position goes to buffer, to set it to 0 inside the map
        traceX = snakeposX.get(snakeposX.size() - 1);
        if (snakeposX.size() > 1) {
            for (int i = snakeposX.size() - 1; i > 0; i--) {
                snakeposX.set(i, snakeposX.get(i - 1));
                snakeposY.set(i, snakeposY.get(i - 1));
            }
        }
        snakeposX.set(0, getX());
        snakeposY.set(0, getY());

    }

    public void maybeEat(Apple a) {
        if (getX() == a.getX() && getY() == a.getY()) {
            snakeposX.add(traceX);
            snakeposY.add(traceY);
            a.setEaten();
        }
    }


    public void destroy() {
        is_destroyed = true;
    }

    public boolean isDestroyed() {
        return is_destroyed;
    }

    public void setDirection(int keyCode) {
        direction = keyCode;
    }

    public void checkSelfDesctruction() {
        if (map.getPoint(getX(), getY()) == Map.WALL) {
            destroy();
        }

        if (snakeposX.size() > 1) {
            for (int i = 1; i < snakeposX.size(); i++) {
                if (getX() == snakeposX.get(i) && getY() == snakeposY.get(i))
                    destroy();
            }
        }
    }
}
