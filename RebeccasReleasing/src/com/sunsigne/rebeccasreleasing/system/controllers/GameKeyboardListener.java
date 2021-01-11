package com.sunsigne.rebeccasreleasing.system.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

@Todo("mini fleche de quete activable par une touch ou map")
public class GameKeyboardListener extends KeyAdapter {

	private boolean[] keyPressed = new boolean[4];

	@Todo("cliquer sur escape dans les options ou sur R en dehors d'un lvl cause un bug")
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) {
			if (Conductor.getState() != STATE.TITLE) {
				World.world.close();
				new Title();
			} else
				Conductor.stop();
		}

		if (key == KeyEvent.VK_R) {
			World.world.restart();
		}

		if (key == KeyEvent.VK_Z)
			keyPressed[Size.DIRECTION_UP] = true;
		if (key == KeyEvent.VK_S)
			keyPressed[Size.DIRECTION_DOWN] = true;
		if (key == KeyEvent.VK_Q)
			keyPressed[Size.DIRECTION_LEFT] = true;
		if (key == KeyEvent.VK_D)
			keyPressed[Size.DIRECTION_RIGHT] = true;

		if (playerismovable()) {
			moveplayerbyY();
			moveplayerbyX();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_Z)
			keyPressed[Size.DIRECTION_UP] = false;
		if (key == KeyEvent.VK_S)
			keyPressed[Size.DIRECTION_DOWN] = false;
		if (key == KeyEvent.VK_Q)
			keyPressed[Size.DIRECTION_LEFT] = false;
		if (key == KeyEvent.VK_D)
			keyPressed[Size.DIRECTION_RIGHT] = false;

		if (playerismovable()) {
			moveplayerbyY();
			moveplayerbyX();
		}
	}

	private boolean playerismovable() {

		if (HandlerObject.getInstance().isPlayerExisting && Conductor.getState() == STATE.LEVEL && !HandlerObject.getInstance().player.isPushed())
			return true;
		else
			return false;
	}

	private void moveplayerbyY() {

		if (keyPressed[Size.DIRECTION_UP] && !keyPressed[Size.DIRECTION_DOWN])
			HandlerObject.getInstance().player.setVelY(-Size.TILE / 9);
		else if (keyPressed[Size.DIRECTION_UP] && keyPressed[Size.DIRECTION_DOWN])
			HandlerObject.getInstance().player.setVelY(0);
		else if (!keyPressed[Size.DIRECTION_UP] && keyPressed[Size.DIRECTION_DOWN])
			HandlerObject.getInstance().player.setVelY(Size.TILE / 9);
		else if (!keyPressed[Size.DIRECTION_UP] && !keyPressed[Size.DIRECTION_DOWN])
			HandlerObject.getInstance().player.setVelY(0);
	}

	private void moveplayerbyX() {

		if (keyPressed[Size.DIRECTION_LEFT] && !keyPressed[Size.DIRECTION_RIGHT])
			HandlerObject.getInstance().player.setVelX(-Size.TILE / 9);
		else if (keyPressed[Size.DIRECTION_LEFT] && keyPressed[Size.DIRECTION_RIGHT])
			HandlerObject.getInstance().player.setVelX(0);
		else if (!keyPressed[Size.DIRECTION_LEFT] && keyPressed[Size.DIRECTION_RIGHT])
			HandlerObject.getInstance().player.setVelX(Size.TILE / 9);
		else if (!keyPressed[Size.DIRECTION_LEFT] && !keyPressed[Size.DIRECTION_RIGHT])
			HandlerObject.getInstance().player.setVelX(0);
	}

}
