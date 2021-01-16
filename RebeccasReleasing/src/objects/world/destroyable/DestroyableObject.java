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

public abstract class DestroyableObject extends GameObject implements IAnimation, IFacing, ICollision {

	private FACING facing;

	protected boolean falling;
	protected int falltime;

	public DestroyableObject(int x, int y, FACING facing) {
		super(true, x, y, OBJECTID.DESTROYABLE);

		this.facing = facing;
	}
	
	// state

	protected abstract boolean updatableFacing();

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

	// collision

	@Override
	public void collision(LivingObject living) {
		if (living.getBoundsTop().intersects(getBounds()))
			updateDestroyable(living, FACING.UP);
		if (living.getBounds().intersects(getBounds()))
			updateDestroyable(living, FACING.DOWN);
		if (living.getBoundsLeft().intersects(getBounds()))
			updateDestroyable(living, FACING.LEFT);
		if (living.getBoundsRight().intersects(getBounds()))
			updateDestroyable(living, FACING.RIGHT);
	}

	public void updateDestroyable(LivingObject living, FACING playerfacing) {

		if (living.collisionDetector.isPlayer)
			refreshPlayerRendering();

		if (!falling) {
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

			fall();
		}
	}

	protected abstract void fall();

	public abstract int givePts();

	public abstract BufferedSound makeMainSound();

	public abstract BufferedSound makeSideSound();

}
