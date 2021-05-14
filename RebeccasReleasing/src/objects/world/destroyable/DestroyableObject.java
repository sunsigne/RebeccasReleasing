package objects.world.destroyable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.GameObject;
import objects.IFacing;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;
import objects.world.loot.ILoot;
import objects.world.loot.LootObject;

public abstract class DestroyableObject extends GameObject implements IAnimation, IFacing, ICollision, ILoot {

	private FACING facing;

	protected boolean falling;
	protected int falltime;

	private boolean destroyable;
	private LootObject loot;

	public DestroyableObject(int x, int y, FACING facing, OBJECTID id) {
		super(true, x, y, id);

		this.facing = facing;
		this.destroyable = true;
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

	public void setDestroyable(boolean destroyable) {
		this.destroyable = destroyable;
	}

	@Override
	public LootObject getLootObject() {
		return loot;
	}

	@Override
	public void setLootObject(LootObject loot) {
		this.loot = loot;
	}

	// design

	protected void drawLootable(Graphics g) {
		if (Game.isDebugMode()) {
			if (loot != null)
				loot.render(g);
		}
	}

	// collision

	@Override
	public void collision(LivingObject living) {
		if (living.getBoundsLeft().intersects(getBounds()))
			updateDestroyable(living, FACING.LEFT);
		if (living.getBoundsRight().intersects(getBounds()))
			updateDestroyable(living, FACING.RIGHT);
		if (living.getBoundsTop().intersects(getBounds()))
			updateDestroyable(living, FACING.UP);
		if (living.getBounds().intersects(getBounds()))
			updateDestroyable(living, FACING.DOWN);
	}

	public void updateDestroyable(LivingObject living, FACING playerfacing) {

		if (destroyable) {
			if (living.isPlayer())
				refreshPlayerRendering();

			if (!falling) {
				setFacing(playerfacing);

				int points = givePts();
				BufferedSound mainSound = makeMainSound();
				BufferedSound sideSound = makeSideSound();

				if (living.isPlayer()) {
					if (HandlerObject.getInstance().getPlayer().isPushed())
						World.gui.addPoints(this, 5 * points);
					else
						World.gui.addPoints(this, points);
				} else
					World.gui.addPoints(this, 2 * points);

				SoundTask.playSound(1.0, mainSound);
				SoundTask.playSound(0.5, sideSound);

				fall();
				loot();
			}
		}
	}

	protected abstract void fall();

	public abstract int givePts();

	public abstract BufferedSound makeMainSound();

	public abstract BufferedSound makeSideSound();

}
