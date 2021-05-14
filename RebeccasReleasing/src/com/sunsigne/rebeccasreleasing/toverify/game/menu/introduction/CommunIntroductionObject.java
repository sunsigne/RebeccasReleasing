package com.sunsigne.rebeccasreleasing.toverify.game.menu.introduction;

import com.sunsigne.rebeccasreleasing.toverify.game.menu.MenuObject;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundTask;

abstract class CommunIntroductionObject extends MenuObject {

	private int phase;
	private float opacity = 1f;

	int jumpTime;
	int jumpCount;

	CommunIntroductionObject() {
		super(null);
	}

	// state

	int getPhase() {
		return phase;
	}

	void setPhase(int phase) {
		this.phase = phase;
	}

	float getOpacity() {
		return opacity;
	}

	void setOpacity(float opacity) {
		this.opacity = opacity;
	}

	int getJumpCount() {
		return jumpCount;
	}

	boolean shouldJump() {
		return jumpTime <= 0 && jumpCount < getMaxJumpCount();
	}

	abstract int getMaxJumpCount();

	// behavior

	void tryJumping(int velX, int velY, BufferedSound sound, int jumpTime,  int stateFallingAtJumpTimeEgal, int stopMovingAtJumpTimeEgal,
			boolean heightBeforeEgalHeightAfter) {
		calculJumping(velX, velY, stateFallingAtJumpTimeEgal, stopMovingAtJumpTimeEgal, heightBeforeEgalHeightAfter);
		if (shouldJump())
		{
			this.jumpTime = jumpTime;
			SoundTask.playSound(0.4f, sound);			
		}
	}

	void calculJumping(int velX, int velY, int stateFallingAtJumpTimeEgal, int stopMovingAtJumpTimeEgal,
			boolean heightBeforeEgalHeightAfter) {
		if (jumpTime > 0) {
			jumpTime--;
			this.velX = velX;
			if (jumpTime > stateFallingAtJumpTimeEgal)
				this.velY = velY;
			else
				this.velY = -velY;
		}
		if (jumpTime <= stopMovingAtJumpTimeEgal) {
			if (heightBeforeEgalHeightAfter)
				y = initY;
			setMotionless();
			if (jumpTime == 1)
				jumpCount++;
		}
	}

}
