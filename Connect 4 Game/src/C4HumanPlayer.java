import java.util.*;

public class C4HumanPlayer extends ConnectPlayer{
	boolean quit=false;
	public C4HumanPlayer(char piece) {
		super(piece);
	}
	@Override
	public int getColumn() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int column = 0;
		System.out.println((this.piece=='R')? "\rRed's Turn: Pick a column (1-7) or ('quit') to quit:  ":"\rYellow's Turn: Pick a column (1-7) or ('quit') to quit:  ");
		if(!input.hasNext("quit")) {
	    column = input.nextInt();
		column = column -1;
		}
		else {
			return -1;
		}
		return column;
		
	}
	
}
