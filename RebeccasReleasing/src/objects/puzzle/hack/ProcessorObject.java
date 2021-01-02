package objects.puzzle.hack;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.OBJECTID;
import objects.puzzle.PuzzleObject;

public abstract class ProcessorObject extends PuzzleObject {

	protected PROCESSORID processorId;
	protected int j, k;
	protected boolean locked, deleted;
	public ProcessorBack myback;
	public ProcessorBack previousback;

	public ProcessorObject(int j, int k, PROCESSORID processorId) {
		super(Size.X0 + (j * 2 - 1) * Size.TILE_PUZZLE, Size.Y0 + (k * 2 - 1) * Size.TILE_PUZZLE, OBJECTID.PROCESSOR);
		this.processorId = processorId;
		this.j = j;
		this.k = k;

		w = 4 * Size.TILE_PUZZLE / 3;
		h = 4 * Size.TILE_PUZZLE / 3;
	}

	// identity

	public void setProcessorID(PROCESSORID processorId) {
		this.processorId = processorId;
	}

	public PROCESSORID getProcessorID() {
		return processorId;
	}

	// state

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	protected void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isLocked() {
		return locked;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void delete() {
		setDeleted(true);
		HandlerObject.getInstance().removeObject(this);
	}

	// position

	public void setJ(int j) {
		this.j = j;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getJ() {
		return j;
	}

	public int getK() {
		return k;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		drawHitbox(g);
	}
		
	@Override
	public Rectangle getBounds() {

		return new Rectangle(x + w / 4, y + h / 4, w, h);
	}

	public abstract void open();

	public abstract void refresh();

}
