
package Connect4;

import org.junit.*;
import static org.junit.Assert.*;
import model.*;

public class RulesTest {
   
   static Player redPlayer;
   static Player blackPlayer;
   static Board board;
   
   
   @BeforeClass
   public static void setup() {

      redPlayer = new Player(ChipColor.RED);
      blackPlayer = new Player(ChipColor.BLACK);
   
   }
   
   @Before
   public void newGame() {
      
      board = new Board(redPlayer, blackPlayer);
      
   }
   
   
   @Test
   public void testRedWinning() {

      board.placeChip(0);
      board.placeChip(0);
      board.placeChip(0);
      board.placeChip(0);
      Result result = Rules.checkWin(board);
      System.out.println("winner is " + result.getWinner().getColor());
      assertEquals("winner should be red", redPlayer, result.getWinner());
   }

   @Test
   public void testBlackWinning() {
      
      board.switchPlayer();
      board.placeChip(0);
      board.placeChip(0);
      board.placeChip(0);
      board.placeChip(0);
      Result result = Rules.checkWin(board);
      assertEquals("winner should be black", blackPlayer, result.getWinner());
   }
   
   @Test
   public void testHorizontalWins() {
      
      board.placeChip(0);
      board.placeChip(1);
      board.placeChip(2);
      board.placeChip(3);
      Result result = Rules.checkWin(board);
      System.out.println("winner is " + result.getWinner().getColor());
      assertEquals("winner should be red", redPlayer, result.getWinner());
   }
   
   @Test
   public void testVerticalWins() {
      
      board.placeChip(0);
      board.placeChip(0);
      board.placeChip(0);
      board.placeChip(0);
      Result result = Rules.checkWin(board);
      System.out.println("winner is " + result.getWinner().getColor());
      assertEquals("winner should be red", redPlayer, result.getWinner());
   }
   
   @Test
   public void testDiagonalUpWins() {
      
      board.placeChip(0);
      board.placeChip(1);
      board.placeChip(1);
      board.switchPlayer();
      board.placeChip(2);
      board.placeChip(2);
      board.switchPlayer();
      board.placeChip(2);
      board.placeChip(3);
      board.placeChip(3);
      board.switchPlayer();
      board.placeChip(3);
      board.switchPlayer();
      board.placeChip(3);
      
      Result result = Rules.checkWin(board);
      System.out.println("winner is " + result.getWinner().getColor());
      assertEquals("winner should be red", redPlayer, result.getWinner());
   }
   
   @Test
   public void testDiagonalDownWins() {
      
      board.placeChip(0);
      board.switchPlayer();
      board.placeChip(0);
      board.placeChip(0);
      board.switchPlayer();
      board.placeChip(0);
      board.switchPlayer();
      board.placeChip(1);
      board.placeChip(1);
      board.switchPlayer();
      board.placeChip(1);
      board.switchPlayer();
      board.placeChip(2);
      board.switchPlayer();
      board.placeChip(2);
      board.placeChip(3);
      
      Result result = Rules.checkWin(board);
      System.out.println("winner is " + result.getWinner().getColor());
      assertEquals("winner should be red", redPlayer, result.getWinner());
   }
}
