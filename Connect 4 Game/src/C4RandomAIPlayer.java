import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {

	C4RandomAIPlayer(char piece) {
		super(piece);
	}

	@Override
	int getColumn() {
		Random generator = new Random();
		int column = generator.nextInt(7);
		return column;
	}
	
}
