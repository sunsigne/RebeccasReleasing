package objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class WC extends GameObject implements ICollision  {

	public WC(int x, int y) {
		super(x, y, OBJECTID.DECOR);

	}

	@Override
	public boolean isCameraDependant() {
		return true;
	}
	
	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		/* if(!isWatchingLeft()) */ g.drawImage(texture.item[36], x, y - Size.TILE / 16, Size.TILE + Size.TILE / 8, Size.TILE + Size.TILE / 8,
				null);
//		if(isWatchingLeft())  g.drawImage(texture.item[37], x - Size.TILE/8, y - Size.TILE/16, Size.TILE + Size.TILE/8, Size.TILE + Size.TILE/8, null);

		drawHitbox(g);
	}
	
	@Override
	public void collision(LivingObject living) {

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, Size.TILE, Size.TILE);
	}


}
