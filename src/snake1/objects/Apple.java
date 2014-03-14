package snake1.objects;

import snake1.data.Arena;

import java.awt.*;

public class Apple extends GameObject{
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

    public Apple() {
        super(Color.RED);
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

        g.fillRect(Arena.ALIGN_X + x * 15, Arena.ALIGN_Y + y * 15, 15, 15);

        g.setColor(Color.RED);
        g.setFont(serif);
        g.clearRect(940, 218, 190, 50);
        g.drawString(" " + time, 960, 260);
    }

    @Override
    public void event(Arena arena) {
        decTime();
        if (time == 0) {
            setDead();
        }
    }

    @Override
    public void collide(Snake snake) {
        snake.eat();
        isEaten = true;
    }
}
