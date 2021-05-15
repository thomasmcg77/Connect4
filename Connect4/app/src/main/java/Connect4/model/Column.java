package model;

import java.util.ArrayList;

public class Column {
   
   public ArrayList<Chip> chips;
   
   
   public ArrayList<Chip> getChips() {
      
      
      return this.chips;
   }
   
   public Column() {
      chips = new ArrayList<Chip>();
   }
   
   public void addChip(Chip chip) {
      chips.add(chip);
   }

   public int getNextOpenSpot() {
      if(chips.size() >= 6) {
         return -1;
      }
      return 5 - chips.size();
   }


   

}
