package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatorfoe;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

import objects.characters.living.FoeObject;
import objects.world.loot.tools.LootTool;

public class MapCreatorKeyFoe {

	static void createKeyFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
//		createCyanKeyFoe(red, green, blue, handler_object, x0, y0);
//		createGreenKeyFoe(red, green, blue, handler_object, x0, y0);
//		createYellowKeyFoe(red, green, blue, handler_object, x0, y0);
//		createOrangeKeyFoe(red, green, blue, handler_object, x0, y0);
//		createRedKeyFoe(red, green, blue, handler_object, x0, y0);
//		createPurpleKeyFoe(red, green, blue, handler_object, x0, y0);
	}
/*
	private static void createCyanKeyFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 254 && blue == 1) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 2) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 3) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 4) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 5) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 6) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createGreenKeyFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 254 && blue == 9) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 10) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 11) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 12) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 13) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 14) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createYellowKeyFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 254 && blue == 17) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 18) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 19) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 20) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 21) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 22) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createOrangeKeyFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 254 && blue == 25) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 26) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 27) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 28) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 29) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 30) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createRedKeyFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 254 && blue == 33) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 34) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 35) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 36) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 37) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 38) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createPurpleKeyFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 254 && blue == 41) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 42) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 43) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 44) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 45) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 254 && blue == 46) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}
*/
}
