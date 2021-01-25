package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.world.puzzler.Case;
import objects.world.puzzler.Computer;
import objects.world.puzzler.Door;
import objects.world.puzzler.TutoDoor;
import objects.world.puzzler.WallCracked;

public class MapCreatorPuzzler {

	static void createDoor(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createDoorVerticalClosed(red, green, blue, handler_object, x0, y0);
		createDoorVerticalOpen(red, green, blue, handler_object, x0, y0);
		createDoorHorizontalClosed(red, green, blue, handler_object, x0, y0);
		createDoorHorizontalOpen(red, green, blue, handler_object, x0, y0);
	}

	private static void createDoorVerticalClosed(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 0 && green == 255 && blue == 15) {
			Door door = new TutoDoor(x0, y0, false);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 14) {
			Door door = new Door(x0, y0, false, DIFFICULTY.CYAN);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 13) {
			Door door = new Door(x0, y0, false, DIFFICULTY.GREEN);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 12) {
			Door door = new Door(x0, y0, false, DIFFICULTY.YELLOW);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 11) {
			Door door = new Door(x0, y0, false, DIFFICULTY.ORANGE);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 10) {
			Door door = new Door(x0, y0, false, DIFFICULTY.RED);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 9) {
			Door door = new Door(x0, y0, false, DIFFICULTY.PURPLE);
			handler_object.addObject(door);
		}
	}

	private static void createDoorVerticalOpen(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 0 && green == 255 && blue == 8) {
			Door door = new Door(x0, y0, false, DIFFICULTY.CYAN);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 7) {
			Door door = new Door(x0, y0, false, DIFFICULTY.GREEN);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 6) {
			Door door = new Door(x0, y0, false, DIFFICULTY.YELLOW);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 5) {
			Door door = new Door(x0, y0, false, DIFFICULTY.ORANGE);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 4) {
			Door door = new Door(x0, y0, false, DIFFICULTY.RED);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 3) {
			Door door = new Door(x0, y0, false, DIFFICULTY.PURPLE);
			door.setSolved(true);
			handler_object.addObject(door);
		}
	}

	private static void createDoorHorizontalClosed(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		
		if (red == 0 && green == 255 && blue == 17) {
			Door door = new TutoDoor(x0, y0, true);
			handler_object.addObject(door);
		}		
		if (red == 0 && green == 255 && blue == 18) {
			Door door = new Door(x0, y0, true, DIFFICULTY.CYAN);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 19) {
			Door door = new Door(x0, y0, true, DIFFICULTY.GREEN);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 20) {
			Door door = new Door(x0, y0, true, DIFFICULTY.YELLOW);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 21) {
			Door door = new Door(x0, y0, true, DIFFICULTY.ORANGE);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 22) {
			Door door = new Door(x0, y0, true, DIFFICULTY.RED);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 23) {
			Door door = new Door(x0, y0, true, DIFFICULTY.PURPLE);
			handler_object.addObject(door);
		}
	}

	private static void createDoorHorizontalOpen(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 0 && green == 255 && blue == 24) {
			Door door = new Door(x0, y0, true, DIFFICULTY.CYAN);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 25) {
			Door door = new Door(x0, y0, true, DIFFICULTY.GREEN);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 26) {
			Door door = new Door(x0, y0, true, DIFFICULTY.YELLOW);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 27) {
			Door door = new Door(x0, y0, true, DIFFICULTY.ORANGE);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 28) {
			Door door = new Door(x0, y0, true, DIFFICULTY.RED);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		if (red == 0 && green == 255 && blue == 29) {
			Door door = new Door(x0, y0, true, DIFFICULTY.PURPLE);
			door.setSolved(true);
			handler_object.addObject(door);
		}
	}

	public static void createWallCracked(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 1 && green == 255 && blue == 15)
		{
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(wallcracked);
		}
		
		if (red == 1 && green == 255 && blue == 14)
		{
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(wallcracked);
		}
		
		if (red == 1 && green == 255 && blue == 13)
		{
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(wallcracked);
		}
		
		if (red == 1 && green == 255 && blue == 12)
		{
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(wallcracked);
		}
		
		if (red == 1 && green == 255 && blue == 11)
		{
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(wallcracked);
		}
		
		if (red == 1 && green == 255 && blue == 10)
		{
			WallCracked wallcracked = new WallCracked(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(wallcracked);
		}
	}

	public static void createCase(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		
		if (red == 2 && green == 255 && blue == 15)
		{
			Case case0 = new Case(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(case0);
		}
		
		if (red == 2 && green == 255 && blue == 14)
		{
			Case case0 = new Case(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(case0);
		}
		
		if (red == 2 && green == 255 && blue == 13)
		{
			Case case0 = new Case(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(case0);
		}
		
		if (red == 2 && green == 255 && blue == 12)
		{
			Case case0 = new Case(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(case0);
		}
		
		if (red == 2 && green == 255 && blue == 11)
		{
			Case case0 = new Case(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(case0);
		}
		
		if (red == 2 && green == 255 && blue == 10)
		{
			Case case0 = new Case(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(case0);
		}

	}

	public static void createComputer(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		
		if (red == 3 && green == 255 && blue == 15)
		{
			Computer computer = new Computer(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(computer);
		}
		
		if (red == 3 && green == 255 && blue == 14)
		{
			Computer computer = new Computer(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(computer);
		}
		
		if (red == 3 && green == 255 && blue == 13)
		{
			Computer computer = new Computer(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(computer);
		}
		
		if (red == 3 && green == 255 && blue == 12)
		{
			Computer computer = new Computer(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(computer);
		}
		
		if (red == 3 && green == 255 && blue == 11)
		{
			Computer computer = new Computer(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(computer);
		}
		
		if (red == 3 && green == 255 && blue == 10)
		{
			Computer computer = new Computer(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(computer);
		}
	}


}
