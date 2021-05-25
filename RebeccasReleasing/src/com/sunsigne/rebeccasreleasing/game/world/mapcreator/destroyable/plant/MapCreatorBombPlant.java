package com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.plant;

import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.destroyable.Plant;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.loot.LootTool;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator.MapCreator;

public class MapCreatorBombPlant {

	void createBombPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator, int x0,
			int y0) {

		createCyanBombPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createGreenBombPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createYellowBombPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createOrangeBombPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createRedBombPlant(red, green, blue, handler_object, mapcreator, x0, y0);
		createPurpleBombPlant(red, green, blue, handler_object, mapcreator, x0, y0);
	}

	private void createCyanBombPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 254 && green == 0 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 1 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.CYAN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createGreenBombPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 254 && green == 4 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 5 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.GREEN;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createYellowBombPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 8 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 9 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.YELLOW;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createOrangeBombPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 12 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 13 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.ORANGE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createRedBombPlant(int red, int green, int blue, HandlerObject handler_object, MapCreator mapcreator,
			int x0, int y0) {
		if (red == 254 && green == 16 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 17 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.RED;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}

	private void createPurpleBombPlant(int red, int green, int blue, HandlerObject handler_object,
			MapCreator mapcreator, int x0, int y0) {
		if (red == 254 && green == 20 && blue == 252) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
		if (red == 254 && green == 21 && blue == 252) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Plant plant = new Plant(x0, y0, facing);
			handler_object.addObject(plant);

			DIFFICULTY difficulty = DIFFICULTY.PURPLE;
			LootTool tool = new LootTool(x0, y0, ToolBank.BOMB, difficulty);
			mapcreator.addToToolList(tool, plant);
			tool.setFake(true);
			handler_object.addObject(tool);
		}
	}
}
