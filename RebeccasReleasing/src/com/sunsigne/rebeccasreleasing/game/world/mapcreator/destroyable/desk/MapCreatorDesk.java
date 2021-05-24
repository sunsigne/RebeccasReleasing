package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.desk;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

import objects.Facing;
import objects.Facing.DIRECTION;
import objects.world.destroyable.Desk;

public class MapCreatorDesk {

	public void createDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0, int y0) {

		createEmptyDesk(red, green, blue, handler_object, x0, y0);
		new MapCreatorKeyDesk().createKeyDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorSwordDesk().createSwordDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorBombDesk().createBombDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorGlassDesk().createGlassDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		new MapCreatorPliersDesk().createPliersDesk(red, green, blue, handler_object, mapcreator, x0, y0);
	}

	private void createEmptyDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 0 && blue == 255) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 1 && blue == 255) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 2 && blue == 255) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 3 && blue == 255) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);
		}
	}
}
