package com.sunsigne.rebeccasreleasing.game.world.mapcreator.puzzler;

import com.sunsigne.rebeccasreleasing.game.object.world.puzzler.Computer;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;

final class MapCreatorComputer {

	void createComputer(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		if (red == 3 && green == 255 && blue == 15) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Computer computer = new Computer(x0, y0, difficulty);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 14) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Computer computer = new Computer(x0, y0, difficulty);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 13) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Computer computer = new Computer(x0, y0, difficulty);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 12) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Computer computer = new Computer(x0, y0, difficulty);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 11) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Computer computer = new Computer(x0, y0, difficulty);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 10) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Computer computer = new Computer(x0, y0, difficulty);
			handler_object.addObject(computer);
		}
	}
}