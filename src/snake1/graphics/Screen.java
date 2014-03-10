package snake1.graphics;

import snake1.data.Map;
import snake1.general.Main;
import snake1.objects.Apple;
import snake1.objects.GameObject;
import snake1.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.List;

public class Screen extends JFrame implements KeyListener, ActionListener, MouseListener {
    private int length = 60;
    private int width = 40;

    private Map map = null;
    private Snake snake = null;
    private Snake snake2 = null;
    private Apple apple = null;

    private boolean isRunning = true;
    private boolean isGameOver = false;
    private boolean nextLevelAccepted = false;

    private Score score = new Score();

    public Screen(String s) {         //Graphics
        super(s);
        setSize(1224, 708); //check for resoluion;
        setLocation(300, 120);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createBufferStrategy(2);

        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    public void gameloop() {
        while (isRunning) {

            snake.tracksnake(map);                                  //tracking the objects (writing the positions to the map Array
            snake.move();

            if (snake2 != null) {
                snake2.tracksnake2(map);
                snake2.moveSecondPlayer();
            }

            snake.checkCollision();
            snake.maybeEat(apple);

            if (snake2 != null) {
                snake2.checkCollision();
                snake2.maybeEat(apple);
            }

            if (game.gametype != Main.DUEL) {
                if (snake.isDestroyed()) {
                    Main.lives--;
                    if (Main.lives <= 0)
                        isGameOver = true;
                    else
                        resurrect();
                }
            }

            if (snake2 != null) {
                if (snake.isDestroyed()) {
                    score.p2wins = true;
                    snake.stop();
                    snake2.stop();
                    isGameOver = true;
                }
                if (snake2.isDestroyed()) {
                    score.p1wins = true;
                    snake.stop();
                    snake2.stop();
                    isGameOver = true;
                }
            }

            if (apple.isDead()) {
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

            if (isGameOver)
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
                isRunning = false;
                Main.restartRequest = true;
                Main.lives = 3;
                Main.level = 1;
                break;
            case KeyEvent.VK_SPACE:
                if (nextLevelAccepted) {
                    isRunning = false;
                    Main.restartRequest = true;
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

    public void render(Map map) {
        BufferStrategy bf = this.getBufferStrategy();
        Graphics2D g = null;

        try {
            g = (Graphics2D) bf.getDrawGraphics();
            score.drawScore(g);
            map.draw(g);

            if (!game.timer_off)
                apple.showTime(g);
            if (game.gametype != Main.DUEL && isGameOver)
                score.ShowGamoverScreen(g);
            if (game.gametype == Main.DUEL && isGameOver)
                score.ShowDuelScreen(g);

            if (nextLevelAccepted) {
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

    private void drawObjects(Graphics g, List<GameObject> objects) {
        for (GameObject object : objects) {
            object.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() >= 975 && e.getX() < 1187 && e.getY() > 570 && e.getY() < 620) {
            isRunning = false;
            Main.restartRequest = true;
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
        nextLevelAccepted = true;

    }

    private void resurrect() {
        snake.stop();
        snake.makeTomb(map);
        snake = new Snake(length, width, map);
        game.speed = game.inspeed;
    }


}


