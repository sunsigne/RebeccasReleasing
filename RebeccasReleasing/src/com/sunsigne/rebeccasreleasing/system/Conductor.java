package com.sunsigne.rebeccasreleasing.system;

import javax.swing.JOptionPane;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.LoadingScreenObject;
import com.sunsigne.rebeccasreleasing.game.menu.introduction.Introduction;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.game.world.ILvl;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.game.world.WorldLvl001;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.system.util.DualChecker;

@Todo("this class may have more responsabilities.")
public class Conductor {

	private static final LoadingScreenObject loadingScreenObject = new LoadingScreenObject();
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
		loading(state);
	}

	// behavior

	private static void loading(STATE state) {
		if (state == STATE.LOADING)
			loadingScreenObject.start();
		else
			loadingScreenObject.stop();

	}

	public static void start() {
		Conductor.setState(STATE.LOADING);
		Game.game.start();
		new DualChecker().start();
		Game.game.forceLoop();
		new Introduction();
	}
	
	public static void closeIntroduction()
	{
		GameMouseInput.getInstance().clearClickable();
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
		ILvl level = new WorldLvl001();
		World.currentWorld = new World(level);
	}

}
