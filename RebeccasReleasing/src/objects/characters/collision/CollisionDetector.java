package objects.characters.collision;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.characters.living.LivingObject;

public class CollisionDetector {

	private LivingObject living;
	public boolean isPlayer;
	
	public CollisionDetector(boolean isPlayer, LivingObject livingObject) 
	{		
		this.living = livingObject;
		this.isPlayer = isPlayer;
	}

	
	public void update() {

		boolean isCameraDependant = true;
		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant);
		for (GameObject tempObject : list) {
			if(ICollision.class.isInstance(tempObject))
			((ICollision)tempObject).collision(living);
		}

	}
	
	/**
	 * Define a behavior result of a collision between a LivingObject and any other object.
	 * Listener can be null for no behavior.
	 * 
	 * @param isWall should block the livingObject or not
	 * @param tempObject the current object (most often, <b>this</b>)
	 * @param listener the actual behavior result of the collision
	 */
	public void collidingBehavior(boolean isWall, GameObject tempObject, CollisionListener listener) {
		if (living.getBounds().intersects(tempObject.getBounds())) {
			if (isWall)
				living.setY((tempObject.getY() - living.getHeight()));
			if(listener != null) listener.triggerAction();
		}

		if (living.getBoundsTop().intersects(tempObject.getBounds())) {
			if (isWall)
				living.setY((tempObject.getY() + tempObject.getHeight()));
			if(listener != null) listener.triggerAction();
		}
		if (living.getBoundsLeft().intersects(tempObject.getBounds())) {
			if (isWall)
				living.setX((tempObject.getX() + tempObject.getWitdh()));
			if(listener != null) listener.triggerAction();
		}
		if (living.getBoundsRight().intersects(tempObject.getBounds())) {
			if (isWall)
				living.setX((tempObject.getX() - living.getWitdh()));
			if(listener != null) listener.triggerAction();
		}
	}


}
