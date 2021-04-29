package com.sunsigne.rebeccasreleasing.system.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.Game;
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

		if (key == KeyEvent.VK_F3)
			Game.switchDebugMode();

		if (key == KeyEvent.VK_F4)
			Game.switchWallPassMode();

		if (key == KeyEvent.VK_ESCAPE) {
			if (Conductor.getState() == STATE.INTRODUCTION)
				Conductor.closeIntroduction();
			else if (Conductor.getState() != STATE.TITLE) {
				World.currentWorld.close();
				new Title();
			} else
				Conductor.stop();
		}

		if (key == KeyEvent.VK_R) {
			World.currentWorld.restart();
		}

		if (key == KeyEvent.VK_E) {
				if(Conductor.getState() == STATE.LEVEL || Conductor.getState() == STATE.PUZZLE)
				World.setNpcRequested(true);
		}

		if (leftKey(key))
			keyPressed[FACING.LEFT.getNum()] = true;
		if (rightKey(key))
			keyPressed[FACING.RIGHT.getNum()] = true;
		if (upKey(key))
			keyPressed[FACING.UP.getNum()] = true;
		if (downKey(key))
			keyPressed[FACING.DOWN.getNum()] = true;

		if (playerismovable()) {
			moveplayerbyY();
			moveplayerbyX();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_E) {
				World.setNpcRequested(false);
			if (World.getChat() != null)
				World.getChat().goToNextSentence();
		}

		if (leftKey(key))
			keyPressed[FACING.LEFT.getNum()] = false;
		if (rightKey(key))
			keyPressed[FACING.RIGHT.getNum()] = false;
		if (upKey(key))
			keyPressed[FACING.UP.getNum()] = false;
		if (downKey(key))
			keyPressed[FACING.DOWN.getNum()] = false;

		if (playerismovable()) {
			moveplayerbyX();
			moveplayerbyY();
		}
	}

	private boolean leftKey(int key) {
		if (key == KeyEvent.VK_Q)
			return true;
		if (key == KeyEvent.VK_LEFT)
			return true;
		return false;
	}

	private boolean rightKey(int key) {
		if (key == KeyEvent.VK_D)
			return true;
		if (key == KeyEvent.VK_RIGHT)
			return true;
		return false;
	}

	private boolean upKey(int key) {
		if (key == KeyEvent.VK_Z)
			return true;
		if (key == KeyEvent.VK_UP)
			return true;
		return false;
	}

	private boolean downKey(int key) {
		if (key == KeyEvent.VK_S)
			return true;
		if (key == KeyEvent.VK_DOWN)
			return true;
		return false;
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
