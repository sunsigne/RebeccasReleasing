package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class ColorEnigmaObject extends PuzzleObject {

	private ColorEnigmaMap colorEnigmaMap;

	public ColorEnigmaObject(int x, int y, ColorEnigmaMap colorEnigmaMap) {
		super(x, y, OBJECTID.P_COLORENIGMA);

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
