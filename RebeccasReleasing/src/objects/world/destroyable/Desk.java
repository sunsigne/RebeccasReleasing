package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.Facing;
import objects.Facing.DIRECTION;

public class Desk extends DestroyableObject {

	private Animation[] animation = new Animation[4];

	public Desk(int x, int y, Facing facing) {
		super(x, y, facing, OBJECTID.DESK);

		w = 2 * Size.TILE;
		h = 2 * Size.TILE;
	}

	// state

	@Override
	protected boolean updatableDirection() {
		return true;
	}

	// behavior

	@Override
	public void tick() {
		if (falltime > 0) {
			runAnimation(facing.getDirection().getNum());
			falltime--;
		}
	}

	// design

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];
		
		if (animation[facing] == null) {
				animation[facing] = new Animation(2, texture.destroyable_desk[facing][1], texture.destroyable_desk[facing][2], texture.destroyable_desk[facing][3],
						texture.destroyable_desk[facing][4], texture.destroyable_desk[facing][5], texture.destroyable_desk[facing][5], texture.destroyable_desk[facing][5]);

		}
		return animation[facing];
	}
	
	public void render(Graphics g) {

		renderingDesk(g);
		drawLootable(g);
	}

	private void renderingDesk(Graphics g) {

		// inital rendering
		if (!falling)
			g.drawImage(texture.destroyable_desk[facing.getDirection().getNum()][0], x , y, w, h, null);
	
		// falling rendering
		if (falling && falltime > 0)
			drawAnimation(g, x , y, w, h, facing.getDirection().getNum());
		
		// final rendering
		if (falling && falltime <= 0)
		{
			g.drawImage(texture.destroyable_desk[facing.getDirection().getNum()][5], x , y, w, h, null);	
		}
	}
	
	// collision

	@Override
	public Rectangle getBounds() {
		if (facing.isHorizontal())
			return new Rectangle(x + w / 8, y + h / 16, w - w / 4, h - h / 2);
		else
			return new Rectangle(x + w / 4, y + h / 16, w - w / 2, h - h / 4);
	}

	@Override
	protected void fall() {
		falling = true;
		falltime = 20;
	}

	@Override
	public int givePts() {
		return 2;
	}

	@Override
	public BufferedSound makeMainSound() {
		return SoundBank.getSound(SoundBank.hit_defense);
	}

	@Override
	public BufferedSound makeSideSound() {
		return null;
	}

}
