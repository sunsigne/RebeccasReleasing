package com.sunsigne.rebeccasreleasing.game.world.mapcreator.puzzler;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class MapCreatorPuzzler {

	public void createPuzzler(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		new MapCreatorCase().createCase(red, green, blue, handler_object, x0, y0);
		new MapCreatorComputer().createComputer(red, green, blue, handler_object, x0, y0);
		new MapCreatorDoor().createDoor(red, green, blue, handler_object, x0, y0);
		new MapCreatorLazer().createLazer(red, green, blue, handler_object, x0, y0);
		new MapCreatorWallCracked().createWallCracked(red, green, blue, handler_object, x0, y0);		
	}

}
