package com.sunsigne.rebeccasreleasing.system.controllers.mouse;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.toverify.system.Game;

public class GameCursor {

	private static Point pos;
	
	private static final BufferedImage emptyImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	private static final Cursor emptyCursor = Toolkit.getDefaultToolkit().createCustomCursor(emptyImg, new Point(0, 0), "empty cursor");

	public static Point getPos() {
		return pos;
	}

	public static void setPos(Point pos) {
		GameCursor.pos = pos;
	}
	
	public static void hideCursor(boolean hide) {

		Cursor cursor = hide ? emptyCursor : Cursor.getDefaultCursor();
		Game.getInstance().setCursor(cursor);
	}

}
