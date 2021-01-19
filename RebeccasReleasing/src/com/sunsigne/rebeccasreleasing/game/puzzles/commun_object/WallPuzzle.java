package com.sunsigne.rebeccasreleasing.game.puzzles.commun_object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class WallPuzzle extends PuzzleObject {

	private BufferedImage texture;
	
	public WallPuzzle(int x, int y, BufferedImage texture) {
		super(x, y, OBJECTID.WALL);
		this.texture = texture;
	}

	// behavior

	@Override
	public void tick() {
	}

	// design
	
	@Override
	public void render(Graphics g) {

		g.drawImage(texture, x, y, w, h, null);
		drawHitbox(g);
	}

	// collision

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
