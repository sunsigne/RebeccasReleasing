package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;

public class Plant extends DestroyableObject {

	private int falltime = 15;

	public Plant(int x, int y, boolean facingLeft) {
		super(x, y, facingLeft, false, DESTROYABLEID.PLANT, PLANT);

		w = Size.TILE / 2;
		h = Size.TILE / 2;
	}

	@Override
	public int givePts() {
		return 50;
	}

	@Override
	public AudioBank makeMainSound() {
		return SoundBank.poterie;
	}

	@Override
	public AudioBank makeSideSound() {
		return SoundBank.hit_attack;
	}


	@Override
	public void tick() {
		if (isFalling() && isDestroyed()) {
			getAnimation().runAnimation();
			;
			falltime--;
			if (falltime == 0)
				setFalling(false);
		}
	}

	@Override
	public void render(Graphics g) {

		int x0 = x;
		int w0 = 4 * w;

		if (isFacingLeft()) {
			x0 = x + 2 * w;
			w0 = -4 * w;
		}

		if (!isDestroyed() || falltime >= 13)
			g.drawImage(texture.plant[0], x, y, 4 * w, 2 * h, null);
		else if (falltime > 0)
			getAnimation().drawAnimation(g, x0, y, w0, 2 * h);
		else
			g.drawImage(texture.plant[3], x0, y, w0, 2 * h, null);

		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x + w / 2, y + h / 2, w, h);
	}

}
