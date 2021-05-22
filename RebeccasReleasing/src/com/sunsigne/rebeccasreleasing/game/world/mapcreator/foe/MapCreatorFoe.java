package com.sunsigne.rebeccasreleasing.game.world.mapcreator.foe;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;

import objects.characters.living.FoeObject;

public class MapCreatorFoe {

	public static void createFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		createEmptyFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorKeyFoe.createKeyFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorSwordFoe.createSwordFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorBombFoe.createBombFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorGlassFoe.createGlassFoe(red, green, blue, handler_object, x0, y0);
		MapCreatorPliersFoe.createPliersFoe(red, green, blue, handler_object, x0, y0);
	}

	private static void createEmptyFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 255 && blue == 1) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 2) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 3) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 4) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 5) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
		}

		if (red == 255 && green == 255 && blue == 6) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
		}
	}
}
