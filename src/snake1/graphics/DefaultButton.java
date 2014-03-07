package snake1.graphics;

import java.awt.*;

public class DefaultButton extends Button{
    private String name;
    private Font font = new Font("Arial", 1, 30);
    private int sizeX = 300;
    private int sizeY= 50;
    private int locationX;
    private int locationY;

    DefaultButton(int locationX, int locationY, String name){
        super(name);
        setSize(sizeX, sizeY);
        setLocation(locationX, locationY);
    }
}
