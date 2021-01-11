package com.sunsigne.rebeccasreleasing.game.event;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.chat.ChatLvl01;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.characters.displayer.Tool;

public class EventLvl01 extends EventBuilder {

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
			new ChatLvl01(1);
		}
	}

	@Override
	public void event02() {

		if (HandlerObject.getInstance().player.getX() > 3700 && HandlerObject.getInstance().player.getY() < 3000) {
			event(2);
			new ChatLvl01(2);
		}
	}

	@Todo("rendre l'apparition de l'outils + évidente ! (nouveau dessin de cutout ?)")
	@Override
	public void event03() {
		if (getMustoccur(3)) {
			event(3);
			setMustoccur(false, 3);
			World.gui.getCharacteristics().getTool(Tool.KEY).upgradeTool();
			World.gui.setRedtool(true, 0);
			AudioTask.playSound(AudioBank.popup);
			Conductor.setState(STATE.LEVEL);
		}
	}

	@Override
	public void event04() {
		if (getMustoccur(4)) {
			event(4);
			setMustoccur(false, 4);
			new ChatLvl01(4);
		}
	}

	@Override
	public void event05() {
		if (getMustoccur(5)) {
			event(5);
			setMustoccur(false, 5);
			new ChatLvl01(5);
		}
	}

	@Override
	public void event06() {
		if (HandlerObject.getInstance().player.getX() > 4530) {
			event(6);
			setMustoccur(false, 4);
			setMustoccur(false, 5);
			new ChatLvl01(6);
		}
	}

	@Override
	public void event07() {
		if (getMustoccur(7)) {
			event(7);
			setMustoccur(false, 7);
			World.gui.setInfinitHp(false);
		}
	}

	@Override
	public void event08() {
		if (HandlerObject.getInstance().player.getX() > 5720) {
			event(8);
			new ChatLvl01(8);
		}
	}

	@Override
	public void event09() {
		if (getMustoccur(9)) {
			event(9);
			setMustoccur(false, 9);
			World.gui.getCharacteristics().getTool(Tool.SWORD).upgradeTool();
			World.gui.setRedtool(true, 1);
			AudioTask.playSound(AudioBank.popup);
			Conductor.setState(STATE.LEVEL);
		}
	}

	@Override
	public void event10() {
		if (getMustoccur(10)) {
			event(10);
			setMustoccur(false, 10);
			new ChatLvl01(10);
		}
	}

	@Override
	public void event11() {
		if (getMustoccur(11)) {
			event(11);
			setMustoccur(false, 10);
			setMustoccur(false, 11);
			new ChatLvl01(11);
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

}
