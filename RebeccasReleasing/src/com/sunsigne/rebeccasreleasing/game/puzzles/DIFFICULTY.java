package com.sunsigne.rebeccasreleasing.game.puzzles;

public enum DIFFICULTY {

	GREEN(1),
	YELLOW(2),
	ORANGE(3),
	RED(4);
	
	
	private int num;

	DIFFICULTY(int num) {

		this.num = num;
	}

	public int getNum() {
		return num;
	}
	
}
