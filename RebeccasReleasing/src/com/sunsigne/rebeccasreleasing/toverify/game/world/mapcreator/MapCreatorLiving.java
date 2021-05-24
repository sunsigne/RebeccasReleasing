package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class MapCreatorLiving {

	void createPlayer(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		if (red == 255 && green == 0 && blue == 0) {
			handler_object.getPlayer().setX(x0);
			handler_object.getPlayer().setY(y0);
		}
	}

}
