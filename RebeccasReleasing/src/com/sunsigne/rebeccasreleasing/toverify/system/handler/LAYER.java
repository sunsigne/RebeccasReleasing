package com.sunsigne.rebeccasreleasing.toverify.system.handler;

public enum LAYER {
	
	WOLRD_GUI_PUZZLE(0),
	DIALOGUE_VENT(1),
	QUIT_MENU(2);

	private int num;

	LAYER(int num) {

		this.num = num;
	}

	public int getNum() {
		return num;
	}
	
}
