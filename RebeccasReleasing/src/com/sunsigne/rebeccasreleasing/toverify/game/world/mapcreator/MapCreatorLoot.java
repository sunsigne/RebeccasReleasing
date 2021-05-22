package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;

import objects.world.loot.tools.LootTool;

public class MapCreatorLoot {

	static void createTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		createKeyTool(red, green, blue, handler_object, x0, y0);
		createSwordTool(red, green, blue, handler_object, x0, y0);
		createBombTool(red, green, blue, handler_object, x0, y0);
		createGlassTool(red, green, blue, handler_object, x0, y0);
		createPliersTool(red, green, blue, handler_object, x0, y0);
	}

	private static void createKeyTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 0 && green == 1 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 0 && green == 2 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 0 && green == 3 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 0 && green == 4 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 0 && green == 5 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 0 && green == 6 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			handler_object.addObject(tool);
		}

	}

	private static void createSwordTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 1 && green == 1 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 1 && green == 2 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 1 && green == 3 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 1 && green == 4 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 1 && green == 5 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 1 && green == 6 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			handler_object.addObject(tool);
		}

	}

	private static void createBombTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 2 && green == 1 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 2 && green == 2 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 2 && green == 3 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 2 && green == 4 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 2 && green == 5 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 2 && green == 6 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			handler_object.addObject(tool);
		}

	}
	
	private static void createGlassTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 3 && green == 1 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 3 && green == 2 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 3 && green == 3 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 3 && green == 4 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 3 && green == 5 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 3 && green == 6 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			handler_object.addObject(tool);
		}
	}
	
	private static void createPliersTool(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 4 && green == 1 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 4 && green == 2 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 4 && green == 3 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 4 && green == 4 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 4 && green == 5 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			handler_object.addObject(tool);
		}

		if (red == 4 && green == 6 && blue == 255) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			handler_object.addObject(tool);
		}
	}
}
