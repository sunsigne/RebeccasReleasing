package com.sunsigne.rebeccasreleasing.game.chat;

import com.sunsigne.rebeccasreleasing.game.world.World;

public class ChatLvl01 extends Chat {

	private static final String lvlFrTxt = "/dialogues/french/lvl01";
	private static final String lvlEngTxt = "/dialogues/english/lvl01";

	public ChatLvl01(int number) {
		super(number, lvlFrTxt, lvlEngTxt);
	}

	@Override
	public void chat00(int count) {
	}

	@Override
	public void chat01(int count) {
		switch (count) {
		case 1:
			chat(1, 0);
			break;
		case 2:
			chat(2, 3);
			break;
		case 3:
			chat(4, 0);
			break;
		case 4:
			chat(5, 6);
			break;
		case 5:
			chat(7, 8);
			break;
		case 6:
			close();
			break;
		}
	}

	@Override
	public void chat02(int count) {
		switch (count) {
		case 1:
			chat(9, 10);
			break;
		case 2:
			chat(11, 12);
			break;
		case 3:
			World.world.getIEvent().setMustoccur(true, 3);
			close();
			break;
		}
	}

	@Override
	public void chat03(int count) {
	}

	@Override
	public void chat04(int count) {
		switch (count) {
		case 1:
			chat(13, 14);
			break;
		case 2:
			close();
			break;
		}
	}

	@Override
	public void chat05(int count) {
		switch (count) {
		case 1:
			chat(15, 0);
			break;
		case 2:
			close();
			break;
		}
	}

	@Override
	public void chat06(int count) {
		switch (count) {
		case 1:
			chat(16, 0);
			break;
		case 2:
			chat(17, 18);
			break;
		case 3:
			chat(19, 20);
			World.world.getIEvent().setMustoccur(true, 7);
			break;
		case 4:
			chat(21, 0);
			break;
		case 5:
			chat(22, 0);
			break;
		case 6:
			chat(23, 24);
			break;
		case 7:
			close();
			break;
		}
	}

	@Override
	public void chat07(int count) {
	}

	@Override
	public void chat08(int count) {
		switch (count) {
		case 1:
			chat(25, 0);
			break;
		case 2:
			chat(26, 27);
			break;
		case 3:
			World.world.getIEvent().setMustoccur(true, 9);
			close();
			break;
		}
	}

	@Override
	public void chat09(int count) {
	}

	@Override
	public void chat10(int count) {
		switch (count) {
		case 1:
			chat(28, 0);
			break;
		case 2:
			chat(29, 30);
			break;
		case 3:
			close();
			break;
		}
	}

	@Override
	public void chat11(int count) {
		switch (count) {
		case 1:
			chat(31, 33);
			break;
		case 2:
			chat(33, 0);
			break;
		case 3:
			chat(34, 35);
			break;
		case 4:
			chat(36, 0);
			break;
		case 5:
			chat(37, 38);
			break;
		case 6:
			close();
			break;
		}
	}

	@Override
	public void chat12(int count) {
	}

	@Override
	public void chat13(int count) {
	}

	@Override
	public void chat14(int count) {
	}

	@Override
	public void chat15(int count) {
	}

}
