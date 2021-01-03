package com.sunsigne.rebeccasreleasing.game;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;

public class ScoreScreen extends Clickable {

	public ScoreScreen() {
		super(STATE.SCORE);

		AudioTask.changeMusicVol(0.2);

	}

	@Override
	public void mousePressed(int mx, int my) {
		World.world.close();
//		World.world = new WorldLvl01();
	}

	@Override
	public void mouseReleased(int mx, int my) {

	}

	@Override
	public void render(Graphics g) {
		greyRender(g);

	}


}
