package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.key.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public class KeyReversed extends KeyObject {

	private boolean exist;

	public KeyReversed(int x, int y) {
		super(x, y);

		velX = 53;
	}

	// state

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public boolean doesExist() {
		return exist;
	}

	public void setMovingUP(boolean movingUP) {
		this.movingUP = movingUP;
	}

	public boolean isMovingUP() {
		return movingUP;
	}

	// behavior

	@Override
	public void tick() {
		if(Conductor.getState() == STATE.PUZZLE)
		{
			velocity();
			collision();
	
			if (x < (Size.X0 + 12 * Size.TILE_PUZZLE))
				velX--;
			else {
				HandlerObject.getInstance().getPlayer().puzzle.setWinning(true);
				velX = 0;
				goUpandDown();
			}
		}
	}

	// collision

	private void collision() {
		if (doesExist()) {

			LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getLayer());
			for (GameObject tempObject : list) {
				if (tempObject.getId() == OBJECTID.WALL && getBounds().intersects(tempObject.getBounds())) {
					HandlerObject.getInstance().getPlayer().puzzle.close();
				}
			}
		}
	}

}
