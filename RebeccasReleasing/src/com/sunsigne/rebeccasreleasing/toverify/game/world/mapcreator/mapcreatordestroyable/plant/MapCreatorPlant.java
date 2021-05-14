package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatordestroyable.plant;

import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;

import objects.IFacing.FACING;
import objects.world.destroyable.Plant;

public class MapCreatorPlant {

	public static void createPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createNoneLootPlant(red, green, blue, handler_object, x0, y0);
		MapCreatorKeyPlant.createKeyPlant(red, green, blue, handler_object, x0, y0);
		MapCreatorSwordPlant.createSwordPlant(red, green, blue, handler_object, x0, y0);

	}

	private static void createNoneLootPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 0 && blue == 255) {
			Plant plant = new Plant(x0, y0, FACING.LEFT);
			handler_object.addObject(plant);
		}
		if (red == 254 && green == 1 && blue == 255) {
			Plant plant = new Plant(x0, y0, FACING.RIGHT);
			handler_object.addObject(plant);
		}
	}

}
