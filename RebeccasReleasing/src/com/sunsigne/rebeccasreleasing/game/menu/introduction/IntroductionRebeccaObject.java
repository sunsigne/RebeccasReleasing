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

class IntroductionRebeccaObject extends CommunIntroductionObject implements IAnimation {

	private Animation animation;
	private int jumpTime;
	private int jumpCount;

	public IntroductionRebeccaObject() {
		super();
		x = -150;
		y = initY = 520;
		w = 9 * Size.TILE_PUZZLE / 4;
		h = 9 * Size.TILE_PUZZLE / 4;
	}

	// state

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];

		if (animation == null)
			animation = new Animation(12, texture.living_rebecca_battle[facing][3],
					texture.living_rebecca_battle[facing][4], texture.living_rebecca_battle[facing][5],
					texture.living_rebecca_battle[facing][6]);
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
		case 3:
			velX = 8;
			break;
		case 4:
		case 5:
			velX = 0;
			break;
		case 6:
		case 7:
		case 8:
			checkJumping();
			if (shouldJump())
				jump();
			break;
		case 21 : 
			x = initX = 300;
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
			y = initY;
			velY = 0;
			if (jumpTime == 1)
				jumpCount++;
		}
	}

	private void jump() {
		SoundTask.playSound(0.7f, SoundBank.getSound(SoundBank.jump));
		jumpTime = 80;
	}

	// design

	@Override
	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		switch (getPhase()) {
		case 3:
		case 4:
		case 5:
			drawAnimation(g, x, y, w, h, FACING.RIGHT.getNum());
			break;
		case 6:
		case 7:
		case 8:
			if (jumpCount < 4)
				drawJumping(g, x, y);
			else
				drawAnimation(g, x, y, w, h, FACING.RIGHT.getNum());
			break;
		case 9:
		case 10:
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));
			g.drawImage(texture.living_rebecca_battle[FACING.RIGHT.getNum()][1], x, y, w, h, null);
			break;
		}
	}

	private void drawJumping(Graphics g, int x0, int y0) {
		int state = 2;
		if (y != initY)
			state = 0;
		g.drawImage(texture.living_rebecca_battle[FACING.RIGHT.getNum()][state], x0, y0, w, h, null);
	}

}