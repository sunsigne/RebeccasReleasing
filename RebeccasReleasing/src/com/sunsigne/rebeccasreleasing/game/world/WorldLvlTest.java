package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.event.Event;
import com.sunsigne.rebeccasreleasing.game.event.EventContext;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.living.FoeObject;

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

			// Set to player infinite hp (so generous!)
			// Move player to the right
			@Override
			public void startEvent() {
				World.makeAllFoesStupid();
				Conductor.setState(STATE.LEVEL);
				HandlerObject.getInstance().player.loadBasicState();
			}
			
		});
	}

}
