package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.search.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class SearchFolder extends PuzzleObject {

	public SearchFolder() {
		super(1220, 600, OBJECTID.DELETE);

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
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
