package objects.world.loot;

import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.toclean.BonusText;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public abstract class LootObject extends GameObject implements ICollisionReaction {

	protected boolean fake;
	private int time_before_lootable = 40;

	public LootObject(int x, int y, boolean fake) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y, OBJECTID.LOOT);
		this.fake = fake;
	}

	// behavior

	@Override
	public void tick() {
		time_before_lootable--;
	}

	// collision

	@Override
	public void collidingReaction(GameObject collidingObject) {

		if (!fake) {
			if (time_before_lootable <= 0) {
				if (collidingObject.isPlayer())
					collidingReaction(collidingObject, false, this, () -> {
						HandlerObject.getInstance().removeObject(this);
						HandlerObject.getInstance().addObject(new BonusText(this, displayTextOnPickup()));
						SoundTask.playSound(playSoundOnPickup());
						triggerActionOnPickup();
					});
			}
		}
	}

	protected abstract String displayTextOnPickup();

	protected abstract void triggerActionOnPickup();

	protected BufferedSound playSoundOnPickup() {
		return SoundBank.getSound(SoundBank.looting);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
