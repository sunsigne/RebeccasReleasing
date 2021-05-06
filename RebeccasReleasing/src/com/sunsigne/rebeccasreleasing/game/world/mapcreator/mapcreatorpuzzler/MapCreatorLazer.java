package com.sunsigne.rebeccasreleasing.game.world.mapcreator.mapcreatorpuzzler;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.IFacing.FACING;
import objects.world.puzzler.Lazer;

public class MapCreatorLazer {

	static void createLazer(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createLazerLeftRunning(red, green, blue, handler_object, x0, y0);
		createLazerRightRunning(red, green, blue, handler_object, x0, y0);
		createLazerUpRunning(red, green, blue, handler_object, x0, y0);
		createLazerDownRunning(red, green, blue, handler_object, x0, y0);
		createLazerHorizontalRunning(red, green, blue, handler_object, x0, y0);
		createLazerVerticalRunning(red, green, blue, handler_object, x0, y0);

		createLazerLeftSolved(red, green, blue, handler_object, x0, y0);
		createLazerRightSolved(red, green, blue, handler_object, x0, y0);
		createLazerUpSolved(red, green, blue, handler_object, x0, y0);
		createLazerDownSolved(red, green, blue, handler_object, x0, y0);
		createLazerHorizontalSolved(red, green, blue, handler_object, x0, y0);
		createLazerVerticalSolved(red, green, blue, handler_object, x0, y0);
	}

	private static void createLazerLeftRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 48) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), false, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 47) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), false, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 46) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), false, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 45) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), false, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 44) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), false, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 43) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), false, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}
	

	private static void createLazerRightRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 42) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), false, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 41) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), false, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 40) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), false, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 39) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), false, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 38) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), false, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 37) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), false, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}


	private static void createLazerUpRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 36) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), false, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 35) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), false, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 34) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), false, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 33) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), false, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 32) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), false, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 31) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), false, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}
	

	private static void createLazerDownRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 30) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), false, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 29) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), false, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 28) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), false, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 27) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), false, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 26) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), false, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 25) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), false, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}


	private static void createLazerHorizontalRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 24) {
			Lazer lazer = new Lazer(x0, y0, 4, false, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 23) {
			Lazer lazer = new Lazer(x0, y0, 4, false, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 22) {
			Lazer lazer = new Lazer(x0, y0, 4, false, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 21) {
			Lazer lazer = new Lazer(x0, y0, 4, false, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 20) {
			Lazer lazer = new Lazer(x0, y0, 4, false, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 19) {
			Lazer lazer = new Lazer(x0, y0, 4, false, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}
	

	private static void createLazerVerticalRunning(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 18) {
			Lazer lazer = new Lazer(x0, y0, 5, false, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 17) {
			Lazer lazer = new Lazer(x0, y0, 5, false, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 16) {
			Lazer lazer = new Lazer(x0, y0, 5, false, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 15) {
			Lazer lazer = new Lazer(x0, y0, 5, false, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 14) {
			Lazer lazer = new Lazer(x0, y0, 5, false, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 13) {
			Lazer lazer = new Lazer(x0, y0, 5, false, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}


	private static void createLazerLeftSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 49) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), true, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 50) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), true, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 51) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), true, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 52) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), true, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 53) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), true, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 54) {
			Lazer lazer = new Lazer(x0, y0, FACING.LEFT.getNum(), true, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}
	

	private static void createLazerRightSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 55) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), true, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 56) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), true, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 57) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), true, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 58) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), true, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 59) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), true, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 60) {
			Lazer lazer = new Lazer(x0, y0, FACING.RIGHT.getNum(), true, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}


	private static void createLazerUpSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 61) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), true, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 62) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), true, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 63) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), true, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 64) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), true, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 65) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), true, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 66) {
			Lazer lazer = new Lazer(x0, y0, FACING.UP.getNum(), true, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}
	

	private static void createLazerDownSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 67) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), true, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 68) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), true, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 69) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), true, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 70) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), true, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 71) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), true, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 72) {
			Lazer lazer = new Lazer(x0, y0, FACING.DOWN.getNum(), true, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}


	private static void createLazerHorizontalSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 73) {
			Lazer lazer = new Lazer(x0, y0, 4, true, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 74) {
			Lazer lazer = new Lazer(x0, y0, 4, true, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 75) {
			Lazer lazer = new Lazer(x0, y0, 4, true, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 76) {
			Lazer lazer = new Lazer(x0, y0, 4, true, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 77) {
			Lazer lazer = new Lazer(x0, y0, 4, true, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 78) {
			Lazer lazer = new Lazer(x0, y0, 4, true, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}
	

	private static void createLazerVerticalSolved(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 4 && green == 255 && blue == 79) {
			Lazer lazer = new Lazer(x0, y0, 5, true, DIFFICULTY.CYAN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 80) {
			Lazer lazer = new Lazer(x0, y0, 5, true, DIFFICULTY.GREEN);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 81) {
			Lazer lazer = new Lazer(x0, y0, 5, true, DIFFICULTY.YELLOW);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 82) {
			Lazer lazer = new Lazer(x0, y0, 5, true, DIFFICULTY.ORANGE);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 83) {
			Lazer lazer = new Lazer(x0, y0, 5, true, DIFFICULTY.RED);
			handler_object.addObject(lazer);
		}

		if (red == 4 && green == 255 && blue == 84) {
			Lazer lazer = new Lazer(x0, y0, 5, true, DIFFICULTY.PURPLE);
			handler_object.addObject(lazer);
		}
	}

	
}
