package com.sunsigne.rebeccasreleasing.game.menu.introduction;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.util.Size;

class IntroductionHelmetObject extends CommunIntroductionObject {

	private boolean visible;

	IntroductionHelmetObject() {
		super();
		x = 1030;
		y = 610;
		w = Size.TILE_PUZZLE / 2;
		h = Size.TILE_PUZZLE / 2;
	}

	// state

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	int getMaxJumpCount() {
		return 1;
	}

	// behavior

	@Override
	public void tick() {
		velocity();

		runPhase();
	}

	private void runPhase() {
		switch (getPhase()) {
		case 9:
			setVisible(true);
			break;
		case 11:
			setVisible(false);
			break;
		case 21:
			x = initX = 730;
			break;
		case 22:
			setVisible(true);
			break;
		case 26:
		case 27:
		case 28:
			tryJumping(6, -6, SoundBank.getSound(SoundBank.hit_critical), 80, 50, 5, false);
			break;
		case 29:
			setVisible(false);
			break;
		}

	}

	// design

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		if (visible) {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));
			g.drawImage(ImageBank.getImage(ImageBank.helmet_of_releasing), x, y, w, h, null);
		}
	}

}