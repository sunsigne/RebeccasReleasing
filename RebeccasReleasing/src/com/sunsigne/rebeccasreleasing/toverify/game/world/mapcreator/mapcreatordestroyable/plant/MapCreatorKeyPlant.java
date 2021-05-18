package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatordestroyable.plant;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

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
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 1 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createGreenKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 4 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 5 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createYellowKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 8 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 9 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createOrangeKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 12 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 13 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createRedKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 254 && green == 16 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 17 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createPurpleKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 20 && blue == 254) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 21 && blue == 254) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.KEY, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

}
