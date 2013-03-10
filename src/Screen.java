import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

public class Screen extends JFrame implements KeyListener, ActionListener, MouseListener {

    int length = 60;
    int width = 40;

    Map map = new Map(length, width, 1);
    Snake snake = new Snake(length, width, map);
    Apple apple = new Apple(length, width, map);


    private boolean actiondone = false;
    private boolean cycledone = false;
    public static boolean restart_request = true;


    int speed = 60;                             //level hardness mostly
    Timer timer = new Timer(speed, this);
    Score score = new Score();

    Screen(String s, int level) {         //Graphics

        super(s);
        setSize(1224, 708);
        setLocation(300, 120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createBufferStrategy(2);


        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        //interaction with user


        while (!restart_request) {
            gameloop();

        }
    }

    private void gameloop() {

        timer.setInitialDelay(speed);
        timer.start();

        map.trackapple(apple);
        map.tracksnake(snake);                                   //tracking the objects (writing the positions to the map Array

        if (!actiondone) {
            if (snake.direction - snake.last_direction != 2 && snake.direction - snake.last_direction != -2)           //Prevents the snake to make pi-turns
                snake.move(snake.direction);                            //Events log
            else snake.move(snake.last_direction);
            actiondone = true;

        }

        //check for events : Collision / Manger
        map.event_check(snake, apple);

        if (apple.iseaten) {
            apple = new Apple(length, width, map);
            score.incValue();
            if (speed > 20)
                speed--;                       //  <-  making it faster

            if (score.value % 5 == 0)
                map.create_walls(10);
        }


        renderMap();
        if (cycledone) {
            cycledone = false;
            actiondone = false;
            timer.setInitialDelay(speed);
            timer.restart();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent e)              // keys changed direction
    {
        int x = e.getKeyCode();
        if (x == KeyEvent.VK_UP || x == KeyEvent.VK_DOWN || x == KeyEvent.VK_LEFT || x == KeyEvent.VK_RIGHT || x == KeyEvent.VK_X)
            snake.direction = e.getKeyCode();
        if (x == KeyEvent.VK_R)
            restart_request = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cycledone = true;

    }

    private void renderMap() {
        BufferStrategy bf = this.getBufferStrategy();
        Graphics2D g = null;

        try {
            g = (Graphics2D) bf.getDrawGraphics();
            map.draw(g);
            score.DrawScore(g);

        } finally {
            if (map.gamover) {
                snake.stop();
                score.ShowGamoverScreen(g);
            }

            if (map.nextlevel){
                snake.stop();
                score.ShowWinScreen(g);
            }
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getX() >= 975 && e.getX() < 1187 && e.getY() > 570 && e.getY() < 620)
            restart_request = true;

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
