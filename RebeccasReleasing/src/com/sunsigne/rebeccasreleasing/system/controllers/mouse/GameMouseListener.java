package com.sunsigne.rebeccasreleasing.system.controllers.mouse;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.sunsigne.rebeccasreleasing.main.Conductor;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;

public class GameMouseListener extends MouseAdapter {

	private static GameMouseListener instance;
	
	protected static IClick clickable;

	private Point pos;

	public GameMouseListener() {

	}

	public GameMouseListener(STATE state) {
		Conductor.setState(state);
	}
		
	public static GameMouseListener getInstance() {
		if (instance == null)
			instance = new GameMouseListener();
		return instance;
	}


	// state

	/**
	 * Give the current pos of the cursor
	 * 
	 * @return the current pos of the cursor
	 */
	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (clickable != null)
			clickable.mousePressed(mx, my);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (clickable != null)
			clickable.mouseReleased(mx, my);
	}

	public static boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public static boolean mouseOver(int mx, int my, int[] rect) {
		if (rect.length == 4)
			return mouseOver(mx, my, rect[0], rect[1], rect[2], rect[3]);
		else
			System.err.println("the array rect in method mouseOver should be 4 int long");
		return false;
	}

	/**
	 * All current clickable object are erased
	 */
	public void clearClickable() {

		HandlerRender.getInstance().removeObject(clickable);
		clickable = null;
		HandlerObject.getInstance().clearFront();
		GameCursor.hideCursor(false);
	}

}
