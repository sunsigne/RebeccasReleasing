package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;

public class ColorEnigmaMap {

	private WIRECOLOR color;
	private BufferedImage texture;

	public ColorEnigmaMap(DIFFICULTY difficulty, WIRECOLOR color, BufferedImage texture) {

		this.color = color;
		this.texture = texture;
	}

	public WIRECOLOR getColor() {
		return color;
	}

	public BufferedImage getTexture() {
		return texture;
	}

}
