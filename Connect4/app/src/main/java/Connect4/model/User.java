package model;

import java.io.Serializable;

public class User implements Serializable{

   private static final long serialVersionUID = 4862935900337283457L;
   private String userName;
   private int gamesWon;
   
   public User(String userName, int gamesWon) {
      
      this.userName = userName;
      this.gamesWon = gamesWon;
   
   }
   
   public String getUsername() {
      
      return this.userName;
   }
   
   public void wonGame() {
      
      this.gamesWon++;
   }
   
   public int getWins(){

      return this.gamesWon;
   }


}
