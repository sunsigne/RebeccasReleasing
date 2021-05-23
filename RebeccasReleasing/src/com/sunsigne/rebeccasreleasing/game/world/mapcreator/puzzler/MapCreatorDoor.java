package com.sunsigne.rebeccasreleasing.game.world.mapcreator.puzzler;

import com.sunsigne.rebeccasreleasing.game.object.world.puzzler.Door;
import com.sunsigne.rebeccasreleasing.game.object.world.puzzler.TutoDoor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;

import objects.Facing.AXIS;

final class MapCreatorDoor {

	void createDoor(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createDoorVerticalClosed(red, green, blue, handler_object, x0, y0);
		createDoorVerticalOpen(red, green, blue, handler_object, x0, y0);
		createDoorHorizontalClosed(red, green, blue, handler_object, x0, y0);
		createDoorHorizontalOpen(red, green, blue, handler_object, x0, y0);
	}

	private void createDoorVerticalClosed(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 0 && green == 255 && blue == 15) {
			AXIS axis = AXIS.VERTICAL;
			Door door = new TutoDoor(x0, y0, axis);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 14) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.CYAN;			
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 13) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.GREEN;			
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 12) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 11) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 10) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 9) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
	}

	private void createDoorVerticalOpen(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 0 && green == 255 && blue == 8) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 7) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 6) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 5) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 4) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 3) {
			AXIS axis = AXIS.VERTICAL;
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
	}

	private void createDoorHorizontalClosed(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 0 && green == 255 && blue == 17) {
			AXIS axis = AXIS.HORIZONTAL;
			Door door = new TutoDoor(x0, y0, axis);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 18) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 19) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 20) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 21) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 22) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 23) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Door door = new Door(x0, y0, axis, difficulty);
			handler_object.addObject(door);
		}
	}

	private void createDoorHorizontalOpen(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {

		if (red == 0 && green == 255 && blue == 24) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 25) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 26) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 27) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 28) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.RED;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
		
		if (red == 0 && green == 255 && blue == 29) {
			AXIS axis = AXIS.HORIZONTAL;
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			Door door = new Door(x0, y0, axis, difficulty);
			door.setSolved(true);
			handler_object.addObject(door);
		}
	}
}
