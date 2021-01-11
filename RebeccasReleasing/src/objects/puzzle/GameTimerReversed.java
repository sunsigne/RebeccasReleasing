package objects.puzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;

import objects.OBJECTID;

public class GameTimerReversed extends PuzzleObject {

	private TimerListener listener;
	private int count = 1;
	private int timeinSec;
	private int ticksbySec;
	private static int SIZE = 200;

	public GameTimerReversed(int timeinSec, TimerListener listener) {
		super((Size.WIDHT - SIZE) - 30, -5, OBJECTID.TIMER);
		this.listener = listener;
		this.timeinSec = 1 + timeinSec;
		ticksbySec = 60;
	}

	@Override
	public void tick() {
		--ticksbySec;
		if (ticksbySec == 0) {
			ticksbySec = 60;
			++count;
		}
		if (count == timeinSec)
			listener.onFinish();
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font("arial", 1, 120);
		g.setFont(font);
		if (count >= 5)
			g.setColor(Color.green);
		if (count <= 4)
			g.setColor(Color.yellow);
		if (count <= 2)
			g.setColor(Color.red);
		g.drawImage(texture.item[12], x, y, SIZE, SIZE, null);
		g.drawString("" + count, x + 68, y + 145);
	}
	
	@Override
	public Rectangle getBounds() {
		return null;
	}



}
