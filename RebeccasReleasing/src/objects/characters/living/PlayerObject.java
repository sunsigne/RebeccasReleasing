package objects.characters.living;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class PlayerObject extends LivingObject {

	private Animation[] animation = new Animation[4];
	private boolean tasking;

	public PlayerObject(int x, int y) {
		super(x, y, OBJECTID.PLAYER);

		loadBasicState();
	}

	// state

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];

		if (animation[facing] == null) {
			animation[facing] = new Animation(10, texture.living_rebecca_walking[facing][0],
					texture.living_rebecca_walking[facing][1], texture.living_rebecca_walking[facing][2],
					texture.living_rebecca_walking[facing][3]);
		}

		return animation[facing];
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
		runAnimation(getFacing().getNum());
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
		int facing = getFacing().getNum();
		
		if (isMotionless())
			g.drawImage(texture.living_rebecca_walking[facing][0], x, y, w, h, null);
		else
			drawAnimation(g, x, y, w, h, getFacing().getNum());

	}

}
