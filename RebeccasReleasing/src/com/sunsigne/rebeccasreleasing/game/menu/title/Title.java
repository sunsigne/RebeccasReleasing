package com.sunsigne.rebeccasreleasing.game.menu.title;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.game.world.ILvl;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.game.world.WorldLvl01;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
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
		System.out.println("title created");
	}

	private void playMusic() {
		STATE state = Conductor.getPreviousState();
		if (state != STATE.TITLE && state != STATE.OPTION)
			AudioTask.playMusic(0.5, AudioBank.soundtrack_3);
	}

	@Todo("passer a un système intelligent qui determine le lvl avec la sauvegarde (dans une autre classe bien sûr)")
	@Override
	public void mousePressed(int mx, int my) {
		if (GameMouseListener.mouseOver(mx, my, playRect)) {
			close();
			AudioTask.stopMusic();
			ILvl level = new WorldLvl01();
			World.world = new World(level);
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

	public void close() {
		GameMouseListener.getInstance().clearClickable();
		HandlerObject.getInstance().clearAll();
	}

}
