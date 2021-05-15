package view.gui;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ChipIcon implements Icon {
    private int radius;
    private Color color;

    public ChipIcon(int radius) {
        this.radius = radius;
        this.color = Color.WHITE;
    }

    public void setColor(ChipColor chipColor) {
        if(chipColor == ChipColor.WHITE) {
            this.color = Color.WHITE;
        }
        else if(chipColor == ChipColor.RED) {
            this.color = Color.RED;
        }
        else {
            this.color = Color.BLACK;
        }
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
      g.setColor(this.color);
      g.fillOval(x, y, this.radius, this.radius);
      Shape circle = new Ellipse2D.Double(this.radius, this.radius, this.radius, this.radius);
      g.drawOval(0, 0, this.radius, this.radius);
    }
}
