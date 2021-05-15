package Connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ChipIcon implements Icon {
    private int radius;

    public ChipIcon(int radius) {
        this.radius = radius;
    }

    @Override
    public int getIconWidth() {
        return this.radius;
    }

    @Override
    public int getIconHeight() {
        return this.radius;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
      // white oval represents the card background
      g.setColor(Color.WHITE);
      g.fillOval(x, y, this.radius, this.radius);
      Shape circle = new Ellipse2D.Double(this.radius, this.radius, this.radius, this.radius);
      g.drawOval(0, 0, this.radius, this.radius);
    }
}
