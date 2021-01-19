package objects.characters.living;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.IFacing.FACING;

public class PlayerObject extends LivingObject {

	private Animation[] animation = new Animation[4];
	private boolean tasking;

	public PlayerObject(int x, int y) {
		super(x, y, OBJECTID.PLAYER);

		loadBasicState();
	}

	// state

	@Override
	public Animation getAnimation(int array, int secondarray) {

		if (animation[array] == null) {
			if (array == FACING.LEFT.getNum())
				animation[array] = new Animation(10, texture.rebecca_walking[6], texture.rebecca_walking[7],
						texture.rebecca_walking[8], texture.rebecca_walking[7]);
			else if (array == FACING.RIGHT.getNum())
				animation[array] = new Animation(10, texture.rebecca_walking[9], texture.rebecca_walking[10],
						texture.rebecca_walking[11], texture.rebecca_walking[10]);
			else if (array == FACING.UP.getNum())
				animation[array] = new Animation(10, texture.rebecca_walking[0], texture.rebecca_walking[1],
						texture.rebecca_walking[2], texture.rebecca_walking[1]);
			else if (array == FACING.DOWN.getNum())
				animation[array] = new Animation(10, texture.rebecca_walking[3], texture.rebecca_walking[4],
						texture.rebecca_walking[5], texture.rebecca_walking[4]);

			else
				animation[array] = new Animation(1);
		}

		return animation[array];
	}

	public boolean isTasking() {
		return tasking;
	}

	public void setTasking(boolean tasking) {
		this.tasking = tasking;
	}

	// behavior

	@Override
	public void tick() {
		runFourDirectionAnimations();
		livingTickBehavior(true);
	}

	public void loadBasicState() {
		setTasking(false);
		setMotionless();
	}

	// design

	@Override
	public void render(Graphics g) {

		renderingRebecca(g);
		drawHitbox(g);
	}

	private void renderingRebecca(Graphics g) {

		if (isMotionless()) {
			if (watching[FACING.LEFT.getNum()])
				g.drawImage(texture.rebecca_walking[7], x, y, w, h, null);
			if (watching[FACING.RIGHT.getNum()])
				g.drawImage(texture.rebecca_walking[10], x, y, w, h, null);
			if (watching[FACING.UP.getNum()])
				g.drawImage(texture.rebecca_walking[1], x, y, w, h, null);
			if (watching[FACING.DOWN.getNum()])
				g.drawImage(texture.rebecca_walking[4], x, y, w, h, null);
		}

		else {
			if (watching[FACING.LEFT.getNum()])
				drawAnimation(FACING.LEFT.getNum(), g, x, y, w, h);
			if (watching[FACING.RIGHT.getNum()])
				drawAnimation(FACING.RIGHT.getNum(), g, x, y, w, h);
			if (watching[FACING.UP.getNum()])
				drawAnimation(FACING.UP.getNum(), g, x, y, w, h);
			if (watching[FACING.DOWN.getNum()])
				drawAnimation(FACING.DOWN.getNum(), g, x, y, w, h);
		}
	}

}
