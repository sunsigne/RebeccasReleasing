package com.sunsigne.rebeccasreleasing.game.puzzles.hack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.main.Size;

public class ProcessorCPU extends ProcessorObject {

	private int number;

	public ProcessorCPU(int col, int row, int number) {
		super(col, row, PROCESSORID.CPU);

		this.number = number;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font(Font.DIALOG_INPUT, 2, 45);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("CPU-" + number, x + Size.TILE_PUZZLE / 2 - 10, y + 2 * Size.TILE_PUZZLE - 10);

		g.drawImage(texture.puzzle_hack[10], x + w / 4, y + h / 4, w, h, null);
		if (isLocked())
			g.drawImage(texture.puzzle_hack[9], x + w / 2, y + h / 2, w / 2, h / 2, null);
		drawHitbox(g);
	}

	@Override
	public void open() {
	}

	@Override
	public void refresh() {
	}

}
