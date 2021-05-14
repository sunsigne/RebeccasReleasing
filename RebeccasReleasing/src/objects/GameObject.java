package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.IRender;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public abstract class GameObject implements ITick, IRender {

	protected TextureBank texture = TextureBank.getInstance();

	private boolean cameraDependant;

	protected OBJECTID id;
	protected int initX, initY;
	protected int x, y;
	protected int miniX, miniY;
	protected int w, h;
	protected int velX, velY;

	public GameObject(boolean cameraDependant, int x, int y, OBJECTID id) {

		this.cameraDependant = cameraDependant;
		setX(x);
		setY(y);
		setID(id);
		initX = x;
		initY = y;

		w = Size.TILE;
		h = Size.TILE;
	}

	// identity

	@Override
	public boolean isCameraDependant() {
		return cameraDependant;
	}

	public OBJECTID getId() {
		return id;
	}

	public void setID(OBJECTID id) {
		this.id = id;
	}

	// position

	public int getX() {
		return x;
	}

	public int getMiniX() {
		return miniX;
	}

	public int getY() {
		return y;
	}

	public int getMiniY() {
		return miniY;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
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
		rect[0] = getBounds().x;
		rect[1] = getBounds().y;
		rect[2] = getBounds().width;
		rect[3] = getBounds().height;
		return rect;
	}

	// velocity

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	protected void velocity() {
		x = x + velX;
		y = y + velY;
	}

	public boolean isMotionless() {
		return isMotionlessbyX() && isMotionlessbyY();
	}

	public boolean isMotionlessbyX() {
		return velX == 0;
	}

	public boolean isMotionlessbyY() {
		return velY == 0;
	}

	public void setMotionless() {
		velX = 0;
		velY = 0;
	}

	public void add() {
		HandlerTick.getInstance().addObject(this);
		HandlerRender.getInstance().addObject(this);
	}

	public void remove() {
		HandlerTick.getInstance().removeObject(this);
		HandlerRender.getInstance().removeObject(this);
	}

	// design

	public void refreshPlayerRendering() {
	}

	public void drawHitbox(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		if (getBounds() != null)
			g2d.draw(getBounds());
	}

	// collision

	public abstract Rectangle getBounds();

}
