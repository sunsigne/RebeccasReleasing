package com.sunsigne.rebeccasreleasing.game.world.mapcreator.mapcreatordestroyable.desk;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.IFacing.FACING;
import objects.world.destroyable.Desk;

public class MapCreatorDesk {

	public static void createDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createNoneLootDesk(red, green, blue, handler_object, x0, y0);
		MapCreatorKeyDesk.createKeyDesk(red, green, blue, handler_object, x0, y0);
		MapCreatorSwordDesk.createSwordDesk(red, green, blue, handler_object, x0, y0);
	}

	private static void createNoneLootDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 0 && blue == 255) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 1 && blue == 255) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 2 && blue == 255) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 3 && blue == 255) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
		}
	}

}
