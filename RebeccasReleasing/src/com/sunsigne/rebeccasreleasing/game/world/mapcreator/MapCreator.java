package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;

import objects.characters.living.PlayerObject;
import objects.world.Wall;
import objects.world.destroyable.DestroyableObject;
import objects.world.loot.tools.LootTool;

@Todo("find the key to open the exit door / pour la déco : tapis, parquet, distributeur de café, de bouffe, poubelle,"
		+ " boites en cartons ou en bois, cuisines & salle de repos, toilettes, labo-chimique, débaras, vestiaires?, silo")
public class MapCreator {

	@SuppressWarnings("unchecked")
	static List<DestroyableObject>[] cyan_tool_list = new List[2];

	@Todo("clean that mess")
	public static void createLevel(BufferedImage image) {

		// To remember the color used, here is the guideline I tried to follow :

		// Red for People (because red = important)
		// Green for Puzzler (as green makes me think to "thinking")
		// Yellow for Foes (as they are both living & puzzler)
		// Cyan for decor (because it's beautiful, right ? decor = beauty)
		// Magenta for destroyable (because it's flashy, like important spot)
		Arrays.setAll(cyan_tool_list, ArrayList :: new);
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

				// decor - cyan
				MapCreatorDecor.createCouch(red, green, blue, handler_object, x0, y0);
				MapCreatorDecor.createSmall(red, green, blue, handler_object, x0, y0);
				MapCreatorDecor.createTall(red, green, blue, handler_object, x0, y0);

				// destroyable - magenta
				MapCreatorDestroyable.createDesk(red, green, blue, handler_object, x0, y0);
				MapCreatorDestroyable.createPlant(red, green, blue, handler_object, x0, y0);


			}
		}

		RandomizeLoot();
	}

	private static void RandomizeLoot() {
		
		int numberOfList = cyan_tool_list.length;
		for (int list = 0; list < numberOfList; list++)
		{
			int sizeOfList = cyan_tool_list[list].size();
			if(sizeOfList == 0) continue;
			int r = new Random().nextInt(sizeOfList);
			DestroyableObject randomDestroyable = cyan_tool_list[list].get(r);
			Tool cyan_tool = new Tool(list, DIFFICULTY.CYAN.getLvl(), 0);
			randomDestroyable.setLootObject(new LootTool(randomDestroyable.getX(), randomDestroyable.getY(), cyan_tool));
			cyan_tool_list[list].clear();
		}		
	}
	
	private static void createWall(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 255 && blue == 255) {
			Wall wall = new Wall(x0, y0);
			handler_object.addObject(wall);
		}
	}

}
