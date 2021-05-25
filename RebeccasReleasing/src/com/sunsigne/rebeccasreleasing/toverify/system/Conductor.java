package com.sunsigne.rebeccasreleasing.toverify.system;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.Ressource;
import com.sunsigne.rebeccasreleasing.ressources.font.FontBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.Game;
import com.sunsigne.rebeccasreleasing.system.conductor.DebugMode;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.system.util.Cycloid;
import com.sunsigne.rebeccasreleasing.system.util.DualChecker;
import com.sunsigne.rebeccasreleasing.system.util.Window;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.LoadingScreenObject;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.introduction.Introduction;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.lazer.object.ColorEnigmaBank;
import com.sunsigne.rebeccasreleasing.toverify.game.world.*;
import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.GameKeyboardInput;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;

public class Conductor {

	public static final boolean skipIntro = true;

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

	////////// RESSOURCES ////////////

	private static LinkedList<Ressource> ressources_list = new LinkedList<>();

	public static void startApp() {

		Conductor.setState(STATE.LOADING);

		registerRessources();
		loadBareMinimumRessources();
		loadRessources();

		Options.loadSavedSettings();

		ImageBank.loadRessources();
		CharacterBank.loadRessources();
		TextureBank.getInstance().loadRessources();
		new ColorEnigmaBank().loadRessources();

		Game.getInstance().addKeyListener(new GameKeyboardInput());
		Game.getInstance().addMouseListener(GameMouseInput.getInstance());
		new Window(Game.getInstance());

		Conductor.setState(STATE.LOADING);
		Game.getInstance().start();
//		new DualChecker().start();
		Game.getInstance().forceLoop();
		
		bareMinimumStart();
		start();
	}

	private static void registerRessources() {
		ressources_list.add(new FontBank());
//		ressources_list.add(new ImageBank());
		ressources_list.add(new SoundBank());
	}

	private static void loadBareMinimumRessources() {
		for (Ressource tempRessource : ressources_list)
			tempRessource.loadBareMinimumRessources();
	}

	private static void loadRessources() {
		for (Ressource tempRessource : ressources_list)
			tempRessource.loadRessources();
	}

	private static void bareMinimumStart() {
		Conductor.setState(STATE.LOADING);
		Game.getInstance().start();
		new DualChecker().start();
		Game.getInstance().forceLoop();
	}
	
	public static void start() {
		if (skipIntro)
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
		new SoundTask().playSound(SoundBank.ERROR);
		JOptionPane.showMessageDialog(null, errorOccured);
		Conductor.stop();
	}

	public static void openLvl() {
		Conductor.setState(STATE.LOADING);
		new SoundTask().stopMusic();
		ILvl level = new WorldLvlTest();
		World.currentWorld = new World(level);
	}

	////////// DEBUG MOD ////////////

	private static final DebugMode debugMode = new DebugMode();

	public static DebugMode getDebugMode() {
		return debugMode;
	}

}
