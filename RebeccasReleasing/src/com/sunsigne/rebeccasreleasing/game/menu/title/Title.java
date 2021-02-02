package com.sunsigne.rebeccasreleasing.game.menu.title;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;
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
			SoundTask.playMusic(0.5, SoundBank.getSound(SoundBank.title_screen));
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
		GameMouseInput.getInstance().clearClickable();
		HandlerObject.getInstance().clearAll();
	}

}
