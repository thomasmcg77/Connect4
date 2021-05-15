package model;

import java.util.ArrayList;

public class Board 
{
   
   private String redUsername;
   private String blackUsername;
   private Player redPlayer;
   private Player blackPlayer;
   private Player currentPlayer;
   private ArrayList<Column> columns;
   
   public Board(Player redPlayer, Player blackPlayer)
   {   
      this.redPlayer = redPlayer;
      this.blackPlayer = blackPlayer;

      this.currentPlayer = redPlayer;
      this.clearBoard();
   }
   
   // Returns the ArrayList of columns storing the chips
   public ArrayList<Column> getColumns() 
   {   
      return this.columns;
   }

   // Returns the player currently placing a chip
   public Player getCurrentPlayer() 
   {
      return this.currentPlayer;
   }

   // Switches which player is currently placing a chip
   public void switchPlayer() 
   {
      if(this.currentPlayer == this.redPlayer)
      {
         this.currentPlayer = this.blackPlayer;
      }
      else 
      {
         this.currentPlayer = this.redPlayer;
      }
   }

   public void setPlayers(String p1, String p2) 
   {
      this.redUsername = p1;
      this.blackUsername = p2;
      
      
      //right now these are hardcoded, but eventually we need to deserialize
      //and perform a check to see if a typed-in username already has won games in the past.
      //if a username has already won games, then create a new User object first, setting gamesWon dynamically and then use setUser() method
      this.redPlayer.setUser(new User(redUsername, 0));
      this.blackPlayer.setUser(new User(blackUsername, 0));
      
      System.out.println("Red Player: " + p1);
      System.out.println("Black Player: " + p2);
   }

   // Updates column to have a chip of the current color
   public void placeChip(int column) 
   {
      System.out.println("Chip placed at column " + column);
      
      ChipColor color = this.currentPlayer.getColor();
      columns.get(column).addChip(new Chip(color));
   }
   
   // Clears all columns of chips
   public void clearBoard() 
   {   
      this.columns = new ArrayList<Column>();

      for (int i=0; i<7; i++) 
      {
         this.columns.add(new Column());
      }
      
   }

   // Returns the specified column object
   public Column getColumn(int col)
   {
      return this.getColumns().get(col);

   }
}
