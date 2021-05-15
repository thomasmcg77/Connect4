package Connect4;

import org.junit.Test;
import static org.junit.Assert.*;
import model.*;


public class ChipTest {
   
   
   @Test
   public void testSetColor() {
      
      Chip chip = new Chip(ChipColor.WHITE);
      assertEquals("chip color should be white", ChipColor.WHITE, chip.getColor());
      
   }
   
   
   @Test
   public void testGetColor() {
      
      Chip chip = new Chip(ChipColor.WHITE);
      chip.setColor(ChipColor.RED);
      assertEquals("chip color should be red", ChipColor.RED, chip.getColor());
   }

}
