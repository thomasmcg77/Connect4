
package Connect4;

import org.junit.Test;
import static org.junit.Assert.*;
import model.*;

public class ResultTest {
   
   @Test
   public void testGetWinner() {
      Player winner = new Player(ChipColor.RED);
      Result result = new Result(winner);
      assertNotNull("there should be a winning player", result.getWinner());
      assertEquals("the winner should be the red player", winner, result.getWinner());
      assertEquals("the winner should have red chips", ChipColor.RED, result.getWinner().getColor());
   }


}
