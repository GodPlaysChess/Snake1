package snake1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MyPanel extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g.drawString("It's a FUCKING SNAKE MADNESS!!!", 50, 50);

        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

    }

    public void rendermap(Map m) {


    }
}
