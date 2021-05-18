package com.sunsigne.rebeccasreleasing.toverify.game.world;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.toverify.game.event.Event;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventContext;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.characters.living.FoeObject;

public class WorldLvlTest implements ILvl {

	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.getImage(ImageBank.lvlTest[ImageBank.CUTOUT_MAP]);
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.getImage(ImageBank.lvlTest[ImageBank.FULL_MAP]);
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
				HandlerObject.getInstance().getPlayer().loadBasicState();
			}
			
		});
	}
	

	public static void makeAllFoesStatue() {

		boolean isCameraDependant = true;
		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant, LAYER.WOLRD_GUI_PUZZLE);
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.FOE) {
				FoeObject tempFoe = (FoeObject) tempObject;
				tempFoe.setStatue(true);
			}
		}
	}


}
