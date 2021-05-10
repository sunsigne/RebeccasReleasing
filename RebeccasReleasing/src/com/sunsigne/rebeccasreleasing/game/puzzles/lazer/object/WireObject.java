package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class WireObject extends PuzzleObject {

	private WIRECOLOR color;
	private boolean exist;
	private boolean cut;
	

	

	public WireObject(int x, int y, WIRECOLOR color) {
		super(x, y, OBJECTID.P_LAZER);

		this.color = color;
		exist = true;
		
		w = Size.TILE_PUZZLE/2;
		h = 6 * Size.TILE_PUZZLE;
	}

	// state	

	public WIRECOLOR getColor() {
		return color;
	}
	
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

		BufferedImage img = texture.puzzle_lazer_wire[color.getNum()];
		if(!cut) g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}
	
	// collision
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}


}
