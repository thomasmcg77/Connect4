

package Connect4;

import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

public class UserTest {
   
   
   @Test
   public void testGetUsername() {
      
      User user = new User("kesweet", 0);
      assertEquals("getUsername() method should return kesweet", "kesweet", user.getUsername());
      
   }
   
   
   @Test
   public void testWonGame() {
      
      User user = new User("kesweet", 0);
      user.wonGame();
      assertEquals("wonGame() method should have made kesweet user have 1 win", 1, user.getWins());
   }

}
