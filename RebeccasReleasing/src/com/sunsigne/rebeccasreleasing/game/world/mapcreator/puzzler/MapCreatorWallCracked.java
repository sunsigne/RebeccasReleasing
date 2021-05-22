package com.sunsigne.rebeccasreleasing.game.world.mapcreator.puzzler;

import com.sunsigne.rebeccasreleasing.game.object.world.puzzler.WallCracked;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;

final class MapCreatorWallCracked {

	static void createWallCracked(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		if (red == 1 && green == 255 && blue == 15) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			WallCracked wallcracked = new WallCracked(x0, y0, difficulty);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 14) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			WallCracked wallcracked = new WallCracked(x0, y0, difficulty);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 13) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			WallCracked wallcracked = new WallCracked(x0, y0, difficulty);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 12) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			WallCracked wallcracked = new WallCracked(x0, y0, difficulty);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 11) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			WallCracked wallcracked = new WallCracked(x0, y0, difficulty);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 10) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			WallCracked wallcracked = new WallCracked(x0, y0, difficulty);
			handler_object.addObject(wallcracked);
		}
	}
}
