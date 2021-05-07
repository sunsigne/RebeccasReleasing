package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class WireObject extends PuzzleObject {

	private boolean exist;
	private boolean cut;
	

	public WireObject(int x, int y, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.P_LAZER);

		w = Size.TILE_PUZZLE/2;
		h = 6 * Size.TILE_PUZZLE;
	}

	// state	

	public boolean doesExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public boolean isCut() {
		return cut;
	}

	public void setCut(boolean cut) {
		this.cut = cut;
	}

	// behavior
	
	@Override
	public void tick() {

	}
	
	// design

	@Override
	public void render(Graphics g) {

		BufferedImage img = texture.puzzle_lazer_wire[0];
		if(!cut) g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}
	
	// collision
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}


}
