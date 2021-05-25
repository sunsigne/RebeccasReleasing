package com.sunsigne.rebeccasreleasing.game.world.mapcreator.puzzler;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.AXIS;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.Lazer;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;

final class MapCreatorLazer {

	void createLazer(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createLazerLeftRunning(red, green, blue, handler_object, x0, y0);
		createLazerRightRunning(red, green, blue, handler_object, x0, y0);
		createLazerUpRunning(red, green, blue, handler_object, x0, y0);
		createLazerDownRunning(red, green, blue, handler_object, x0, y0);
		createLazerVerticalRunning(red, green, blue, handler_object, x0, y0);
		createLazerHorizontalRunning(red, green, blue, handler_object, x0, y0);

		createLazerLeftSolved(red, green, blue, handler_object, x0, y0);
		createLazerRightSolved(red, green, blue, handler_object, x0, y0);
		createLazerUpSolved(red, green, blue, handler_object, x0, y0);
		createLazerDownSolved(red, green, blue, handler_object, x0, y0);
		createLazerVerticalSolved(red, green, blue, handler_object, x0, y0);
		createLazerHorizontalSolved(red, green, blue, handler_object, x0, y0);
	}

	private void createLazerLeftRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 48) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 47) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 46) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 45) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 44) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 43) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerRightRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 42) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 41) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 40) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 39) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 38) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 37) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerUpRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 36) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 35) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 34) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 33) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 32) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 31) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerDownRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 30) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 29) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 28) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 27) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 26) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 25) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerVerticalRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 18) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 17) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 16) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 15) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 14) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 13) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerHorizontalRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 24) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 23) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 22) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 21) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 20) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 19) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerLeftSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 49) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 50) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 51) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 52) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 53) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 54) {
			Facing facing = new Facing(DIRECTION.LEFT);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerRightSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 55) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 56) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 57) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 58) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 59) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 60) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerUpSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 61) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 62) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 63) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 64) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 65) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 66) {
			Facing facing = new Facing(DIRECTION.UP);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerDownSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 67) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 68) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 69) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 70) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 71) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 72) {
			Facing facing = new Facing(DIRECTION.DOWN);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerVerticalSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 79) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 80) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 81) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 82) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 83) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 84) {
			Facing facing = new Facing(AXIS.VERTICAL);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}
	}

	private void createLazerHorizontalSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 73) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 74) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 75) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 76) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 77) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 78) {
			Facing facing = new Facing(AXIS.HORIZONTAL);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Lazer lazer = new Lazer(x0, y0, facing, difficulty);
			lazer.setSolved(true);
			handler_object.addObject(lazer);
		}
	}
}
