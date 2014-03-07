package snake1.objects;

import snake1.data.Map;

import java.awt.*;

public class Apple extends RandomlyLocatedObject {
    private boolean isDead = false;
    private boolean isEaten = false;
    private int time = 100;
    private static final Font serif = new Font("Serif", Font.BOLD, 40);

    public boolean isEaten() {
        return isEaten;
    }

    public boolean isDead() {
        return isDead;
    }

    public Apple(int maxX, int maxY) {
        super(maxX, maxY, Color.RED);
        type = GameObjectType.APPLE;
    }

    protected void setEaten() {
        isEaten = true;
    }

    private void setDead() {
        isDead = true;
    }

    public void decTime() {
        time--;
    }


    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(Map.ALIGN_X + x * 15, Map.ALIGN_Y + y * 15, 15, 15);

        g.setColor(Color.RED);
        g.setFont(serif);
        g.clearRect(940, 218, 190, 50);
        g.drawString(" " + time, 960, 260);
    }

    @Override
    public void event() {
        decTime();
        if (time == 0) {
            setDead();
        }
    }
}
