package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.main.Size;

public interface IAnimation {

	public Animation getAnimation(int array, int secondarray);

	public default void runAnimation() {
		runAnimation(0, 0);
	}	

	public default void runAnimation(int array) {
		runAnimation(array, 0);
	}	
	
	public default void runAnimation(int array, int secondarray) {
		getAnimation(array, secondarray).runAnimation();
	}

	public default void drawAnimation(Graphics g, int x, int y) {
		drawAnimation(0, 0, g, x, y, Size.TILE, Size.TILE);
	}	

	public default void drawAnimation(int array, Graphics g, int x, int y) {
		drawAnimation(array, 0, g, x, y, Size.TILE, Size.TILE);
	}	

	public default void drawAnimation(int array, int secondarray, Graphics g, int x, int y) {
		getAnimation(array, secondarray).drawAnimation(g, x, y, Size.TILE, Size.TILE);
	}

	public default void drawAnimation(Graphics g, int x, int y, int width, int height) {
		drawAnimation(0, 0, g, x, y, width, height);
	}

	public default void drawAnimation(int array, Graphics g, int x, int y, int width, int height) {
		drawAnimation(array, 0, g, x, y, width, height);
	}

	public default void drawAnimation(int array, int secondarray, Graphics g, int x, int y, int width, int height) {
		getAnimation(array, secondarray).drawAnimation(g, x, y, width, height);
	}

}
