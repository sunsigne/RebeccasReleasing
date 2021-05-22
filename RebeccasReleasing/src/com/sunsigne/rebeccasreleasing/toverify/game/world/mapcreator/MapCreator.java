package com.sunsigne.rebeccasreleasing.toverify.game.world.mapcreator;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.Wall;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.destroyable.MapCreatorDestroyable;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.foe.MapCreatorFoe;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.puzzler.MapCreatorPuzzler;
import com.sunsigne.rebeccasreleasing.ressources.tools.BufferedTool;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolIndex;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

import objects.Facing;
import objects.Facing.DIRECTION;
import objects.world.loot.ILoot;
import objects.world.loot.tools.LootTool;

public class MapCreator {

	@SuppressWarnings("unchecked")
	private static List<ILoot>[][] tool_list = new List[7][ToolIndex.getTotalNumOfTools()]; // - difficulty - number of tools

	public static void addToToolList(LootTool lootTool, ILoot iloot) {
		int lvl = lootTool.getTool().getCurrentLvl();
		int index = lootTool.getTool().getToolBank().getIndex();
		MapCreator.tool_list[lvl][index].add(iloot);
	}

	private static void setUpForRandomizingLoot() {
		for (int difficulty = 0; difficulty < 7; difficulty++) {
			Arrays.setAll(tool_list[difficulty], ArrayList::new);
		}
	}

	public static void createLevel(BufferedImage image) {

		HandlerObject handler_object = HandlerObject.getInstance();
		// To remember the color used, here is the guideline I tried to follow :

		// Red for People (because red = important)
		// Green for Puzzler (as green makes me think to "thinking")
		// Yellow for Foes (as they are both living & puzzler)
		// Bleu for loots (opposite of foe ! Foe blocks you, loots help you)
		// Cyan for decor (because it's beautiful, right ? decor = beauty)
		// Magenta for destroyable (because it's flashy, like important spot)
		setUpForRandomizingLoot();

		createPlayer(handler_object);

		int w = image.getWidth();
		int h = image.getHeight();
		int step = 32;

		for (int xx = 0; xx < h; xx += step) {
			for (int yy = 0; yy < w; yy += step) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				int x0 = xx * Size.TILE / step;
				int y0 = yy * Size.TILE / step;

				createWall(red, green, blue, handler_object, x0, y0);

				// living - red
				MapCreatorLiving.createPlayer(red, green, blue, handler_object, x0, y0);

				// puzzler - green
				MapCreatorPuzzler.createPuzzler(red, green, blue, handler_object, x0, y0);

				// foe - yellow
				MapCreatorFoe.createFoe(red, green, blue, handler_object, x0, y0);

				// loot - blue
				MapCreatorLoot.createTool(red, green, blue, handler_object, x0, y0);

				// decor - cyan
				MapCreatorDecor.createSmall(red, green, blue, handler_object, x0, y0);

				// destroyable - magenta
				MapCreatorDestroyable.createDestroyable(red, green, blue, handler_object, x0, y0);
			}
		}

		randomizeLoot();
	}

	private static void createPlayer(HandlerObject handler_object) {
		handler_object.resetPlayer();
		handler_object.addObject(handler_object.getPlayer());
	}

	private static void randomizeLoot() {

		// search into list, classed by their difficulty
		for (int lvl = 0; lvl < 7; lvl++) {
			int numberOfTool = tool_list[lvl].length;
//			System.out.println("difficulty : " + difficulty + " / number of different tools : " + numberOfTool);
			if (numberOfTool == 0)
				continue;

			// search for list, classed by the type of tool
			for (int tool = 0; tool < numberOfTool; tool++) {
				int sizeOfList = tool_list[lvl][tool].size();
//				System.out.println("difficulty : " + difficulty + " / tool number : " + tool + " / number of source for loot : " + sizeOfList);
				if (sizeOfList == 0)
					continue;

				// take a random ILoot into the list
				int r = new Random().nextInt(sizeOfList);
				ILoot randomILoot = tool_list[lvl][tool].get(r);
				GameObject randomILootObject = (GameObject) randomILoot;

				// search of ToolBank by index
				ToolBank toolBank = null;
				var map = ToolBank.copyMap();

				for (ToolBank tempToolBank : map.keySet()) {
					if (tempToolBank.getIndex() == tool)
						toolBank = tempToolBank;
				}

				// creation of the tool
				LootTool lootTool = new LootTool(randomILootObject.getX(), randomILootObject.getY(), toolBank,
						DIFFICULTY.getDifficulty(lvl));

				// set to the random ILootObject, the loot tool
				randomILoot.setLootObject(lootTool);
				tool_list[lvl][tool].clear();
			}
		}

	}

	private static void createWall(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 255 && blue == 255) {
			Facing facing = new Facing(DIRECTION.NULL);
			Wall wall = new Wall(x0, y0, facing);
			handler_object.addObject(wall);
		}

		if (red == 255 && green == 254 && blue == 255) {
			Facing facing = new Facing(DIRECTION.LEFT);
			Wall wall = new Wall(x0, y0, facing);
			handler_object.addObject(wall);
		}

		if (red == 255 && green == 253 && blue == 255) {
			Facing facing = new Facing(DIRECTION.RIGHT);
			Wall wall = new Wall(x0, y0, facing);
			handler_object.addObject(wall);
		}

		if (red == 255 && green == 252 && blue == 255) {
			Facing facing = new Facing(DIRECTION.UP);
			Wall wall = new Wall(x0, y0, facing);
			handler_object.addObject(wall);
		}

		if (red == 255 && green == 251 && blue == 255) {
			Facing facing = new Facing(DIRECTION.DOWN);
			Wall wall = new Wall(x0, y0, facing);
			handler_object.addObject(wall);
		}

	}

}
