package com.sunsigne.rebeccasreleasing.toverify.game.menu.title;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;

public class Title extends Clickable {

	private static final ChatMap fr = new ChatMap(LANGUAGE.FRENCH, new GameFile("texts/french/menu"));
	private static final ChatMap eng = new ChatMap(LANGUAGE.ENGLISH, new GameFile("texts/english/menu"));
	private static final ChatMap custom = new ChatMap(LANGUAGE.CUSTOM, new GameFile("texts/custom/menu"));
	
	public static final int[] playRect = { 780, 570, 360, 90 };
	public static final int[] optionsRect = { 710, 740, 500, 90 };
	public static final int[] quitRect = { 710, 920, 500, 90 };

	private static GameObject object;
	
	public Title() {
		super(STATE.TITLE);

		playMusic();
		object = new TitleObject(fr, eng, custom);
//		object.add();
		HandlerObject.getInstance().addObject(object);
	}
	
	@Override
	public LAYER getLayer() {
		return LAYER.WOLRD_GUI_PUZZLE;
	}

	private void playMusic() {
		STATE state = Conductor.getPreviousState();
		if (state != STATE.TITLE && state != STATE.OPTION)
			new SoundTask().playMusic(0.5, SoundBank.title_screen);
	}

	@Override
	public void mousePressed(int mx, int my) {
		if (GameMouseInput.mouseOver(mx, my, playRect)) {
			close();
			Conductor.openLvl();
		}

		if (GameMouseInput.mouseOver(mx, my, optionsRect)) {
			close();
			new Options();
		}

		if (GameMouseInput.mouseOver(mx, my, quitRect))
			Conductor.stop();
	}

	@Override
	public void mouseReleased(int mx, int my) {

	}

	@Override
	public void render(Graphics g) {
		gradientRender(g);

	}

	@Override
	public void close() {
		clearClickable();
		HandlerObject.getInstance().clear(false, LAYER.WOLRD_GUI_PUZZLE);
	}



}
