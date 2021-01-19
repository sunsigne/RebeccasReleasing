package com.sunsigne.rebeccasreleasing.game.puzzles.hack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.main.Size;

public class ProcessorTrash extends ProcessorObject {

	private boolean empty;

	public ProcessorTrash() {
		super(6, 3, PROCESSORID.TRASH);

	}

	// state

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public boolean isEmpty() {
		return empty;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font(Font.DIALOG_INPUT, 2, 45);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("trash", x + Size.TILE_PUZZLE / 2 - 10, y + 2 * Size.TILE_PUZZLE - 10);

		if (isEmpty())
			g.drawImage(texture.hack[3], x + w / 4, y + h / 4, w, h, null);
		else
			g.drawImage(texture.hack[2], x + w / 4, y + h / 4, w, h, null);
		drawHitbox(g);
	}

	@Override
	public void open() {
	}

	@Override
	public void refresh() {
	}

}
