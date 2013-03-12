package snake1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

public class Screen extends JFrame implements KeyListener, ActionListener, MouseListener {
    private int length = 60;
    private int width = 40;

    private Map map = null;
    private Snake snake = null;
    private Apple apple = null;
    private boolean is_running = true;
    private boolean is_gameover = false;
    private boolean next_level_accepted = false;
    private boolean go_further = false;


    private int speed = 40;                             //level hardness mostly
    private Score score = new Score();

    // private int level = 1;

    public Screen(String s, int level) {         //Graphics
        super(s);
        setSize(1224, 708);
        setLocation(300, 120);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createBufferStrategy(2);


        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        //interaction with user

        map = new Map(length, width, level);
        snake = new Snake(length, width, map);
        apple = new Apple(length, width, map);
    }

    public void gameloop() {
        while (is_running) {
            snake.tracksnake(map);                                   //tracking the objects (writing the positions to the map Array

            snake.move();

            //check for events : Collision / Manger

            snake.checkSelfDesctruction();
            snake.maybeEat(apple);

            if (snake.isDestroyed())
                is_gameover = true;

            if (apple.isEaten()) {
                apple = new Apple(length, width, map);
                score.incValue();
                if (speed < 100)
                    speed++;                       //  <-  making it faster

                if (score.getValue() % 5 == 0)
                    map.createWalls(10);
            }

            if (is_gameover)
                snake.stop();

            if (score.NextLevelCondition(Main.level))
                GoToNextLevel();


            renderScreen();


            try {
                Thread.sleep(2000l / speed);
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e)              // keys changed direction
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                snake.setDirection(e.getKeyCode());
                break;
            case KeyEvent.VK_X:
                snake.destroy();
                break;
            case KeyEvent.VK_R:
                is_running = false;
                Main.restart_request = true;
                break;
            case KeyEvent.VK_SPACE:
                if (next_level_accepted) {
                    is_running = false;
                    Main.restart_request = true;
                }
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void renderScreen() {
        BufferStrategy bf = this.getBufferStrategy();
        Graphics2D g = null;

        try {
            g = (Graphics2D) bf.getDrawGraphics();
            map.draw(g);
            score.DrawScore(g);

            if (is_gameover) {
                score.ShowGamoverScreen(g);
            }


            if (next_level_accepted)
                score.ShowWinScreen(g);


          /*  if (score.NextLevelCondition(Main.level)) {
                score.ShowWinScreen(g);
            } */

        } finally {
            // It is best to dispose() a Graphics object when done with it.
            if (g != null) {
                g.dispose();
            }
        }

        bf.show();
        Toolkit.getDefaultToolkit().sync();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() >= 975 && e.getX() < 1187 && e.getY() > 570 && e.getY() < 620) {
            is_running = false;
            Main.restart_request = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void GoToNextLevel() {
        snake.stop();
        Main.level++;
        next_level_accepted = true;


      /* while (!go_further) {
            if (go_further)
                Main.next_level_request = true;
                is_running = false;
            Main.restart_request = true;
        }
        */
    }


}


