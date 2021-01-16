package com.sunsigne.rebeccasreleasing.toclean.rebuild;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;

public interface ILoot {

	@Todo("GameObject loot should be a list or an array, not just an defined object")
	public default void drop(double chance, GameObject loot) {
		double r = Math.random();
		if (r <= chance)
			HandlerObject.getInstance().addObject(loot);
	}

}
