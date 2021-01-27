package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;

import objects.world.loot.tools.LootTool;

public class MapCreatorLoot {

	static void createTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		createKeyTool(red, green, blue, handler_object, x0, y0);
		createSwordTool(red, green, blue, handler_object, x0, y0);
		createBombTool(red, green, blue, handler_object, x0, y0);
		createGlassTool(red, green, blue, handler_object, x0, y0);
	}

	private static void createKeyTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 0 && green == 1 && blue == 255) {
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 0 && green == 2 && blue == 255) {
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 0 && green == 3 && blue == 255) {
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 0 && green == 4 && blue == 255) {
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 0 && green == 5 && blue == 255) {
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 0 && green == 6 && blue == 255) {
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

	}

	private static void createSwordTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 1 && green == 1 && blue == 255) {
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 1 && green == 2 && blue == 255) {
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 1 && green == 3 && blue == 255) {
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 1 && green == 4 && blue == 255) {
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 1 && green == 5 && blue == 255) {
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 1 && green == 6 && blue == 255) {
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

	}

	private static void createBombTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 2 && green == 1 && blue == 255) {
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.CYAN.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 2 && green == 2 && blue == 255) {
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.GREEN.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 2 && green == 3 && blue == 255) {
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.YELLOW.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 2 && green == 4 && blue == 255) {
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.ORANGE.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 2 && green == 5 && blue == 255) {
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.RED.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 2 && green == 6 && blue == 255) {
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.PURPLE.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

	}
	
	private static void createGlassTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 3 && green == 1 && blue == 255) {
			Tool tool = new Tool(Tool.GLASS, DIFFICULTY.CYAN.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 3 && green == 2 && blue == 255) {
			Tool tool = new Tool(Tool.GLASS, DIFFICULTY.GREEN.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 3 && green == 3 && blue == 255) {
			Tool tool = new Tool(Tool.GLASS, DIFFICULTY.YELLOW.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 3 && green == 4 && blue == 255) {
			Tool tool = new Tool(Tool.GLASS, DIFFICULTY.ORANGE.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 3 && green == 5 && blue == 255) {
			Tool tool = new Tool(Tool.GLASS, DIFFICULTY.RED.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

		if (red == 3 && green == 6 && blue == 255) {
			Tool tool = new Tool(Tool.GLASS, DIFFICULTY.PURPLE.getLvl(), 0);
			LootTool loot = new LootTool(x0, y0, tool);
			handler_object.addObject(loot);
		}

	}

}
