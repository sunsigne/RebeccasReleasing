package com.sunsigne.rebeccasreleasing.game.world.mapcreator.foe;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

import objects.characters.living.FoeObject;
import objects.world.loot.tools.LootTool;

public class MapCreatorPliersFoe {

	static void createPliersFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		createCyanPliersFoe(red, green, blue, handler_object, x0, y0);
		createGreenPliersFoe(red, green, blue, handler_object, x0, y0);
		createYellowPliersFoe(red, green, blue, handler_object, x0, y0);
		createOrangePliersFoe(red, green, blue, handler_object, x0, y0);
		createRedPliersFoe(red, green, blue, handler_object, x0, y0);
		createPurplePliersFoe(red, green, blue, handler_object, x0, y0);
	}

	private static void createCyanPliersFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 250 && blue == 1) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 2) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 3) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 4) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 5) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 6) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createGreenPliersFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 250 && blue == 9) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 10) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 11) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 12) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 13) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 14) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createYellowPliersFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 250 && blue == 17) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 18) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 19) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 20) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 21) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 22) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createOrangePliersFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 250 && blue == 25) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 26) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 27) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 28) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 29) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 30) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createRedPliersFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 250 && blue == 33) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 34) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 35) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 36) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 37) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 38) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createPurplePliersFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 250 && blue == 41) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 42) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 43) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 44) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 45) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 250 && blue == 46) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);
			
			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			MapCreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}
}
