package com.sunsigne.rebeccasreleasing.game.power;

public enum POWER {

	KEY_WALLDESTROYER(0);

	private int num;

	POWER(int num) {

		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public static POWER getPower(int num) {

		POWER power = null;

		for (POWER allpower : POWER.values()) {
			if (allpower.getNum() == num)
				power = allpower;
		}

		return power;
	}

}
