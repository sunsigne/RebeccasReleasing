package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Lamp;

import objects.world.Stairs;
import objects.world.decor.WC;

public class MapCreatorDecor {

	static void createSmall(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 0 && green == 253 && blue == 255) {
			Lamp lamp = new Lamp(x0, y0);
			handler_object.addObject(lamp);
		}
		
		if (red == 2 && green == 253 && blue == 255) {
			WC wc = new WC(x0, y0);
			handler_object.addObject(wc);
		}
		
		if (red == 3 && green == 253 && blue == 255) {
			Stairs stairs = new Stairs(x0, y0, true, 1);
			handler_object.addObject(stairs);
		}
		
		if (red == 4 && green == 253 && blue == 255) {
			Stairs stairs = new Stairs(x0, y0, false, 1);
			handler_object.addObject(stairs);
		}

	}

}
