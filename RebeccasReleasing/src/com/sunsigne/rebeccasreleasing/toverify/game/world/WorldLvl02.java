package com.sunsigne.rebeccasreleasing.toverify.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.toverify.ressources.images.ImageBank;

public class WorldLvl02 implements ILvl {

	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.getImage(ImageBank.lvl02[ImageBank.CUTOUT_MAP]);
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.getImage(ImageBank.lvl02[ImageBank.FULL_MAP]);
	}

	@Override
	public void loadEvent() {

	}

}
