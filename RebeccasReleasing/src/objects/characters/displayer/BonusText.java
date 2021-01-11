package objects.characters.displayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;

public class BonusText extends GameObject {

	private int time;
	private String text;

	public BonusText(GameObject object, String text) {
		super(object.getX(), object.getY(), OBJECTID.DISPLAYER, true);

		this.text = text;
		time = 40;
		velY = -1;
	}

	@Override
	public void tick() {
		velocity();
		--time;
		if (time == 0)
			HandlerObject.getInstance().removeObject(this);

	}

	@Override
	public void render(Graphics g) {

		Font font = new Font("arial", 1, Size.TILE / 2);
		g.setFont(font);
		g.setColor(Color.yellow);
		g.drawString(text, x, y - Size.TILE);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
