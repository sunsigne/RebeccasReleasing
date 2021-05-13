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
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.getImage(ImageBank.lvltest_cutout);
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.getImage(ImageBank.lvltest);
	}

	@Override
	public void loadEvent() {
		eventMakeAllFoeStatue();
	}

	private void eventMakeAllFoeStatue() {
		new Event("Make All Foe Statue", new EventContext() {

			// When the level start
			@Override
			public boolean startingCondition() {
				return Conductor.getState() == STATE.LEVEL;
			}

			// Turn all foes into statues
			@Override
			public void startEvent() {
				makeAllFoesStatue();
				Conductor.setState(STATE.LEVEL);
				HandlerObject.getInstance().player.loadBasicState();
			}
			
		});
	}
	

	public static void makeAllFoesStatue() {

		boolean isCameraDependant = true;
		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant);
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.FOE) {
				FoeObject tempFoe = (FoeObject) tempObject;
				tempFoe.setStatue(true);
			}
		}
	}


}
