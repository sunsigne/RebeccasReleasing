package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.plant;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.destroyable.Plant;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.loot.LootTool;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

public class MapCreatorPliersPlant {

	void createPliersPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0,
			int y0) {

		createCyanPliersPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createGreenPliersPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createYellowPliersPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createOrangePliersPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createRedPliersPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createPurplePliersPlant(red, green, blue, handler_object, mapcreator, x0, y0);
	}

	private void createCyanPliersPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 0 && blue == 250) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 1 && blue == 250) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createGreenPliersPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 4 && blue == 250) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 5 && blue == 250) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createYellowPliersPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 8 && blue == 250) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 9 && blue == 250) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createOrangePliersPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 12 && blue == 250) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 13 && blue == 250) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createRedPliersPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 254 && green == 16 && blue == 250) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 17 && blue == 250) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createPurplePliersPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 20 && blue == 250) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 21 && blue == 250) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.PLIERS, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}
}
