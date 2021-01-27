package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.event.Event;
import com.sunsigne.rebeccasreleasing.game.event.EventContext;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class WorldLvlTest implements ILvl {

	@Override
	public int getLvlNumber() {
		return 0;
	}

	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.getImage(ImageBank.lvltest_cutout);
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.getImage(ImageBank.lvltest);
	}

	@Override
	public void loadEvent() {
		eventMakeAllFoeStupid();
	}

	private void eventMakeAllFoeStupid() {
		new Event("Make All Foe Stupid", new EventContext() {

			// When the level start
			@Override
			public boolean startingCondition() {
				return Conductor.getState() == STATE.LEVEL;
			}

			// Turn all foes into statues
			@Override
			public void startEvent() {
				World.makeAllFoesStatue();
				Conductor.setState(STATE.LEVEL);
				HandlerObject.getInstance().player.loadBasicState();
			}
			
		});
	}

}
