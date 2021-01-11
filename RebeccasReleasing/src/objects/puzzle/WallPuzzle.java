package objects.puzzle;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;

import objects.OBJECTID;

public class WallPuzzle extends PuzzleObject {

	private WALLTYPE type;

	public WallPuzzle(int x, int y, WALLTYPE type) {
		super(x, y, OBJECTID.WALL);
		this.type = type;

		w = Size.TILE_PUZZLE;
		h = Size.TILE_PUZZLE;
	}

	public static enum WALLTYPE {
		CARD, HACK, SEARCH, BOMB;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		BufferedImage img = null;
		img = paintingWall(type);

		for (int i = 0; i < 13; i++) {
			g.drawImage(img, x + i * w, y, w, h, null);
		}
		for (int i = 0; i < 13; i++) {
			g.drawImage(img, x + i * w, y + 7 * h, w, h, null);
		}
		for (int i = 0; i < 8; i++) {
			g.drawImage(img, x, y + i * h, w, h, null);
		}
		for (int i = 0; i < 8; i++) {
			g.drawImage(img, x + 13 * w, y + i * h, w, h, null);
		}
	}

	private BufferedImage paintingWall(WALLTYPE type) {

		BufferedImage img = null;

		switch (type) {
		case CARD:
			img = texture.item[25];
			break;
		case HACK:
			img = texture.item[32];
			break;
		case SEARCH:
			img = texture.item[35];
			break;
		case BOMB:
			img = texture.item[30];
			break;
		default:
			img = ImageTask.drawMissingTexture();
			break;
		}
		return img;
	}

	@Override
	public Rectangle getBounds() {

		return null;
	}


}
