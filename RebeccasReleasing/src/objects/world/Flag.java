package objects.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.ScoreScreen;
import com.sunsigne.rebeccasreleasing.main.Size;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Flag extends GameObject implements ICollision {

	private boolean reached;

	public Flag(int x, int y) {
		super(x, y, OBJECTID.FLAG, true);

	}

	// state

	public void setReached(boolean reached) {
		this.reached = reached;
	}

	public boolean isReached() {
		return reached;
	}	

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(x, y, Size.TILE, Size.TILE);
//		g.drawImage(texture.item[2], x, y, Size.TILE, Size.TILE, null);	
		drawHitbox(g);
	}

	@Override
	public void collision(LivingObject living) {

		if (living.collisionDetector.isPlayer && !this.isReached()) {

			living.collisionDetector.collidingBehavior(false, this, () -> {
				setReached(true);
				new ScoreScreen();
				return;
			});
		}

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, Size.TILE, Size.TILE);
	}


}
