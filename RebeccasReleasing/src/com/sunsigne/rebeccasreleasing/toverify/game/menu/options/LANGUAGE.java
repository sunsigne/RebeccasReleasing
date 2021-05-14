package com.sunsigne.rebeccasreleasing.toverify.game.menu.options;

public enum LANGUAGE {

	ENGLISH(1), FRENCH(2), CUSTOM(3);

	private int num;

	LANGUAGE(int num) {

		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public static LANGUAGE getLanguage(int num) {

		LANGUAGE language = null;

		for (LANGUAGE alllanguage : LANGUAGE.values()) {
			if (alllanguage.getNum() == num)
				language = alllanguage;
		}

		return language;
	}
	
	public static int getTotalLanguages() {
		return LANGUAGE.values().length;
	}

}
