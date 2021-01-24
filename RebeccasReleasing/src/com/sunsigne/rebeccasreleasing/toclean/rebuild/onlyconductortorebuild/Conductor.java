package com.sunsigne.rebeccasreleasing.toclean.rebuild.onlyconductortorebuild;

import javax.swing.JOptionPane;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.game.world.ILvl;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.game.world.WorldLvl01;
import com.sunsigne.rebeccasreleasing.game.world.WorldLvl02;
import com.sunsigne.rebeccasreleasing.game.world.WorldLvl03;
import com.sunsigne.rebeccasreleasing.main.DualChecker;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;

@Todo("this class may have more responsabilities.")
public class Conductor {

	private static STATE state;
	private static STATE previousState;

	// state

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

	// behavior

	public static void start() {
		Conductor.setState(STATE.LOADING);
		Game.game.start();
		new DualChecker().start();
		Game.game.forceLoop();
		new Title();
	}

	public static void stop() {
		new DualChecker().stop();
		System.exit(1);
	}

	public static void fatalError(String errorOccured) {
		SoundTask.playSound(SoundBank.getSound(SoundBank.error));
		JOptionPane.showMessageDialog(null, errorOccured);
		Conductor.stop();
	}

	@Todo("passer a un syst�me intelligent qui determine le lvl avec la sauvegarde")
	public static void openLvl() {
		Conductor.setState(STATE.LOADING);
		SoundTask.stopMusic();
		//!! new map creator ! Lvl 02 and 03 won't work
		ILvl level = new WorldLvl01();
		World.currentWorld = new World(level);
	}

}
