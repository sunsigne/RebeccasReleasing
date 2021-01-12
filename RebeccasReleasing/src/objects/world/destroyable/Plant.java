package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;

public class Plant extends DestroyableObject {

	private int falltime = 15;

	public Plant(int x, int y, FACING facing) {
		super(x, y, facing);

		w = Size.TILE / 2;
		h = Size.TILE / 2;
	}

	@Override
	public Animation getAnimation(int array, int secondarray) {
		if (animation == null)
			animation = new Animation(2, texture.plant[0], texture.plant[1], texture.plant[2], texture.plant[3],
					texture.plant[3]);
		return animation;
	}

	@Override
	protected boolean updatableFacing() {
		return false;
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

	@Override
	public void tick() {
		if (isFalling() && falltime > 0) {
			runAnimation();
			falltime--;
		}
	}

	@Override
	public void render(Graphics g) {

		int x0 = x;
		int w0 = w;

		if (getFacing() == FACING.LEFT) {
			x0 = x + 2 * w;
			w0 = -4 * w;
		}

		if (getFacing() == FACING.RIGHT) {
			x0 = x;
			w0 = 4 * w;
		}

		if (!isHorizontal()) {

			if (!isFalling() || falltime >= 13)
				g.drawImage(texture.plant[0], x, y, 4 * w, 2 * h, null);
			else if (falltime > 0)
				drawAnimation(g, x0, y, w0, 2 * h);
			else
				g.drawImage(texture.plant[3], x0, y, w0, 2 * h, null);
		}
		
		else g.drawImage(ImageTask.drawMissingTexture(), x, y, w, h, null);

		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x + w / 2, y + h / 2, w, h);
	}

}
