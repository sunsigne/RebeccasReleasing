package com.sunsigne.rebeccasreleasing.toverify.game.menu.introduction;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.Clickable;

public class Introduction extends Clickable {

	private static final ChatMap fr = new ChatMap(LANGUAGE.FRENCH, new GameFile("texts/french/dialogues/introduction"));
	private static final ChatMap eng = new ChatMap(LANGUAGE.ENGLISH, new GameFile("texts/english/dialogues/introduction"));
	private static final ChatMap custom = new ChatMap(LANGUAGE.CUSTOM, new GameFile("texts/custom/dialogues/introduction"));
	
	public Introduction() {
		super(STATE.INTRODUCTION);

		new SoundTask().playSound(0.6, SoundBank.PIERRE_FEUILLE_CISEAUX_COM);
		new AutomaticTimerObject(150, () -> new SoundTask().playMusic(0.5, SoundBank.MUSIC_INTRODUCTION));
		HandlerObject.getInstance().addObject(new IntroductionObject(fr, eng, custom));

	}
	
	@Override
	public LAYER getLayer() {
		return LAYER.WOLRD_GUI_PUZZLE;
	}

	@Override
	public void mousePressed(int mx, int my) {

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
		Conductor.closeIntroduction();
	}

}
