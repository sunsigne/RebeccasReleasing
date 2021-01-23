package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

public interface ILvl {


	int getLvlNumber();		

	BufferedImage getCutoutLvlImage();

	BufferedImage getLvlImage();

	void loadEvent();

}
