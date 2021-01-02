package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.characters.living.FoeObject;
import objects.characters.living.PlayerObject;
import objects.world.Flag;
import objects.world.Wall;
import objects.world.decor.Coffee;
import objects.world.decor.Couch;
import objects.world.decor.Lamp;
import objects.world.decor.WC;
import objects.world.decor.Water;
import objects.world.destroyable.Desk;
import objects.world.destroyable.Plant;
import objects.world.puzzler.Case;
import objects.world.puzzler.Computer;
import objects.world.puzzler.Door;
import objects.world.puzzler.WallCracked;

@Todo("find the key to open the exit door / pour la déco : tapis, parquet, distributeur de café, de bouffe, poubelle,"
		+ " boites en cartons ou en bois, cuisines & salle de repos, toilettes, labo-chimique, débaras, vestiaires?")
public class MapBuilder {

	

	public static void createLevel(BufferedImage image) {

		HandlerObject handler_object = HandlerObject.getInstance();
		
		handler_object.player = new PlayerObject(0, 0);
		handler_object.addObject(handler_object.player);
		handler_object.isPlayerExisting = true;

		int w = image.getWidth();
		int h = image.getHeight();

		for (int xx = 0; xx < h; xx++) {
			for (int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				if (red == 255 && green == 0 && blue == 0) {
					handler_object.player.setX(xx * Size.TILE);
					handler_object.player.setY(yy * Size.TILE);
				}

				if (red == 255 && green == 255 && blue == 255)
					handler_object.addObject(new Wall(xx * Size.TILE, yy * Size.TILE, Wall.WALLTYPE.WALL));
				// door
				if (red == 128 && green == 128 && blue == 128)
					handler_object.addObject(new Door(xx * Size.TILE, yy * Size.TILE, true));
				if (red == 127 && green == 127 && blue == 127)
					handler_object.addObject(new Door(xx * Size.TILE, yy * Size.TILE, false));
				// couch
				if (red == 64 && green == 0 && blue == 0)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, false, true, 1)); // single
				if (red == 64 && green == 0 && blue == 1)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, true, false, 2)); // vertical dual left
				if (red == 64 && green == 0 && blue == 2)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, true, false, 3)); // vertical trio left
				if (red == 64 && green == 0 && blue == 3)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, true, true, 1)); // single reversed
				if (red == 64 && green == 0 && blue == 4)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, true, true, 2)); // horizontal dual reversed
				if (red == 64 && green == 0 && blue == 5)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, true, true, 3)); // horizontal trio reversed
				if (red == 64 && green == 0 && blue == 6)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, false, false, 2)); // vertical dual right
				if (red == 64 && green == 0 && blue == 7)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, false, false, 3)); // vertical trio right
				if (red == 64 && green == 0 && blue == 8)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, false, true, 2)); // horizontal dual
				if (red == 64 && green == 0 && blue == 9)
					handler_object.addObject(new Couch(xx * Size.TILE, yy * Size.TILE, false, true, 3)); // horizontal trio
				// other
				if (red == 0 && green == 64 && blue == 64)
					handler_object.addObject(new Water(xx * Size.TILE, yy * Size.TILE));
				
				if (red == 0 && green == 65 && blue == 64)
					handler_object.addObject(new Coffee(xx * Size.TILE, yy * Size.TILE));
				
				if (red == 0 && green == 64 && blue == 65)
					handler_object.addObject(new Lamp(xx * Size.TILE, yy * Size.TILE));

				if (red == 64 && green == 64 && blue == 64)
					handler_object.addObject(new WallCracked(xx * Size.TILE, yy * Size.TILE));
				if (red == 0 && green == 0 && blue == 255)
					handler_object.addObject(new FoeObject(xx * Size.TILE, yy * Size.TILE));
				if (red == 0 && green == 255 && blue == 0)
					handler_object.addObject(new Computer(xx * Size.TILE, yy * Size.TILE));
				if (red == 128 && green == 128 && blue == 255)
					handler_object.addObject(new Case(xx * Size.TILE, yy * Size.TILE));
				if (red == 255 && green == 0 && blue == 255)
					handler_object.addObject(new Desk(xx * Size.TILE, yy * Size.TILE, true));
				if (red == 255 && green == 128 && blue == 255)
					handler_object.addObject(new Desk(xx * Size.TILE, yy * Size.TILE, false));
				if (red == 0 && green == 255 && blue == 128)
					handler_object.addObject(new Plant(xx * Size.TILE, yy * Size.TILE, false));
				if (red == 128 && green == 255 && blue == 128)
					handler_object.addObject(new Plant(xx * Size.TILE, yy * Size.TILE, true));
				if (red == 64 && green == 64 && blue == 0)
					handler_object.addObject(new WC(xx * Size.TILE, yy * Size.TILE));
				if (red == 64 && green == 64 && blue == 32)
					handler_object.addObject(new WC(xx * Size.TILE, yy * Size.TILE));
				if (red == 192 && green == 192 && blue == 192)
					handler_object.addObject(new Flag(xx * Size.TILE, yy * Size.TILE));

//				if(red == 255 && green == 255 && blue == 0) handler.addObject(new Silo(xx*Size.TILE, yy*Size.TILE));				
			}
		}
	}

	
	
}
