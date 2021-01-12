package objects.characters.living;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;

import objects.OBJECTID;
import objects.characters.collision.CollisionDetector;

public class PlayerObject extends LivingObject {

	private Animation[] animation = new Animation[4];
	private boolean tasking;

	public PlayerObject(int x, int y) {
		super(x, y, OBJECTID.PLAYER);

		collisionDetector = new CollisionDetector(true, this);
		loadBasicState();
	}

	@Override
	public Animation getAnimation(int array, int secondarray) {

		if (animation[array] == null) {
			if (array == Size.DIRECTION_UP)
				animation[array] = new Animation(10, texture.rebecca_walking[0], texture.rebecca_walking[1],
						texture.rebecca_walking[2], texture.rebecca_walking[1]);
			else if (array == Size.DIRECTION_DOWN)
				animation[array] = new Animation(10, texture.rebecca_walking[3], texture.rebecca_walking[4],
						texture.rebecca_walking[5], texture.rebecca_walking[4]);
			else if (array == Size.DIRECTION_LEFT)
				animation[array] = new Animation(10, texture.rebecca_walking[6], texture.rebecca_walking[7],
						texture.rebecca_walking[8], texture.rebecca_walking[7]);
			else if (array == Size.DIRECTION_RIGHT)
				animation[array] = new Animation(10, texture.rebecca_walking[9], texture.rebecca_walking[10],
						texture.rebecca_walking[11], texture.rebecca_walking[10]);
			else
				animation[array] = new Animation(1);
		}

		return animation[array];
	}

	public void setTasking(boolean tasking) {
		this.tasking = tasking;
	}

	public boolean isTasking() {
		return tasking;
	}

	@Override
	public void tick() {
		if (!isPushed)
			updateWatchingDirection();

		runAnimations();
		
		if (isPlayerActive()) {
			velocity();
			pushTimer();
		}
		collisionDetector.update();
	}

	private void pushTimer() {
		if (isPushed && pushTime > 0)
			pushTime--;
		else if (isPushed) {
			isPushed = false;
			pushTime = 10;
			setMotionless();
		}

	}

	private void runAnimations() {
		runAnimation(Size.DIRECTION_UP);
		runAnimation(Size.DIRECTION_DOWN);
		runAnimation(Size.DIRECTION_LEFT);
		runAnimation(Size.DIRECTION_RIGHT);
	}

	@Override
	public void render(Graphics g) {

		renderingRebecca(g);
		drawHitbox(g);
	}

	private void renderingRebecca(Graphics g) {

		if (isMotionless()) {
			if (watching[Size.DIRECTION_UP])
				g.drawImage(texture.rebecca_walking[1], x, y, w, h, null);
			if (watching[Size.DIRECTION_DOWN])
				g.drawImage(texture.rebecca_walking[4], x, y, w, h, null);
			if (watching[Size.DIRECTION_LEFT])
				g.drawImage(texture.rebecca_walking[7], x, y, w, h, null);
			if (watching[Size.DIRECTION_RIGHT])
				g.drawImage(texture.rebecca_walking[10], x, y, w, h, null);
		}

		else {
			if (watching[Size.DIRECTION_UP])
				drawAnimation(Size.DIRECTION_UP, g, x, y, w, h);
			if (watching[Size.DIRECTION_DOWN])
				drawAnimation(Size.DIRECTION_DOWN, g, x, y, w, h);
			if (watching[Size.DIRECTION_LEFT])
				drawAnimation(Size.DIRECTION_LEFT, g, x, y, w, h);
			if (watching[Size.DIRECTION_RIGHT])
				drawAnimation(Size.DIRECTION_RIGHT, g, x, y, w, h);
		}

	}

	public void loadBasicState() {
		setTasking(false);
		setMotionless();
	}

}
