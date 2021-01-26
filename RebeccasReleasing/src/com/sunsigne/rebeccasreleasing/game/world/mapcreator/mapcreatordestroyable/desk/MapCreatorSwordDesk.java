package com.sunsigne.rebeccasreleasing.game.world.mapcreator.mapcreatordestroyable.desk;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.MapCreator;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;

import objects.IFacing.FACING;
import objects.world.destroyable.Desk;

public class MapCreatorSwordDesk {

	static void createSwordDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createCyanSwordDesk(red, green, blue, handler_object, x0, y0);
		createGreenSwordDesk(red, green, blue, handler_object, x0, y0);
		createYellowSwordDesk(red, green, blue, handler_object, x0, y0);
		createOrangeSwordDesk(red, green, blue, handler_object, x0, y0);
		createRedSwordDesk(red, green, blue, handler_object, x0, y0);
		createPurpleSwordDesk(red, green, blue, handler_object, x0, y0);
	}

	private static void createCyanSwordDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 0 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 1 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 2 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 3 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
	}

	private static void createGreenSwordDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 4 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 5 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 6 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 7 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
	}

	private static void createYellowSwordDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 8 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 9 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 10 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 11 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
	}

	private static void createOrangeSwordDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 12 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 13 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 14 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 15 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
	}

	private static void createRedSwordDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 16 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 17 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 18 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 19 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
	}

	private static void createPurpleSwordDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 20 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 21 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 22 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
		if (red == 255 && green == 23 && blue == 253) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
		}
	}

}
