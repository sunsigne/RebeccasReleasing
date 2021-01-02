package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;

public class Desk extends DestroyableObject {

	private double random;
	private int falltime = 20;

	public Desk(int x, int y, boolean horizontal) {
		super(x, y, false, horizontal, DESTROYABLEID.DESK, NULL);
		random = Math.random();

		if (random <= 0.5 & horizontal)
			loadAnimation(DESK_A);
		if (random > 0.5 & horizontal)
			loadAnimation(DESK_B);
		if (random <= 0.5 & !horizontal)
			loadAnimation(DESK_C);
		if (random > 0.5 & !horizontal)
			loadAnimation(DESK_D);
		setUpdatableFacing(true);

		w = 2 * Size.TILE;
		h = 2 * Size.TILE;
	}

	@Override
	public int givePts() {
		return 100;
	}

	@Override
	public String makeMainSound() {
		return AudioBank.hit_attack;
	}

	@Override
	public String makeSideSound() {
		return null;
	}

	@Override
	public void tick() {
		if (isFalling() && isDestroyed()) {
			getAnimation().runAnimation();
			falltime--;
			if (falltime == 0)
				setFalling(false);
		}
	}

	public void render(Graphics g) {

		BufferedImage startImg = null;
		BufferedImage endImg = null;
		int x0 = x - w / 64;
		int w0 = w;
		int gap = 0;

		if (horizontal) {
			gap = w / 64;
			if (random <= 0.5) {
				startImg = texture.desk[0];
				endImg = texture.desk[5];
			}
			if (random > 0.5) {
				startImg = texture.desk[6];
				endImg = texture.desk[11];
			}
		} else {
			if (random <= 0.5) {
				startImg = texture.desk[12];
				endImg = texture.desk[17];
			}
			if (random > 0.5) {
				startImg = texture.desk[18];
				endImg = texture.desk[23];
			}
			if (isFacingLeft()) {
				x0 = x + w / 2 - w / 64;
				w0 = -w;
			}
		}

		if (!isDestroyed() || falltime >= 20)
			g.drawImage(startImg, x - w / 64, y, w + gap, h, null);
		else if (falltime > 0)
			getAnimation().drawAnimation(g, x0, y, w0 + gap, h);
		else
			g.drawImage(endImg, x0, y, w0 + gap, h, null);

		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {

		if (!horizontal)
			return new Rectangle(x, y, w / 2, h);
		else
			return new Rectangle(x, y, w, h / 2);
	}

	@Override
	public void refreshPlayerRendering() {
		if (horizontal) {
			if (HandlerObject.getInstance().player.getY() < y + h / 15)
				HandlerRender.getInstance().playerAbove = false;
		}
	}

}
