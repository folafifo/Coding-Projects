
import java.util.Scanner;
public class Game {
	public static final char CROSS = 'x';
	public static final char NOUGHT = 'o';
	public static final char EMPTY = ' ';
	public static final String UP_BARRIER = " | ";
	public static final String LOW_BARRIER = "-";
	public static void fillBoard(char[][] board) {
		for (int row = 0; (row < board.length); row++)
			for (int column = 0; (column < board[row].length); column++)
				board[row][column] = 'r';
	}
	public static void clearBoard(char[][] board) {
		for (int row = 0; (row < board.length); row++) {
			for (int column = 0; (column < board[row].length); column++)
				board[row][column] = EMPTY;
		}
	}
	public static void printBoard(char[][] board) {
		int useLine = 0;
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[row].length; column++) {
				String ending = "";
				ending = (column == 2) ? " " : UP_BARRIER;
				System.out.print(board[row][column] + ending);
			}
			if (useLine < 2) {
				System.out.println("\r----------");
				useLine++;
			}
		}
	}
	public static boolean canMakeMove(char[][] board, int row, int column) {
		if (board[row][column] != EMPTY) {
			return false;
		} else
			return true;
	}
	public static void makeMove(char[][] board, char currentPlayerPiece, int row, int column) {
		if ((currentPlayerPiece == NOUGHT) || (currentPlayerPiece == CROSS)) {
			board[row][column] = currentPlayerPiece;
		} else
			System.out.println("Sorry Invalid Character Input. ");
	}
	public static boolean isBoardFull(char[][] board) {
		for (int row = 0; (row < board.length); row++)
			for (int column = 0; (column < board[row].length); column++)
				if (board[row][column] == EMPTY) {
					return false;
				}
		return true;
	}
	public static char winner(char[][] board) {
		if ((board[0][0] == NOUGHT) && (board[0][1] == NOUGHT) && (board[0][2] == NOUGHT)) {
			return NOUGHT;
		}
		if ((board[0][0] == CROSS) && (board[0][1] == CROSS) && (board[0][2] == CROSS)) {
			return CROSS;
		}
		if ((board[1][0] == NOUGHT) && (board[1][1] == NOUGHT) && (board[1][2] == NOUGHT)) {
			return NOUGHT;
		}
		if ((board[1][0] == CROSS) && (board[1][1] == CROSS) && (board[1][2] == CROSS)) {
			return CROSS;
		}
		if ((board[2][0] == NOUGHT) && (board[2][1] == NOUGHT) && (board[2][2] == NOUGHT)) {
			return NOUGHT;
		}
		if ((board[2][0] == CROSS) && (board[2][1] == CROSS) && (board[2][2] == CROSS)) {
			return CROSS;
		}
		if ((board[0][0] == NOUGHT) && (board[1][0] == NOUGHT) && (board[2][0] == NOUGHT)) {
			return NOUGHT;
		}
		if ((board[0][0] == CROSS) && (board[1][0] == CROSS) && (board[2][0] == CROSS)) {
			return CROSS;
		}
		if ((board[0][1] == NOUGHT) && (board[1][1] == NOUGHT) && (board[2][1] == NOUGHT)) {
			return NOUGHT;
		}
		if ((board[0][1] == CROSS) && (board[1][1] == CROSS) && (board[2][1] == CROSS)) {
			return CROSS;
		}
		if ((board[0][2] == NOUGHT) && (board[1][2] == NOUGHT) && (board[2][2] == NOUGHT)) {
			return NOUGHT;
		}
		if ((board[0][2] == CROSS) && (board[1][2] == CROSS) && (board[2][2] == CROSS)) {
			return CROSS;
		}
		if ((board[0][0] == NOUGHT) && (board[1][1] == NOUGHT) && (board[2][2] == NOUGHT)) {
			return NOUGHT;
		}
		if ((board[0][0] == CROSS) && (board[1][1] == CROSS) && (board[2][2] == CROSS)) {
			return CROSS;
		}
		if ((board[0][2] == NOUGHT) && (board[1][1] == NOUGHT) && (board[2][0] == NOUGHT)) {
			return NOUGHT;
		}
		if ((board[0][2] == CROSS) && (board[1][1] == CROSS) && (board[2][0] == CROSS)) {
			return CROSS;
		}
		return EMPTY;
	}
	public static void main(String[] args) {
		char board[][] = new char[3][3];
		Scanner input = new Scanner(System.in);
		clearBoard(board);
		char currentPlayerPiece = CROSS;
		char winner = EMPTY;
		System.out.println("Player 1 is Crosses. Player 2 is Noughts. ");
		printBoard(board);
		while (!isBoardFull(board)) {
			System.out.print("\rPlease enter a row and column " + "separated by spaces ranging from 1-3: ");
			int row = input.nextInt();
			int column = input.nextInt();
			column-=1;
			row-=1;
			if (canMakeMove(board, row, column)) {
				makeMove(board, currentPlayerPiece, row, column);
				printBoard(board);
			} else if (!canMakeMove(board, row, column)) {
				System.out.println("Sorry that space is taken! ");
				fillBoard(board);
			}
			winner = winner(board);
			if ((winner == NOUGHT) || (winner == CROSS)) {
				fillBoard(board);
			}
			if (currentPlayerPiece == NOUGHT) {
				currentPlayerPiece = CROSS;
			} else if (currentPlayerPiece == CROSS) {
				currentPlayerPiece = NOUGHT;
			}
		}
		if (winner == NOUGHT) {
			System.out.println("\rThe winner is Noughts!");
		}
		if (winner == CROSS) {
			System.out.println("\rThe winner is Crosses!");
		}
		if ((winner == EMPTY) && (!(board[0][0] == 'r'))) {
			System.out.println("\rThe game is a draw!");
		}
		input.close();
	}
}
