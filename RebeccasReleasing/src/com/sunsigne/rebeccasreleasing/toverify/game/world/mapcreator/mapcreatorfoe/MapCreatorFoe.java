package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatorfoe;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;

import objects.characters.living.FoeObject;

public class MapCreatorFoe {

	public static void createFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		createNoneLootFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorKeyFoe.createKeyFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorSwordFoe.createSwordFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorBombFoe.createBombFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorGlassFoe.createGlassFoe(red, green, blue, handler_object, x0, y0);
	}

	private static void createNoneLootFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 255 && blue == 1) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 2) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 3) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 4) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 5) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 6) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
		}

	}

}
