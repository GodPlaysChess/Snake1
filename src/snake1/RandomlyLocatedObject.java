package snake1;

public class RandomlyLocatedObject {
    private int x;
    private int y;

    protected Map map = null;

    // 1st way is to add random modifier (true/false) to create in fixed or random position.
    public RandomlyLocatedObject(int maxX, int maxY, Map m) {
        this.map = m;
        do {
            x = (int) (Math.random() * maxX);
            y = (int) (Math.random() * maxY);
        } while (map.notZero(x, y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void incX() {
        x++;
    }

    protected void decX() {
        x--;
    }

    protected void incY() {
        y++;
    }

    protected void decY() {
        y--;
    }
}


