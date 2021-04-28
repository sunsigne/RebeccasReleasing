package objects.world.loot;

import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.BonusText;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

@Todo("item to stun all ennemies ?"
		+ "/ les loots c'est ici ou dans une class � part que �a se g�re, pas sur les ennemis")
public abstract class LootObject extends GameObject implements ICollision {

	protected boolean fake;
	private int time_before_lootable = 40;

	public LootObject(int x, int y, boolean fake) {
		super(true, x, y, OBJECTID.LOOT);
		this.fake = fake;
	}

	// behavior

	@Override
	public void tick() {
		time_before_lootable--;
	}

	// collision

	@Override
	public void collision(LivingObject living) {

		if (!fake) {
			if (time_before_lootable <= 0) {
				if (living.isPlayer())
					living.getCollisionDetector().collidingBehavior(false, this, () -> {
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
