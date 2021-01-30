package com.sunsigne.rebeccasreleasing.game.menu.introduction;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.IFacing.FACING;

class IntroductionRebeccaObject extends CommunIntroductionObject implements IAnimation {

	private Animation animation;
	private int jumpTime;
	private int jumpCount;

	public IntroductionRebeccaObject() {
		super();
		x = -150;
		w = 9 * Size.TILE_PUZZLE / 4;
		h = 9 * Size.TILE_PUZZLE / 4;
	}

	// state

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];

		if (animation == null)
			animation = new Animation(12, texture.living_rebecca_battle[facing][9],
					texture.living_rebecca_battle[facing][10], texture.living_rebecca_battle[facing][11],
					texture.living_rebecca_battle[facing][12]);
		return animation;
	}

	public int getJumpCount() {
		return jumpCount;
	}

	private boolean shouldJump() {
		return jumpTime <= 0 && jumpCount < 4;
	}

	// behavior

	@Override
	public void tick() {
		runAnimation(FACING.RIGHT.getNum());
		velocity();

		runPhase();
	}

	private void runPhase() {
		switch (getPhase()) {
		case 0:
		case 1:
		case 2:
			break;
		case 3:
			velX = 8;
			break;
		case 4:
		case 5:
			velX = 0;
			break;
		case 6:
		case 7:
			checkJumping();
			if (shouldJump())
				jump();
			break;
		}

	}

	private void checkJumping() {
		int speed = -4;
		if (jumpTime > 0) {
			jumpTime--;
			if (jumpTime > 50)
				velY = speed;
			else
				velY = -speed;
		}
		if (jumpTime <= 20) {
			if (jumpTime == 20)
				jumpCount++;
			y = initY;
		}
	}

	private void jump() {
		SoundTask.playSound(0.7f, SoundBank.getSound(SoundBank.jump));
		jumpTime = 80;
	}

	// design

	@Override
	public void render(Graphics g) {
		int x0 = initX + 800;
		int y0 = y + 520;

		switch (getPhase()) {
		case 0:
		case 1:
		case 2:
			break;
		case 3:
		case 4:
		case 5:
			drawAnimation(g, x, y0, w, h, FACING.RIGHT.getNum());
			break;
		case 6:
		case 7:	
			if (jumpCount < 4) drawJumping(g, x0, y0);
			else drawAnimation(g, x0, y0, w, h, FACING.RIGHT.getNum());
			break;
		}
	}

	private void drawJumping(Graphics g, int x0, int y0) {
			int state = 13;
			if (y != initY)
				state = 14;
			g.drawImage(texture.living_rebecca_battle[FACING.RIGHT.getNum()][state], x0, y0, w, h, null);
	}

}