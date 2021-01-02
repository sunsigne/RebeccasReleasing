package objects.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public class Wall extends GameObject implements ICollision {

	private WALLTYPE type;

	public Wall(int x, int y, WALLTYPE type) {
		super(x, y, OBJECTID.WALL);
		this.type = type;

		if (type == WALLTYPE.WALL) {
			w = Size.TILE;
			h = Size.TILE;
		} else {
			w = Size.TILE_PUZZLE;
			h = Size.TILE_PUZZLE;
		}
	}

	public static enum WALLTYPE {
		WALL, KEY;
	}

	@Override
	public boolean isCameraDependant() {
		switch (type) {
		case KEY: return false;
		case WALL: return true;
		default: System.err.println("A wall has an Unkown WALLTYPE !"); return false;	
		}
	}
	
	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		BufferedImage img = null;
		img = paintingWall(type);

		g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	private BufferedImage paintingWall(WALLTYPE type) {
		BufferedImage img = null;

		switch (type) {
		case KEY:
			img = texture.item[3];
			break;
		case WALL:
			img = texture.item[2];
			break;
		default:
			img = ImageTask.drawEmptyTexture();
			break;
		}
		return img;
	}
	
	@Override
	public void collision(LivingObject living)
	{
		living.collisionDetector.collidingBehavior(true, this, null);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}	

}
