package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;

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

	}

}
