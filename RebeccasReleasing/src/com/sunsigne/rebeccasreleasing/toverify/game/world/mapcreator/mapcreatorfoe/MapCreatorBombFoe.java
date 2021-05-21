package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatorfoe;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

import objects.characters.living.FoeObject;
import objects.world.loot.tools.LootTool;

public class MapCreatorBombFoe {

	static void createBombFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
//		createCyanBombFoe(red, green, blue, handler_object, x0, y0);
//		createGreenBombFoe(red, green, blue, handler_object, x0, y0);
//		createYellowBombFoe(red, green, blue, handler_object, x0, y0);
//		createOrangeBombFoe(red, green, blue, handler_object, x0, y0);
//		createRedBombFoe(red, green, blue, handler_object, x0, y0);
//		createPurpleBombFoe(red, green, blue, handler_object, x0, y0);
	}
/*
	private static void createCyanBombFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 252 && blue == 1) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 2) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 3) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 4) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 5) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 6) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createGreenBombFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 252 && blue == 9) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 10) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 11) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 12) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 13) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 14) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createYellowBombFoe(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 252 && blue == 17) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 18) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 19) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 20) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 21) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 22) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createOrangeBombFoe(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 252 && blue == 25) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 26) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 27) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 28) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 29) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 30) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createRedBombFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 252 && blue == 33) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 34) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 35) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 36) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 37) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 38) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createPurpleBombFoe(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 252 && blue == 41) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 42) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 43) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 44) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 45) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 252 && blue == 46) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.BOMB, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool);
			fakeTool.setFake(true);
			handler_object.addObject(fakeTool);
		}

	}
*/
}
