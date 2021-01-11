package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import com.sunsigne.rebeccasreleasing.main.Game;

public class ImageTask {

	private static URL loc = Game.class.getProtectionDomain().getCodeSource().getLocation();

	// WARNING !!! All paths in this method must have their / replaced by double \\
	public static BufferedImage loadImage(String ImageBank) {

		BufferedImage image = null;

		try {
			String path = "\\ressources\\textures\\" + ImageBank;
			URL url = new File((new File(loc.toURI())).getParent() + path).toURI().toURL();
			image = ImageIO.read(url);
		} catch (Exception e) {
			System.err.println("an image's path isn't corret");
			image = drawMissingTexture();
		}

		return image;
	}

	public static BufferedImage drawMissingTexture() {
		int width = 64;
		int height = 64;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();

		g2d.setColor(Color.magenta);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.black);
		g2d.fillRect(width / 2, 0, width / 2, height / 2);
		g2d.fillRect(0, height / 2, width / 2, height / 2);
		g2d.dispose();

		return img;
	}

}
