package objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

@Todo("pour tuto : attirer l'attention sur le timer !!")
public abstract class TimerObject extends GameObject {

	public static final int TIME = 9;
	private TimerListener listener;
	private int ticksbySec = 60;

	protected int timeinSec;

	public TimerObject(int timeinSec, TimerListener listener) {
		super(false, Size.WIDHT - 230, -5, OBJECTID.TIMER);
		this.listener = listener;
		this.timeinSec = timeinSec;
		ticksbySec = 60;

		w = 200;
		h = 200;
	}

	// behavior

	@Override
	public void tick() {
		--ticksbySec;
		if (ticksbySec == 0) {
			ticksbySec = 60;
			tickTimer();

		}
		if (finishCondition())
			listener.onFinish();
	}

	protected abstract void tickTimer();

	protected abstract boolean finishCondition();

	// design

	@Override
	public void render(Graphics g) {

		Font font = new Font("arial", 1, 120);
		g.setFont(font);
		if (getIntToDisplay() >= 5)
			g.setColor(Color.green);
		if (getIntToDisplay() <= 4)
			g.setColor(Color.yellow);
		if (getIntToDisplay() <= 2)
			g.setColor(Color.red);
		g.drawImage(texture.gui_data[2], x, y, w, h, null);
		g.drawString(String.valueOf(getIntToDisplay()), x + 68, y + 145);
	}

	protected abstract int getIntToDisplay();

	// collision

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
