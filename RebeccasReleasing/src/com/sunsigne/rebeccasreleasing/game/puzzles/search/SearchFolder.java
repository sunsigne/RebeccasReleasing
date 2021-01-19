package com.sunsigne.rebeccasreleasing.game.puzzles.search;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class SearchFolder extends PuzzleObject {

	public SearchFolder() {
		super(720, 800, OBJECTID.P_WORDFOLDER);

		w = Size.TILE_PUZZLE * 4;
		h = Size.TILE_PUZZLE * 3;
	}

	@Override
	public void tick() {
		x = 1220;
		y = 600;
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(ImageBank.getImage(ImageBank.search_folder), x, y, Size.TILE_PUZZLE * 4, Size.TILE_PUZZLE * 4, null);
		drawHitbox(g);
	}	

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
