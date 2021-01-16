package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;

import objects.IFacing.FACING;

public class Desk extends DestroyableObject {

	private Animation[] animation = new Animation[4];

	private double random;

	public Desk(int x, int y, FACING facing) {
		super(x, y, facing);

		this.random = Math.random();
		resize();
	}

	// state

	@Override
	protected boolean updatableFacing() {
		return true;
	}
		
	private void resize() {
		if(isHorizontal()) w = 2 * Size.TILE;
		else h = 2 * Size.TILE;		
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

		if (animation[array] == null)
			
			/*if (random <= 0.5)*/
			animation[array] = getRandomAnimationA(array);
			/*if (random > 0.5)animation[array] = getRandomAnimationB(array); */

		return animation[array];
	}

	private Animation getRandomAnimationA(int array) {
		if (isHorizontal())
		animation[array] = new Animation(2, texture.desk[0], texture.desk[1], texture.desk[2],
				texture.desk[3], texture.desk[4], texture.desk[5], texture.desk[5]);
		else
		{
			if (array == Size.DIRECTION_LEFT)
				animation[array] = new Animation(2, texture.desk[24], texture.desk[25], texture.desk[26],
						texture.desk[27], texture.desk[28], texture.desk[29], texture.desk[29]);
			if (array == Size.DIRECTION_RIGHT)
				animation[array] = new Animation(2, texture.desk[12], texture.desk[13], texture.desk[14],
						texture.desk[15], texture.desk[16], texture.desk[17], texture.desk[17]);
		}
		return animation[array];		
	}
	
	private Animation getRandomAnimationB(int array) {
		if (isHorizontal())
			animation[array] = new Animation(2, texture.desk[6], texture.desk[7], texture.desk[8],
					texture.desk[9], texture.desk[10], texture.desk[11], texture.desk[11]);
		else
		{
			if (array == Size.DIRECTION_LEFT)
				animation[array] = new Animation(2, texture.desk[30], texture.desk[31], texture.desk[32],
						texture.desk[33], texture.desk[34], texture.desk[35], texture.desk[35]);
			if (array == Size.DIRECTION_RIGHT)
				animation[array] = new Animation(2, texture.desk[18], texture.desk[19], texture.desk[20],
						texture.desk[21], texture.desk[22], texture.desk[23], texture.desk[23]);
		}
		return animation[array];		
	}

	public void render(Graphics g) {
/*
		BufferedImage startImg = null;
		BufferedImage endImg = null;
		int x0 = x - w / 64;
		int w0 = w;
		int gap = 0;

		if (isHorizontal()) {
			gap = w / 64;
			if (random <= 0.5) {
				startImg = texture.desk[0];
				endImg = texture.desk[5];
			}
			if (random > 0.5) {
				startImg = texture.desk[6];
				endImg = texture.desk[11];
			}
		} else if (!isHorizontal()) {
			if (random <= 0.5) {
				startImg = texture.desk[12];
				endImg = texture.desk[17];
			}
			if (random > 0.5) {
				startImg = texture.desk[18];
				endImg = texture.desk[23];
			}
			if (getFacing() == FACING.LEFT) {
				x0 = x + w / 2 - w / 64;
				w0 = -w;
			}
		}

		if (!falling || falltime > 19)
			g.drawImage(startImg, x - w / 64, y, w + gap, h, null);
		else if (falltime > 0)
			drawAnimation(g, x0, y, w0 + gap, h);
		else
			g.drawImage(endImg, x0, y, w0 + gap, h, null);
*/
		renderingDesk(g);
		drawHitbox(g);

	}
	
	private void renderingDesk(Graphics g) {
		
		int w0 = 2 * Size.TILE;
		int h0 = 2 * Size.TILE;
		
		// inital rendering
		if (!falling) {
//			if(random <= 0.5)
			{
				if (isHorizontal())
					g.drawImage(texture.desk[0], x, y, w0, h0, null);
				if (getFacing() == FACING.LEFT)
					g.drawImage(texture.desk[30], x - Size.TILE, y, w0, h0, null);	
				if (getFacing() == FACING.RIGHT)
					g.drawImage(texture.desk[12], x, y, w0, h0, null);
			}
/*			else
			{
				if (isHorizontal())
					g.drawImage(texture.desk[6], x, y, w, h, null);
				if (getFacing() == FACING.LEFT)
					g.drawImage(texture.desk[30], x, y, w  - Size.TILE, h, null);	
				if (getFacing() == FACING.RIGHT)
					g.drawImage(texture.desk[18], x, y, w, h, null);
			}
*/
		}
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
	public void refreshPlayerRendering() {
		if (isHorizontal()) {
			if (HandlerObject.getInstance().player.getY() < y + h / 15)
				HandlerRender.getInstance().playerAbove = false;
		}
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

	@Override
	protected void fall() {
		falling = true;
		falltime = 20;
	}

	@Override
	public int givePts() {
		return 2;
	}

	@Override
	public BufferedSound makeMainSound() {
		return SoundBank.getSound(SoundBank.hit_attack);
	}

	@Override
	public BufferedSound makeSideSound() {
		return null;
	}

}
