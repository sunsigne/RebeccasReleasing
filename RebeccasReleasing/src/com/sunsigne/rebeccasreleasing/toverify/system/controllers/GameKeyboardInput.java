package com.sunsigne.rebeccasreleasing.toverify.system.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.sunsigne.rebeccasreleasing.toverify.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;

import objects.IFacing.FACING;
import objects.characters.living.PlayerObject;
import objects.world.IInteraction;

public class GameKeyboardInput extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		directionKeyAction(key, true);
		interactionKeyAction(key);
		cheatKeyAction(key);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		directionKeyAction(key, false);
	}

	private void interactionKeyAction(int key) {

		if (interactionKey(key)) {
			if (Conductor.getState() == STATE.LEVEL) {
				IInteraction interaction = HandlerObject.getInstance().getPlayer().getInteraction();
				if (interaction != null)
					interaction.doAction();
			}
		}
	}

	private void cheatKeyAction(int key) {

		if (key == KeyEvent.VK_F3)
			Game.switchDebugMode();

		if (key == KeyEvent.VK_F4)
			Game.switchWallPassMode();

		if (key == KeyEvent.VK_F5)
			Game.switchMultiToolMode();

		if (key == KeyEvent.VK_R) {
			if (Conductor.getState() == STATE.LEVEL || Conductor.getState() == STATE.PUZZLE || Conductor.getState() == STATE.CHATTING)
				World.currentWorld.restart();
		}

		if (key == KeyEvent.VK_ESCAPE) {
			STATE state = Conductor.getState();

			if (state == STATE.INTRODUCTION)
				Conductor.closeIntroduction();
			else if (state == STATE.LEVEL || state == STATE.CHATTING || state == STATE.PUZZLE) {
				World.currentWorld.close();
				new Title();
			} else
				Conductor.stop();
		}
	}

	////////// PLAYER ////////////

	private boolean[] keyPressed = new boolean[4];

	private boolean playerIsMovable() {

		boolean isPlayerExisting = HandlerObject.getInstance().isPlayerExisting();
		boolean isPlayerPushed = HandlerObject.getInstance().getPlayer().isPushed();
		boolean isLevelState = Conductor.getState() == STATE.LEVEL;

		return isPlayerExisting && !isPlayerPushed && isLevelState;
	}

	private void directionKeyAction(int key, boolean pressed) {

		if (leftKey(key))
			keyPressed[FACING.LEFT.getNum()] = pressed;
		if (rightKey(key))
			keyPressed[FACING.RIGHT.getNum()] = pressed;
		if (upKey(key))
			keyPressed[FACING.UP.getNum()] = pressed;
		if (downKey(key))
			keyPressed[FACING.DOWN.getNum()] = pressed;

		if (playerIsMovable()) {
			moveplayerbyY();
			moveplayerbyX();
		}
	}

	private void moveplayerbyX() {

		if (keyPressed[FACING.LEFT.getNum()] && !keyPressed[FACING.RIGHT.getNum()])
			HandlerObject.getInstance().getPlayer().setVelX(-PlayerObject.SPEED);
		else if (keyPressed[FACING.LEFT.getNum()] && keyPressed[FACING.RIGHT.getNum()])
			HandlerObject.getInstance().getPlayer().setVelX(0);
		else if (!keyPressed[FACING.LEFT.getNum()] && keyPressed[FACING.RIGHT.getNum()])
			HandlerObject.getInstance().getPlayer().setVelX(PlayerObject.SPEED);
		else if (!keyPressed[FACING.LEFT.getNum()] && !keyPressed[FACING.RIGHT.getNum()])
			HandlerObject.getInstance().getPlayer().setVelX(0);
	}

	private void moveplayerbyY() {

		if (keyPressed[FACING.UP.getNum()] && !keyPressed[FACING.DOWN.getNum()])
			HandlerObject.getInstance().getPlayer().setVelY(-PlayerObject.SPEED);
		else if (keyPressed[FACING.UP.getNum()] && keyPressed[FACING.DOWN.getNum()])
			HandlerObject.getInstance().getPlayer().setVelY(0);
		else if (!keyPressed[FACING.UP.getNum()] && keyPressed[FACING.DOWN.getNum()])
			HandlerObject.getInstance().getPlayer().setVelY(PlayerObject.SPEED);
		else if (!keyPressed[FACING.UP.getNum()] && !keyPressed[FACING.DOWN.getNum()])
			HandlerObject.getInstance().getPlayer().setVelY(0);
	}

	////////// KEYS ////////////

	private boolean leftKey(int key) {
		return key == KeyEvent.VK_Q || key == KeyEvent.VK_LEFT;
	}

	private boolean rightKey(int key) {
		return key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT;
	}

	private boolean upKey(int key) {
		return key == KeyEvent.VK_Z || key == KeyEvent.VK_UP;
	}

	private boolean downKey(int key) {
		return key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN;
	}

	private boolean interactionKey(int key) {
		return key == KeyEvent.VK_E;
	}

}
