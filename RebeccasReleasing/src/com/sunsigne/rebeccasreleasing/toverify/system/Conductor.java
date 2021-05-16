package com.sunsigne.rebeccasreleasing.toverify.system;

import javax.swing.JOptionPane;

import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.LoadingScreenObject;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.introduction.Introduction;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.toverify.game.world.*;
import com.sunsigne.rebeccasreleasing.toverify.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.toverify.system.util.DualChecker;

public class Conductor {

	private static final ChatMap fr = new ChatMap(LANGUAGE.FRENCH, new GameFile("texts/french/menu"));
	private static final ChatMap eng = new ChatMap(LANGUAGE.ENGLISH, new GameFile("texts/english/menu"));
	private static final ChatMap custom = new ChatMap(LANGUAGE.CUSTOM, new GameFile("texts/custom/menu"));
	
	private static final LoadingScreenObject loadingScreenObject = new LoadingScreenObject(fr, eng, custom);
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
		Game.getInstance().start();
//		new DualChecker().start();
		Game.getInstance().forceLoop();
		if (Game.skipIntro)
			new Title();
		else
			new Introduction();
	}

	public static void closeIntroduction() {
		GameMouseInput.getInstance().clearAllClickable();
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

	public static void openLvl() {
		Conductor.setState(STATE.LOADING);
		SoundTask.stopMusic();
		ILvl level = new WorldLvl02();
		World.currentWorld = new World(level);
	}

}
