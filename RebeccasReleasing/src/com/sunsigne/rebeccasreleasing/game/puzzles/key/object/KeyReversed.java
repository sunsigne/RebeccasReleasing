package com.sunsigne.rebeccasreleasing.game.puzzles.key.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;

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
		velocity();
		collision();

		if (x < (Size.X0 + 12 * Size.TILE_PUZZLE))
			velX--;
		else {
			HandlerObject.getInstance().player.puzzle.setWinning(true);
			velX = 0;
			goUpandDown();
		}
	}

	// collision

	private void collision() {
		if (doesExist()) {

			LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
			for (GameObject tempObject : list) {
				if (tempObject.getId() == OBJECTID.WALL && getBounds().intersects(tempObject.getBounds())) {
					HandlerObject.getInstance().player.puzzle.close();
				}
			}
		}
	}

}
