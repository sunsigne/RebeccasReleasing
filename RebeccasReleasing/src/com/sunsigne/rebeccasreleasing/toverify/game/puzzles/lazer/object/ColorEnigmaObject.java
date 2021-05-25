package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.lazer.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class ColorEnigmaObject extends PuzzleObject {

	private ColorEnigmaMap colorEnigmaMap;

	public ColorEnigmaObject(int x, int y, ColorEnigmaMap colorEnigmaMap) {
		super(x, y, OBJECTID.DELETE);

		this.colorEnigmaMap = colorEnigmaMap;

		w = 6 * Size.TILE_PUZZLE;
	}

	// state

	public WIRECOLOR getColor() {
		return colorEnigmaMap.getColor();
	}

	// behavior

	@Override
	public void tick() {

	}

	// design

	@Override
	public void render(Graphics g) {

		BufferedImage img = colorEnigmaMap.getTexture();
		g.drawImage(img, x, y, w, h, null);
	}

	// collision

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
