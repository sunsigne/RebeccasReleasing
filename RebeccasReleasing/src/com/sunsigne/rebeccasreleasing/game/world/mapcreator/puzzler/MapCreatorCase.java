package com.sunsigne.rebeccasreleasing.game.world.mapcreator.puzzler;

import com.sunsigne.rebeccasreleasing.game.object.world.puzzler.Case;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;

final class MapCreatorCase {

	static void createCase(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		if (red == 2 && green == 255 && blue == 15) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Case case0 = new Case(x0, y0, difficulty);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 14) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Case case0 = new Case(x0, y0, difficulty);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 13) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Case case0 = new Case(x0, y0, difficulty);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 12) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Case case0 = new Case(x0, y0, difficulty);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 11) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Case case0 = new Case(x0, y0, difficulty);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 10) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Case case0 = new Case(x0, y0, difficulty);
			handler_object.addObject(case0);
		}
	}
}
