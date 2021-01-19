package com.sunsigne.rebeccasreleasing.game.puzzles.bomb.object;

import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;

public class BombReversed extends BombObject {

	private boolean winning;

	public BombReversed(int x, int y, DIFFICULTY difficulty) {
		super(x, y, difficulty);

		randomCountGeneration(false);
		setExploding(true);
		enlargeTime = new Random().nextInt(32);
	}

	// state

	@Override
	public Animation getAnimation(int array, int secondarray) {
		if (animation == null)
			animation = new Animation(2, texture.bomb[9], texture.bomb[8], texture.bomb[7], texture.bomb[6],
					texture.bomb[5], texture.bomb[4], texture.bomb[3], texture.bomb[2], texture.bomb[1],
					texture.bomb[1]);
		return animation;
	}

	public boolean isWinning() {
		return winning;
	}

	// behavior

	@Override
	public void tick() {

		if (boomtime < 30) {
			runAnimation();
			boomtime--;
		}

		if (boomtime < 0) {
			goUpandDown();
			goBigandSmall();
		}
	}

	public void addCount() {

		if (isExploding() && boomtime == 30) {
			count = 1;
			boomtime--;
			SoundTask.playSound(SoundBank.getSound(SoundBank.r_explosion_medium));
			setExploding(false);
		}

		else if (boomtime < 0) {
			if (count < totalcount) {
				count = count + 1;
				SoundTask.playSound(SoundBank.getSound(SoundBank.r_explosion_little));
			}
		}

		checkWinning();
	}

	private void checkWinning() {
		if (count == totalcount)
			winning = true;
	}

	// design

	@Override
	public void render(Graphics g) {

		paintCount(g);
		int gap = 0;
		if(getDifficulty().getLvl() > 4) gap = 16 + enlargeTime;

		if (isExploding() && boomtime == 30)
			g.drawImage(texture.bomb[9], x + 2*gap, y + 2*gap, w - 4*gap, h - 4*gap, null);
		else if (!isExploding()) {
			if (boomtime > 0)
				drawAnimation(g, x + 2*gap, y + 2*gap, w - 4*gap, h - 4*gap);
			else {
				g.drawImage(texture.bomb[0], x + 2*gap, y + 2*gap, w - 4*gap, h - 4*gap, null);
				g.drawString("" + count, x + 88 + 5*gap/8, y + 187 - 7*gap/8);
			}
		}
		drawHitbox(g);
	}
}
