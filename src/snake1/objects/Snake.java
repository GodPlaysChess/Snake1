package snake1.objects;

import snake1.data.Arena;
import snake1.data.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.PriorityQueue;
import java.util.Queue;

public class Snake extends GameObject {

    private Direction direction = Direction.HOLD;
    private Direction lastDirection = Direction.HOLD;
    private boolean isDestroyed = false;

    private Queue<SnakePart> tail = new PriorityQueue<>();
    private int traceX = x;
    private int traceY = y;

    public Snake(Color color) {
        super(color);
    }

    public void stop() {
        direction = Direction.HOLD;
    }

    private void moveHead() {
        if (direction != Direction.HOLD) {
            if (direction == Direction.DOWN && lastDirection == Direction.UP ||
                    direction == Direction.UP && lastDirection == Direction.DOWN ||
                    direction == Direction.LEFT && lastDirection == Direction.RIGHT ||
                    direction == Direction.RIGHT && lastDirection == Direction.LEFT) {
                moveTo(lastDirection);
            } else {
                moveTo(direction);
            }
        }
    }

    private void moveTo(Direction direction) {
        switch (direction) {                                           //Moving the head
            case UP:
                decY();
                break;
            case DOWN:
                incY();
                break;
            case LEFT:
                decX();
                break;
            case RIGHT:
                incX();
                break;
            default:
                //
        }
        lastDirection = direction;
    }

    public void moveTail() {
        if (direction != Direction.HOLD && tail.size() > 0) {
            SnakePart movedPart = tail.poll();
            movedPart.set(traceX, traceY);
            tail.add(movedPart);
        }
    }

    public void eat() {
        //add a new tail part in the end of the queue. Tail itself does not moveHead. Head moves.
        tail.add(new SnakePart(traceX, traceY, findColor()));
    }


    public void destroy() {
        isDestroyed = true;
    }

    public void setDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                direction = Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                direction = Direction.DOWN;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                direction = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                direction = Direction.RIGHT;
                break;
            default:
        }
    }

    public void makeTomb(Arena arena) {
        arena.setPoint(x, y, Wall.INSTANCE);
        for (SnakePart sp : tail) {
            arena.setPoint(sp.getX(), sp.getY(), Wall.INSTANCE);
        }
    }

    @Override
    public void event(Arena arena) {
        moveHead();
        arena.getPoint(x, y).collide(this);
        traceX = x;
        traceY = y;
        if (isDestroyed) {
            makeTomb(arena);
        }
    }

    @Override
    public void collide(Snake snake) {
        snake.destroy();
        snake.stop();
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
}

