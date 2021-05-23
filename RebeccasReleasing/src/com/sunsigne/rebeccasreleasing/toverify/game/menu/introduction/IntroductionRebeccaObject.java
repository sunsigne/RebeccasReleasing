package com.sunsigne.rebeccasreleasing.toverify.game.menu.introduction;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

import objects.Facing.DIRECTION;

class IntroductionRebeccaObject extends CommunIntroductionObject implements IAnimation {

	private Animation[][] animation = new Animation[2][2]; // - facing - mood

	IntroductionRebeccaObject() {
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
		int mood = array[1];

		if (animation[facing][mood] == null)
			animation[facing][mood] = new Animation(12,
					texture.getLivingBattle(CharacterBank.rebecca, facing, 3 + 3 * mood),
					texture.getLivingBattle(CharacterBank.rebecca, facing, 4 + 3 * mood),
					texture.getLivingBattle(CharacterBank.rebecca, facing, 5 + 3 * mood),
					texture.getLivingBattle(CharacterBank.rebecca, facing, 4 + 3 * mood));
		return animation[facing][mood];
	}

	private enum MOOD {
		HAPPY(0), UNHAPPY(1);

		private int num;

		MOOD(int num) {
			this.num = num;
		}

		public int getNum() {
			return num;
		}
	}

	@Override
	int getMaxJumpCount() {
		return 4;
	}

	// behavior

	@Override
	public void tick() {
		runAnimations();
		velocity();

		runPhase();
	}

	private void runAnimations() {
		runAnimation(DIRECTION.LEFT.getNum(), MOOD.HAPPY.getNum());
		runAnimation(DIRECTION.LEFT.getNum(), MOOD.UNHAPPY.getNum());
		runAnimation(DIRECTION.RIGHT.getNum(), MOOD.HAPPY.getNum());
		runAnimation(DIRECTION.RIGHT.getNum(), MOOD.UNHAPPY.getNum());
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
			tryJumping(0, -4, SoundBank.jump, 80, 50, 20, true);
			break;
		case 21:
			x = initX = 500;
			break;
		case 31:
			tryJumping(0, -8, SoundBank.jump, 25, 15, 5, true);
			break;
		case 32:
		case 33:
			velX = 10;
			break;
		}

	}

	// design

	@Override
	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		switch (getPhase()) {
		case 3:
		case 4:
		case 5:
			drawAnimation(g, x, y, w, h, DIRECTION.RIGHT.getNum(), MOOD.HAPPY.getNum());
			break;
		case 6:
		case 7:
		case 8:
			if (jumpCount < 4)
				drawJumping(g, x, y);
			else
				drawAnimation(g, x, y, w, h, DIRECTION.RIGHT.getNum(), MOOD.HAPPY.getNum());
			break;
		case 9:
		case 10:
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));
			g.drawImage(texture.getLivingBattle(CharacterBank.rebecca, DIRECTION.RIGHT.getNum(), 1), x, y, w, h, null);
			break;
		case 22:
		case 23:
		case 24:
		case 25:
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));
			g.drawImage(texture.getLivingBattle(CharacterBank.rebecca, DIRECTION.RIGHT.getNum(), 1), x, y, w, h, null);
			break;
		case 26:
		case 27:
		case 28:
		case 29:
		case 30:
			g.drawImage(texture.getLivingBattle(CharacterBank.rebecca, DIRECTION.RIGHT.getNum(), 17), x, y, w, h, null);
			break;
		case 31:
			drawAnimation(g, x, y, w, h, DIRECTION.RIGHT.getNum(), MOOD.UNHAPPY.getNum());
			break;
		case 32:
			drawAnimation(g, x, y, w, h, DIRECTION.RIGHT.getNum(), MOOD.HAPPY.getNum());
			break;
		}
	}

	private void drawJumping(Graphics g, int x0, int y0) {
		int state = 2;
		if (y != initY)
			state = 0;
		g.drawImage(texture.getLivingBattle(CharacterBank.rebecca, DIRECTION.RIGHT.getNum(), state), x0, y0, w, h, null);
	}

}