package com.sunsigne.rebeccasreleasing.game.event;

import com.sunsigne.rebeccasreleasing.game.chat.ChatLvl01;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class EventLvl01 extends EventBuilder {

	
	@Override
	public void event00() {
		if (HandlerObject.getInstance().isPlayerExisting) {
			event(0);
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

	@Override
	public void event03() {
		if (getMustoccur(3)) {
			event(3);
			setMustoccur(false, 3);
			new ChatLvl01(3);
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
		if (HandlerObject.getInstance().player.getX() > 4530) {
			event(5);
			setMustoccur(false, 3);
			setMustoccur(false, 4);
			new ChatLvl01(5);
		}
	}

	@Override
	public void event06() {
		if (getMustoccur(6)) {
			event(6);
			setMustoccur(false, 6);
			int points = World.gui.getPoints();
			World.startGUI();
			World.gui.setPoints(points);
		}
	}

	@Override
	public void event07() {
		if (HandlerObject.getInstance().player.getX() > 5720) {
			event(7);
			new ChatLvl01(7);
		}
	}

	@Override
	public void event08() {
		if (getMustoccur(8)) {
			event(8);
			setMustoccur(false, 8);
			new ChatLvl01(8);
		}
	}

	@Override
	public void event09() {
		if (getMustoccur(9)) {
			event(9);
			setMustoccur(false, 8);
			setMustoccur(false, 9);
			new ChatLvl01(9);
		}
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


}
