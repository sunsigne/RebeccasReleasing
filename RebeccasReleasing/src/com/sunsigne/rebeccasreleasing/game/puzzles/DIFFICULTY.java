package com.sunsigne.rebeccasreleasing.game.puzzles;

import com.sunsigne.rebeccasreleasing.Todo;

@Todo("!! purple est une difficult� legendaire (pour les boss), � ne pas utiliser comme les autres")
public enum DIFFICULTY {
	
	NONE(0),
	CYAN(1),
	GREEN(2),
	YELLOW(3),
	ORANGE(4),
	RED(5),
	PURPLE(6);

	public static final int MIN = 1;
	public static final int MAX = 5;
	public static final int MAX_AND_LEGENDRAY = MAX + 1;
	
	private int lvl;

	DIFFICULTY(int lvl) {

		this.lvl = lvl;
	}

	public int getLvl() {
		return lvl;
	}
	
	public static DIFFICULTY getDifficulty(int lvl) {

		DIFFICULTY difficulty = null;

		for (DIFFICULTY alldifficulty : DIFFICULTY.values()) {
			if (alldifficulty.getLvl() == lvl)
				difficulty = alldifficulty;
		}

		return difficulty;
	}
	
	
	
}
