package controller;

import model.*;


public class Connect4Controller
{
   
   protected Player blackPlayer;
   protected Player redPlayer;
   protected Board board;
   protected Connect4UserInterface ui;
   private UserCatalog userCatalog;
   
   public Connect4Controller(Player redPLayer, Player blackPlayer, Board board, Connect4UserInterface ui, UserCatalog userCatalog)
   {
      this.redPlayer = redPlayer;
      this.blackPlayer = blackPlayer;
      this.board = board;
      this.ui = ui;
      this.userCatalog = userCatalog;
   }
   
   // Resets board and allows chips to be placed
   public void startNewGame()
   {
      ui.reset();
      board.clearBoard();
      ui.enableChipPlacement();
   }
   
   // Checks if there is a win
   public void checkBoardWin()
   {
      Result result = Rules.checkWin(board);
      
      if(ui.isTie()) {
         this.handleTie();
         return;
      }
      
      if (result.getWinner() == null) {

         return;
         
      } else {

         boolean playAgain = ui.playAgain(result.getWinner(), false);

         
         if (playAgain)
         {
            this.startNewGame();
         }
      }
      
      
   }

   public void handleTie() {
      boolean playAgain = ui.playAgain(new Player(ChipColor.WHITE), true);

      if(playAgain) {
         this.startNewGame();
      }
   }


   public void addUsers(String p1, String p2)
   {
      board.setPlayers(p1, p2);
   }

   // Updates the chip placement in both the UI and the backend
   public void placeInCol(int c)
   {
      int row = board.getColumn(c).getNextOpenSpot();
      ui.addChipIcon(c, row, board.getCurrentPlayer());
      board.placeChip(c);

      // Disables column button if full
      if(row-1 == -1)
      {
         ui.disableColumn(c);
      }
      
      this.checkBoardWin();

      board.switchPlayer();
   }

}
