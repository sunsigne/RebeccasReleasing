package com.sunsigne.rebeccasreleasing.game.object.collision;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.system.util.GenericListener;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.living.LivingObject;

public interface ICollisionReaction {

	void collidingReaction(GameObject collidingObject);

	public default void blockPass(GameObject collidingObject, GameObject currentObject) {
		collidingReaction(collidingObject, true, currentObject, null);
	}

	public default void collidingReaction(GameObject collidingObject, boolean blockPass, GameObject currentObject,
			GenericListener listener) {

		// collidingObject has a simple hitox
		if (collidingObject instanceof LivingObject == false) {
			if (collidingObject.getBounds().intersects(currentObject.getBounds())) {
				if (blockPass)
					collidingObject
							.setY((currentObject.getY() + currentObject.getMiniY() - collidingObject.getHeight()));
				if (listener != null)
					listener.doAction();
			}
		}

		// collidingObject is a LivingObject (with complex hitbox)
		else {
			if (((LivingObject) collidingObject).getBoundsLeft().intersects(currentObject.getBounds())) {
				if (blockPass)
					collidingObject
							.setX((currentObject.getX() + currentObject.getMiniX() + currentObject.getBounds().width));
				if (listener != null)
					listener.doAction();
			}
			if (((LivingObject) collidingObject).getBoundsRight().intersects(currentObject.getBounds())) {
				if (blockPass)
					collidingObject
							.setX((currentObject.getX() + currentObject.getMiniX() - collidingObject.getWitdh()));
				if (listener != null)
					listener.doAction();
			}
			if (((LivingObject) collidingObject).getBoundsTop().intersects(currentObject.getBounds())) {
				if (blockPass)
					collidingObject
							.setY((currentObject.getY() + currentObject.getMiniY() + currentObject.getBounds().height));
				if (listener != null)
					listener.doAction();
			}
			if (((LivingObject) collidingObject).getBoundsDown().intersects(currentObject.getBounds())) {
				if (blockPass)
					collidingObject
							.setY((currentObject.getY() + currentObject.getMiniY() - collidingObject.getHeight()));
				if (listener != null)
					listener.doAction();
			}
		}
	}
}
