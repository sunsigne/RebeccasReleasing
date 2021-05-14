package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.hack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class ProcessorLocker extends ProcessorObject {

	private ProcessorObject processor;

	public ProcessorLocker(int col, int row) {
		super(col, row, PROCESSORID.LOCKER);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font(Font.DIALOG_INPUT, 2, 45);
		g.setFont(font);
		g.setColor(Color.white);

		g.drawString("Locker", x + Size.TILE_PUZZLE / 2 - 20, y + 2 * Size.TILE_PUZZLE - 20);
		g.drawImage(texture.puzzle_hack[5], x + w / 4, y + h / 4, w, h, null);

		if (isLocked())
			g.drawImage(texture.puzzle_hack[9], x + w / 2, y + h / 2, w / 2, h / 2, null);
	}

	@Override
	public void open() {
	}

	@Override
	public void refresh() {
	}

	public void locking(ProcessorObject processor) {
		this.processor = processor;
		processor.setLocked(true);
	}

	public void unlocking() {
		processor.setLocked(false);
	}

}
