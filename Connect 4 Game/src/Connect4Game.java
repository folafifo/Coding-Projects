
import java.util.*;

public class Connect4Game {
	public static void main(String[] args) {
		System.out.println("Lets play Connect 4!");
		Scanner input = new Scanner(System.in);
		System.out.println("Please select the option that suits you 1: Human v Human,"
				+ " 2: Human v Computer, 3: Quit");
		int option = input.nextInt();
		switch (option){
		case 1:
			Connect4Grid2DArray game = new Connect4Grid2DArray();
			game.emptyGrid();
			System.out.println(game.toString());
			C4HumanPlayer player1 = new C4HumanPlayer('R');
			C4HumanPlayer player2 = new C4HumanPlayer('Y');
			game.currentPlayer = player1;
			boolean played = false;
			boolean finished = false;
			while(!finished) {
				int column = game.currentPlayer.getColumn();
				if (column!=-1) {
					if (game.isValidColumn(column) && !game.isColumnFull(column)) {
						game.dropPiece(game.currentPlayer, column);
						System.out.println(game.toString());
						System.out
								.println((game.currentPlayer.piece == 'R') ? "Red has Played in Column " + (column + 1)
										: "Yellow has Played in Column " + (column + 1));
						played = true;
					} else {
						System.out.println("That Column either does not exist or is Full. Please select another: ");
						played = false;
					}
					if (game.didLastPieceConnect4()) {
						game.currentPlayer.displayWinner();
						finished = true;
					} else if (game.isGridFull()) {
						System.out.println("\rGame over! its a draw!!!");
						finished = true;
					} else if (played) {
						if (game.currentPlayer == player1) {
							game.currentPlayer = player2;
						} else if (game.currentPlayer == player2) {
							game.currentPlayer = player1;
						}
					} 
				}
				else {
					System.out.println("The game has been quit. Goodbye!");
					finished = true;
				}
			}
			break;	
		case 2:
			Connect4Grid2DArray vsAi = new Connect4Grid2DArray();
			vsAi.emptyGrid();
			System.out.println(vsAi.toString());
			boolean played1 = false;
			C4HumanPlayer human = new C4HumanPlayer('R');
			C4RandomAIPlayer ai = new C4RandomAIPlayer('Y');
			vsAi.currentPlayer = human;
			boolean finished1 = false;
			while(!finished1) {
				int column = vsAi.currentPlayer.getColumn();
				if (column!=-1) {
					if (vsAi.isValidColumn(column) && !vsAi.isColumnFull(column)) {
						vsAi.dropPiece(vsAi.currentPlayer, column);
						System.out.println(vsAi.toString());
						System.out.println(
								(vsAi.currentPlayer.piece == 'R') ? "Red has Played in Column " + (column + 1) + "."
										: "Yellow has Played in Column " + (column + 1) + ".");
						played1 = true;
					} else {
						System.out.println("That Column either does not exist or is Full. Please select another: ");
						played1 = false;
					}
					if (vsAi.didLastPieceConnect4()) {
						vsAi.currentPlayer.displayWinner();
						finished1 = true;
					} else if (vsAi.isGridFull()) {
						System.out.println("Game over! its a draw!!!");
						finished1 = true;
					} else if (played1) {
						if (vsAi.currentPlayer == human) {
							vsAi.currentPlayer = ai;
						} else if (vsAi.currentPlayer == ai) {
							vsAi.currentPlayer = human;
						}
					} 
				}
				else {
					System.out.println("The game has been quit. Goodbye!");
					finished1 = true;
				}
			}
			break;	
		case 3:
			System.out.println("Goodbye!");
			break;
		default:
			break;
		}
		input.close();
	}
}
