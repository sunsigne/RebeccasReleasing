package objects.puzzle.hack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleHack;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class ProcessorFolder extends ProcessorObject {

	private ProcessorObject[] processors;
	private int docs;
	private String name;
	private int nameGap;
	private boolean system;

	public ProcessorFolder(int col, int row, int nameGap, String name, ProcessorObject... args) {
		super(col, row, PROCESSORID.FOLDER);

		this.name = name;
		this.nameGap = nameGap;

		processors = new ProcessorObject[args.length];
		for (int i = 0; i < args.length; i++) {
			processors[i] = args[i];
			docs = args.length;
		}
		myback = new ProcessorBack(previousback, args);
		actionLocker();
	}

	public ProcessorFolder(ProcessorObject... args) {
		this(1, 1, 0, null, args);
		system = true;
	}

	public void refresh() {
		myback = new ProcessorBack(previousback, processors);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font(Font.DIALOG_INPUT, 2, 45);
		g.setFont(font);
		g.setColor(Color.white);

		if (system) {
			g.drawString("system", x + Size.TILE_PUZZLE / 2 - 20, y + 2 * Size.TILE_PUZZLE - 10);
			g.drawImage(texture.hack[0], x + w / 4, y + h / 4, w, h, null);
		} else {
			g.drawString(name, x + nameGap + Size.TILE_PUZZLE / 4 - 15, y + 2 * Size.TILE_PUZZLE - 20);
			g.drawImage(texture.hack[4], x + w / 4, y + h / 4, w, h, null);
		}

		if (isLocked())
			g.drawImage(texture.hack[9], x + w / 2, y + h / 2, w / 2, h / 2, null);
		drawHitbox(g);
	}

	public void open() {
		PuzzleHack.refreshPuzzle();

		for (int i = 0; i < docs; i++) {
			processors[i].previousback = myback;
			processors[i].refresh();
			if (!processors[i].isDeleted())
				HandlerObject.getInstance().addObject(processors[i]);
		}

		HandlerObject.getInstance().addObject(previousback);

	}

	// locker

	public void actionLocker() {
		for (int i = 0; i < docs; i++) {
			if (processors[i].getProcessorID() == PROCESSORID.LOCKER) {
				ProcessorLocker locker = (ProcessorLocker) processors[i];
				int rad = new Random().nextInt(docs);
				while (rad == i)
					rad = new Random().nextInt(docs);
				locker.locking(processors[rad]);
			}
		}
	}

}
