package com.sunsigne.rebeccasreleasing.toverify.game.objects;

public class Facing {

	public int getNum() {
		if (direction.getNum() != -1)
			return direction.getNum();
		if (axis.getNum() != -1)
			return axis.getNum();
		return -1;
	}

	public boolean isHorizontal() {

		boolean flag = false;

		if (direction == DIRECTION.LEFT)
			flag = true;
		if (direction == DIRECTION.RIGHT)
			flag = true;
		if (axis == AXIS.HORIZONTAL)
			flag = true;

		return flag;
	}

	public static boolean isHorizontal(DIRECTION direction) {
		
		boolean flag = false;

		if (direction == DIRECTION.LEFT)
			flag = true;
		if (direction == DIRECTION.RIGHT)
			flag = true;

		return flag;
	}

	////////// DIRECTION ////////////

	private DIRECTION direction;

	public Facing(DIRECTION direction) {
		this.direction = direction;
		this.axis = AXIS.NULL;
	}

	public DIRECTION getDirection() {
		return direction;
	}

	public void setDirection(DIRECTION direction) {
		this.direction = direction;
	}

	public enum DIRECTION {
		NULL(-1), LEFT(0), RIGHT(1), UP(2), DOWN(3);

		private int num;

		DIRECTION(int num) {

			this.num = num;
		}

		public int getNum() {
			return num;
		}
	}

	////////// AXIS ////////////

	private AXIS axis;

	public Facing(AXIS axis) {
		this.direction = DIRECTION.NULL;
		this.axis = axis;
	}

	public enum AXIS {
		NULL(-1), VERTICAL(4), HORIZONTAL(5);

		private int num;

		AXIS(int num) {

			this.num = num;
		}

		public int getNum() {
			return num;
		}
	}
}
