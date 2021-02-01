package com.sunsigne.rebeccasreleasing.game.menu.introduction;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.IFacing.FACING;

class IntroductionVladimirObject extends CommunIntroductionObject implements IAnimation {

	private Animation[] animation = new Animation[3]; // - mood
	private int jumpTime;
	private int jumpCount;

	public IntroductionVladimirObject() {
		super();

		setOpacity(0f);
		
		x = initX = 800;
		y = initY = 520;
		w = 9 * Size.TILE_PUZZLE / 4;
		h = 9 * Size.TILE_PUZZLE / 4;
	}

	// state

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];
		int mood = array[1];

		if (animation[mood] == null)
			animation[mood] = new Animation(12, texture.living_vladimir_battle[facing][3 + 4 * mood],
					texture.living_vladimir_battle[facing][4 + 4 * mood],
					texture.living_vladimir_battle[facing][5 + 4 * mood],
					texture.living_vladimir_battle[facing][6 + 4 * mood]);
		return animation[mood];
	}

	private enum MOOD {
		HAPPY(0), UNHAPPY(1), ANGRY(2);

		private int num;

		MOOD(int num) {
			this.num = num;
		}

		public int getNum() {
			return num;
		}
	}

	public int getJumpCount() {
		return jumpCount;
	}

	private boolean shouldJump() {
		return jumpTime <= 0 && jumpCount < 2;
	}

	// behavior

	@Override
	public void tick() {
		runAnimations();
		velocity();

		runPhase();
	}

	private void runAnimations() {
		runAnimation(FACING.LEFT.getNum(), MOOD.HAPPY.getNum());
		runAnimation(FACING.LEFT.getNum(), MOOD.UNHAPPY.getNum());
		runAnimation(FACING.LEFT.getNum(), MOOD.ANGRY.getNum());
	}

	private void runPhase() {
		switch (getPhase()) {
		case 17:
			checkJumping();
			if (shouldJump())
				jump();
			break;
		case 19 : 
		case 20 : velX = -16;
			break;
		case 21 : 
			x = initX = 600;
			velX = 0;
			break;
		}

	}

	private void checkJumping() {
		int speed = -8;
		if (jumpTime > 0) {
			jumpTime--;
			if (jumpTime > 20)
				velY = speed;
			else
				velY = -speed;
		}
		if (jumpTime <= 10) {
			y = initY;
			velY = 0;
			if (jumpTime == 1)
				jumpCount++;
		}
	}

	private void jump() {
		SoundTask.playSound(0.7f, SoundBank.getSound(SoundBank.jump));
		jumpTime = 30;
	}

	// design

	@Override
	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;


		switch (getPhase()) {
		case 12:
		case 13:
		case 14:
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));
			drawAnimation(g, x, y, w, h, FACING.LEFT.getNum(), MOOD.UNHAPPY.getNum());
			break;
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));
			drawAnimation(g, x, y, w, h, FACING.LEFT.getNum(), MOOD.ANGRY.getNum());
			break;
		}
	}

}