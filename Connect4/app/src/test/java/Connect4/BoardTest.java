import jdk.jfr.Timestamp;

import org.junit.*;
import static org.junit.Assert.*;
import model.*;
import java.util.ArrayList;

public class BoardTest {

    @Test
    public void testGetColumns() {
        Player player = new Player(ChipColor.RED);
        Player player2 = new Player(ChipColor.BLACK);
        Board board = new Board(player, player2);
        ArrayList<Column> columns = board.getColumns();
        assertEquals("Should have 7 columns", 7, columns.size());
    }

    @Test
    public void testGetCurrentPlayer() {
        Player player = new Player(ChipColor.RED);
        Player player2 = new Player(ChipColor.BLACK);
        Board board = new Board(player, player2);
        Player current = board.getCurrentPlayer();
        assertEquals("Current player should be the red player", player.getColor(), current.getColor());
    }

    @Test
    public void testSwitchPlayer() {
        Player player = new Player(ChipColor.RED);
        Player player2 = new Player(ChipColor.BLACK);
        Board board = new Board(player, player2);
        board.switchPlayer();
        Player current = board.getCurrentPlayer();
        assertEquals("Current player should be the black player", player2.getColor(), current.getColor());
    }

    @Test
    public void testPlaceChipSpot() {
        Player player = new Player(ChipColor.RED);
        Player player2 = new Player(ChipColor.BLACK);
        Board board = new Board(player, player2);
        board.switchPlayer();
        board.placeChip(2);
        Column column = board.getColumns().get(2);
        assertEquals("Index 5 should be taken (the bottom row), so the next available spot should be 4", 4, column.getNextOpenSpot());
    }

    @Test
    public void testPlaceChipColor() {
        Player player = new Player(ChipColor.RED);
        Player player2 = new Player(ChipColor.BLACK);
        Board board = new Board(player, player2);
        board.switchPlayer();
        board.placeChip(2);
        ArrayList<Chip> chips = board.getColumns().get(2).getChips();
        assertEquals("Black chip should be placed", ChipColor.BLACK, chips.get(0).getColor());
    }

    @Test 
    public void testClearBoard() {
        Player player = new Player(ChipColor.RED);
        Player player2 = new Player(ChipColor.BLACK);
        Board board = new Board(player, player2);
        board.placeChip(3);
        board.clearBoard();
        boolean clear = true;
        ArrayList<Column> columns = board.getColumns();
        for(int i=0; i<columns.size(); i++) {
            ArrayList<Chip> chips = columns.get(i).getChips();
            if(chips.size() > 0) {
                clear = false;
                break;
            }
        }
        assertEquals("Board should not contain any chips", true, clear);
    }
}
