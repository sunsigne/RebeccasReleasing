package objects.puzzle.bomb;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.OBJECTID;

public class Bomb extends BombObject {

	private boolean lastbomb;

	public Bomb(int x, int y) {
		super(x, y, OBJECTID.HEAD, BOMB);

		count = 1 + new Random().nextInt(3);
		totalcount = count;
	}

	// state

	public void setLastbomb(boolean lastbomb) {
		this.lastbomb = lastbomb;
	}

	public boolean isLastbomb() {
		return lastbomb;
	}

	public void removeCount() {
		SoundTask.playSound(SoundBank.explosion_little);
		count = count - 1;
	}

	@Override
	public void tick() {
		if (count == 0) {
			count--;
			setExploding(true);
			if (!isLastbomb())
				SoundTask.playSound(SoundBank.explosion_medium);
		}

		if (isExploding()) {
			getAnimation().runAnimation();
			boomtime--;
			if (boomtime <= 0 || isLastbomb())
				HandlerObject.getInstance().removeObject(this);
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

		if (!isExploding()) {
			g.drawImage(texture.bomb[0], x, y, w, h, null);
			g.drawString("" + count, x + 88, y + 187);
		} else
			getAnimation().drawAnimation(g, x, y, w, h);
		drawHitbox(g);
	}

}
