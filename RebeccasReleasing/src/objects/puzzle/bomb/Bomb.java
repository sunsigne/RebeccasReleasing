package objects.puzzle.bomb;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;

import objects.OBJECTID;

public class Bomb extends BombObject {

	public Bomb(int x, int y) {
		super(x, y, OBJECTID.HEAD);

		count = 1 + new Random().nextInt(3);
		totalcount = count;

		animation = createAnimation();
	}

	private Animation createAnimation() {
		Animation anim = new Animation(2, texture.bomb[1], texture.bomb[2], texture.bomb[3], texture.bomb[4],
				texture.bomb[5], texture.bomb[6], texture.bomb[7], texture.bomb[8], texture.bomb[9], texture.bomb[9]);
		return anim;
	}

	// state

	public void removeCount() {
		SoundTask.playSound(SoundBank.getSound(SoundBank.explosion_little));
		count = count - 1;
	}

	@Override
	public void tick() {
		if (count == 0) {
			count--;
			setExploding(true);
			SoundTask.playSound(SoundBank.getSound(SoundBank.explosion_medium));
		}

		if (isExploding()) {
			animation.runAnimation();
			boomtime--;
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

		} else if (isExploding()) {
			if (boomtime > 0)
				animation.drawAnimation(g, x, y, w, h);
			else
				g.drawImage(texture.bomb[9], x, y, w, h, null);
		}

		drawHitbox(g);
	}

}
