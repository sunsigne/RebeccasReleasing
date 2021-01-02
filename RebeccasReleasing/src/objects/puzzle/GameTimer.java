package objects.puzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.main.Size;

import objects.OBJECTID;

@Todo("pour tuto : attirer l'attention sur le timer !!")
public class GameTimer extends PuzzleObject {

	public static final int TIME = 9;
	private TimerListener listener;
	private int timeinSec;
	private int ticksbySec;
	private static int SIZE = 200;

	public GameTimer(int timeinSec, TimerListener listener) {
		super((Size.WIDHT - SIZE) - 30, -5, OBJECTID.TIMER);
		this.listener = listener;
		this.timeinSec = timeinSec;
		ticksbySec = 60;
	}

	@Override
	public void tick() {
		--ticksbySec;
		if (ticksbySec == 0) {
			ticksbySec = 60;
			--timeinSec;
		}
		if (timeinSec == 0)
			listener.onFinish();
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font("arial", 1, 120);
		g.setFont(font);
		if (timeinSec >= 5)
			g.setColor(Color.green);
		if (timeinSec <= 4)
			g.setColor(Color.yellow);
		if (timeinSec <= 2)
			g.setColor(Color.red);
		g.drawImage(texture.item[12], x, y, SIZE, SIZE, null);
		g.drawString("" + timeinSec, x + 68, y + 145);
	}
	
	@Override
	public Rectangle getBounds() {
		return null;
	}


}
