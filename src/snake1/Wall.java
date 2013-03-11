package snake1;

public class Wall extends RandomlyLocatedObject {
    public Wall(int maxX, int maxY, Map m) {
        super(maxX, maxY, m);
        map.setPoint(getX(), getY(), Map.WALL);
    }
}

