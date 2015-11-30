import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	
	Board board;
	
	@Before
	public void init() {
		board = new Board();
	}
		
	@Test
	public void emptyBoardTest() {
		assertEquals(false, board.hasWinner());
	}
	
	@Test
	public void setValidMarkNoWinner() throws InvalidPositionException {
		board.setMark("o", 0, 0);
		assertEquals(false, board.hasWinner());
	}
	
	@Test
	public void setValidMarkWinner() throws InvalidPositionException {
		board.setMark("o", 0, 0);
		board.setMark("o", 1, 1);
		board.setMark("o", 2, 2);
		assertEquals(true, board.hasWinner());
	}
	
	@Test (expected = InvalidPositionException.class)
	public void setInvalidMark() throws InvalidPositionException {
		board.setMark("o", 3, -2);
	}

}
