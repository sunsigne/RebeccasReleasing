package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;

public class Plant extends DestroyableObject {

	private Animation[] animation = new Animation[4];

	public Plant(int x, int y, FACING facing) {
		super(x, y, facing);

		if(facing == FACING.UP) facing = FACING.LEFT;
		if(facing == FACING.DOWN) facing = FACING.RIGHT;
		
		w = Size.TILE / 2;
		h = Size.TILE / 2;
	}

	// state

	@Override
	protected boolean updatableFacing() {
		return false;
	}

	// behavior

	@Override
	public void tick() {
		if (falltime > 0) {
			runAnimation(getFacing().getNum());
			falltime--;
		}
	}

	// design

	@Override
	public Animation getAnimation(int array, int secondarray) {

		if (animation[array] == null) {
			animation[array] = new Animation(2, texture.destroyable_plant[array][0],
					texture.destroyable_plant[array][0], texture.destroyable_plant[array][1],
					texture.destroyable_plant[array][2], texture.destroyable_plant[array][3],
					texture.destroyable_plant[array][3]);
		}
		return animation[array];
	}

	@Override
	public void render(Graphics g) {

		renderingPlant(g);
		drawHitbox(g);
	}

	private void renderingPlant(Graphics g) {

		int w0 = 2 * Size.TILE;
		int h0 = Size.TILE;
		int gap = 0;

		if (getFacing() == FACING.LEFT)
			gap = Size.TILE;

		if (!falling)
			g.drawImage(texture.destroyable_plant[getFacing().getNum()][0], x - gap, y, w0, h0, null);

		if (falling && falltime > 0)
			drawAnimation(getFacing().getNum(), g, x - gap, y, w0, h0);

		if (falling && falltime <= 0)
			g.drawImage(texture.destroyable_plant[getFacing().getNum()][3], x - gap, y, w0, h0, null);

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
	public BufferedSound makeMainSound() {
		return SoundBank.getSound(SoundBank.poterie);
	}

	@Override
	public BufferedSound makeSideSound() {
		return SoundBank.getSound(SoundBank.hit_defense);
	}

}
