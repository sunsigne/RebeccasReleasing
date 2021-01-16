package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;

	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage grabImage(int col, int row, int width, int height) {

		BufferedImage img = null;
		try {
			img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
		} catch (Exception e) {
			img = ImageTask.drawMissingTexture();
		}
		return img;
	}

}
