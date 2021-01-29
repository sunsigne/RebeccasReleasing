package com.sunsigne.rebeccasreleasing.game.menu.introduction;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class Introduction extends Clickable {

	public Introduction() {
		super(STATE.INTRODUCTION);

//		SoundTask.playMusic(0.5, SoundBank.getSound(SoundBank.soundtrack_3));
//		HandlerObject.getInstance().addObject(new IntroductionObject());

	}

	@Override
	public void mousePressed(int mx, int my) {

	}

	@Override
	public void mouseReleased(int mx, int my) {

	}

	@Override
	public void render(Graphics g) {
	}

	@Override
	public void close() {
		Conductor.closeIntroduction();
	}

}
