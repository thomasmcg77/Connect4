package Connect4;

import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

public class ChipColorTest {
   
   
   @Test
   public void testRedColor() {
      
      ChipColor red = ChipColor.RED;
      assertEquals("chip color should be red", ChipColor.RED, red);
      
   }
   
   
   @Test
   public void testBlackColor() {
      
      ChipColor black = ChipColor.BLACK;
      assertEquals("chip color should be red", ChipColor.BLACK, black);
   }
   
   @Test
   public void testWhiteColor() {
      
      ChipColor white = ChipColor.WHITE;
      assertEquals("chip color should be red", ChipColor.WHITE, white);
   
   }

}
