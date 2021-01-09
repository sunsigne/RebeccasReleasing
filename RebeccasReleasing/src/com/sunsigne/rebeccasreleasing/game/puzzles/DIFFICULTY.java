package com.sunsigne.rebeccasreleasing.game.puzzles;

public enum DIFFICULTY {

	NONE(0),
	CYAN(1),
	GREEN(2),
	YELLOW(3),
	ORANGE(4),
	RED(5);

	
	private int num;

	DIFFICULTY(int num) {

		this.num = num;
	}

	public int getNum() {
		return num;
	}
	
	public static DIFFICULTY getDifficulty(int num) {

		DIFFICULTY difficulty = null;

		for (DIFFICULTY alldifficulty : DIFFICULTY.values()) {
			if (alldifficulty.getNum() == num)
				difficulty = alldifficulty;
		}

		return difficulty;
	}
	
	
	
}
