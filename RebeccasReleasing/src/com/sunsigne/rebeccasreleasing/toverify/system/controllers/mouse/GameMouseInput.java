package com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerRender;

import objects.GameObject;

public class GameMouseInput extends MouseAdapter {

	private static GameMouseInput instance;

	protected static IClick[] clickable = new IClick[3];

	public GameMouseInput() {

	}

	public GameMouseInput(STATE state) {
		Conductor.setState(state);
	}

	public static GameMouseInput getInstance() {
		if (instance == null)
			instance = new GameMouseInput();
		return instance;
	}

	// state

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		for (int layer = 2; layer >= 0; layer--) {
			if (clickable[layer] != null) {
				clickable[layer].mousePressed(mx, my);
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		for (int layer = 2; layer >= 0; layer--) {
			if (clickable[layer] != null) {
				clickable[layer].mouseReleased(mx, my);
				break;
			}
		}
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

	public void clearAllClickable() {

		for (int layer = 0; layer < 3; layer++) {
			HandlerRender.getInstance().removeObject(clickable[layer]);
			HandlerObject.getInstance().clear(false, layer);
		}
		clickable = new IClick[3];
		GameCursor.hideCursor(false);
	}
}
