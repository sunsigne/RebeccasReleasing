package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatordestroyable;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatordestroyable.desk.MapCreatorDesk;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatordestroyable.plant.MapCreatorPlant;

public class MapCreatorDestroyable {

	public static void createDestroyable(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		MapCreatorDesk.createDesk(red, green, blue, handler_object, x0, y0);
		MapCreatorPlant.createPlant(red, green, blue, handler_object, x0, y0);
	}

}
