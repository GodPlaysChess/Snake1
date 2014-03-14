package snake1.graphics;

import snake1.data.GameSettings;
import snake1.data.Arena;
import snake1.general.Main;
import snake1.objects.GameObject;
import snake1.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.List;

public class Screen extends JFrame {
    private final int length = 60;
    private final int width = 40;

    private boolean isRunning = true;
    private boolean isGameOver = false;
    private boolean nextLevelAccepted = false;

    public Screen(String s) {
        super(s);
        setSize(1224, 708); //TODO check for resolution;
        setLocation(300, 120);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createBufferStrategy(2);

        this.setFocusable(true);
    }

    public void gameloop() {
        while (isRunning) {

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
    }

    public void render(Arena arena, Score score) {
        BufferStrategy bf = this.getBufferStrategy();
        Graphics2D g = null;

        try {
            g = (Graphics2D) bf.getDrawGraphics();
            score.drawScore(g, lives, level);
            arena.draw(g);
            if (!game.timer_off)
                apple.showTime(g);
            if (game.gametype != Main.DUEL && isGameOver)
                score.showGameoverScreen(g);
            if (game.gametype == Main.DUEL && isGameOver)
                score.showDuelScreen(g);
            if (nextLevelAccepted) {
                score.setValue();
                score.showWinScreen(g);
            }

        } finally {
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

}


