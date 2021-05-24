package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.plant;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

import objects.Facing;
import objects.Facing.DIRECTION;
import objects.world.destroyable.Plant;
import objects.world.loot.tools.LootTool;

public class MapCreatorSwordPlant {

	void createSwordPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0,
			int y0) {

		createCyanSwordPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createGreenSwordPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createYellowSwordPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createOrangeSwordPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createRedSwordPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createPurpleSwordPlant(red, green, blue, handler_object, mapcreator, x0, y0);
	}

	private void createCyanSwordPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 254 && green == 0 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 1 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createGreenSwordPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 4 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 5 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createYellowSwordPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 8 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 9 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createOrangeSwordPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 12 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 13 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createRedSwordPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 254 && green == 16 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 17 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createPurpleSwordPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 20 && blue == 253) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 21 && blue == 253) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.SWORD, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}
}
