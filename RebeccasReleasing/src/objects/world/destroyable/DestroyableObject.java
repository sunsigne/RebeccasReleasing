package objects.world.destroyable;

import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.AnimatedObject;
import objects.GameObject;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;
import objects.world.storing.Looting;
import tofinish.AudioBank;

public abstract class DestroyableObject extends AnimatedObject implements Looting, ICollision {

	protected DESTROYABLEID destroyableId;
	protected boolean destroyed;
	private boolean falling;

	public DestroyableObject(int x, int y, boolean facingLeft, boolean horizontal, DESTROYABLEID destroyableId,
			int animation) {
		super(x, y, facingLeft, horizontal, OBJECTID.DESTROYABLE, animation);
		this.destroyableId = destroyableId;
	}

	public abstract int givePts();

	public abstract AudioBank makeMainSound();

	public abstract AudioBank makeSideSound();

	// identity

	public void setDesstroyableID(DESTROYABLEID destroyableId) {
		this.destroyableId = destroyableId;
	}

	public DESTROYABLEID getDestroyableID() {
		return destroyableId;
	}

	// state

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public void setDestroyed(boolean empty) {
		this.destroyed = empty;
	}

	public boolean isFalling() {
		return falling;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	@Override
	public boolean isCameraDependant() {
		return true;
	}

	@Override
	public void collision(LivingObject living) {
		if (living.getBounds().intersects(getBounds()))
			updateDestroyable(living, this, false);
		if (living.getBoundsTop().intersects(getBounds()))
			updateDestroyable(living, this, false);
		if (living.getBoundsLeft().intersects(getBounds()))
			updateDestroyable(living, this, true);
		if (living.getBoundsRight().intersects(getBounds()))
			updateDestroyable(living, this, false);
	}

	public void updateDestroyable(LivingObject living, GameObject tempObject, boolean facingLeft) {

		if (living.collisionDetector.isPlayer)
			refreshPlayerRendering();

		if (!isDestroyed() && !isFalling()) {
			if (isUpdatableFacing())
				setFacingLeft(facingLeft);

			int points = givePts();
			AudioBank mainSound = makeMainSound();
			AudioBank sideSound = makeSideSound();

			if (living.collisionDetector.isPlayer) {
				if (HandlerObject.getInstance().player.isPushed())
					World.gui.addPoints(this, 8 * points);
				else
					World.gui.addPoints(this, points);
			} else
				World.gui.addPoints(this, 2 * points);

			SoundTask.playSound(1.0, mainSound);
			SoundTask.playSound(0.5, sideSound);

			setDestroyed(true);
			setFalling(true);
		}
	}

}
