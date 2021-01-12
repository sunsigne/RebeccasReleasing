package objects.puzzle.bomb;

import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;

public class Bomb extends BombObject {

	public Bomb(int x, int y) {
		super(x, y);

		count = 1 + new Random().nextInt(3);
		totalcount = count;
	}

	@Override
	public Animation getAnimation(int array, int secondarray) {
		if (animation == null)
			animation = new Animation(2, texture.bomb[1], texture.bomb[2], texture.bomb[3], texture.bomb[4],
					texture.bomb[5], texture.bomb[6], texture.bomb[7], texture.bomb[8], texture.bomb[9],
					texture.bomb[9]);
		return animation;
	}

	// state

	public void removeCount() {
		if (count > 0) {
			SoundTask.playSound(SoundBank.getSound(SoundBank.explosion_little));
			count = count - 1;
		}
	}

	@Override
	public void tick() {
		if (count == 0) {
			count--;
			setExploding(true);
			SoundTask.playSound(SoundBank.getSound(SoundBank.explosion_medium));
		}

		if (isExploding()) {
			runAnimation();
			boomtime--;
		}
	}

	@Override
	public void render(Graphics g) {

		paintCount(g);

		if (!isExploding()) {
			g.drawImage(texture.bomb[0], x, y, w, h, null);
			g.drawString("" + count, x + 88, y + 187);

		} else if (isExploding()) {
			if (boomtime > 0)
				drawAnimation(g, x, y, w, h);
			else
				g.drawImage(texture.bomb[9], x, y, w, h, null);
		}

		drawHitbox(g);
	}

}
