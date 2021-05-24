package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.Facing;
import objects.Facing.DIRECTION;

public class Plant extends DestroyableObject {

	private Animation[] animation = new Animation[2];

	public Plant(int x, int y, Facing facing) {
		super(x, y, facing, OBJECTID.PLANT);

		if(facing.getDirection() == DIRECTION.UP) facing.setDirection(DIRECTION.LEFT);
		if(facing.getDirection() == DIRECTION.DOWN) facing.setDirection(DIRECTION.RIGHT);
		
		w = Size.TILE / 2;
		h = Size.TILE / 2;
	}

	// state

	@Override
	protected boolean updatableDirection() {
		return false;
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
			animation[facing] = new Animation(2, texture.destroyable_plant[facing][0],
					texture.destroyable_plant[facing][0], texture.destroyable_plant[facing][1],
					texture.destroyable_plant[facing][2], texture.destroyable_plant[facing][3],
					texture.destroyable_plant[facing][3]);
		}
		return animation[facing];
	}

	@Override
	public void render(Graphics g) {

		renderingPlant(g);
		drawLootable(g);
	}

	private void renderingPlant(Graphics g) {

		int w0 = 2 * Size.TILE;
		int h0 = Size.TILE;
		int gap = 0;

		if (facing.getDirection() == DIRECTION.LEFT)
			gap = Size.TILE;

		if (!falling)
			g.drawImage(texture.destroyable_plant[facing.getDirection().getNum()][0], x - gap, y, w0, h0, null);

		if (falling && falltime > 0)
			drawAnimation(g, x - gap, y, w0, h0, facing.getDirection().getNum());

		if (falling && falltime <= 0)
			g.drawImage(texture.destroyable_plant[facing.getDirection().getNum()][3], x - gap, y, w0, h0, null);

	}

	// collision

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x + w / 2, y + h / 2, w, h);
	}

	@Override
	protected void fall() {
		falling = true;
		falltime = 15;
	}

	@Override
	public int givePts() {
		return 1;
	}

	@Override
	public SoundBank makeMainSound() {
		return SoundBank.POT;
	}

	@Override
	public SoundBank makeSideSound() {
		return SoundBank.HIT_LITTLE;
	}

}
