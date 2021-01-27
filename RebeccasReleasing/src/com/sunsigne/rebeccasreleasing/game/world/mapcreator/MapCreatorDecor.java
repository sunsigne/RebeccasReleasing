package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Lamp;

import objects.IFacing.FACING;
import objects.world.decor.Coffee;
import objects.world.decor.Couch;
import objects.world.decor.Counter;
import objects.world.decor.WC;
import objects.world.decor.Water;

public class MapCreatorDecor {

	static void createCouch(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createCouchVertical(red, green, blue, handler_object, x0, y0);
		createCouchHorizontal(red, green, blue, handler_object, x0, y0);

	}

	private static void createCouchVertical(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		// dual left
		if (red == 15 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.LEFT, 2);
			handler_object.addObject(couch);
		}
		// trial left
		if (red == 14 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.LEFT, 3);
			handler_object.addObject(couch);
		}
		// dual right
		if (red == 13 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.RIGHT, 2);
			handler_object.addObject(couch);
		}
		// trial right
		if (red == 12 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.RIGHT, 3);
			handler_object.addObject(couch);
		}
	}

	private static void createCouchHorizontal(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		// single up
		if (red == 17 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.UP, 1);
			handler_object.addObject(couch);
		}
		// dual up
		if (red == 18 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.UP, 2);
			handler_object.addObject(couch);
		}
		// trial up
		if (red == 19 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.UP, 3);
			handler_object.addObject(couch);
		}
		// single down
		if (red == 20 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.DOWN, 1);
			handler_object.addObject(couch);
		}
		// dual down
		if (red == 21 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.DOWN, 2);
			handler_object.addObject(couch);
		}
		// trial down
		if (red == 22 && green == 255 && blue == 255) {
			Couch couch = new Couch(x0, y0, FACING.DOWN, 3);
			handler_object.addObject(couch);
		}
	}
	
	static void createLong(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 0 && green == 254 && blue == 255) {
			Counter counter = new Counter(x0, y0);
			handler_object.addObject(counter);
		}
	}

	static void createSmall(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 0 && green == 253 && blue == 255) {
			Lamp lamp = new Lamp(x0, y0);
			handler_object.addObject(lamp);
		}
		
		if (red == 2 && green == 253 && blue == 255) {
			WC wc = new WC(x0, y0);
			handler_object.addObject(wc);
		}
	}

	static void createTall(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 0 && green == 252 && blue == 255) {
			Water water = new Water(x0, y0);
			handler_object.addObject(water);
		}

		if (red == 1 && green == 252 && blue == 255) {
			Coffee coffee = new Coffee(x0, y0);
			handler_object.addObject(coffee);
		}
	}
}
