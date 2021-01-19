package objects.world.destroyable;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;

public class Desk extends DestroyableObject {

	private Animation[] animation = new Animation[4];

	public Desk(int x, int y, FACING facing) {
		super(x, y, facing);

		w = 2 * Size.TILE;
		h = 2 * Size.TILE;
	}

	// state

	@Override
	protected boolean updatableFacing() {
		return true;
	}

	// behavior

	@Override
	public void tick() {
		if (falltime > 0) {
			runFourDirectionAnimations();
			falltime--;
		}
	}

	// design

	@Override
	public Animation getAnimation(int array, int secondarray) {

		if (animation[array] == null) {
			if (array == FACING.LEFT.getNum())
				animation[array] = new Animation(2, texture.neodesk[7], texture.neodesk[8], texture.neodesk[9],
						texture.neodesk[10], texture.neodesk[11], texture.neodesk[11], texture.neodesk[11]);
			else if (array == FACING.RIGHT.getNum())
				animation[array] = new Animation(2, texture.neodesk[13], texture.neodesk[14], texture.neodesk[15],
						texture.neodesk[16], texture.neodesk[17], texture.neodesk[17], texture.neodesk[17]);
			else if (array == FACING.UP.getNum())
				animation[array] = new Animation(2, texture.neodesk[1], texture.neodesk[2], texture.neodesk[3],
						texture.neodesk[4], texture.neodesk[5], texture.neodesk[5], texture.neodesk[5]);
			else if (array == FACING.DOWN.getNum())
				animation[array] = new Animation(2, texture.neodesk[1], texture.neodesk[2], texture.neodesk[3],
						texture.neodesk[4], texture.neodesk[5], texture.neodesk[5], texture.neodesk[5]);

			else
				animation[array] = new Animation(1);
		}
		return animation[array];
	}

	public void render(Graphics g) {

		renderingDesk(g);
		drawHitbox(g);
	}

	private void renderingDesk(Graphics g) {

		// inital rendering
		if (!falling) {
			if (getFacing() == FACING.LEFT)
				g.drawImage(texture.neodesk[6], x, y, w, h, null);
			if (getFacing() == FACING.RIGHT)
				g.drawImage(texture.neodesk[12], x, y, w, h, null);
			if (isHorizontal())
				g.drawImage(texture.neodesk[0], x, y, w, h, null);
		}

		// falling rendering
		if (falling && falltime > 0) {
			if (getFacing() == FACING.LEFT)
				drawAnimation(FACING.LEFT.getNum(), g, x, y, w, h);
			if (getFacing() == FACING.RIGHT)
				drawAnimation(FACING.RIGHT.getNum(), g, x, y, w, h);
			if (isHorizontal())
				drawAnimation(FACING.DOWN.getNum(), g, x, y, w, h);
		}

		// final rendering
		if (falling && falltime <= 0) {
			if (getFacing() == FACING.LEFT)
				g.drawImage(texture.neodesk[11], x, y, w, h, null);
			if (getFacing() == FACING.RIGHT)
				g.drawImage(texture.neodesk[17], x, y, w, h, null);
			if (isHorizontal())
				g.drawImage(texture.neodesk[5], x, y, w, h, null);
		}

	}

	// collision

	@Override
	public void refreshPlayerRendering() {
		if (isHorizontal()) {
			if (HandlerObject.getInstance().player.getY() < y + h / 4)
				HandlerRender.getInstance().playerAbove = false;
		}
	}

	@Override
	public Rectangle getBounds() {
		if (isHorizontal())
			return new Rectangle(x + w / 8, y + h / 16, w - w / 4, h - h / 2);
		else
			return new Rectangle(x + w / 4, y + h / 16, w - w / 2, h - h / 4);
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
		return SoundBank.getSound(SoundBank.hit_defense);
	}

	@Override
	public BufferedSound makeSideSound() {
		return null;
	}

}
