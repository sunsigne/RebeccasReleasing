package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Lamp;

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

	}

}
