package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.object;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundTask;

public class Bomb extends BombObject {

	public Bomb(int x, int y, DIFFICULTY difficulty) {
		super(x, y, difficulty);

		randomCountGeneration(false);
	}

	// state

	@Override
	public Animation getAnimation(int... array) {
		if (animation == null)
			animation = new Animation(2, texture.puzzle_bomb[1], texture.puzzle_bomb[2], texture.puzzle_bomb[3], texture.puzzle_bomb[4],
					texture.puzzle_bomb[5], texture.puzzle_bomb[6], texture.puzzle_bomb[7], texture.puzzle_bomb[8], texture.puzzle_bomb[9],
					texture.puzzle_bomb[9]);
		return animation;
	}

	// behavior

	@Override
	public void tick() {

		if (count == 0) {
			count--;
			setExploding(true);
			SoundTask.playSound(SoundBank.getSound(SoundBank.explosion_medium));
		}

		if (isExploding()) {
			runAnimation();
			boomtime--;
		}

		else {
			goUpandDown();
			goBigandSmall();
		}
	}

	public void removeCount() {
		if (count > 0) {
			SoundTask.playSound(SoundBank.getSound(SoundBank.explosion_little));
			count = count - 1;
		}
	}

	// design

	@Override
	public void render(Graphics g) {

		paintCount(g);
		int gap = 0;
		if(getDifficulty().getLvl() > 4) gap = 16 + enlargeTime;

		if (!isExploding()) {
			g.drawImage(texture.puzzle_bomb[0], x + 2*gap, y + 2*gap, w - 4*gap, h - 4*gap, null);
			g.drawString("" + count, x + 88 + 5*gap/8, y + 187 - 7*gap/8);

		} else if (isExploding()) {
			if (boomtime > 0)
				drawAnimation(g, x + 2*gap, y + 2*gap, w - 4*gap, h - 4*gap);
			else
				g.drawImage(texture.puzzle_bomb[9], x + 2*gap, y + 2*gap, w - 4*gap, h - 4*gap, null);
		}
	}

}
