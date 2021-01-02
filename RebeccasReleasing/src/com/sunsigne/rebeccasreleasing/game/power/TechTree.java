package com.sunsigne.rebeccasreleasing.game.power;

import com.sunsigne.rebeccasreleasing.Todo;

@Todo("tech tree : dezoom, break doors, doors doesn't reclosed with time, smaller key, longer stunned ennemy, crit chance")
public class TechTree {

	private boolean[] haspower = new boolean[2];
	private boolean exist;

	public TechTree() {
//		setPower(POWER.Key_WallDestroyer, true);
		setExist(true);
	}

	// state

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public boolean doesExist() {
		return exist;
	}

	public void setPower(POWER power, boolean haspower) {
		for (POWER allpower : POWER.values()) {
			if (allpower.equals(power))
				this.haspower[power.getNum()] = haspower;
		}
	}

	public boolean hasPower(POWER power) {
		boolean flag = false;

		for (POWER allpower : POWER.values()) {
			if (allpower.equals(power))
				flag = haspower[power.getNum()];
		}

		return flag;
	}

}
