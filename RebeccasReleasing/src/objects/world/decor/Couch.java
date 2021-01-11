package objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;

import objects.GameObject;
import objects.IFacing;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Couch extends GameObject implements ICollision, IFacing {

	private FACING facing;
	private int lenght = 3;

	public Couch(int x, int y, FACING facing, int lenght) {
		super(x, y, OBJECTID.WALL, true);

		this.facing = facing;
		if (lenght < 4)
			this.lenght = lenght;

		if (isHorizontal())
			w = lenght * Size.TILE;
		if (!isHorizontal())
			h = lenght * Size.TILE;
	}

	@Override
	public FACING getFacing() {
		return facing;
	}

	@Override
	public void setFacing(FACING facing) {
		if (updatableFacing())
			this.facing = facing;
	}

	@Override
	public boolean updatableFacing() {
		return false;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		BufferedImage img = paintingCouch();
		g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	private BufferedImage paintingCouch() {

		BufferedImage img = null;

		if (facing == FACING.UP)
			img = texture.couch[Size.DIRECTION_UP][lenght];
		if (facing == FACING.DOWN)
			img = texture.couch[Size.DIRECTION_DOWN][lenght];
		if (facing == FACING.LEFT)
			img = texture.couch[Size.DIRECTION_LEFT][lenght];
		if (facing == FACING.RIGHT)
			img = texture.couch[Size.DIRECTION_RIGHT][lenght];

		return img;
	}

	@Override
	public void collision(LivingObject living) {

		living.collisionDetector.collidingBehavior(true, this, null);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
