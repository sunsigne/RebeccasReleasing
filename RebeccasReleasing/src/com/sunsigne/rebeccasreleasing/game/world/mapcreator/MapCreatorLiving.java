package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class MapCreatorLiving {

	static void createPlayer(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		if (red == 255 && green == 0 && blue == 0) {
			handler_object.player.setX(x0);
			handler_object.player.setY(y0);
		}
	}

}
