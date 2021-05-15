package Connect4;

import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

public class PlayerTest {
   
   
   @Test
   public void testGetColor() {
      
      Player player = new Player(ChipColor.RED);
      assertEquals("player's chip color should be red", ChipColor.RED, player.getColor());
      
   }
   
   
   @Test
   public void testSetUser() {
      
      User user = new User("kesweet", 2);
      Player player = new Player(ChipColor.RED);
      player.setUser(user);
      assertEquals("player should have new user as attribute", user, player.getUser());
   }
   
   @Test
   public void testGetUsername() {
      
      User user = new User("kesweet", 2);
      Player player = new Player(ChipColor.RED);
      player.setUser(user);
      assertEquals("player should have new username kesweet", "kesweet", player.getUsername());
   
   }

}
