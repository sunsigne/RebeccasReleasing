package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatorpuzzler;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;

import objects.world.puzzler.Case;
import objects.world.puzzler.Computer;
import objects.world.puzzler.WallCracked;

public class MapCreatorPuzzler {

	public static void createPuzzler(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		
		MapCreatorDoor.createDoor(red, green, blue, handler_object, x0, y0);
		createWallCracked(red, green, blue, handler_object, x0, y0);
		createCase(red, green, blue, handler_object, x0, y0);
		createComputer(red, green, blue, handler_object, x0, y0);
		MapCreatorLazer.createLazer(red, green, blue, handler_object, x0, y0);
		
	}
	
	public static void createWallCracked(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 1 && green == 255 && blue == 15) {
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 14) {
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 13) {
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 12) {
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 11) {
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(wallcracked);
		}

		if (red == 1 && green == 255 && blue == 10) {
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(wallcracked);
		}
	}

	public static void createCase(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		if (red == 2 && green == 255 && blue == 15) {
			Case case0 = new Case(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 14) {
			Case case0 = new Case(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 13) {
			Case case0 = new Case(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 12) {
			Case case0 = new Case(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 11) {
			Case case0 = new Case(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(case0);
		}

		if (red == 2 && green == 255 && blue == 10) {
			Case case0 = new Case(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(case0);
		}

	}

	public static void createComputer(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		if (red == 3 && green == 255 && blue == 15) {
			Computer computer = new Computer(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 14) {
			Computer computer = new Computer(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 13) {
			Computer computer = new Computer(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 12) {
			Computer computer = new Computer(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 11) {
			Computer computer = new Computer(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(computer);
		}

		if (red == 3 && green == 255 && blue == 10) {
			Computer computer = new Computer(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(computer);
		}
	}


}
