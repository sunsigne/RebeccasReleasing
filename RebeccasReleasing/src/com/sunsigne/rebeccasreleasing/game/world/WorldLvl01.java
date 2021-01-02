package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.event.EventLvl01;
import com.sunsigne.rebeccasreleasing.game.event.IEvent;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;

public class WorldLvl01 implements ILvl {

	@Override
	public int getLvlNumber() {
		return 1;
	}

	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.lvl01_cutout;
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.lvl01;
	}

	@Override
	public IEvent getIEvent() {
		return new EventLvl01();
	}

}
