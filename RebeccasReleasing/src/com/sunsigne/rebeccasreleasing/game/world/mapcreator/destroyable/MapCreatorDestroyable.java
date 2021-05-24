package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable;

import com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.desk.MapCreatorDesk;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.plant.MapCreatorPlant;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

public class MapCreatorDestroyable {

	public void createDestroyable(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0, int y0) {

		new MapCreatorDesk().createDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorPlant().createPlant(red, green, blue, handler_object, mapcreator, x0, y0);
	}

}
