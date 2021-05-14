package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatordestroyable.desk;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

import objects.IFacing.FACING;
import objects.world.destroyable.Desk;
import objects.world.loot.tools.LootTool;

public class MapCreatorKeyDesk {

	static void createKeyDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createCyanKeyDesk(red, green, blue, handler_object, x0, y0);
		createGreenKeyDesk(red, green, blue, handler_object, x0, y0);
		createYellowKeyDesk(red, green, blue, handler_object, x0, y0);
		createOrangeKeyDesk(red, green, blue, handler_object, x0, y0);
		createRedKeyDesk(red, green, blue, handler_object, x0, y0);
		createPurpleKeyDesk(red, green, blue, handler_object, x0, y0);
	}

	private static void createCyanKeyDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 0 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 1 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 2 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 3 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createGreenKeyDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 4 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 5 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 6 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 7 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createYellowKeyDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 8 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 9 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 10 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 11 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createOrangeKeyDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 12 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 13 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 14 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 15 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createRedKeyDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 16 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 17 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 18 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 19 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createPurpleKeyDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 20 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 21 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 22 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 255 && green == 23 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, desk);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

}
