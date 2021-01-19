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
		if (HandlerObject.getInstance().isPlayerExisting) {
			event(0);
			World.gui.setInfinitHp(true);
			HandlerObject.getInstance().player.setVelY(0);
			HandlerObject.getInstance().player.setVelX(Size.TILE / 16);

		}
	}

	@Override
	public void event01() {
		if (HandlerObject.getInstance().player.getX() > 2400) {
			event(1);
			new Chat(1, null, frlvl01, englvl01);
		}
	}

	@Override
	public void event02() {

		if (HandlerObject.getInstance().player.getX() > 3700 && HandlerObject.getInstance().player.getY() < 3000) {
			event(2);
			new Chat(2, () -> setMustoccur(true, 3), frlvl01, englvl01);
		}
	}

	@Todo("rendre l'apparition de l'outils + évidente ! (nouveau dessin de cutout ?)"
			+ "éventuellemt faire loot la clef (l'idée est bonne mais il faut justifier le fait de ne pas looter l'épée ...")
	@Override
	public void event03() {
		if (getMustoccur(3)) {
			event(3);
			World.gui.getCharacteristics().getTool(Tool.KEY).upgradeLvlTo(1);
			World.gui.setRedtool(true, 0);
			SoundTask.playSound(SoundBank.getSound(SoundBank.popup));
			Conductor.setState(STATE.LEVEL);
			getMostLeftPuzzler(OBJECTID.DOOR).setEventOnClose(() -> setMustoccur(true, 4), false);
		}
	}

	@Override
	public void event04() {
		if (getMustoccur(4)) {
			event(4);
			moveThePlayerFutherFromDoor();
			new Chat(3, null, frlvl01, englvl01);
			getMostLeftPuzzler(OBJECTID.DOOR).setEventOnClose(() -> setMustoccur(true, 5), false);
		}
	}

	@Override
	public void event05() {
		if (getMustoccur(5)) {
			event(5);
			moveThePlayerFutherFromDoor();
			new Chat(4, null, frlvl01, englvl01);
		}
	}

	@Override
	public void event06() {
		if (HandlerObject.getInstance().player.getX() > 4530) {
			event(6);
			setMustoccur(false, 4);
			setMustoccur(false, 5);
			// event 7 during chat
			new Chat(5, null, frlvl01, englvl01);
		}
	}

	@Override
	public void event07() {
		if (getMustoccur(7)) {
			event(7);
			World.gui.setInfinitHp(false);
		}
	}

	@Override
	public void event08() {
		if (HandlerObject.getInstance().player.getX() > 5720) {
			event(8);
			new Chat(6, () -> setMustoccur(true, 9), frlvl01, englvl01);
		}
	}

	@Override
	public void event09() {
		if (getMustoccur(9)) {
			event(9);
			World.gui.getCharacteristics().getTool(Tool.SWORD).upgradeLvlTo(1);
			World.gui.setRedtool(true, 1);
			SoundTask.playSound(SoundBank.getSound(SoundBank.popup));
			Conductor.setState(STATE.LEVEL);
			getMostLeftPuzzler(OBJECTID.FOE).setEventOnClose(() -> setMustoccur(true, 10), false);
			getMostLeftPuzzler(OBJECTID.FOE).setEventOnClose(() -> setMustoccur(true, 11), true);
		}
	}

	@Override
	public void event10() {
		if (getMustoccur(10)) {
			event(10);
			new Chat(7, null, frlvl01, englvl01);
		}
	}

	@Override
	public void event11() {
		if (getMustoccur(11)) {
			event(11);
			setMustoccur(false, 10);
			new Chat(8, null, frlvl01, englvl01);
		}
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
