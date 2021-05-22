package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.plant;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.Facing;
import objects.Facing.DIRECTION;
import objects.world.destroyable.Plant;

public class MapCreatorPlant {

	public static void createPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createEmptyPlant(red, green, blue, handler_object, x0, y0);
		MapCreatorKeyPlant.createKeyPlant(red, green, blue, handler_object, x0, y0);
		MapCreatorSwordPlant.createSwordPlant(red, green, blue, handler_object, x0, y0);
		MapCreatorBombPlant.createBombPlant(red, green, blue, handler_object, x0, y0);
		MapCreatorGlassPlant.createGlassPlant(red, green, blue, handler_object, x0, y0);
		MapCreatorPliersPlant.createPliersPlant(red, green, blue, handler_object, x0, y0);

	}

	private static void createEmptyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
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
