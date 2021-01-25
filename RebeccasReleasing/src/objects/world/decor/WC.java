package objects.world.decor;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

@Todo("redesign")
public class WC extends GameObject implements ICollision  {

	public WC(int x, int y) {
		super(true, x, y, OBJECTID.DECOR);

	}
	
	// behavior

	@Override
	public void tick() {

	}
	
	// design

	@Override
	public void render(Graphics g) {

//		/* if(!isWatchingLeft()) */ g.drawImage(texture.item[36], x, y - Size.TILE / 16, Size.TILE + Size.TILE / 8, Size.TILE + Size.TILE / 8,
//				null);
//		if(isWatchingLeft())  g.drawImage(texture.item[37], x - Size.TILE/8, y - Size.TILE/16, Size.TILE + Size.TILE/8, Size.TILE + Size.TILE/8, null);

		drawHitbox(g);
	}
	
	// collision
	
	@Override
	public void collision(LivingObject living) {

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}


}
