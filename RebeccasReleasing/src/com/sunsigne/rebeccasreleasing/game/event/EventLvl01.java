package com.sunsigne.rebeccasreleasing.game.event;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.chat.Chat;
import com.sunsigne.rebeccasreleasing.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.onlyconductortorebuild.Conductor;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.living.FoeObject;
import objects.world.puzzler.Door;
import objects.world.puzzler.IPuzzler;

public class EventLvl01 extends EventBuilder {

	private static final ChatMap frlvl01 = new ChatMap(LANGUAGE.FRENCH, new GameFile("/dialogues/french/lvl01"));
	private static final ChatMap englvl01 = new ChatMap(LANGUAGE.ENGLISH, new GameFile("/dialogues/english/lvl01"));

	@Override
	public void event00() {

	}

	@Override
	public void event01() {

	}

	@Override
	public void event02() {

	}

	@Override
	public void event03() {

	}

	@Override
	public void event04() {

	}

	@Override
	public void event05() {

	}

	@Override
	public void event06() {
	}

	@Override
	public void event07() {
	}

	@Override
	public void event08() {
	}

	@Override
	public void event09() {

	}

	@Override
	public void event10() {

	}

	@Override
	public void event11() {

	}

	@Override
	public void event12() {
	}

	@Override
	public void event13() {
	}

	@Override
	public void event14() {
	}

	@Override
	public void event15() {
	}

	// !! currently, give the wrong door (because not recalculate when puzzle
	// solved)
	private void moveThePlayerFutherFromDoor() {
		int playerPosX = HandlerObject.getInstance().player.getX();
		HandlerObject.getInstance().player.setX(playerPosX - Size.TILE / 2);
	}

	@Todo("unfinished method")
	private IPuzzler getMostLeftPuzzler(OBJECTID objectID) {
		IPuzzler object = null;
		if (objectID == OBJECTID.DOOR)
			object = new Door(99999, 0, false, DIFFICULTY.CYAN);
		if (objectID == OBJECTID.FOE)
			object = new FoeObject(99999, 0, DIFFICULTY.CYAN);

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(true);
		for (GameObject tempObject : list) {
			if (tempObject.getId() == objectID) {
				IPuzzler tempPuzzler = (IPuzzler) tempObject;
				if (!tempPuzzler.isSolved() && tempObject.getX() < ((GameObject) object).getX())
					object = tempPuzzler;
			}
		}
		return object;
	}

}
