package objects.characters.living;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.main.Size;

import objects.OBJECTID;
import objects.characters.collision.CollisionDetector;

public class PlayerObject extends LivingObject {

	private boolean tasking;

	public PlayerObject(int x, int y) {
		super(x, y, OBJECTID.PLAYER, PLAYER);

		collisionDetector = new CollisionDetector(true, this);
		loadBasicState();
	}

	public void setTasking(boolean tasking) {
		this.tasking = tasking;
	}

	public boolean isTasking() {
		return tasking;
	}

	@Override
	public void tick() {
		if(!isPushed) updateWatchingDirection();
		runAnimations();
		if (isPlayerActive())
		{
			velocity();
			pushTimer();
		}
		collisionDetector.update();
	}

	private void pushTimer() {
		if (isPushed && pushTime > 0)
			pushTime --;
		else if (isPushed)
		{
			isPushed = false;
			pushTime = 10;
			setMotionless();
		}
		
	}

	private void runAnimations() {
		getAnimation(Size.DIRECTION_UP).runAnimation();
		getAnimation(Size.DIRECTION_DOWN).runAnimation();
		getAnimation(Size.DIRECTION_LEFT).runAnimation();
		getAnimation(Size.DIRECTION_RIGHT).runAnimation();
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
				getAnimation(Size.DIRECTION_UP).drawAnimation(g, x, y, w, h);
			if (watching[Size.DIRECTION_DOWN])
				getAnimation(Size.DIRECTION_DOWN).drawAnimation(g, x, y, w, h);
			if (watching[Size.DIRECTION_LEFT])
				getAnimation(Size.DIRECTION_LEFT).drawAnimation(g, x, y, w, h);
			if (watching[Size.DIRECTION_RIGHT])
				getAnimation(Size.DIRECTION_RIGHT).drawAnimation(g, x, y, w, h);
		}

	}

	public void loadBasicState() {
		setTasking(false);
		setMotionless();
	}


}
