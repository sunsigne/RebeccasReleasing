package com.sunsigne.rebeccasreleasing.game.menu.title;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.main.Conductor;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class Title extends Clickable {

	public static final int[] playRect = { 780, 570, 360, 90 };
	public static final int[] optionsRect = { 710, 740, 500, 90 };
	public static final int[] quitRect = { 710, 920, 500, 90 };

	public Title() {
		super(STATE.TITLE);

		playMusic();
		HandlerObject.getInstance().addObject(new TitleObject());
	}

	private void playMusic() {
		STATE state = Conductor.getPreviousState();
		if (state != STATE.TITLE && state != STATE.OPTION)
			SoundTask.playMusic(0.5, SoundBank.getSound(SoundBank.soundtrack_3));
	}

	@Override
	public void mousePressed(int mx, int my) {
		if (GameMouseListener.mouseOver(mx, my, playRect)) {
			close();
			Conductor.openLvl();
		}

		if (GameMouseListener.mouseOver(mx, my, optionsRect)) {
			close();
			new Options();
		}

		if (GameMouseListener.mouseOver(mx, my, quitRect))
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
		GameMouseListener.getInstance().clearClickable();
		HandlerObject.getInstance().clearAll();
	}

}
