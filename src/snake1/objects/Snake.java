package snake1.objects;

import snake1.data.Map;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.PriorityQueue;
import java.util.Queue;

public class Snake extends GameObject {
    private int direction = KeyEvent.VK_0;
    private int lastDirection;

    private boolean isDestroyed = false;
    private boolean isStopped = false;

    //private ArrayList<SnakePart> tail = new ArrayList<>();
    private Queue<SnakePart> tail = new PriorityQueue<>();

    public Snake(Color color) {
        super();
        this.color = color;
    }

    public void stop() {
        isStopped = true;
    }

    public void move() {
        if (!isStopped) {
            if (direction - lastDirection != 2 && direction - lastDirection != -2) {           //Prevents the snake to make pi-turns
                moveTo(direction);
            } else moveTo(lastDirection);
        }
    }

    public void moveSecondPlayer() {
        if (!isStopped) {
            if (direction - lastDirection != 4 && direction - lastDirection != -4
                    && direction - lastDirection != 3 && direction - lastDirection != -3) {           //Prevents the snake to make pi-turns
                moveTo(direction);
            } else moveTo(lastDirection);
        }
    }

    private void moveTo(int direction) {

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
            default:
                //
        }
        lastDirection = direction;

        if (direction != KeyEvent.VK_0) {                                                              //Shifting the whole snake
            updateTailPosition();
        }

    }

    private void updateTailPosition() {
        if (tail.size() > 0) {
            tail.add(tail.peek().set(x, y));
        }
        move();
    }

/*    public void maybeEat(Apple a) {
        if (getX() == a.getX() && getY() == a.getY()) {
            snakeposX.add(traceX);
            snakeposY.add(traceY);
            a.setEaten();
        }
    }*/


    public void destroy() {
        isDestroyed = true;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDirection(int keyCode) {
        direction = keyCode;
    }

    private void checkCollision() {
        if (direction != KeyEvent.VK_0 && destructionConditions() && !isStopped) {
            destroy();
        }
    }

    public void makeTomb(Map m) {
        m.setPoint(x, y, Map.WALL);
        if (snakeposX.size() > 1) {
            for (int i = 1; i < snakeposX.size(); i++) {
                m.setPoint(snakeposX.get(i), snakeposY.get(i), Map.SPACE);
            }
        }
        m.setPoint(traceX, traceY, 0);
    }

    private boolean destructionConditions() {
        if (map.getPoint(getX(), getY()) == Map.WALL) {
            return true;
        }
        if (map.getPoint(getX(), getY()) == Map.SNAKE) {
            return true;
        }
        if (map.getPoint(getX(), getY()) == Map.SNAKE2) {
            return true;
        }
        if (map.getPoint(getX(), getY()) == Map.SNAKE2_HEAD) {
            return true;
        }
        if (map.getPoint(getX(), getY()) == Map.SNAKE_HEAD) {
            return true;
        }

        return false;
    }


    @Override
    public void event() {
        move();
        checkCollision(); // <-wall/apple/snake
    }
}

