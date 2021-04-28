package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.mapcreatordestroyable.MapCreatorDestroyable;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.mapcreatorfoe.MapCreatorFoe;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;

import objects.GameObject;
import objects.IFacing.FACING;
import objects.characters.living.PlayerObject;
import objects.world.Wall;
import objects.world.loot.ILoot;
import objects.world.loot.tools.LootTool;

@Todo("find the key to open the exit door / pour la déco : tapis, parquet, distributeur de café, de bouffe, poubelle,"
		+ " boites en cartons ou en bois, cuisines & salle de repos, toilettes, labo-chimique, débaras, vestiaires?, silo")
public class MapCreator {

	@SuppressWarnings("unchecked")
	private static List<ILoot>[][] tool_list = new List[7][4]; // - difficulty - state

	public static void addToToolList(Tool tool, ILoot iloot) {
		MapCreator.tool_list[tool.getCurrentLvl()][tool.getToolNum()].add(iloot);
	}

	private static void setUpForRandomizingLoot() {
		for (int difficulty = 0; difficulty < 7; difficulty++) {
			Arrays.setAll(tool_list[difficulty], ArrayList::new);
		}
	}

	public static void createLevel(BufferedImage image) {

		// To remember the color used, here is the guideline I tried to follow :

		// Red for People (because red = important)
		// Green for Puzzler (as green makes me think to "thinking")
		// Yellow for Foes (as they are both living & puzzler)
		// Bleu for loots (opposite of foe ! Foe blocks you, loots help you)
		// Cyan for decor (because it's beautiful, right ? decor = beauty)
		// Magenta for destroyable (because it's flashy, like important spot)
		setUpForRandomizingLoot();
		HandlerObject handler_object = HandlerObject.getInstance();

		handler_object.player = new PlayerObject(0, 0);
		handler_object.addObject(handler_object.player);
		handler_object.isPlayerExisting = true;

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
				MapCreatorPuzzler.createDoor(red, green, blue, handler_object, x0, y0);
				MapCreatorPuzzler.createWallCracked(red, green, blue, handler_object, x0, y0);
				MapCreatorPuzzler.createCase(red, green, blue, handler_object, x0, y0);
				MapCreatorPuzzler.createComputer(red, green, blue, handler_object, x0, y0);

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

	private static void randomizeLoot() {

		// search into list, classed by their difficulty
		for (int difficulty = 0; difficulty < 7; difficulty++) {
			int numberOfTool = tool_list[difficulty].length;
//			System.out.println("difficulty : " + difficulty + " / number of different tools : " + numberOfTool);
			if (numberOfTool == 0)
				continue;

			// search for list, classed by the type of tool
			for (int tool = 0; tool < numberOfTool; tool++) {
				int sizeOfList = tool_list[difficulty][tool].size();
//				System.out.println("difficulty : " + difficulty + " / tool number : " + tool + " / number of source for loot : " + sizeOfList);
				if (sizeOfList == 0)
					continue;

				// take a random ILoot into the list
				int r = new Random().nextInt(sizeOfList);
				ILoot randomILoot = tool_list[difficulty][tool].get(r);
				GameObject randomILootObject = (GameObject) randomILoot;
				// creation of the tool
				Tool lootTool = new Tool(tool, difficulty, 0);

				// set to the random ILootObject, the loot tool
				randomILoot.setLootObject(new LootTool(randomILootObject.getX(), randomILootObject.getY(), lootTool, false));
				tool_list[difficulty][tool].clear();
			}
		}

	}

	private static void createWall(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 255 && blue == 255) {
			Wall wall = new Wall(x0, y0, null);
			handler_object.addObject(wall);
		}
				
		if (red == 255 && green == 254 && blue == 255) {
			Wall wall = new Wall(x0, y0, FACING.LEFT);
			handler_object.addObject(wall);
		}
		
		if (red == 255 && green == 253 && blue == 255) {
			Wall wall = new Wall(x0, y0, FACING.RIGHT);
			handler_object.addObject(wall);
		}
		
		if (red == 255 && green == 252 && blue == 255) {
			Wall wall = new Wall(x0, y0, FACING.UP);
			handler_object.addObject(wall);
		}
		
		if (red == 255 && green == 251 && blue == 255) {
			Wall wall = new Wall(x0, y0, FACING.DOWN);
			handler_object.addObject(wall);
		}

	}

}
