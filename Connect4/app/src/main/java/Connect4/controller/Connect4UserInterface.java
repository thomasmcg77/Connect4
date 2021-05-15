package controller;

import model.*;


public interface Connect4UserInterface {
   
   public void reset();
   public void enableChipPlacement();
   public boolean playAgain(Player winner, boolean tie);
   public void addChipIcon(int col, int row, Player currentPlayer);
   public void disableColumn(int col);
   public boolean isTie();
}
