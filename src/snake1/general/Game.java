package snake1.general;

import snake1.data.GameData;
import snake1.data.GameSettings;
import snake1.graphics.Score;
import snake1.graphics.Screen;
import snake1.objects.Apple;
import snake1.objects.GameObject;

import java.awt.event.*;

public final class Game implements KeyListener, ActionListener, MouseListener {

    private boolean gameOn;

    private GameData gameData;
    private Screen screen;
    private Score score;
    //private GameSettings settings;


    private Game(GameSettings settings) {
        gameOn = true;
        screen = new Screen("Snake");
        gameData = new GameData(settings);
        screen.addKeyListener(this);
        screen.addMouseListener(this);
    }

    public static Game create(GameSettings settings) {
        return new Game(settings);
    }

    public void start() {
        while (gameOn) {
            doTick();
            screen.render(gameData.getArena());
            try {
                Thread.sleep((long) (1130 / Math.sqrt(gameData.getSpeed()) - 100));                 //(6.13 / Math.sqrt(speed) - 0.2)  Thread.sleep(2000l / speed);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private void doTick() {
        for (GameObject object : gameData.getGameObjects()) {
            object.event(gameData.getArena());
        }
        globalEvents();
        gameData.updateMap();

    }

    private void globalEvents() {
        Apple apple = gameData.getApple();
        if (apple.isDead()) {
            gameData.addApple();
        }
        if (apple.isEaten()) {
            score.incValue();
            gameData.incSpeed();
            if (score.getValue() % 5 == 0) {
                gameData.addWall();
            }
        }
        if (gameData.getPlayer().isDestroyed()) {
            gameData.decreaseLife();
            ressurect();
        }
        if (isGameOver()) {
            gameData.getPlayer().stop();
        }
        if (score.nextLevelCondition(gameData.getCurrentLevel())) {
            gameData.nextLevel();
        }

        if (gameData.getOpponent() != null) {

        }
    }

    private boolean isGameOver() {
        return gameData.getCurrentLives() < 0;
    }


    public void restart() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                gameData.getPlayer().setDirection(e.getKeyCode());
                break;
            case KeyEvent.VK_X:
                gameData.getPlayer().destroy();
                break;
            case KeyEvent.VK_R:
                restart();          //TODO SHOULD REALLY THINK HOW TO MAKE IT SMART
                break;
            case KeyEvent.VK_SPACE:
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                if (gameData.getOpponent() != null)
                    gameData.getOpponent().setDirection(e.getKeyCode());
                break;
            default:
                //
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() >= 975 && e.getX() < 1187 && e.getY() > 570 && e.getY() < 620) {
            restart();
            //isRunning = false; //TODO the same is up there. Need to recreate the game in a smart way
            //Main.restartRequest = true;
        }
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
