package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.event.EventLvl02;
import com.sunsigne.rebeccasreleasing.game.event.IEvent;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;

public class WorldLvl02 implements ILvl {

	@Override
	public int getLvlNumber() {
		return 2;
	}
	
	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.lvl02_cutout;
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.lvl02;
	}

	@Override
	public IEvent getIEvent() {
		return new EventLvl02();
	}

}
