package objects.puzzle.hack;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class ProcessorDesktop extends ProcessorObject {

	private ProcessorObject[] processors;
	private int docs;
	private boolean openned;

	public ProcessorDesktop(ProcessorObject... args) {
		super(0, 0, PROCESSORID.DESKTOP);

		processors = new ProcessorObject[args.length];
		for (int i = 0; i < args.length; i++) {
			processors[i] = args[i];
			docs = args.length;
		}
		myback = new ProcessorBack(null, args);
	}

	@Override
	public void refresh() {
		for (int i = 0; i < docs; i++) {
			myback = new ProcessorBack(previousback, processors[i]);
		}
	}

	@Override
	public void tick() {
		if (!openned) {
			open();	
			openned = true;
		}
	}

	@Override
	public void render(Graphics g) {
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	public void open() {
		openned = true;

		for (int i = 0; i < docs; i++) {
			processors[i].previousback = myback;
			processors[i].refresh();
			HandlerObject.getInstance().addObject(processors[i]);
		}
	}

}
