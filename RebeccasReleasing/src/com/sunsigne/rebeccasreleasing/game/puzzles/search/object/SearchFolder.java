package com.sunsigne.rebeccasreleasing.game.puzzles.search.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class SearchFolder extends PuzzleObject {

	public SearchFolder() {
		super(1220, 600, OBJECTID.P_WORDFOLDER);

		w = Size.TILE_PUZZLE * 4;
		h = Size.TILE_PUZZLE * 3;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		int y0 = y - 56;
		
		g.drawImage(texture.puzzle_search, x, y0, w, h, null);
		drawHitbox(g);
	}	

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
