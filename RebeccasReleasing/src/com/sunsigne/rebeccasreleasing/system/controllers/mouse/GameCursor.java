package com.sunsigne.rebeccasreleasing.system.controllers.mouse;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Game;

public class GameCursor {

	private static BufferedImage emptyImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	private static Cursor emptyCursor = Toolkit.getDefaultToolkit().createCustomCursor(emptyImg, new Point(0, 0), "empty cursor");

	public static void hideCursor(boolean hide) {

		Cursor cursor = null;

		if (hide)
			cursor = emptyCursor;
		else
			cursor = Cursor.getDefaultCursor();

		Game.game.setCursor(cursor);
	}

}
