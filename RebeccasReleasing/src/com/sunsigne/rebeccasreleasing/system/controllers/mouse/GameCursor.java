package com.sunsigne.rebeccasreleasing.system.controllers.mouse;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.system.Game;

public class GameCursor {

	private static Point pos;

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		GameCursor.pos = pos;
	}

	public void hideCursor(boolean hide) {
		BufferedImage emptyImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor emptyCursor = Toolkit.getDefaultToolkit().createCustomCursor(emptyImg, new Point(0, 0), "empty cursor");
		Cursor cursor = hide ? emptyCursor : Cursor.getDefaultCursor();
		Game.getInstance().setCursor(cursor);
	}

}
