package model;

import java.util.ArrayList;

public class Rules {
   
   private Result result;

   public static Result checkWin(Board board) {

   Player player = board.getCurrentPlayer();
   
   ChipColor playerColor = player.getColor();
   
   //need to update to allow for ties
   

   //looping through columns
   for (int j = 0; j < board.getColumns().size(); j++) {
      
      Column currentColumn = board.getColumns().get(j);
      int verticalMatchingChips = 0;
      
      //looping through chips in each column
      for (int i = 0; i < currentColumn.getChips().size(); i++) {
         
         int horizontalMatchingChips = 0;
         
         Chip currentChip = currentColumn.getChips().get(i);
         
         //checking vertical wins
         if (currentChip.getColor() == playerColor) {
            
            verticalMatchingChips++;
            
            int nextColumnIndex = j + 1;
            
            
            //checking horizontal wins
            while (nextColumnIndex < board.getColumns().size()) {
               
               Column nextColumn = board.getColumns().get(nextColumnIndex);
               
               
               if (i < nextColumn.getChips().size()) {
                  
                  if (nextColumn.getChips().get(i).getColor() == playerColor) {
                        
                     horizontalMatchingChips++;
               
                     if (horizontalMatchingChips >= 3) {
               
                        return new Result(player);
                        
                     } else {
                        
                        nextColumnIndex++;
                        
                     }
                     
                  } else {
                  
                     break;
                  }
                  
                  
               } else {
                  
                  break;
               }
            }
            
            int diagonalMatchingChips = 0;
            
            int diagonalUpIndex = i + 1;
            
            nextColumnIndex = j + 1;
            
               
      
            //checking diagonal wins
            
            while (nextColumnIndex < board.getColumns().size()) {
               
               Column nextColumn = board.getColumns().get(nextColumnIndex);
               
               //checking upward diagonal wins
               if (diagonalUpIndex < nextColumn.getChips().size()) {
                     
                  if (nextColumn.getChips().get(diagonalUpIndex).getColor() == playerColor) {
                           
                     diagonalMatchingChips++;
                     diagonalUpIndex++;
                     
                     if (diagonalMatchingChips >= 3) {
               
                        return new Result(player);
                        
                     } else {
                        
                        nextColumnIndex++;
                        
                     }
                    
                     
                  } else {
                     
                     break;
                  }
                     
               
               } else {
                  break;
                  
               }
            }
               
            int diagonalDownIndex = i - 1;
         
            int diagonalDownMatchingChips = 0;
            
            nextColumnIndex = j + 1;
               
            while (nextColumnIndex < board.getColumns().size()) {
               
               Column nextColumn = board.getColumns().get(nextColumnIndex);
               
               //I changed this to just a new if statement and it seemed to break the regular diagonal win-checking. Will try again later.
               //trying to find out why sometimes backwards diagonal wins are not found successfully.
               if (diagonalDownIndex < nextColumn.getChips().size() && diagonalDownIndex >= 0) {
               
                  if (nextColumn.getChips().get(diagonalDownIndex).getColor() == playerColor) {
                     
                     diagonalDownMatchingChips++;
                     diagonalDownIndex--;
                     
                     
                     if (diagonalDownMatchingChips >= 3) {
               
                        return new Result(player);
                        
                     } else {
                        
                        nextColumnIndex++;
                        
                     }
                     
                  } else {
                     
                     break;
                  }
               
               } else {
                  
                  break;
               }
                  
                  
            }
            
            
            
         } else {
            
            verticalMatchingChips = 0;
            
         }
      }
    
      if (verticalMatchingChips > 3) {
         
         return new Result(player);
      }
      
      
      
   }

      return new Result(null);
   }
}
