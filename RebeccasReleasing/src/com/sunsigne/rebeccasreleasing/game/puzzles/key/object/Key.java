package com.sunsigne.rebeccasreleasing.game.puzzles.key.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;

public class Key extends KeyObject {

	private boolean throwing;

	public Key(int x, int y) {
		super(x, y);
	}

	// state

	public void setThrowing(boolean throwing) {
		this.throwing = throwing;
	}

	public boolean isThrowing() {
		return throwing;
	}
	
	// behavior

	@Override
	public void tick() {
		if(Conductor.getState() == STATE.PUZZLE)
		{
			velocity();
			collision();

			if (isThrowing()) {
				velY = 0;
				velX--;
			} else
				goUpandDown();
		}
	}

	// collision
	
	private void collision() {

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.P_LOCK && getBounds().intersects(tempObject.getBounds())) {
				HandlerObject.getInstance().player.puzzle.setWinning(true);
				HandlerObject.getInstance().player.puzzle.close();
			}
			if (tempObject.getId() == OBJECTID.WALL && getBounds().intersects(tempObject.getBounds())) {
				HandlerObject.getInstance().player.puzzle.close();
			}
		}
	}

}
