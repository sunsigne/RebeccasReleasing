package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;

public class ColorEnigma {

	private DIFFICULTY difficulty;
	private WIRECOLOR color;
	private BufferedImage texture;
	
	
	public ColorEnigma(DIFFICULTY difficulty, WIRECOLOR color, BufferedImage texture) {
		
		this.difficulty = difficulty;
		this.color = color;
		this.texture = texture;
	}


	public DIFFICULTY getDifficulty() {
		return difficulty;
	}


	public WIRECOLOR getColor() {
		return color;
	}


	public BufferedImage getTexture() {
		return texture;
	}
	
}
