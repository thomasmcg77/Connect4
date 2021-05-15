package view.gui;

import model.*;
import controller.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.ArrayList;

public class StartupWindow implements ActionListener
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel p1Label;
    private JLabel p2Label;
    private JLabel highScoreLabel;
    private JLabel hs1;
    private JLabel hs2;
    private JLabel hs3;
    private JTextField p1AnswerField;
    private JTextField p2AnswerField;
    private JButton startGameButton;
    private Connect4Controller controller;
    private UserCatalog userCatalog;

    public StartupWindow(Connect4Controller controller, UserCatalog userCatalog)
    {
       this.controller = controller;
       this.userCatalog = userCatalog;

       // create a top-level container
       this.mainFrame = new JFrame("Set Up");
       this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // create a special container for storing all the piecies
       this.mainPanel = new JPanel();
       this.mainPanel.setPreferredSize(new Dimension(400, 250));

       // create text containing a question
       this.p1Label = new JLabel("Red chip username: ");
       this.mainPanel.add(this.p1Label);

       this.p1AnswerField = new JTextField();
       this.p1AnswerField.setPreferredSize(new Dimension(150, 30));
       this.mainPanel.add(this.p1AnswerField);

       // P2 Section

       this.p2Label = new JLabel("Black chip username: ");
       this.mainPanel.add(this.p2Label);

       this.p2AnswerField = new JTextField();
       this.p2AnswerField.setPreferredSize(new Dimension(150, 30));
       this.mainPanel.add(this.p2AnswerField);

       this.highScoreLabel = new JLabel("High Scores:\n");
       this.highScoreLabel.setPreferredSize(new Dimension(350, 30));
       
       ArrayList<User> topThree = userCatalog.getSortedUsers();

       User firstUser = topThree.get(0);
       this.hs1 = new JLabel(firstUser.getUsername() + " has " + firstUser.getWins() + " wins");
       this.hs1.setPreferredSize(new Dimension(350, 30));

       User secondUser = topThree.get(1);
       this.hs2 = new JLabel(secondUser.getUsername() + " has " + secondUser.getWins() + " wins");
       this.hs2.setPreferredSize(new Dimension(350, 30));

       User thirdUser = topThree.get(2);
       this.hs3 = new JLabel(thirdUser.getUsername() + " has " + thirdUser.getWins() + " wins");
       this.hs3.setPreferredSize(new Dimension(350, 30));

       this.mainPanel.add(this.highScoreLabel);
       this.mainPanel.add(this.hs1);
       this.mainPanel.add(this.hs2);
       this.mainPanel.add(this.hs3);

       this.startGameButton = new JButton("Start Game");
       this.mainPanel.add(this.startGameButton);
       startGameButton.addActionListener(this);

       // add the special container to the top-level container
       this.mainFrame.add(this.mainPanel);
       // auto-size everything
       this.mainFrame.pack();
       // make top-level container visible
       this.mainFrame.setVisible(true);
    }

    public void newGame() {
        this.startGameButton.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        this.startGameButton.setEnabled(false);
        this.controller.addUsers(this.p1AnswerField.getText(), this.p2AnswerField.getText());

        userCatalog.addUser(this.p1AnswerField.getText());
        userCatalog.addUser(this.p2AnswerField.getText());
        
        this.controller.startNewGame();
    }

}
