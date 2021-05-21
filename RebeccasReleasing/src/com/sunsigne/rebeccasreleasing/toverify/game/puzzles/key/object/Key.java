package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.key.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

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

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getLayer());
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.P_LOCK && getBounds().intersects(tempObject.getBounds())) {
				HandlerObject.getInstance().getPlayer().puzzle.setWinning(true);
				HandlerObject.getInstance().getPlayer().puzzle.close();
			}
			if (tempObject.getId() == OBJECTID.WALL && getBounds().intersects(tempObject.getBounds())) {
				HandlerObject.getInstance().getPlayer().puzzle.close();
			}
		}
	}

}
