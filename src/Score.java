import java.awt.*;

public class Score {
    int value = 0;
    Font font = new Font("Arial", Font.PLAIN, 38);
    Font font2 = new Font("Arial", Font.BOLD, 38);

    public void DrawScore(Graphics2D g){

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("SCORE", 1020, 150);
        g.setFont(font2);
        g.clearRect(1060,180, 90, 38);                       //  ERASE PREVIOUS NUMBER HERE
        g.drawString(String.valueOf(value), 1080, 210);

        DrawRestart(g);

    }

    public void incValue(){
        value++;
    }

    private void DrawRestart(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawString("RESTART", 995, 610);
        g.drawRect(975,570,212,50);
    }

    void ShowGamoverScreen(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawString("YOUR GAME IS OVER, SUCKER", 195, 310);
    }

    void ShowWinScreen(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawString("CONGRATULATIONS!!! YOU WON!!! BETTER LUCK ON THE NEXT LEVEL!", 195, 310);
    }

    private void DrawHelp(Graphics2D g){

    }



}
