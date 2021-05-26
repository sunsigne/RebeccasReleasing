package com.sunsigne.rebeccasreleasing.toverify.game.objects.world.destroyable;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.living.LivingObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.loot.ILoot;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.loot.LootObject;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;

public abstract class DestroyableObject extends GameObject implements IAnimation, ICollisionReaction, ILoot {

	protected Facing facing;

	protected boolean falling;
	protected int falltime;

	private boolean destroyable;
	private LootObject loot;

	public DestroyableObject(int x, int y, Facing facing) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y);

		this.facing = facing;
		this.destroyable = true;
	}

	// state

	protected abstract boolean updatableDirection();

	private void setDirection(DIRECTION playerfacing) {
		if (updatableDirection()) {
			boolean horizontaleToHorizontale = facing.isHorizontal() && Facing.isHorizontal(playerfacing);
			boolean verticalToVertical = !facing.isHorizontal() && !Facing.isHorizontal(playerfacing);

			if (horizontaleToHorizontale || verticalToVertical)
				this.facing.setDirection(playerfacing);
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
		if (Conductor.getDebugMode().getHitboxMode().getState()) {
			if (loot != null)
				loot.render(g);
		}
	}

	// collision

	@Override
	public void collidingReaction(GameObject collidingObject) {

		if (collidingObject instanceof LivingObject) {

			if (((LivingObject) collidingObject).getBoundsLeft().intersects(getBounds()))
				updateDestroyable(collidingObject, DIRECTION.LEFT);
			if (((LivingObject) collidingObject).getBoundsRight().intersects(getBounds()))
				updateDestroyable(collidingObject, DIRECTION.RIGHT);
			if (((LivingObject) collidingObject).getBoundsTop().intersects(getBounds()))
				updateDestroyable(collidingObject, DIRECTION.UP);
			if (((LivingObject) collidingObject).getBounds().intersects(getBounds()))
				updateDestroyable(collidingObject, DIRECTION.DOWN);
		}
	}

	public void updateDestroyable(GameObject collidingObject, DIRECTION playerfacing) {

		if (destroyable) {
			if (collidingObject.isPlayer())
				refreshPlayerRendering();

			if (!falling) {
				setDirection(playerfacing);

				int points = givePts();
				SoundBank mainSound = makeMainSound();
				SoundBank sideSound = makeSideSound();

				if (collidingObject.isPlayer()) {
					if (HandlerObject.getInstance().getPlayer().isPushed())
						World.gui.addPoints(this, 5 * points);
					else
						World.gui.addPoints(this, points);
				} else
					World.gui.addPoints(this, 2 * points);

				new SoundTask().playSound(1.0, mainSound);
				new SoundTask().playSound(0.5, sideSound);

				fall();
				loot();
			}
		}
	}

	public void refreshPlayerRendering() {
		if (facing.isHorizontal()) {
			if (HandlerObject.getInstance().getPlayer().getY() < y + h / 4)
				HandlerRender.getInstance().setPlayerRenderingRefreshed(false);
		}
	}

	protected abstract void fall();

	public abstract int givePts();

	public abstract SoundBank makeMainSound();

	public abstract SoundBank makeSideSound();

}
