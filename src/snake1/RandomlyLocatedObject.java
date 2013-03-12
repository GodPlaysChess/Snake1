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
        if (x == map.getSizeX())
            x = 0;
    }

    protected void decX() {
        x--;
        if (x == -1)
            x = map.getSizeX() - 1;
    }

    protected void incY() {
        y++;
        if (y == map.getSizeY())
            y = 0;
    }

    protected void decY() {
        y--;
        if (y == -1)
            y = map.getSizeY() - 1;

    }

    protected void setY(int val) {
        y = val;
    }

    protected void setX(int val) {
        y = val;
    }
}


