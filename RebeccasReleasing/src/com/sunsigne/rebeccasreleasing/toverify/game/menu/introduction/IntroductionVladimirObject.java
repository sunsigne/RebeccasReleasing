package com.sunsigne.rebeccasreleasing.toverify.game.menu.introduction;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

import objects.IFacing.FACING;

class IntroductionVladimirObject extends CommunIntroductionObject implements IAnimation {

	private Animation[][] animation = new Animation[2][2]; // - facing - mood

	IntroductionVladimirObject() {
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

		if (animation[facing][mood] == null)
			animation[facing][mood] = new Animation(12, texture.getLivingBattle(CharacterBank.vladimir, facing, 6 + 3 * mood),
					texture.getLivingBattle(CharacterBank.vladimir, facing, 7 + 3 * mood),
					texture.getLivingBattle(CharacterBank.vladimir, facing, 8 + 3 * mood),
					texture.getLivingBattle(CharacterBank.vladimir, facing, 7 + 3 * mood));
		return animation[facing][mood];
	}

	private enum MOOD {
		UNHAPPY(0), ANGRY(1);

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
		return 2;
	}
	
	// behavior

	@Override
	public void tick() {
		runAnimations();
		velocity();

		runPhase();
	}

	private void runAnimations() {
		runAnimation(FACING.LEFT.getNum(), MOOD.UNHAPPY.getNum());
		runAnimation(FACING.LEFT.getNum(), MOOD.ANGRY.getNum());
		runAnimation(FACING.RIGHT.getNum(), MOOD.UNHAPPY.getNum());
		runAnimation(FACING.RIGHT.getNum(), MOOD.ANGRY.getNum());
	}

	private void runPhase() {
		switch (getPhase()) {
		case 17:
			tryJumping(0, -8, SoundBank.getSound(SoundBank.jump), 25, 15, 5, true);
			break;
		case 19:
		case 20:
			velX = -10;
			break;
		case 21:
			x = initX = 1150;
			velX = 0;
			break;
		case 25:
			velX = -35;
			break;
		case 26:
			velX = 35;
			break;
		case 27:
			velX = 0;
			x = initX;
			break;
		case 30:
			velX = 15;
			break;			
		}

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
			drawAnimation(g, x, y, w, h, FACING.LEFT.getNum(), MOOD.ANGRY.getNum());
			break;
		case 17:
		case 18:
		case 19:
		case 20:
			if (jumpCount < 2)
				g.drawImage(texture.getLivingBattle(CharacterBank.vladimir, FACING.LEFT.getNum(), 12), x, y, w, h, null);
			else {
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));
				drawAnimation(g, x, y, w, h, FACING.LEFT.getNum(), MOOD.ANGRY.getNum());
			}
			break;
		case 22:
		case 23:
		case 24:
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));
			drawAnimation(g, x, y, w, h, FACING.LEFT.getNum(), MOOD.ANGRY.getNum());
			break;
		case 25:
		case 26:
			g.drawImage(texture.getLivingBattle(CharacterBank.vladimir, FACING.LEFT.getNum(), 13), x, y, w, h, null);
			break;
		case 27:
		case 28:
		case 29:
			drawAnimation(g, x, y, w, h, FACING.LEFT.getNum(), MOOD.ANGRY.getNum());
			break;
		case 30: drawAnimation(g, x, y, w, h, FACING.RIGHT.getNum(), MOOD.ANGRY.getNum());
			break;
			
		}
	}

}