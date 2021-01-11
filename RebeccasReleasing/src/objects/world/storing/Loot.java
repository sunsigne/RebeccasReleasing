package objects.world.storing;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.stream.Collector.Characteristics;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.displayer.BonusText;
import objects.characters.displayer.Tool;
import objects.characters.living.LivingObject;

@Todo("item to stun all ennemies" + "/ les loots c'est ici ou dans une class à part que ça se gère, pas sur les ennemis" )
public class Loot extends GameObject implements ICollision {

	protected LOOTID lootId;

	public Loot(int x, int y, LOOTID lootId) {
		super(x, y, OBJECTID.LOOT);

		this.lootId = lootId;
	}

	// identity

	public void setLootID(LOOTID lootId) {
		this.lootId = lootId;
	}

	public LOOTID getLootID() {
		return lootId;
	}

	@Override
	public boolean isCameraDependant() {
		return true;
	}
	
	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		if (lootId == LOOTID.CRITCARD) {
			g.drawImage(ImageBank.card_frame, x, y, Size.TILE * 2 / 3, Size.TILE, null);
			g.drawImage(ImageBank.card_critical, x, y, Size.TILE * 2 / 3, Size.TILE, null);
		}
		if(lootId == LOOTID.KEY)
			g.drawImage(texture.item[0], x, y, w, h, null);
		drawHitbox(g);
	}
	
	@Override
	public void collision(LivingObject living) {
		
		if (living.collisionDetector.isPlayer && !living.isMotionless())
			living.collisionDetector.collidingBehavior(false, this, () -> update());
	}

	
	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, Size.TILE, Size.TILE);
	}

	private void update() {

		HandlerObject.getInstance().removeObject(this);
		
		switch (lootId) {
		case CRITCARD:
			doActionCritCard();
			break;
		case KEY:
			World.gui.getCharacteristics().getTool(Tool.KEY).upgradeTool();
			break;
		default:
			break;
		}
	}

	private void doActionCritCard() {

		HandlerObject.getInstance().addObject(new BonusText(this, "100% crit"));
		AudioTask.playSound(AudioBank.looting);
		World.gui.getCharacteristics().setSureCrit(true);
	}
}
