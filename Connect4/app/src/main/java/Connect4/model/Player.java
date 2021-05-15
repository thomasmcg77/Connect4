package model;

import java.util.ArrayList;

public class Player {
   
   private User user;
   private ArrayList<Chip> chips;
   private ChipColor chipColor;
   
   
   public Player(ChipColor chipColor) {
      
      this.chipColor = chipColor;
   }
   
   public ChipColor getColor() {
      
      return this.chipColor;
   }
   
   public void setUser(User user) {
      
      this.user = user;
   }
   
   public User getUser() {
      
      return this.user;
   }
   
   public String getUsername() {
      
      return this.user.getUsername();
   }
   
   //public void moveChip() {}
   
   //public void resetChips() {}
   
}
