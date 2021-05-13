package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;

public class WorldLvl02 implements ILvl {

	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.getImage(ImageBank.lvl02_cutout);
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.getImage(ImageBank.lvl02);
	}

	@Override
	public void loadEvent() {

	}

}
