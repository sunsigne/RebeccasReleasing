package objects.puzzle;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;

import objects.OBJECTID;

public class WallPuzzle extends PuzzleObject {

	private WALLTYPE type;

	public WallPuzzle(int x, int y, WALLTYPE type) {
		super(x, y, OBJECTID.WALL);
		this.type = type;

	}

	public static enum WALLTYPE {
		KEY;
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
		default:
			img = ImageTask.drawMissingTexture();
			break;
		}
		return img;
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}	

}
