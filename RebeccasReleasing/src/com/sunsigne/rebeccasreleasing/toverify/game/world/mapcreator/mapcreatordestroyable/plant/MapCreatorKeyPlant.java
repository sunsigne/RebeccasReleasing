package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatordestroyable.plant;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;
import com.sunsigne.rebeccasreleasing.toverify.ressources.tools.ToolBank;

import objects.Facing;
import objects.Facing.DIRECTION;
import objects.world.destroyable.Plant;
import objects.world.loot.tools.LootTool;

public class MapCreatorKeyPlant {

	static void createKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createCyanKeyPlant(red, green, blue, handler_object, x0, y0);
		createGreenKeyPlant(red, green, blue, handler_object, x0, y0);
		createYellowKeyPlant(red, green, blue, handler_object, x0, y0);
		createOrangeKeyPlant(red, green, blue, handler_object, x0, y0);
		createRedKeyPlant(red, green, blue, handler_object, x0, y0);
		createPurpleKeyPlant(red, green, blue, handler_object, x0, y0);

	}

	private static void createCyanKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 254 && green == 0 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 1 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createGreenKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 4 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 5 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createYellowKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 8 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 9 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createOrangeKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 12 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 13 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createRedKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 254 && green == 16 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 17 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private static void createPurpleKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 20 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 21 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.KEY, difficulty);
			MapCreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

}
