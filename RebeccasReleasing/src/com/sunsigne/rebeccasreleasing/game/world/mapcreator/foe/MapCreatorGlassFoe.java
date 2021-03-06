package com.sunsigne.rebeccasreleasing.game.world.mapcreator.foe;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.living.FoeObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.loot.LootTool;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

public class MapCreatorGlassFoe {

	void createGlassFoe(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0,
			int y0) {
		createCyanGlassFoe(red, green, blue, handler_object, mapcreator, x0, y0);
		createGreenGlassFoe(red, green, blue, handler_object, mapcreator, x0, y0);
		createYellowGlassFoe(red, green, blue, handler_object, mapcreator, x0, y0);
		createOrangeGlassFoe(red, green, blue, handler_object, mapcreator, x0, y0);
		createRedGlassFoe(red, green, blue, handler_object, mapcreator, x0, y0);
		createPurpleGlassFoe(red, green, blue, handler_object, mapcreator, x0, y0);
	}

	private void createCyanGlassFoe(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 251 && blue == 1) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 2) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 3) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 4) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 5) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 6) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createGreenGlassFoe(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 251 && blue == 9) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 10) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 11) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 12) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 13) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 14) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createYellowGlassFoe(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 251 && blue == 17) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 18) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 19) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 20) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 21) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 22) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createOrangeGlassFoe(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 251 && blue == 25) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 26) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 27) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 28) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 29) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 30) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createRedGlassFoe(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 251 && blue == 33) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 34) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 35) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 36) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 37) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 38) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createPurpleGlassFoe(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 251 && blue == 41) {
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 42) {
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 43) {
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 44) {
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 45) {
			DIFFICULTY difficulty = DIFFICULTY.RED;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}

		if (red == 255 && green == 251 && blue == 46) {
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			FoeObject foe = new FoeObject(x0, y0, difficulty);
			handler_object.addObject(foe);

			difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.GLASS, difficulty);
			mapcreator.addToToolList(tool, foe);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}
}
