package objects.characters.living;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.toverify.Todo;
import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.GameObject;
import objects.world.IInteraction;
import objects.world.Stairs;

public class PlayerObject extends LivingObject {

	public static final int SPEED = Size.TILE / 9;

	private Animation[] animation = new Animation[4];
	private boolean tasking;
	private boolean blinking;

	private IInteraction interaction;

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

	public IInteraction getInteraction() {
		return interaction;
	}

	public void setInteraction(IInteraction interaction) {
		this.interaction = interaction;
	}

	// behavior

	@Override
	public void tick() {
		runAnimation(getFacing().getNum());
		livingTickBehavior(true);
		checkInteractionProximity();
	}

	private void checkInteractionProximity() {
		if (getInteraction() != null) {
			float distance = (float) Math.sqrt(Math.pow(getX() - ((GameObject) interaction).getX(), 2)
					+ Math.pow(getY() - ((GameObject) interaction).getY(), 2));
			if (distance > Size.TILE)
				setInteraction(null);
		}

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
