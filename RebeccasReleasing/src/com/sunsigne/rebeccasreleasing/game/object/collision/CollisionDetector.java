package com.sunsigne.rebeccasreleasing.game.object.collision;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;

import objects.characters.living.LivingObject;

public class CollisionDetector implements ITick {

	private GameObject collidingObject;

	public CollisionDetector(GameObject collidingObject) {
		this.collidingObject = collidingObject;
	}

	@Override
	public void tick() {

		boolean cameraDependant = collidingObject.isCameraDependant();
		LAYER layer = collidingObject.getLayer();

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(cameraDependant, layer);
		for (GameObject tempObject : list) {
			if (collidingObject != tempObject && isColliding(tempObject))
				((ICollisionReaction) tempObject).collidingReaction(collidingObject);
		}
	}

	private boolean isColliding(GameObject tempObject) {

		// tempObject has no collision behavior
		if (!ICollisionReaction.class.isInstance(tempObject))
			return false;

		else {
			// collidingObject has a simple hitox
			if (collidingObject instanceof LivingObject == false) {
				if (collidingObject.getBounds().intersects(tempObject.getBounds()))
					return true;
			}
			// collidingObject is a LivingObject (with complex hitbox)
			else {

				LivingObject livingObject = (LivingObject) collidingObject;
				// collidingObject is a wallpass player
				if (livingObject.isPlayer() && Game.getWallPassMode().getState())
					return false;
				// complex hitbox checking
				if (livingObject.getBoundsLeft().intersects(tempObject.getBounds()))
					return true;
				if (livingObject.getBoundsRight().intersects(tempObject.getBounds()))
					return true;
				if (livingObject.getBoundsTop().intersects(tempObject.getBounds()))
					return true;
				if (livingObject.getBoundsDown().intersects(tempObject.getBounds()))
					return true;
			}
			// no collision detected
			return false;
		}
	}
}
