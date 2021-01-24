package com.sunsigne.rebeccasreleasing.game.world.mapcreator;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.characters.living.FoeObject;

public class MapCreatorFoe {


	public static void createFoe(int red, int green, int blue, HandlerObject handler_object, int x0, int y0) {
		if (red == 255 && green == 255 && blue == 15)
		{
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.CYAN);
			handler_object.addObject(foe);
		}
		
		if (red == 255 && green == 255 && blue == 14)
		{
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.GREEN);
			handler_object.addObject(foe);
		}
		
		if (red == 255 && green == 255 && blue == 13)
		{
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.YELLOW);
			handler_object.addObject(foe);
		}
		
		if (red == 255 && green == 255 && blue == 12)
		{
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.ORANGE);
			handler_object.addObject(foe);
		}
		
		if (red == 255 && green == 255 && blue == 11)
		{
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.RED);
			handler_object.addObject(foe);
		}
		
		if (red == 255 && green == 255 && blue == 10)
		{
			FoeObject foe = new FoeObject(x0, y0, DIFFICULTY.PURPLE);
			handler_object.addObject(foe);
		}

	}

	
}
