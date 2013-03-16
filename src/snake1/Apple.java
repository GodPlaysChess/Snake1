package snake1;

import sun.net.www.ApplicationLaunchException;

import java.awt.*;

public class Apple extends RandomlyLocatedObject {
    private boolean is_dead = false;
    private boolean is_eaten = false;
    private int time;

    public boolean isEaten() {
        return is_eaten;
    }

    public boolean Is_dead(){
        return is_dead;
    }

    public Apple(int maxX, int maxY, Map m) {
        super(maxX, maxY, m);
        time = 100;
        map.setPoint(getX(), getY(), Map.APPLE);
    }

    protected void setEaten() {
        is_eaten = true;
    }

    private void setIs_dead() {
        is_dead = true;
    }

    private int getTime() {
        return time;
    }

    public void decTime() {
        time--;
    }


    public void ShowTime(Graphics2D g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.BOLD, 40));
        g.clearRect(940, 218, 190, 50);
        g.drawString(" " + getTime(), 960, 260);
    }

    public void CheckTimer(Map m) {
        if (getTime() == 0) {
            setIs_dead();
            m.setPoint(getX(), getY(), Map.WALL);
        }


    }

}
