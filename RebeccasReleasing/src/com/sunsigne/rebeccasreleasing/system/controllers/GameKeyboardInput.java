package com.sunsigne.rebeccasreleasing.system.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.IFacing.FACING;

@Todo("mini fleche de quete activable par une touch ou map")
public class GameKeyboardInput extends KeyAdapter {

	private boolean[] keyPressed = new boolean[4];

	@Todo("cliquer sur escape dans les options ou sur R en dehors d'un lvl cause un bug")
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) {
			if (Conductor.getState() != STATE.TITLE) {
				World.currentWorld.close();
				new Title();
			} else
				Conductor.stop();
		}

		if (key == KeyEvent.VK_R) {
			World.currentWorld.restart();
		}

		if (key == KeyEvent.VK_Q)
			keyPressed[FACING.LEFT.getNum()] = true;
		if (key == KeyEvent.VK_D)
			keyPressed[FACING.RIGHT.getNum()] = true;
		if (key == KeyEvent.VK_Z)
			keyPressed[FACING.UP.getNum()] = true;
		if (key == KeyEvent.VK_S)
			keyPressed[FACING.DOWN.getNum()] = true;

		if (playerismovable()) {
			moveplayerbyY();
			moveplayerbyX();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_Q)
			keyPressed[FACING.LEFT.getNum()] = false;
		if (key == KeyEvent.VK_D)
			keyPressed[FACING.RIGHT.getNum()] = false;
		if (key == KeyEvent.VK_Z)
			keyPressed[FACING.UP.getNum()] = false;
		if (key == KeyEvent.VK_S)
			keyPressed[FACING.DOWN.getNum()] = false;

		if (playerismovable()) {
			moveplayerbyX();
			moveplayerbyY();
		}
	}

	private boolean playerismovable() {

		if (HandlerObject.getInstance().isPlayerExisting && Conductor.getState() == STATE.LEVEL
				&& !HandlerObject.getInstance().player.isPushed())
			return true;
		else
			return false;
	}

	private void moveplayerbyX() {

		if (keyPressed[FACING.LEFT.getNum()] && !keyPressed[FACING.RIGHT.getNum()])
			HandlerObject.getInstance().player.setVelX(-Size.TILE / 9);
		else if (keyPressed[FACING.LEFT.getNum()] && keyPressed[FACING.RIGHT.getNum()])
			HandlerObject.getInstance().player.setVelX(0);
		else if (!keyPressed[FACING.LEFT.getNum()] && keyPressed[FACING.RIGHT.getNum()])
			HandlerObject.getInstance().player.setVelX(Size.TILE / 9);
		else if (!keyPressed[FACING.LEFT.getNum()] && !keyPressed[FACING.RIGHT.getNum()])
			HandlerObject.getInstance().player.setVelX(0);
	}
	
	private void moveplayerbyY() {

		if (keyPressed[FACING.UP.getNum()] && !keyPressed[FACING.DOWN.getNum()])
			HandlerObject.getInstance().player.setVelY(-Size.TILE / 9);
		else if (keyPressed[FACING.UP.getNum()] && keyPressed[FACING.DOWN.getNum()])
			HandlerObject.getInstance().player.setVelY(0);
		else if (!keyPressed[FACING.UP.getNum()] && keyPressed[FACING.DOWN.getNum()])
			HandlerObject.getInstance().player.setVelY(Size.TILE / 9);
		else if (!keyPressed[FACING.UP.getNum()] && !keyPressed[FACING.DOWN.getNum()])
			HandlerObject.getInstance().player.setVelY(0);
	}


}
