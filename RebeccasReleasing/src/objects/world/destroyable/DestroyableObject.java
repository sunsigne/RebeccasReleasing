package objects.world.destroyable;

import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.IFacing;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public abstract class DestroyableObject extends GameObject implements ICollision, IAnimation, IFacing {

	protected Animation animation;
	private FACING facing;

	private boolean falling;

	public DestroyableObject(int x, int y, FACING facing) {
		super(true, x, y, OBJECTID.DESTROYABLE);

		this.facing = facing;
	}

	@Override
	public FACING getFacing() {
		return facing;
	}

	@Override
	public void setFacing(FACING facing) {
		boolean horizontaleToHorizontale = isHorizontal() && isHorizontal(facing);
		boolean verticalToVertical = !isHorizontal() && !isHorizontal(facing);

		if (updatableFacing()) {
			if (horizontaleToHorizontale || verticalToVertical)
				this.facing = facing;
		}
	}

	protected abstract boolean updatableFacing();

	public abstract int givePts();

	public abstract BufferedSound makeMainSound();

	public abstract BufferedSound makeSideSound();


	// state

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isFalling() {
		return falling;
	}


	@Override
	public void collision(LivingObject living) {
		if (living.getBoundsTop().intersects(getBounds()))
			updateDestroyable(living, this, FACING.UP);
		if (living.getBounds().intersects(getBounds()))
			updateDestroyable(living, this, FACING.DOWN);
		if (living.getBoundsLeft().intersects(getBounds()))
			updateDestroyable(living, this, FACING.LEFT);
		if (living.getBoundsRight().intersects(getBounds()))
			updateDestroyable(living, this, FACING.RIGHT);
	}

	public void updateDestroyable(LivingObject living, GameObject tempObject, FACING playerfacing) {

		if (living.collisionDetector.isPlayer)
			refreshPlayerRendering();

		if (!isFalling()) {
			setFacing(playerfacing);

			int points = givePts();
			BufferedSound mainSound = makeMainSound();
			BufferedSound sideSound = makeSideSound();

			if (living.collisionDetector.isPlayer) {
				if (HandlerObject.getInstance().player.isPushed())
					World.gui.addPoints(this, 5 * points);
				else
					World.gui.addPoints(this, points);
			} else
				World.gui.addPoints(this, 2 * points);

			SoundTask.playSound(1.0, mainSound);
			SoundTask.playSound(0.5, sideSound);

			setFalling(true);
		}
	}

}
