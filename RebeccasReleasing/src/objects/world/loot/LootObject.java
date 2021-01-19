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

@Todo("item to stun all ennemies"
		+ "/ les loots c'est ici ou dans une class à part que ça se gère, pas sur les ennemis")
public abstract class LootObject extends GameObject implements ICollision {

	public LootObject(int x, int y) {
		super(true, x, y, OBJECTID.LOOT);

	}

	// behavior

	@Override
	public void tick() {
	}

	// collision

	@Override
	public void collision(LivingObject living) {

		if (living.isPlayer() && !living.isMotionless())
			living.getCollisionDetector().collidingBehavior(false, this, () -> {
				HandlerObject.getInstance().removeObject(this);
				HandlerObject.getInstance().addObject(new BonusText(this, displayTextOnPickup()));
				SoundTask.playSound(playSoundOnPickup());
				triggerActionOnPickup();
			});
	}
	
	protected abstract String displayTextOnPickup();

	protected abstract void triggerActionOnPickup();
	
	protected BufferedSound playSoundOnPickup()
	{
		return SoundBank.getSound(SoundBank.looting);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
