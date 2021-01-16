package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;

public class Plant extends DestroyableObject {

	private Animation[] animation = new Animation[4];

	public Plant(int x, int y, FACING facing) {
		super(x, y, facing);

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
			runAnimations();
			falltime--;
		}
	}

	private void runAnimations() {
		runAnimation(Size.DIRECTION_UP);
		runAnimation(Size.DIRECTION_DOWN);
		runAnimation(Size.DIRECTION_LEFT);
		runAnimation(Size.DIRECTION_RIGHT);
	}

	// design

	@Override
	public Animation getAnimation(int array, int secondarray) {

		if (animation[array] == null) {
			if (array == Size.DIRECTION_LEFT)
				animation[array] = new Animation(2, texture.plant[0], texture.plant[0], texture.plant[1], texture.plant[2],
						texture.plant[3], texture.plant[3]);
			else if (array == Size.DIRECTION_RIGHT)
				animation[array] = new Animation(2, texture.plant[4], texture.plant[4], texture.plant[5], texture.plant[6],
						texture.plant[7], texture.plant[3]);
			else
				animation[array] = new Animation(1);
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

		if (!isHorizontal()) {

			// inital rendering
			if (!falling) {
				if (getFacing() == FACING.LEFT)
					g.drawImage(texture.plant[0], x - Size.TILE, y, w0, h0, null);
				if (getFacing() == FACING.RIGHT)
					g.drawImage(texture.plant[4], x, y, w0, h0, null);
			}

			// falling rendering
			if (falling && falltime > 0) {
				if (getFacing() == FACING.LEFT)
					drawAnimation(Size.DIRECTION_LEFT, g, x - Size.TILE, y, w0, h0);
				if (getFacing() == FACING.RIGHT)
					drawAnimation(Size.DIRECTION_RIGHT, g, x, y, w0, h0);
			}

			// final rendering
			if (falling && falltime <= 0) {
				if (getFacing() == FACING.LEFT)
					g.drawImage(texture.plant[3], x - Size.TILE, y, w0, h0, null);
				if (getFacing() == FACING.RIGHT)
					g.drawImage(texture.plant[7], x, y, w0, h0, null);
			}

		} else
			g.drawImage(ImageTask.drawMissingTexture(), x, y, w0, h0, null);
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
		return SoundBank.getSound(SoundBank.hit_attack);
	}

}
