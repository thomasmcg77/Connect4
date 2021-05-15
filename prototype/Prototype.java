import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.Color;

public class Prototype
{
    private int frameSize = 650;
    private JFrame mainFrame;

    public Prototype(int size)
    {
        this.frameSize = size;

        // top level container for the game
        mainFrame = new JFrame("Connect 4");
        mainFrame.setPreferredSize(new Dimension(frameSize*3/2, frameSize));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // the container representing our card table
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));

        JPanel controlPanel = new JPanel();
        JButton column1 = new JButton("Column 1");
        JButton column2 = new JButton("Column 2");
        JButton column3 = new JButton("Column 3");
        JButton column4 = new JButton("Column 4");
        JButton column5 = new JButton("Column 5");
        JButton column6 = new JButton("Column 6");
        JButton column7 = new JButton("Column 7");
        controlPanel.add(column1);
        controlPanel.add(column2);
        controlPanel.add(column3);
        controlPanel.add(column4);
        controlPanel.add(column5);
        controlPanel.add(column6);
        controlPanel.add(column7);
        gamePanel.add(controlPanel, BorderLayout.NORTH);

        JPanel boardGame = new JPanel();
        boardGame.setBackground(new Color(42, 108, 229));
        boardGame.setPreferredSize(new Dimension(100, 700));
        
        for (int i = 0; i < 6; i++) {
           JPanel column = new JPanel();
           column.setBackground(new Color(42, 108, 229));
           for (int j = 0; j < 7; j++) {
              JLabel chipLabel = new JLabel(new ChipIcon(75));
              column.add(chipLabel);
           }
           boardGame.revalidate();
           boardGame.repaint();
           boardGame.add(column);
        }

        gamePanel.add(boardGame, BorderLayout.CENTER);
        // place card table into the top level container
        mainFrame.add(gamePanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    /**
     * Do not remove this meethod
     */
    public JFrame getFrame()
    {
        return mainFrame;
    }

    public static void main(String []args)
    {
        Prototype blackJackPrototype = new Prototype(650);
    }
}
