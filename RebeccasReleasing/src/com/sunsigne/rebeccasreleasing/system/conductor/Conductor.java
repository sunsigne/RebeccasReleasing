package com.sunsigne.rebeccasreleasing.system.conductor;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.main.DualChecker;
import com.sunsigne.rebeccasreleasing.main.Game;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;

@Todo("this class must still be constructed.")
public class Conductor {

	public static STATE state;

	
	public static void start()
	{
		Game.game.start();
		new DualChecker().start();
		AudioTask.playMusic(0.5, AudioBank.soundtrack_3);
		new Title();
	}
	
/*	
	public static IClose close (IClose iclose)
	{
		return iclose;
	}
*/	
	
	public static void stop()
	{
		new DualChecker().stop();
		System.exit(1);
	}
	
	
}
