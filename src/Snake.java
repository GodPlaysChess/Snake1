import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake extends Object {
    int direction = KeyEvent.VK_0;
    int last_direction;
    private int tail;
    int traceX;
    int traceY;

    boolean isdestroyed = false;
    private boolean stopped = false;


    ArrayList<Integer> snakeposX = new ArrayList<Integer>();
    ArrayList<Integer> snakeposY = new ArrayList<Integer>();

    Snake(int maxX, int maxY, Map m) {                                              //Creating head and writing the snake position into an array
        super(maxX, maxY, m);
        tail = 1;
        snakeposX.add(x);
        snakeposY.add(y);
    }

    private void setStateCollision() {
        isdestroyed = true;
    }

    public void stop(){
        stopped = true;
    }

    void increaseTail() {
        tail++;
    }

    int getTail() {
        return tail;
    }


    void move(int direction) {
        if (!stopped){
        switch (direction) {                                           //Moving the head
            case KeyEvent.VK_UP:
                y--;
                break;
            case KeyEvent.VK_DOWN:
                y++;
                break;
            case KeyEvent.VK_LEFT:
                x--;
                break;
            case KeyEvent.VK_RIGHT:
                x++;
                break;
            case KeyEvent.VK_X:
                destroy();
                break;
            case KeyEvent.VK_0:
                break;


        }
        last_direction = direction;

        if (direction != KeyEvent.VK_0) {                                                              //Shifting the whole snake
            update_pos();
        }
        }

    }

    private void update_pos() {
        traceY = snakeposY.get(tail - 1);                                  //Last position goes to buffer, to set it to 0 inside the map
        traceX = snakeposX.get(tail - 1);
        if (tail > 1) {
            for (int i = tail - 1; i > 0; i--) {
                snakeposX.set(i, snakeposX.get(i - 1));
                snakeposY.set(i, snakeposY.get(i - 1));
            }
        }
        snakeposX.set(0, x);
        snakeposY.set(0, y);

    }

    void manger(Apple a) {
        increaseTail();
        snakeposX.add(traceX);
        snakeposY.add(traceY);
        a.setEaten();
    }


    public void destroy() {
        isdestroyed = true;
    }

}
