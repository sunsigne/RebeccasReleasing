package objects.world.puzzler;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable.TutoPuzzleKey;

public class TutoDoor extends Door implements IPuzzler {

	// this specific door is exactly like a regular one but open a tutoPuzzleKey
	public TutoDoor(int x, int y, boolean horizontal) {
		super(x, y, horizontal, DIFFICULTY.CYAN);
	}

	@Override
	public Puzzle getPuzzle() {
		return new TutoPuzzleKey(this);
	}

}
