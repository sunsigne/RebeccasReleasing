package objects.characters.living;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.system.Game;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

public class PlayerObject extends LivingObject {

	private Animation[] animation = new Animation[4];
	private boolean tasking;
	private boolean blinking;

	public PlayerObject(int x, int y) {
		super(x, y, OBJECTID.PLAYER);

		loadBasicState();
	}

	// state

	@Todo("Put this method in a mother class for all characters")
	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];

		if (animation[facing] == null) {
			animation[facing] = new Animation(10, texture.getLivingWalking(CharacterBank.rebecca, facing, 0),
					texture.getLivingWalking(CharacterBank.rebecca, facing, 1),
					texture.getLivingWalking(CharacterBank.rebecca, facing, 2),
					texture.getLivingWalking(CharacterBank.rebecca, facing, 1));
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

	public void blink(int invulnerabitilyTime) {
		if (invulnerabitilyTime % 4 == 0)
			blinking = false;
		else
			blinking = true;
	}

	// design

	@Override
	public void render(Graphics g) {

		if (!blinking)
			renderingRebecca(g);
		drawHitbox(g);
	}

	private void renderingRebecca(Graphics g) {
		int facing = getFacing().getNum();

		Graphics2D g2d = (Graphics2D) g;
		if (Game.isWallPassMode())
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));

		if (isMotionless())
			g.drawImage(texture.getLivingWalking(CharacterBank.rebecca, facing, 1), x, y, w, h, null);
		else
			drawAnimation(g, x, y, w, h, getFacing().getNum());

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

	}
}
