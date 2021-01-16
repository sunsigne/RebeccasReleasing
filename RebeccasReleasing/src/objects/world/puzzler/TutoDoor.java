package objects.world.puzzler;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.TutoPuzzleKey;
import com.sunsigne.rebeccasreleasing.toclean.verify.IPuzzler;

public class TutoDoor extends Door implements IPuzzler {

	// this specific door is exactly like a regular one, but open a tutoPuzzleKey instead
	public TutoDoor(int x, int y, boolean horizontal) {
		super(x, y, horizontal, DIFFICULTY.CYAN);
	}
	
	@Override
	public Puzzle getPuzzle() {
			return new TutoPuzzleKey(this);
	}

}
