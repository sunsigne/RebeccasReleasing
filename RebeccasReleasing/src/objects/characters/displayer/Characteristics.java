package objects.characters.displayer;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;

public class Characteristics {

	private boolean sureCrit;
	private DIFFICULTY key = DIFFICULTY.GREEN;
	
	
	public boolean isSureCrit() {
		return sureCrit;
	}

	public void setSureCrit(boolean sureCrit) {
		this.sureCrit = sureCrit;
	}

	public DIFFICULTY getKey() {
		return key;
	}

	public void setKey(DIFFICULTY key) {
		this.key = key;
	}
}
