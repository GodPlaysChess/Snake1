package snake1.graphics;

import java.awt.*;

public class Score {
    private int value = 0;
    public boolean p1wins = false;
    public boolean p2wins = false;

    private int rectsize = 20;
    public final static int LEFT_EDGE = 995;
    public final static int BOTTOM_EDGE = 610;

    private static final Font FONT_DEFAULT = new Font("Arial", Font.PLAIN, 38);
    private static final Font FONT_BOLD = new Font("Arial", Font.BOLD, 38);
    private static final Font FONT_EXPLAIN = new Font("arial", Font.PLAIN, 20);


    public void drawScore(Graphics2D g, int lives, int level) {
        g.setFont(FONT_DEFAULT);
        g.setColor(Color.BLACK);
        g.drawString("SCORE", 1020, 150);
        g.setFont(FONT_BOLD);
        g.clearRect(1060, 180, 90, 38);                       //  ERASE PREVIOUS NUMBER HERE
        g.drawString(String.valueOf(value), 1080, 210);

        drawRestart(g);
        drawHelp(g);
        drawLives(g, lives);

    }

    public void incValue() {
        value++;
    }

    private void drawLives(Graphics2D g, int lives) {
        g.drawString("LIVES", LEFT_EDGE - 15, BOTTOM_EDGE - 90);
        g.clearRect(LEFT_EDGE - 40, BOTTOM_EDGE - 85, 190, 45);

        for (int i = 1; i < lives; i++) {
            drawSnakeHead(LEFT_EDGE + i * (rectsize + 5) - 20, BOTTOM_EDGE - 80, g);
        }

    }

    private void drawSnakeHead(int x, int y, Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillOval(x - 2, y - 2, rectsize + 4, rectsize + 4);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, rectsize, rectsize);
        g.setColor(Color.RED);
        g.fillOval(x + rectsize / 3, y, rectsize / 3 + 3, rectsize);


    }

    private void drawRestart(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawString("RESTART", LEFT_EDGE, BOTTOM_EDGE);
        g.drawRect(LEFT_EDGE - 20, BOTTOM_EDGE - 40, 212, 50);
    }

    public void showGameoverScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawString("YOUR GAME IS OVER, :(", 195, 310);
    }

    public void showDuelScreen(Graphics2D g) {
        if (p1wins) showPlayer1WinScreen(g);
        if (p2wins) showPlayer2WinScreen(g);
    }

    private void showPlayer1WinScreen(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.drawString("CONGRATULATIONS!!", 195, 310);
        g.drawString("BLUE SNAKE WINS", 195, 240);

    }

    private void showPlayer2WinScreen(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.drawString("PURPLE SNAKE WINS", 195, 310);
        g.drawString("CONGRATULATIONS!!", 195, 240);

    }

    public void showWinScreen(Graphics2D g, int level) {
        if (level == 6)
            g.drawString("CONGRATULATIONS!!! YOU HAVE COMPLETED ALL LEVELS!!!", 195, 310);
        else {
            g.setColor(Color.BLACK);
            g.drawString("CONGRATULATIONS!!! YOU WON!!!", 195, 310);
            g.drawString("BETTER LUCK ON THE NEXT LEVEL!", 190, 350);
            g.drawString("Press SPACE to continue", 195, 610);
        }
    }

    private void drawHelp(Graphics2D g) {
        g.setFont(FONT_EXPLAIN);
        g.setColor(Color.RED);
        g.fillRect(LEFT_EDGE - 30, BOTTOM_EDGE - 300, rectsize, rectsize);

        g.setColor(Color.BLACK);
        g.drawString(" Apple", LEFT_EDGE + 2 * rectsize, BOTTOM_EDGE - 285);
        g.setColor(Color.BLUE);
        g.fillRect(LEFT_EDGE - 30, BOTTOM_EDGE - 270, rectsize, rectsize);
        g.setColor(Color.GREEN);
        g.fillRect(LEFT_EDGE + rectsize - 30, BOTTOM_EDGE - 270, rectsize, rectsize);
        g.setColor(Color.BLACK);
        g.drawString(" Your snake", LEFT_EDGE + 2 * rectsize, BOTTOM_EDGE - 270 + 15);


        g.drawString("Use arrows to move", LEFT_EDGE, 410);

        g.drawString("Or WSAD for player 2", LEFT_EDGE - 9, 445);
    }


    public int getValue() {
        return value;
    }

    public void resetValue() {
        value = 0;
    }

    public boolean nextLevelCondition(int level) {
        switch (level) {
            case 1:
                return (value > 25);
            case 2:
                return (value > 25);
            case 3:
                return (value > 25);
            case 4:
                return (value > 25);
            case 5:
                return (value > 25);
            default:
                return false;
        }
    }
}
