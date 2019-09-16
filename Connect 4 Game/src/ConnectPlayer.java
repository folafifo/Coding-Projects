

public abstract class  ConnectPlayer {
	protected char piece;
	protected int lastRow;
	protected int lastColumn;
	abstract int getColumn() ;
	ConnectPlayer(char piece){
		this.piece=piece;
		this.lastColumn=0;
		this.lastRow=0;
	}
	public void displayWinner() {
		
		System.out.println((this.piece=='R')?"Red Wins!":"Yellow Wins!");
	}
	
}
