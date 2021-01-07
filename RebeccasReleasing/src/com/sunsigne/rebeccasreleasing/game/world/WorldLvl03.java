package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.event.EventLvl03;
import com.sunsigne.rebeccasreleasing.game.event.IEvent;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;

public class WorldLvl03 implements ILvl {

	@Override
	public int getLvlNumber() {
		return 3;
	}
	
	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.lvl03_cutout;
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.lvl03;
	}

	@Override
	public IEvent getIEvent() {
		return new EventLvl03();
	}

}
