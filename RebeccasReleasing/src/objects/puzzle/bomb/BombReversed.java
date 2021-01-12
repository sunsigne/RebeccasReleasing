package objects.puzzle.bomb;

import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;

public class BombReversed extends BombObject {

	private boolean winning;
	
	public BombReversed(int x, int y) {
		super(x, y);

		totalcount = 1 + new Random().nextInt(3);
		setExploding(true);
	}


	@Override
	public Animation getAnimation(int array, int secondarray) {
		if (animation == null)
			animation = new Animation(2, texture.bomb[9], texture.bomb[8], texture.bomb[7], texture.bomb[6],
					texture.bomb[5], texture.bomb[4], texture.bomb[3], texture.bomb[2], texture.bomb[1],
					texture.bomb[1]);
		return animation;
	}

	// state
	
	public boolean isWinning() {
		return winning;
	}

	public void addCount() {

		if(isExploding() && boomtime == 30)
		{
			count = 1;
			boomtime--;
			SoundTask.playSound(SoundBank.getSound(SoundBank.r_explosion_medium));
			setExploding(false);
		}
		
		else if (boomtime < 0)
		{
			if (count < totalcount)
			{
			count = count + 1;
			SoundTask.playSound(SoundBank.getSound(SoundBank.r_explosion_little));
			}
		}
	}

	@Override
	public void tick() {
		if (boomtime < 30) {
			runAnimation();
			boomtime--;
		}
		
		if (boomtime < 0 && count == totalcount)
			winning = true;
	}

	@Override
	public void render(Graphics g) {

		paintCount(g);

		if(isExploding() && boomtime == 30)
			g.drawImage(texture.bomb[9], x, y, w, h, null);
		else if(!isExploding())
		{
			if (boomtime > 0)
				drawAnimation(g, x, y, w, h);
			else 
				{
				g.drawImage(texture.bomb[0], x, y, w, h, null);
				g.drawString("" + count, x + 88, y + 187);
				}
		}
		drawHitbox(g);
	}
}
