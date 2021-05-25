package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.desk;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.destroyable.Desk;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.loot.LootTool;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

public class MapCreatorKeyDesk {

	void createKeyDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0,
			int y0) {

		createCyanKeyDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createGreenKeyDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createYellowKeyDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createOrangeKeyDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createRedKeyDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createPurpleKeyDesk(red, green, blue, handler_object, mapcreator, x0, y0);
	}

	private void createCyanKeyDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 0 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);

		}
		if (red == 255 && green == 1 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 2 && blue == 254) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 3 && blue == 254) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createGreenKeyDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 4 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 5 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 6 && blue == 254) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 7 && blue == 254) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createYellowKeyDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 8 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 9 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 10 && blue == 254) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 11 && blue == 254) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createOrangeKeyDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 12 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 13 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 14 && blue == 254) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 15 && blue == 254) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createRedKeyDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 16 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 17 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 18 && blue == 254) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 19 && blue == 254) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createPurpleKeyDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 20 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 21 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 22 && blue == 254) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 23 && blue == 254) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}
}
