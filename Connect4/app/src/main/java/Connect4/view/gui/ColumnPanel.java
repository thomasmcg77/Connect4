package view.gui;

import model.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Dimension;

public class ColumnPanel extends JPanel {
    
    private ArrayList<ChipIcon> chips;

    public ColumnPanel () {
        this.chips = new ArrayList<ChipIcon>();
        this.setBackground(new Color(42, 108, 229));
        this.setPreferredSize(new Dimension(90, 700));
        for(int j = 0; j < 6; j++) {
            ChipIcon icon = new ChipIcon(75);
            JLabel chipLabel = new JLabel(icon);
            chips.add(icon);
            this.add(chipLabel);
        }
    }

    public void placeChipIcon(int loc, ChipColor color) {
        chips.get(loc).setColor(color);
        this.revalidate();
        this.repaint();
    }
}
