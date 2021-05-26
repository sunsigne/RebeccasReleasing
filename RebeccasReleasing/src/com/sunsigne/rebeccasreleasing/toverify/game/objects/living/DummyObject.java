package com.sunsigne.rebeccasreleasing.toverify.game.objects.living;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;

public class DummyObject extends LivingObject {

	private Animation[] animation = new Animation[4];
	private BufferedImage[][] dummy_walking = new BufferedImage[4][4]; // - facing - state

	public DummyObject(int x, int y, boolean female, int num) {
		super(x, y);

		getDummy(female, num);
	}

	// state

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];

		if (animation[facing] == null) {
			animation[facing] = new Animation(10, dummy_walking[facing][0], dummy_walking[facing][1],
					dummy_walking[facing][2], dummy_walking[facing][3]);
		}

		return animation[facing];
	}

	private void getDummy(boolean female, int num) {

		if (female) {
//			if(num == 1) dummy_walking = texture.living_dummy_female01_walking;
//			if(num == 2) dummy_walking = texture.living_dummy_female02_walking;
		}

		else {
//			if(num == 1) dummy_walking = texture.living_dummy_male01_walking;
//			if(num == 2) dummy_walking = texture.living_dummy_male02_walking;
		}

	}

	// behavior

	@Override
	public void tick() {
		runAnimation(getFacing().getNum());
		livingTickBehavior(true);
	}

	// design

	@Override
	public void render(Graphics g) {

		renderingDummy(g);
	}

	private void renderingDummy(Graphics g) {
		int facing = getFacing().getNum();

		if (isMotionless())
			g.drawImage(dummy_walking[facing][1], x, y, w, h, null);
		else
			drawAnimation(g, x, y, w, h, getFacing().getNum());

	}


}
