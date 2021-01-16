package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Game;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.system.handler.IRender;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;

public abstract class GameObject implements ITick, IRender {

	protected TextureBank texture = TextureBank.getInstance();

	private boolean cameraDependant;

	protected OBJECTID id;
	protected int x, y;
	protected int w, h;
	protected int velX, velY;

	public GameObject(boolean cameraDependant, int x, int y, OBJECTID id) {

		this.cameraDependant = cameraDependant;
		setX(x);
		setY(y);
		setID(id);

		w = Size.TILE;
		h = Size.TILE;
	}

	// identity

	@Override
	public boolean isCameraDependant() {
		return cameraDependant;
	}

	public void setID(OBJECTID id) {
		this.id = id;
	}

	public OBJECTID getId() {
		return id;
	}

	// position

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// size

	public int getWitdh() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public int[] getRect() {
		int[] rect = new int[4];
		rect[0] = getX();
		rect[1] = getY();
		rect[2] = getWitdh();
		rect[3] = getHeight();
		return rect;
	}

	// velocity

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	protected void velocity() {
		x = x + velX;
		y = y + velY;
	}

	public void setMotionless() {
		velX = 0;
		velY = 0;
	}

	public boolean isMotionless() {

		if (velX == 0 && velY == 0)
			return true;
		else
			return false;
	}

	public boolean isMotionlessbyX() {

		if (velX == 0)
			return true;
		else
			return false;
	}

	public boolean isMotionlessbyY() {

		if (velY == 0)
			return true;
		else
			return false;
	}

	// design

	public void refreshPlayerRendering() {
	}

	protected void drawHitbox(Graphics g) {
		if (Game.visibleHitbox) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.white);
			if (getBounds() != null)
				g2d.draw(getBounds());
		}
	}

	// collision

	public abstract Rectangle getBounds();

}
