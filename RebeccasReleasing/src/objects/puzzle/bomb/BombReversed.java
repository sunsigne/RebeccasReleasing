package objects.puzzle.bomb;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;

import objects.OBJECTID;

public class BombReversed extends BombObject {

	private boolean stable, fullcount;

	public BombReversed(int x, int y) {
		super(x, y, OBJECTID.HEAD, REVERSED_BOMB);

		totalcount = 1 + new Random().nextInt(3);

	}

	// state

	public void setStable(boolean stable) {
		this.stable = stable;
	}

	public void setFullcount(boolean fullcount) {
		this.fullcount = fullcount;
	}

	public boolean isStable() {
		return stable;
	}

	public boolean isFullcount() {
		return fullcount;
	}

	public void addCount() {

		if (!isExploding() && count < totalcount) {
			count = count + 1;
			if (count == totalcount)
				setFullcount(true);

			if (count == 1) {
				AudioTask.playSound(AudioBank.r_explosion_medium);
				setExploding(true);
			} else {
				AudioTask.playSound(AudioBank.r_explosion_little);
			}

		}
	}

	@Override
	public void tick() {
		if (isExploding()) {
			getAnimation().runAnimation();
			boomtime--;
			if (boomtime <= 0) {
				setExploding(false);
				setStable(true);
			}
		}
	}

	@Override
	public void render(Graphics g) {

		int alpha = 160;
		Font font = new Font("arial", 1, 120);
		g.setFont(font);
		if (count == totalcount)
			g.setColor(new Color(250, 50, 50, alpha));
		else
			g.setColor(Color.yellow);

		if (!isExploding() && isStable()) {
			g.drawImage(texture.bomb[0], x, y, w, h, null);
			g.drawString("" + count, x + 88, y + 187);
		} else if (isExploding()) {
			getAnimation().drawAnimation(g, x, y, w, h);
		}
		drawHitbox(g);
	}

}
