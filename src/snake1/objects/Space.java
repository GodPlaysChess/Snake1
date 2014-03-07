package snake1.objects;

import java.awt.*;

public class Space extends GameObject {

    public Space(int x, int y) {
        color = Color.WHITE;
        type = GameObjectType.SPACE;
        this.x = x;
        this.y = y;
    }

    @Override
    public void event() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
