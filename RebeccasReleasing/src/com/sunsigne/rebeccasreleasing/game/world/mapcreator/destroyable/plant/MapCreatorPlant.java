package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.plant;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.destroyable.Plant;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

public class MapCreatorPlant {

	public void createPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0, int y0) {

		createEmptyPlant(red, green, blue, handler_object, x0, y0);
		new MapCreatorKeyPlant().createKeyPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorSwordPlant().createSwordPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorBombPlant().createBombPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorGlassPlant().createGlassPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorPliersPlant().createPliersPlant(red, green, blue, handler_object, mapcreator, x0, y0);

	}

	private void createEmptyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 0 && blue == 255) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
		}
		if (red == 254 && green == 1 && blue == 255) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
		}
	}

}
