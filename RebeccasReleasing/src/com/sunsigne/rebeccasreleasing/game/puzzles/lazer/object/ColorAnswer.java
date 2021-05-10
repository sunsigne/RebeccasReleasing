package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class ColorAnswer extends PuzzleObject {

	private ColorEnigma enigma;

	public ColorAnswer(int x, int y, ColorEnigma enigma) {
		super(x, y, OBJECTID.P_COLORANSWER);

		this.enigma = enigma;

		w = 6 * Size.TILE_PUZZLE;
	}

	// state

	public ColorEnigma getEnigma() {
		return enigma;
	}

	public WIRECOLOR getColor() {
		return enigma.getColor();
	}

	// behavior

	@Override
	public void tick() {

	}

	// design

	@Override
	public void render(Graphics g) {

		BufferedImage img = enigma.getTexture();
		g.drawImage(img, x, y, w, h, null);
	}

	// collision

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
