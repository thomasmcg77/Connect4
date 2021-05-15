package view.gui;

import model.*;
import controller.Connect4UserInterface;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;

public class Connect4Table implements Connect4UserInterface
{

   private int frameSize;
   private JFrame mainFrame;
   private JPanel boardGame;
   private ArrayList<ColumnPanel> columns;
   private ArrayList<JButton> buttons;
   private int numDisabledColumns;

    public Connect4Table()
    {
        this.frameSize = 650;
        this.columns = new ArrayList<ColumnPanel>();
        this.buttons = new ArrayList<JButton>();
        this.numDisabledColumns = 0;

        // top level container for the game
        mainFrame = new JFrame("Connect 4");
        mainFrame.setPreferredSize(new Dimension(frameSize*3/2, frameSize));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // the container representing our board
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));

        JPanel controlPanel = new JPanel();
        
        // Creates column buttons and adds them to the board
        for(int i=0; i<7; i++)
        {
            JButton tempColumn = new JButton("Column " + (i+1));
            buttons.add(tempColumn);
            controlPanel.add(tempColumn);
            tempColumn.setEnabled(false);
        }

        gamePanel.add(controlPanel, BorderLayout.NORTH);

        boardGame = new JPanel();
        boardGame.setBackground(new Color(42, 108, 229));
        boardGame.setPreferredSize(new Dimension(100, 700));

        for (int i = 0; i < 7; i++)
        {
           ColumnPanel column = new ColumnPanel();
           columns.add(column);
           boardGame.revalidate();
           boardGame.repaint();
           boardGame.add(column);
        }

        gamePanel.add(boardGame, BorderLayout.CENTER);
        mainFrame.add(gamePanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    // Disables the specified column button
    public void disableColumn(int col)
    {
        buttons.get(col).setEnabled(false);
        numDisabledColumns += 1;

    }

    // Sets the ChipIcon in the specified row, column to the color of the current player
    public void addChipIcon(int col, int row, Player currentPlayer)
    {
      columns.get(col).placeChipIcon(row, currentPlayer.getColor());
    }


    // Adds ActionListener to the designated column button
    public void setPlaceCol(int col, ActionListener l)
    {
       buttons.get(col).addActionListener(l);
       
      }

    
    
    public boolean isTie() {
        return numDisabledColumns >= 7;
    }

    /**
     * Do not remove this meethod
     */
    public JFrame getFrame()

    {
        return this.mainFrame;
    }

    // Clears the board (sets all chips to white)
    public void reset()
    {
        for (int col=0; col<7; col++) {
            for (int row=0; row<6; row++) {
                columns.get(col).placeChipIcon(row, ChipColor.WHITE);
            }
            
        }
        this.numDisabledColumns = 0;
    }


    // Enables the column buttons
    public void enableChipPlacement()
    {
        for(int i=0; i<buttons.size(); i++)
        {
            buttons.get(i).setEnabled(true);
        }
    }

    // Disables column buttons and creates a pop-up for choosing to play again
    public boolean playAgain(Player winner, boolean tie)
    {
        if(tie) {
           
            int choice = JOptionPane.showConfirmDialog(mainFrame, "The game was tied. Play again?", "Results", JOptionPane.YES_NO_OPTION);
            return choice == JOptionPane.YES_OPTION;
         }
         else {
            
            for(int i=0; i<buttons.size(); i++)
           {
               buttons.get(i).setEnabled(false);
           }

           int choice = JOptionPane.showConfirmDialog(mainFrame, "The winner was " + winner.getUsername() + ". Play again?", "Results", JOptionPane.YES_NO_OPTION);
           return choice == JOptionPane.YES_OPTION;
         }
    }

    public void addOnCloseListener(WindowAdapter l){
        mainFrame.addWindowListener(l);
    }
   
}


