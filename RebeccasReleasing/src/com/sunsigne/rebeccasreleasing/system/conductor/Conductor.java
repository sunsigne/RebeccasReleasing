package com.sunsigne.rebeccasreleasing.system.conductor;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.main.DualChecker;
import com.sunsigne.rebeccasreleasing.main.Game;

@Todo("this class may have more responsabilities.")
public class Conductor {

	private static STATE state;
	private static STATE previousState;


	public static STATE getState() {
		return state;
	}
	
	public static STATE getPreviousState() {
		return previousState;
	}

	public static void setState(STATE state) {
		Conductor.previousState = Conductor.state;
		Conductor.state = state;
	}
		
	
	public static void start()
	{
		Game.game.start();
		new DualChecker().start();
		Game.game.forceLoop();
		new Title();
	}

	
	public static void stop()
	{
		new DualChecker().stop();
		System.exit(1);
	}

	
}
