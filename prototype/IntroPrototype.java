import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class IntroPrototype
{
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel p1Label;
    JLabel p2Label;
    JLabel highScoreLabel;
    JLabel hs1;
    JLabel hs2;
    JLabel hs3;
    JTextField p1AnswerField;
    JTextField p2AnswerField;
    JButton p1SubmitButton;
    JButton p2SubmitButton;
    JButton startGameButton;

    public IntroPrototype()
    {
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

       this.p1SubmitButton = new JButton("Player 1");
       this.mainPanel.add(this.p1SubmitButton);

       // P2 Section

       this.p2Label = new JLabel("Black chip username: ");
       this.mainPanel.add(this.p2Label);

       this.p2AnswerField = new JTextField();
       this.p2AnswerField.setPreferredSize(new Dimension(150, 30));
       this.mainPanel.add(this.p2AnswerField);

       this.p2SubmitButton = new JButton("Player 2");
       this.mainPanel.add(this.p2SubmitButton);

       this.highScoreLabel = new JLabel("High Scores:\n");
       this.highScoreLabel.setPreferredSize(new Dimension(350, 30));
       this.hs1 = new JLabel("Placeholder1 has 3 win(s)");
       this.hs1.setPreferredSize(new Dimension(350, 30));
       this.hs2 = new JLabel("Placeholder2 has 2 win(s)");
       this.hs2.setPreferredSize(new Dimension(350, 30));
       this.hs3 = new JLabel("Placeholder3 has 1 win(s)");
       this.hs3.setPreferredSize(new Dimension(350, 30));

       this.mainPanel.add(this.highScoreLabel);
       this.mainPanel.add(this.hs1);
       this.mainPanel.add(this.hs2);
       this.mainPanel.add(this.hs3);

       this.startGameButton = new JButton("Start Game");
       this.mainPanel.add(this.startGameButton);

       // add the special container to the top-level container
       this.mainFrame.add(this.mainPanel);
       // auto-size everything
       this.mainFrame.pack();
       // make top-level container visible
       this.mainFrame.setVisible(true);
    }

    public static void main(String []args)
    {
        IntroPrototype setUp = new IntroPrototype();
    }

}