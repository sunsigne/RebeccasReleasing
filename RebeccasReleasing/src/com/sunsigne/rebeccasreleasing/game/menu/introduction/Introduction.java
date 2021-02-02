package com.sunsigne.rebeccasreleasing.game.menu.introduction;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class Introduction extends Clickable {

	private static final ChatMap frintroduction = new ChatMap(LANGUAGE.FRENCH, new GameFile("/dialogues/french/introduction"));
//	private static final ChatMap englvl01 = new ChatMap(LANGUAGE.ENGLISH, new GameFile("/dialogues/english/introduction"));
	
	public Introduction() {
		super(STATE.INTRODUCTION);

		SoundTask.playSound(0.6, SoundBank.getSound(SoundBank.pierre_feuille_ciseaux_com));
		new AutomaticTimerObject(150, () -> SoundTask.playMusic(0.5, SoundBank.getSound(SoundBank.introduction)));
		HandlerObject.getInstance().addObject(new IntroductionObject(frintroduction));

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
