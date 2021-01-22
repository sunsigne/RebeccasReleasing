package com.sunsigne.rebeccasreleasing.game.puzzles.hack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class ProcessorBack extends ProcessorObject {

	private ProcessorObject[] processors;
	private int docs;

	public ProcessorBack(ProcessorBack previousback, ProcessorObject... args) {
		super(6, 3, PROCESSORID.FOLDER);

		this.previousback = previousback;

		processors = new ProcessorObject[args.length];
		for (int i = 0; i < args.length; i++) {
			processors[i] = args[i];
			docs = args.length;
		}
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		Font font = new Font(Font.DIALOG_INPUT, 2, 45);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("back", x + 3 * Size.TILE_PUZZLE / 4 - 27, y + 2 * Size.TILE_PUZZLE - 15);

		g.drawImage(texture.puzzle_hack[4], x + h / 3, y + h / 4, w, h, null);
		drawHitbox(g);
	}

	public void open() {
		refreshPuzzle();

		for (int i = 0; i < docs; i++) {
			if (!processors[i].isDeleted())
				HandlerObject.getInstance().addObject(processors[i]);
		}
		HandlerObject.getInstance().addObject(previousback);

	}

	@Override
	public void refresh() {
	}

}
