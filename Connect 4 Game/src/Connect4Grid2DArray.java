
public class Connect4Grid2DArray implements Connect4Grid {
	public final char EMPTY = '0';
	char[][] board = new char[6][7];
	ConnectPlayer currentPlayer;

	public void emptyGrid() {
		for (int row = 0; (row < this.board.length); row++) {
			for (int column = 0; (column < this.board[row].length); column++)
				this.board[row][column] = EMPTY;
		}
	}

	public String toString() {
		String board = "\r";
		board = board + "  1 2 3 4 5 6 7\r";
		for (int row = 0; (row < this.board.length); row++) {
			board = board + (row+1) + " ";
			for (int column = 0; (column < this.board[row].length); column++) {
				board = board + this.board[row][column];
				board = board + " " ;
			}
			board = board + "\r" ;
		}
		board = board + "\r";
		return board;
	}

	public boolean isValidColumn(int column) {
		if(column>6 || column<0) {
			return false;
		}
		return true;
	}

	public boolean isColumnFull(int column) {
		if (isValidColumn(column)) { 
			for (int row = 0; row < this.board.length; row++) {
				if (this.board[row][column] == EMPTY) {
					return false;
				}
			} 
		}
		else {
			return false;
		}
		return true;
	}

	public void dropPiece(ConnectPlayer player, int column) {
		boolean finished = false;
		if (isValidColumn(column)) {
			for (int row = 5; (row > -1) && (!finished); row--) {
				if (this.board[row][column] == EMPTY) {
					this.board[row][column] = player.piece;
					finished = true;
					player.lastRow = row;
					player.lastColumn = column;
				}
			}
		}
	}

	public boolean didLastPieceConnect4() {
//horizontal forwards
		int row =currentPlayer.lastRow;
		int count = 1;
		boolean finished = false;
		for(int column = currentPlayer.lastColumn+1;column< this.board[row].length&&!finished;column++) {
			if(board[row][column]==currentPlayer.piece) {
				count++;
			}
			else {
				finished = true;
			}
			if (count>=4) {
				return true;
			}
		}
//horizontal backwards	
		finished = false;
		for(int column = currentPlayer.lastColumn-1;column> -1&&!finished;column--) {
			if(board[row][column]==currentPlayer.piece) {
				count++;
			}
			else {
				finished = true;
			}
			if (count>=4) {
				return true;
			}
		}
//below
	    count = 1;
	    finished = false;
	    int column = currentPlayer.lastColumn;
		for( row = currentPlayer.lastRow+1;row<this.board.length&&!finished;row++) {
			if(board[row][column]==currentPlayer.piece) {
				count++;
			}
			else {
				finished = true;
			}
			if (count>=4) {
				return true;
			}
		}
// diagonal forward upward		
		count = 1;
		finished = false;
	    column = currentPlayer.lastColumn+1;
	    row =currentPlayer.lastRow-1;
		for( row = currentPlayer.lastRow-1;row>-1&&!finished&&column<this.board[row].length;row--,column++) {
			if(board[row][column]==currentPlayer.piece) {
				count++;
			}
			else {
				finished = true;
			}
			if (count>=4) {
				return true;
			}
		}
// diagonal backward downward
		finished = false;
	    column = currentPlayer.lastColumn-1;
	    row =currentPlayer.lastRow+1;
		for( row = currentPlayer.lastRow+1;row<this.board.length&&!finished&&column>-1;row++,column--) {
			if(board[row][column]==currentPlayer.piece) {
				count++;
			}
			else {
				finished = true;
			}
			if (count>=4) {
				return true;
			}
		}
// diagonal forward downward		
		count = 1;
		finished = false;
	    column = currentPlayer.lastColumn+1;
	    row =currentPlayer.lastRow+1;
		for( row = currentPlayer.lastRow+1;row<this.board.length&&!finished&&column<this.board[row].length;row++,column++) {
			if(board[row][column]==currentPlayer.piece) {
				count++;
			}
			else {
				finished = true;
			}
			if (count>=4) {
				return true;
			}
		}
// diagonal backward upward		
		finished = false;
	    column = currentPlayer.lastColumn-1;
	    row =currentPlayer.lastRow-1;
		for( row = currentPlayer.lastRow-1;row>-1&&!finished&&column>-1;row--,column--) {
			if(board[row][column]==currentPlayer.piece) {
				count++;
			}
			else {
				finished = true;
			}
			if (count>=4) {
				return true;
			}
		}
		return false;
	}

	public boolean isGridFull() {
		for (int row = 0; (row < this.board.length); row++) {
			for (int column = 0; (column < this.board[row].length); column++) {
				if (this.board[row][column] == '0') {
					return false;
				}
			}
		}
		return true;
	}
}
