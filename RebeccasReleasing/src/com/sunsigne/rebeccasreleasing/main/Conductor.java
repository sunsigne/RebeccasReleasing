package com.sunsigne.rebeccasreleasing.main;

import javax.swing.JOptionPane;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.game.world.ILvl;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.game.world.WorldLvl01;
import com.sunsigne.rebeccasreleasing.game.world.WorldLvl02;
import com.sunsigne.rebeccasreleasing.game.world.WorldLvl03;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;

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
	
	@Todo("passer a un système intelligent qui determine le lvl avec la sauvegarde")
	public static void openLvl()
	{
		SoundTask.stopMusic();
		ILvl level = new WorldLvl01();
		World.currentWorld = new World(level);
	}
	
	
	public static void fatalError(String errorOccured)
	{
		SoundTask.playSound(SoundBank.getSound(SoundBank.error));
		JOptionPane.showMessageDialog(null, errorOccured);
		Conductor.stop();
	}

	
	public static void stop()
	{
		new DualChecker().stop();
		System.exit(1);
	}

	
}
