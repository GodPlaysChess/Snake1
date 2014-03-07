package snake1.graphics;

import snake1.general.Main;

import java.awt.*;

public class Score {
    private int value = 0;
    public boolean p1wins = false;
    public boolean p2wins = false;

    private int rectsize = 20;
    public final static int left_edge = 995;
    public final static int bottom_edge = 610;

    private Font font = new Font("Arial", Font.PLAIN, 38);
    private Font font2 = new Font("Arial", Font.BOLD, 38);
    private Font font_explain = new Font("arial", Font.PLAIN, 20);


    public void drawScore(Graphics2D g) {
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("SCORE", 1020, 150);
        g.setFont(font2);
        g.clearRect(1060, 180, 90, 38);                       //  ERASE PREVIOUS NUMBER HERE
        g.drawString(String.valueOf(value), 1080, 210);

        drawRestart(g);
        drawHelp(g);
        drawLives(g);

    }

    public void incValue() {
        value++;
    }

    private void drawLives(Graphics2D g) {
        g.drawString("LIVES", left_edge - 15, bottom_edge - 90);
        g.clearRect(left_edge - 40, bottom_edge - 85, 190, 45);

        for (int i = 1; i < Main.lives; i++) {
            DrawSnakeHead(left_edge + i * (rectsize + 5) - 20, bottom_edge - 80, g);
        }

    }

    private void DrawSnakeHead(int x, int y, Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillOval(x - 2, y - 2, rectsize + 4, rectsize + 4);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, rectsize, rectsize);
        g.setColor(Color.RED);
        g.fillOval(x + rectsize / 3, y, rectsize / 3 + 3, rectsize);


    }

    private void drawRestart(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawString("RESTART", left_edge, bottom_edge);
        g.drawRect(left_edge - 20, bottom_edge - 40, 212, 50);
    }

    public void ShowGamoverScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawString("YOUR GAME IS OVER, :(", 195, 310);
    }

    public void ShowDuelScreen(Graphics2D g) {
        if (p1wins) ShowPlayer1WinScreen(g);
        if (p2wins) ShowPlayer2WinScreen(g);
    }

    private void ShowPlayer1WinScreen(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.drawString("CONGRATULATIONS!!", 195, 310);
        g.drawString("BLUE SNAKE WINS", 195, 240);

    }

    private void ShowPlayer2WinScreen(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.drawString("PURPLE SNAKE WINS", 195, 310);
        g.drawString("CONGRATULATIONS!!", 195, 240);

    }

    public void ShowWinScreen(Graphics2D g) {

        if (Main.level==6)
            g.drawString("CONGRATULATIONS!!! YOU HAVE COMPLETED ALL LEVELS!!!", 195, 310);
        else{
        g.setColor(Color.BLACK);
        g.drawString("CONGRATULATIONS!!! YOU WON!!!", 195, 310);
        g.drawString("BETTER LUCK ON THE NEXT LEVEL!", 190, 350);
        g.drawString("Press SPACE to continue", 195, 610);
        }
    }

    private void drawHelp(Graphics2D g) {
        g.setFont(font_explain);
        g.setColor(Color.RED);
        g.fillRect(left_edge - 30, bottom_edge - 300, rectsize, rectsize);

        g.setColor(Color.BLACK);
        g.drawString(" Apple", left_edge + 2 * rectsize, bottom_edge - 285);
        g.setColor(Color.BLUE);
        g.fillRect(left_edge - 30, bottom_edge - 270, rectsize, rectsize);
        g.setColor(Color.GREEN);
        g.fillRect(left_edge + rectsize - 30, bottom_edge - 270, rectsize, rectsize);
        g.setColor(Color.BLACK);
        g.drawString(" Your snake", left_edge + 2 * rectsize, bottom_edge - 270 + 15);


        g.drawString("Use arrows to move", left_edge, 410);

        g.drawString("Or WSAD for player 2", left_edge - 9, 445);
    }


    public int getValue() {
        return value;
    }

    public void setValue() {
        value = 0;

    }

    public boolean NextLevelCondition(int level) {
        switch (level) {
            case 1:
                return (getValue() > 25);
            case 2:
                return (getValue() > 25);
            case 3:
                return (getValue() > 25);
            case 4:
                return (getValue() > 25);
            case 5:
                return (getValue() > 25);
        }
        return false;
    }
}
