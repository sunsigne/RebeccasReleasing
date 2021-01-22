package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.Graphics;

public interface IAnimation {

	public Animation getAnimation(int... array);

	public default void runAnimation(int... array) {
		getAnimation(array).runAnimation();
	}

	public default void drawAnimation(Graphics g, int x, int y, int width, int height, int... array) {
		getAnimation(array).drawAnimation(g, x, y, width, height);
	}
	
}
