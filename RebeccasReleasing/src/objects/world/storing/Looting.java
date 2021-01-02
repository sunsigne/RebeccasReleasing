package objects.world.storing;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;

public interface Looting {

	public default void drop(double chance, GameObject loot) {
		double r = Math.random();
		if (r <= chance)
			HandlerObject.getInstance().addObject(loot);
	}

}
