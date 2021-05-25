package com.sunsigne.rebeccasreleasing.toverify.system.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.sunsigne.rebeccasreleasing.system.Game;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.living.PlayerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.IInteraction;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;

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
			Conductor.getDebugMode().getHitboxMode().cycle();
//			Game.getHitboxMode().cycle();

		if (key == KeyEvent.VK_F4)
			Conductor.getDebugMode().getWallPassMode().cycle();

		if (key == KeyEvent.VK_F5)
			Conductor.getDebugMode().getMultiToolMode().cycle();

		if (key == KeyEvent.VK_R) {
			if (Conductor.getState() == STATE.LEVEL || Conductor.getState() == STATE.PUZZLE
					|| Conductor.getState() == STATE.CHATTING)
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
			keyPressed[DIRECTION.LEFT.getNum()] = pressed;
		if (rightKey(key))
			keyPressed[DIRECTION.RIGHT.getNum()] = pressed;
		if (upKey(key))
			keyPressed[DIRECTION.UP.getNum()] = pressed;
		if (downKey(key))
			keyPressed[DIRECTION.DOWN.getNum()] = pressed;

		if (playerIsMovable()) {
			moveplayerbyY();
			moveplayerbyX();
		}
	}

	private void moveplayerbyX() {

		if (keyPressed[DIRECTION.LEFT.getNum()] && !keyPressed[DIRECTION.RIGHT.getNum()])
			HandlerObject.getInstance().getPlayer().setVelX(-PlayerObject.SPEED);
		else if (keyPressed[DIRECTION.LEFT.getNum()] && keyPressed[DIRECTION.RIGHT.getNum()])
			HandlerObject.getInstance().getPlayer().setVelX(0);
		else if (!keyPressed[DIRECTION.LEFT.getNum()] && keyPressed[DIRECTION.RIGHT.getNum()])
			HandlerObject.getInstance().getPlayer().setVelX(PlayerObject.SPEED);
		else if (!keyPressed[DIRECTION.LEFT.getNum()] && !keyPressed[DIRECTION.RIGHT.getNum()])
			HandlerObject.getInstance().getPlayer().setVelX(0);
	}

	private void moveplayerbyY() {

		if (keyPressed[DIRECTION.UP.getNum()] && !keyPressed[DIRECTION.DOWN.getNum()])
			HandlerObject.getInstance().getPlayer().setVelY(-PlayerObject.SPEED);
		else if (keyPressed[DIRECTION.UP.getNum()] && keyPressed[DIRECTION.DOWN.getNum()])
			HandlerObject.getInstance().getPlayer().setVelY(0);
		else if (!keyPressed[DIRECTION.UP.getNum()] && keyPressed[DIRECTION.DOWN.getNum()])
			HandlerObject.getInstance().getPlayer().setVelY(PlayerObject.SPEED);
		else if (!keyPressed[DIRECTION.UP.getNum()] && !keyPressed[DIRECTION.DOWN.getNum()])
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
