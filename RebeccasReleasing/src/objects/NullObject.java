package objects;

import java.awt.Graphics;
import java.awt.Rectangle;

public class NullObject extends GameObject {

	public NullObject() {
		super(false, 0, 0, OBJECTID.NULL);

	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	

}
