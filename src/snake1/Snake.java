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
        if (!stopped) {
            if (direction - last_direction != 2 && direction - last_direction != -2) {           //Prevents the snake to make pi-turns
                _move(direction);
            } else _move(last_direction);
        }
    }

    public void move2() {
        if (!stopped) {
            if (direction - last_direction != 4 && direction - last_direction != -4 && direction - last_direction != 3 && direction - last_direction != -3) {           //Prevents the snake to make pi-turns
                _move(direction);
            } else _move(last_direction);
        }
    }

    private void _move(int direction) {

        switch (direction) {                                           //Moving the head
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                decY();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                incY();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                decX();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                incX();
                break;
        }
        last_direction = direction;

        if (direction != KeyEvent.VK_0) {                                                              //Shifting the whole snake
            update_pos();
        }


    }

    public void tracksnake(Map m) {

        map.setPoint(getX(), getY(), m.SNAKE_HEAD);

        for (int i = 1; i < snakeposX.size(); i++) {                           //was 0 without head
            m.setPoint(snakeposX.get(i), snakeposY.get(i), Map.SNAKE);
        }
        m.setPoint(traceX, traceY, 0);

    }

    public void tracksnake2(Map m) {

        map.setPoint(getX(), getY(), m.SNAKE2_HEAD);

        for (int i = 1; i < snakeposX.size(); i++) {                           //was 0 without head
            m.setPoint(snakeposX.get(i), snakeposY.get(i), Map.SNAKE2);
        }
        m.setPoint(traceX, traceY, 0);

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
        if (direction != KeyEvent.VK_0 && DestructionConditions() && stopped == false)
            destroy();
    }

    public void MakeTomb(Map m) {
        m.setPoint(getX(), getY(), Map.WALL);
        if (snakeposX.size() > 1) {
            for (int i = 1; i < snakeposX.size(); i++) {
                m.setPoint(snakeposX.get(i), snakeposY.get(i), Map.SPACE);
            }
        }
        m.setPoint(traceX, traceY, 0);
    }

    private boolean DestructionConditions() {
        if (map.getPoint(getX(), getY()) == Map.WALL)
            return true;
        if (map.getPoint(getX(), getY()) == Map.SNAKE)
            return true;
        if (map.getPoint(getX(), getY()) == Map.SNAKE2)
            return true;
        if (map.getPoint(getX(), getY()) == Map.SNAKE2_HEAD)
            return true;
        if (map.getPoint(getX(), getY()) == Map.SNAKE_HEAD)
            return true;

        else return false;
    }


}

