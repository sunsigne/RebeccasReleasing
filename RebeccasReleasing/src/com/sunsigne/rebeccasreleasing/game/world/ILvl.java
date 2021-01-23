package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.event.IEvent;

public interface ILvl {


	int getLvlNumber();		

	BufferedImage getCutoutLvlImage();

	BufferedImage getLvlImage();

	void loadEvent();

}
