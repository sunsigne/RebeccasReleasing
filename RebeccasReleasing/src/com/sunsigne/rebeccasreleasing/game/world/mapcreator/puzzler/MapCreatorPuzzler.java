package com.sunsigne.rebeccasreleasing.game.world.mapcreator.puzzler;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class MapCreatorPuzzler {

	public static void createPuzzler(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		MapCreatorCase.createCase(red, green, blue, handler_object, x0, y0);
		MapCreatorComputer.createComputer(red, green, blue, handler_object, x0, y0);
		MapCreatorDoor.createDoor(red, green, blue, handler_object, x0, y0);
		MapCreatorLazer.createLazer(red, green, blue, handler_object, x0, y0);
		MapCreatorWallCracked.createWallCracked(red, green, blue, handler_object, x0, y0);		
	}

}
