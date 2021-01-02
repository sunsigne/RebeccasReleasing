package com.sunsigne.rebeccasreleasing.game.chat;

import com.sunsigne.rebeccasreleasing.game.world.World;

import objects.characters.CHARA;

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
			chat(CHARA.Rebecca, read(2), null);
			break;
		case 2:
			chat(CHARA.Sarah, read(4), read(5));
			break;
		case 3:
			chat(CHARA.Rebecca, read(7), null);
			break;
		case 4:
			chat(CHARA.Sarah, read(9), read(10));
			break;
		case 5:
			chat(CHARA.Sarah, read(11), read(12));
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
			chat(CHARA.Rebecca, read(15), read(16));
			break;
		case 2:
			chat(CHARA.Sarah, read(18), read(19));
			break;
		case 3:
			close();
			break;
		}
	}

	@Override
	public void chat03(int count) {
		switch (count) {
		case 1:
			chat(CHARA.Sarah, read(22), read(23));
			break;
		case 2:
			close();
			break;
		}
	}

	@Override
	public void chat04(int count) {
		switch (count) {
		case 1:
			chat(CHARA.Sarah, read(25), null);
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
			chat(CHARA.Rebecca, read(28), null);
			break;
		case 2:
			chat(CHARA.Sarah, read(30), read(31));
			break;
		case 3:
			chat(CHARA.Sarah, read(32), read(33));
			World.world.getIEvent().setMustoccur(true, 6);
			break;
		case 4:
			chat(CHARA.Sarah, read(34), null);
			break;
		case 5:
			chat(CHARA.Rebecca, read(36), null);
			break;
		case 6:
			chat(CHARA.Sarah, read(38), read(39));
			break;
		case 7:
			close();
			break;
		}
	}

	@Override
	public void chat06(int count) {
	}

	@Override
	public void chat07(int count) {
		switch (count) {
		case 1:
			chat(CHARA.Rebecca, read(42), null);
			break;
		case 2:
			chat(CHARA.Sarah, read(44), read(45));
			break;
		case 3:
			close();
			break;
		}
	}

	@Override
	public void chat08(int count) {
		switch (count) {
		case 1:
			chat(CHARA.Rebecca, read(48), null);
			break;
		case 2:
			chat(CHARA.Sarah, read(50), read(51));
			break;
		case 3:
			close();
			break;
		}
	}

	@Override
	public void chat09(int count) {
		switch (count) {
		case 1:
			chat(CHARA.Sarah, read(54), read(55));
			break;
		case 2:
			chat(CHARA.Rebecca, read(57), null);
			break;
		case 3:
			chat(CHARA.Sarah, read(59), read(60));
			break;
		case 4:
			chat(CHARA.Rebecca, read(62), null);
			break;
		case 5:
			chat(CHARA.Rebecca, read(64), read(65));
			break;
		case 6:
			close();
			break;
		}
	}

	@Override
	public void chat10(int count) {
	}

	@Override
	public void chat11(int count) {
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
