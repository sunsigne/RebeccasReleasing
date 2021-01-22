package objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.IFacing;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Couch extends GameObject implements ICollision, IFacing {

	private FACING facing;
	private int lenght = 3;

	public Couch(int x, int y, FACING facing, int lenght) {
		super(true, x, y, OBJECTID.WALL);

		this.facing = facing;
		if (lenght < 4)
			this.lenght = lenght;

		h = Size.TILE/2;
		
		if (isHorizontal())
			w = lenght * Size.TILE;
		if (!isHorizontal())
			h = h + (lenght-1) * Size.TILE;
	}
	
	// state

	@Override
	public FACING getFacing() {
		return facing;
	}

	@Override
	public void setFacing(FACING facing) {
			this.facing = facing;
	}
	
	// behavior

	@Override
	public void tick() {
	}
	
	// design

	@Override
	public void render(Graphics g) {

		int h0 = h + Size.TILE/2;
		
		BufferedImage img = paintingCouch();
		g.drawImage(img, x, y, w, h0, null);
		drawHitbox(g);
	}

	private BufferedImage paintingCouch() {

		BufferedImage img = null;

		if (facing == FACING.LEFT)
			img = texture.decor_couch[FACING.LEFT.getNum()][lenght];
		if (facing == FACING.RIGHT)
			img = texture.decor_couch[FACING.RIGHT.getNum()][lenght];
		if (facing == FACING.UP)
			img = texture.decor_couch[FACING.UP.getNum()][lenght];
		if (facing == FACING.DOWN)
			img = texture.decor_couch[FACING.DOWN.getNum()][lenght];

		return img;
	}
	
	// collision

	@Override
	public void collision(LivingObject living) {

		living.getCollisionDetector().collidingBehavior(true, this, null);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

}
