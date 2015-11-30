
public class Board {
	
	private int rows = 3;
	private int columns = 3;
	
	private String[][] board = new String[rows][columns];
	
	public Board() {
		for (int i=0; i < rows; i++) {
			for (int j=0; j < columns; j++) {
				board[i][j] = "init";
			}
		}
	}
	
	public void setMark(String mark, int x, int y) throws InvalidPositionException {
		if (x < 0 || x >= rows || y < 0 || y >=columns) {
			throw new InvalidPositionException("Ungültige Werte");
		} else if (!board[x][y].equalsIgnoreCase("init")) {
			throw new InvalidPositionException("Feld schon belegt");
		} else if (!(mark.equalsIgnoreCase("o") || mark.equalsIgnoreCase("x"))) {
			throw new InvalidPositionException("Ungültiges Zeichen");
		} else {
			board[x][y] = mark;
		}
	}
	
	public boolean hasWinner() {
		return checkRows() || checkColumns() || checkDiagonal();
	}
	
	private boolean checkRows() {
		return (board[0][0].equalsIgnoreCase(board[0][1])
				&& board[0][1].equalsIgnoreCase(board[0][2])
				&& !board[0][1].equalsIgnoreCase("init")) ||
				(board[1][0].equalsIgnoreCase(board[1][1])
				&& board[1][1].equalsIgnoreCase(board[1][2])
				&& !board[1][0].equalsIgnoreCase("init")) ||
				(board[2][0].equalsIgnoreCase(board[2][1])
				&& board[2][1].equalsIgnoreCase(board[2][2])
				&& !board[2][0].equalsIgnoreCase("init"));
				
	}
	
	private boolean checkColumns() {
		return (board[0][0].equalsIgnoreCase(board[1][0])
				&& board[1][0].equalsIgnoreCase(board[2][0])
				&& !board[0][0].equalsIgnoreCase("init")) ||
				(board[0][1].equalsIgnoreCase(board[1][1])
				&& board[1][1].equalsIgnoreCase(board[2][1])
				&& !board[0][1].equalsIgnoreCase("init")) ||
				(board[0][2].equalsIgnoreCase(board[1][2])
				&& board[1][2].equalsIgnoreCase(board[2][2])
				&& !board[0][2].equalsIgnoreCase("init"));
		
	}
	
	private boolean checkDiagonal() {
		return board[0][0].equalsIgnoreCase(board[1][1])
				&& board[1][1].equalsIgnoreCase(board[2][2])
				&& !board[1][1].equalsIgnoreCase("init");
	}

}
