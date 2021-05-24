package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.desk;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

import objects.Facing;
import objects.Facing.DIRECTION;
import objects.world.destroyable.Desk;
import objects.world.loot.tools.LootTool;

public class MapCreatorSwordDesk {

	void createSwordDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0,
			int y0) {

		createCyanSwordDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createGreenSwordDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createYellowSwordDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createOrangeSwordDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createRedSwordDesk(red, green, blue, handler_object, mapcreator, x0, y0);
		createPurpleSwordDesk(red, green, blue, handler_object, mapcreator, x0, y0);
	}

	private void createCyanSwordDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 0 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 1 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 2 && blue == 253) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 3 && blue == 253) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createGreenSwordDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 4 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 5 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 6 && blue == 253) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 7 && blue == 253) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createYellowSwordDesk(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 255 && green == 8 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 9 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 10 && blue == 253) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 11 && blue == 253) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createOrangeSwordDesk(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 255 && green == 12 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 13 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 14 && blue == 253) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 15 && blue == 253) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createRedSwordDesk(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 255 && green == 16 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 17 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 18 && blue == 253) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 19 && blue == 253) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createPurpleSwordDesk(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 255 && green == 20 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 21 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 22 && blue == 253) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 23 && blue == 253) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}
}
