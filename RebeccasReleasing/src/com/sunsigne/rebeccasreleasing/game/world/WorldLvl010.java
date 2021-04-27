package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;

public class WorldLvl010 implements ILvl {

	@Override
	public int getLvlNumber() {
		return 010;
	}
	
	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.getImage(ImageBank.lvl010_cutout);
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.getImage(ImageBank.lvl010);
	}

	@Override
	public void loadEvent() {

	}

}
