package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;

import objects.IFacing.FACING;
import objects.world.destroyable.Desk;
import objects.world.destroyable.Plant;

public class MapCreatorDestroyable {

	static void createDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createNoneLootDesk(red, green, blue, handler_object, x0, y0);
		createCyanSwordDesk(red, green, blue, handler_object, x0, y0);
	}

	private static void createNoneLootDesk(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 0 && blue == 255) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 1 && blue == 255) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 2 && blue == 255) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
		}
		if (red == 255 && green == 3 && blue == 255) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
		}
	}

	private static void createCyanSwordDesk(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 255 && green == 0 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.LEFT);
			handler_object.addObject(desk);
			MapCreator.tool_list[DIFFICULTY.CYAN.getLvl()][Tool.SWORD].add(desk);
		}
		if (red == 255 && green == 1 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.RIGHT);
			handler_object.addObject(desk);
			MapCreator.tool_list[DIFFICULTY.CYAN.getLvl()][Tool.SWORD].add(desk);
		}
		if (red == 255 && green == 2 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.UP);
			handler_object.addObject(desk);
			MapCreator.tool_list[DIFFICULTY.CYAN.getLvl()][Tool.SWORD].add(desk);
		}
		if (red == 255 && green == 3 && blue == 254) {
			Desk desk = new Desk(x0, y0, FACING.DOWN);
			handler_object.addObject(desk);
			MapCreator.tool_list[DIFFICULTY.CYAN.getLvl()][Tool.SWORD].add(desk);
		}
	}

	static void createPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {

		createNoneLootPlant(red, green, blue, handler_object, x0, y0);
		createCyanKeyPlant(red, green, blue, handler_object, x0, y0);
	}

	private static void createNoneLootPlant(int red, int green, int blue, HandlerObject handler_object, int x0,
			int y0) {
		if (red == 254 && green == 0 && blue == 255) {
			Plant plant = new Plant(x0, y0, FACING.LEFT);
			handler_object.addObject(plant);
		}
		if (red == 254 && green == 1 && blue == 255) {
			Plant plant = new Plant(x0, y0, FACING.RIGHT);
			handler_object.addObject(plant);
		}
	}

	private static void createCyanKeyPlant(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 254 && green == 0 && blue == 254) {
			Plant plant = new Plant(x0, y0, FACING.LEFT);
			handler_object.addObject(plant);
			MapCreator.tool_list[DIFFICULTY.CYAN.getLvl()][Tool.KEY].add(plant);
		}
		if (red == 254 && green == 1 && blue == 254) {
			Plant plant = new Plant(x0, y0, FACING.RIGHT);
			handler_object.addObject(plant);
			MapCreator.tool_list[DIFFICULTY.CYAN.getLvl()][Tool.KEY].add(plant);
		}
	}

}
