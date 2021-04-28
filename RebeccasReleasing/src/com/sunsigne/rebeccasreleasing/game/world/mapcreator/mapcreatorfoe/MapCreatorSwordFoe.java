package com.sunsigne.rebeccasreleasing.game.world.mapcreator.mapcreatorfoe;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.MapCreator;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;

import objects.characters.living.FoeObject;
import objects.world.loot.tools.LootTool;

public class MapCreatorSwordFoe {

	static void createSwordFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		createCyanSwordFoe(red, green, blue, handler_object, x0, y0);
		createGreenSwordFoe(red, green, blue, handler_object, x0, y0);
		createYellowSwordFoe(red, green, blue, handler_object, x0, y0);
		createOrangeSwordFoe(red, green, blue, handler_object, x0, y0);
		createRedSwordFoe(red, green, blue, handler_object, x0, y0);
		createPurpleSwordFoe(red, green, blue, handler_object, x0, y0);
	}

	// Yes, this method is probably useless
	private static void createCyanSwordFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 253 && blue == 1) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 2) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 3) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 4) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 5) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 6) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createGreenSwordFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 253 && blue == 9) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 10) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 11) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 12) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 13) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 14) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createYellowSwordFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 253 && blue == 17) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 18) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 19) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 20) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 21) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 22) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createOrangeSwordFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 253 && blue == 25) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 26) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 27) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 28) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 29) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 30) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createRedSwordFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 253 && blue == 33) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 34) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 35) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 36) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 37) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 38) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

	}

	private static void createPurpleSwordFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 253 && blue == 41) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 42) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 43) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 44) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 45) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

		if (red == 255 && green == 253 && blue == 46) {
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, foe);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}

	}

}
