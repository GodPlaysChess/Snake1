package snake1;

public class Apple extends RandomlyLocatedObject {
    private boolean is_eaten = false;
    public boolean isEaten() {
        return is_eaten;
    }

    public Apple(int maxX, int maxY, Map m) {
        super(maxX, maxY, m);
        map.setPoint(getX(), getY(), Map.APPLE);
    }

    protected void setEaten() {
        is_eaten = true;
    }

}
