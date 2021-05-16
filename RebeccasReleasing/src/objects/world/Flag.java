package objects.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Flag extends GameObject implements ICollision {

	private boolean reached;

	public Flag(int x, int y) {
		super(true, 0, x, y, OBJECTID.FLAG);

	}

	// state

	public boolean isReached() {
		return reached;
	}	
	
	public void setReached(boolean reached) {
		this.reached = reached;
	}

	// behavior
	
	@Override
	public void tick() {
	}
	
	// design

	@Override
	public void render(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(x, y, Size.TILE, Size.TILE);
//		g.drawImage(texture.item[2], x, y, Size.TILE, Size.TILE, null);	
	}
	
	// collision

	@Override
	public void collision(LivingObject living) {

		if (living.isPlayer() && !this.isReached()) {

			living.getCollisionDetector().collidingBehavior(false, this, () -> {
				setReached(true);
//				new ScoreScreen();
			});
		}

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}


}
