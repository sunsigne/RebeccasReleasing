package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.mapcreatordestroyable.plant;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

import objects.Facing.DIRECTION;
import objects.world.destroyable.Plant;
import objects.world.loot.tools.LootTool;

public class MapCreatorSwordPlant {

	static void createSwordPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
/*
		createCyanSwordPlant(red, green, blue, handler_object, x0, y0);
		createGreenSwordPlant(red, green, blue, handler_object, x0, y0);
		createYellowSwordPlant(red, green, blue, handler_object, x0, y0);
		createOrangeSwordPlant(red, green, blue, handler_object, x0, y0);
		createRedSwordPlant(red, green, blue, handler_object, x0, y0);
		createPurpleSwordPlant(red, green, blue, handler_object, x0, y0);

*/	}
/*
	private static void createCyanSwordPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 254 && green == 0 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.LEFT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 1 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.RIGHT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.CYAN.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createGreenSwordPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 4 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.LEFT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 5 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.RIGHT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.GREEN.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createYellowSwordPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 8 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.LEFT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 9 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.RIGHT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.YELLOW.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createOrangeSwordPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 12 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.LEFT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 13 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.RIGHT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.ORANGE.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createRedSwordPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 254 && green == 16 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.LEFT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 17 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.RIGHT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.RED.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}

	private static void createPurpleSwordPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 20 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.LEFT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
		if (red == 254 && green == 21 && blue == 253) {
			Plant plant = new Plant(x0, y0, DIRECTION.RIGHT);
			handler_object.addObject(plant);
			Tool tool = new Tool(Tool.SWORD, DIFFICULTY.PURPLE.getLvl(), 0);
			MapCreator.addToToolList(tool, plant);
			LootTool fakeTool = new LootTool(x0, y0, tool, true);
			handler_object.addObject(fakeTool);
		}
	}
*/
}
