package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;

public class WorldLvl03 implements ILvl {

	@Override
	public int getLvlNumber() {
		return 3;
	}
	
	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.getImage(ImageBank.lvl03_cutout);
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.getImage(ImageBank.lvl03);
	}

	@Override
	public void loadEvent() {

	}

}
