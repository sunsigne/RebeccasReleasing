package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable;

import com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.desk.MapCreatorDesk;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.plant.MapCreatorPlant;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class MapCreatorDestroyable {

	public static void createDestroyable(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		MapCreatorDesk.createDesk(red, green, blue, handler_object, x0, y0);
		MapCreatorPlant.createPlant(red, green, blue, handler_object, x0, y0);
	}

}
