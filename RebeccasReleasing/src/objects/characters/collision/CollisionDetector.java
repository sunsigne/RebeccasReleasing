package objects.characters.collision;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;

import objects.GameObject;
import objects.characters.living.FoeObject;
import objects.characters.living.LivingObject;

public class CollisionDetector {

	private LivingObject living;

	public CollisionDetector(LivingObject livingObject) {
		this.living = livingObject;
	}

	public void update() {

		boolean isCameraDependant = true;
		for (int cameraLayer = 0; cameraLayer < 3; cameraLayer++) {
			LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant, cameraLayer);
			for (GameObject tempObject : list) {
				if (ICollision.class.isInstance(tempObject))
					((ICollision) tempObject).collision(living);
			}
		}

	}

	public void collidingBehavior(boolean isWall, GameObject tempObject, CollisionListener listener) {
		if (living.isPlayer() && Game.isWallPassMode())
			return;

		if (living.getBounds().intersects(tempObject.getBounds())) {
			if (isWall)
				living.setY((tempObject.getY() + tempObject.getMiniY() - living.getHeight()));
			if (listener != null)
				listener.triggerAction();
		}

		if (living.getBoundsTop().intersects(tempObject.getBounds())) {
			if (isWall)
				living.setY((tempObject.getY() + tempObject.getMiniY() + tempObject.getBounds().height));
			if (listener != null)
				listener.triggerAction();
		}
		if (living.getBoundsLeft().intersects(tempObject.getBounds())) {
			if (isWall)
				living.setX((tempObject.getX() + tempObject.getMiniX() + tempObject.getBounds().width));
			if (listener != null)
				listener.triggerAction();
		}
		if (living.getBoundsRight().intersects(tempObject.getBounds())) {
			if (isWall)
				living.setX((tempObject.getX() + tempObject.getMiniX() - living.getWitdh()));
			if (listener != null)
				listener.triggerAction();

		}
	}

	public void collidingBehaviorThinDecor(GameObject tempObject) {
		if (living.isPlayer() && Game.isWallPassMode())
			return;

		if (living.getBounds().intersects(tempObject.getBounds())) {
			living.setY((tempObject.getY() + tempObject.getMiniY() - living.getHeight()));
		}

		if (living.getBoundsTop().intersects(tempObject.getBounds())) {
			living.setY((tempObject.getY() + tempObject.getMiniY() + tempObject.getBounds().height));
		}
	}

	public void collidingBehaviorBetweenFoes(LivingObject living, FoeObject currentFoe) {
		if (living.getBounds().intersects(currentFoe.getBigBounds())) {
			living.setY((currentFoe.getY() - living.getHeight()));
		}
		if (living.getBoundsTop().intersects(currentFoe.getBigBounds())) {
			living.setY((currentFoe.getY() + currentFoe.getBigBounds().height));
		}
		if (living.getBoundsLeft().intersects(currentFoe.getBigBounds())) {
			living.setX((currentFoe.getX() + currentFoe.getBigBounds().width));
		}
		if (living.getBoundsRight().intersects(currentFoe.getBigBounds())) {
			living.setX((currentFoe.getX() - living.getWitdh()));
		}
	}

}
