package snake1.objects;

import java.awt.*;

public class Wall extends GameObject {


    public Wall(int x, int y) {
        color = Color.DARK_GRAY;
        type = GameObjectType.WALL;
        this.x = x;
        this.y = y;
    }

    @Override
    public void event() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

