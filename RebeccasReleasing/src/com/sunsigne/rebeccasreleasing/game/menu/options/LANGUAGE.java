package com.sunsigne.rebeccasreleasing.game.menu.options;

import com.sunsigne.rebeccasreleasing.Todo;

@Todo("at least, create ONE customable language, for developpers")
public enum LANGUAGE {

	ENGLISH(1), FRENCH(2), ;

	public static final int TOTALNUM = 2;
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

}
