package objects.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.IFacing;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Wall extends GameObject implements ICollision, IFacing {

	private FACING facing;

	public Wall(int x, int y, FACING facing) {
		super(true, x, y, OBJECTID.WALL);
		if (facing != null)
			setFacing(facing);
		else
			resetSize();
	}

	// state

	@Override
	public FACING getFacing() {
		return facing;
	}

	@Override
	public void setFacing(FACING facing) {
		this.facing = facing;
		switch (facing) {
		case LEFT:
			resetSize();
			h = h / 2;
			w = w / 2;
			break;
		case RIGHT:
			resetSize();
			h = h / 2;
			w = w / 2;
			miniX = w;
			break;
		case UP:
			resetSize();
			h = h / 2;
			break;
		case DOWN:
			resetSize();
			h = h / 2;
			miniY = h;
			break;

		}
	}

	private void resetSize() {
		x = initX;
		y = initY;
		w = Size.TILE;
		h = Size.TILE;
	}

	// behavior

	@Override
	public void tick() {
	}

	// design

	@Override
	public void render(Graphics g) {
		drawHitbox(g);
	}

	// collision

	@Override
	public void collision(LivingObject living) {
		living.getCollisionDetector().collidingBehavior(true, this, null);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x + miniX, y + miniY, w, h);
	}

}
