package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;

public class Animation {

	private int speed;
	private int frames;

	private int index;
	private int count;

	private BufferedImage[] images;
	private BufferedImage currentImg;

	private boolean flag;

	public Animation(int speed, BufferedImage... args) {

		this.speed = speed;
		frames = args.length;

		if (frames != 0) {
			images = new BufferedImage[frames];
			for (int i = 0; i < args.length; i++) {
				images[i] = args[i];
			}

			currentImg = images[0];
		} else
			currentImg = ImageTask.drawEmptyTexture();
	}

	public void runAnimation() {
		if (frames != 0) {
			if (!flag) {
				nextFrame();
				flag = true;
			}

			index++;
			if (index > speed) {
				index = 0;
				nextFrame();
			}
		}
	}

	private void nextFrame() {
		for (int i = 0; i < frames; i++) {
			if (count == i)
				currentImg = images[i];
		}
		count++;

		if (count == frames)
			count = 0;
	}

	public void drawAnimation(Graphics g, int x, int y) {
		g.drawImage(currentImg, x, y, Size.TILE, Size.TILE, null);
	}

	public void drawAnimation(Graphics g, int x, int y, int width, int height) {
		g.drawImage(currentImg, x, y, width, height, null);
	}

}
