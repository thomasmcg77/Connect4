

package Connect4;

import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

public class ColumnTest {
   
   @Test
   public void testGetNextOpenSpot() {
      Column column = new Column();
      column.addChip(new Chip(ChipColor.RED));
      assertNotNull("column should have an open spot", column.getNextOpenSpot());
      assertEquals("next open spot should be at location 4", 4, column.getNextOpenSpot());
   }

   @Test
   public void testAddChip() {
      Column column = new Column();
      column.addChip(new Chip(ChipColor.RED));
      assertEquals("column should have one chip", 1, column.getChips().size());
   }
}
