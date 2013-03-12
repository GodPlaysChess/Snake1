package snake1;

import java.awt.*;

public class Score {
    private int value = 0;
    private int rectsize = 20;
    private int left_edge = 995;
    private int bottom_edge = 610;

    private Font font = new Font("Arial", Font.PLAIN, 38);
    private Font font2 = new Font("Arial", Font.BOLD, 38);
    private Font font_explain = new Font("arial", Font.PLAIN, 20);



    public void DrawScore(Graphics2D g) {

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("SCORE", 1020, 150);
        g.setFont(font2);
        g.clearRect(1060, 180, 90, 38);                       //  ERASE PREVIOUS NUMBER HERE
        g.drawString(String.valueOf(value), 1080, 210);

        DrawRestart(g);
        DrawHelp(g);

    }

    public void incValue() {
        value++;
    }

    private void DrawRestart(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawString("RESTART", left_edge, bottom_edge);
        g.drawRect(left_edge-20, bottom_edge-40, 212, 50);
    }

    public void ShowGamoverScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawString("YOUR GAME IS OVER, SUCKER", 195, 310);
    }

    public void ShowWinScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawString("CONGRATULATIONS!!! YOU WON!!!", 195, 310);
        g.drawString("BETTER LUCK ON THE NEXT LEVEL!", 190, 350);
        g.drawString("Press SPACE to continue", 195, 610);
    }

    private void DrawHelp(Graphics2D g) {
        g.setFont(font_explain);
        g.setColor(Color.RED);
        g.fillRect(left_edge-30, bottom_edge-300, rectsize, rectsize);

        g.setColor(Color.BLACK);
        g.drawString(" Apple", left_edge+2*rectsize, bottom_edge-285);
        g.setColor(Color.BLUE);
        g.fillRect(left_edge-30, bottom_edge-270, rectsize, rectsize);
        g.setColor(Color.GREEN);
        g.fillRect(left_edge+rectsize-30, bottom_edge-270, rectsize, rectsize);
        g.setColor(Color.BLACK);
        g.drawString(" Your snake", left_edge+2*rectsize, bottom_edge-270+15);


        g.drawString("Use arrows to move", left_edge, 410);
    }

    public int getValue() {
        return value;
    }

    public boolean NextLevelCondition(int level) {

        switch (level) {
            case 1:
                return (getValue() > 30);
            case 2:
                return (getValue() > 30);


        }
        return false;
    }
}
