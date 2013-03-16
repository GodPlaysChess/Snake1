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
    private Snake snake2 = null;
    private Apple apple = null;
    private GameSettings game = null;

    private boolean is_running = true;
    private boolean is_gameover = false;
    private boolean next_level_accepted = false;

    private Score score = new Score();

    public Screen(String s, int gametype) {         //Graphics
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

        game = new GameSettings(gametype);
        map = new Map(length, width, Main.level);
        if (Main.level>2)
            game.timer_off=false;
        snake = new Snake(length, width, map);
        apple = new Apple(length, width, map);

        if (gametype == Main.DUEL)
            snake2 = new Snake(length, width, map);



    }

    public void gameloop() {
        while (is_running) {

            snake.tracksnake(map);                                  //tracking the objects (writing the positions to the map Array
            snake.move();

            if (snake2 != null) {
                snake2.tracksnake2(map);
                snake2.move2();
            }

            apple.decTime();

            if (!game.timer_off)
                apple.CheckTimer(map);

            snake.checkSelfDesctruction();
            snake.maybeEat(apple);

            if (snake2 != null) {
                snake2.checkSelfDesctruction();
                snake2.maybeEat(apple);
            }

            if (game.gametype != Main.DUEL) {
                if (snake.isDestroyed()) {
                    Main.lives--;
                    if (Main.lives <= 0)
                        is_gameover = true;
                    else
                        ressurect();
                }
            }

            if (snake2 != null) {
                if (snake.isDestroyed()) {
                    score.p2wins = true;
                    snake.stop();
                    snake2.stop();
                    is_gameover=true;
                }
                if (snake2.isDestroyed()) {
                    score.p1wins = true;
                    snake.stop();
                    snake2.stop();
                    is_gameover=true;
                }
            }


            if (apple.Is_dead()) {
                apple = new Apple(length, width, map);
            }


            if (apple.isEaten()) {
                apple = new Apple(length, width, map);
                score.incValue();
                if (game.speed < game.speedlimit)
                    game.speed++;                       //  <-  making it faster

                if (score.getValue() % 5 == 0)
                    map.createWalls(game.wallrate);
            }

            if (is_gameover)
                snake.stop();

            if (score.NextLevelCondition(Main.level))
                GoToNextLevel();

            renderScreen();

            try {
                Thread.sleep((long) (1130 / Math.sqrt(game.speed) - 100));                 //(6.13 / Math.sqrt(speed) - 0.2)  Thread.sleep(2000l / speed);
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
                Main.lives = 3;
                Main.level = 1;
                break;
            case KeyEvent.VK_SPACE:
                if (next_level_accepted) {
                    is_running = false;
                    Main.restart_request = true;
                }
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                if (snake2 != null)
                    snake2.setDirection(e.getKeyCode());
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

            if (!game.timer_off)
                apple.ShowTime(g);


            if (game.gametype != Main.DUEL && is_gameover)
                score.ShowGamoverScreen(g);

            if (game.gametype == Main.DUEL && is_gameover)
                score.ShowDuelScreen(g);

            if (next_level_accepted) {
                score.setValue();
                score.ShowWinScreen(g);
            }

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
            Main.lives = 3;
            Main.level = 1;
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

    }

    private void ressurect() {
        snake.stop();
        snake.MakeTomb(map);
        snake = new Snake(length, width, map);
        game.speed = game.inspeed;
    }


}


