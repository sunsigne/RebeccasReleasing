package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.desk;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

import objects.Facing;
import objects.Facing.DIRECTION;
import objects.world.destroyable.Desk;
import objects.world.loot.tools.LootTool;

public class MapCreatorBombDesk {

	void createBombDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createCyanBombDesk(red, green, blue, handler_object, x0, y0);
		createGreenBombDesk(red, green, blue, handler_object, x0, y0);
		createYellowBombDesk(red, green, blue, handler_object, x0, y0);
		createOrangeBombDesk(red, green, blue, handler_object, x0, y0);
		createRedBombDesk(red, green, blue, handler_object, x0, y0);
		createPurpleBombDesk(red, green, blue, handler_object, x0, y0);
	}

	private void createCyanBombDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 0 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 1 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 2 && blue == 252) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 3 && blue == 252) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createGreenBombDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 4 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 5 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 6 && blue == 252) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 7 && blue == 252) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createYellowBombDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 8 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 9 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 10 && blue == 252) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 11 && blue == 252) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createOrangeBombDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 12 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 13 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 14 && blue == 252) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 15 && blue == 252) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createRedBombDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 16 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 17 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 18 && blue == 252) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 19 && blue == 252) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createPurpleBombDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 20 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 21 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 22 && blue == 252) {
			Facing facing = new Facing(DIRECTION.UP);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 255 && green == 23 && blue == 252) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Desk desk = new Desk(x0, y0, facing);
			handler_object.addObject(desk);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			MapCreator.addToToolList(tool, desk);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}
}
