package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.hack;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

// Yes, the whole running of thoses classes between each other
//is incredibly complexe... I'm a mad man !
public abstract class ProcessorObject extends PuzzleObject {

	protected PROCESSORID processorId;
	protected int col, row;
	protected boolean locked, deleted;
	public ProcessorBack myback;
	public ProcessorBack previousback;

	public ProcessorObject(int col, int row, PROCESSORID processorId) {
		super(Size.X0 + (col * 2 - 1) * Size.TILE_PUZZLE, Size.Y0 + (row * 2 - 1) * Size.TILE_PUZZLE);
		this.processorId = processorId;
		this.col = col;
		this.row = row;

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

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x + w / 4, y + h / 4, w, h);
	}

	public abstract void open();

	public abstract void refresh();

	public void refreshPuzzle() {
//		Puzzle puzzle = HandlerObject.getInstance().player.puzzle;

		HandlerObject.getInstance().clear(false, LAYER.WOLRD_GUI_PUZZLE);
		
//		HandlerObject.getInstance().addObject(puzzle.getTimer());
		HandlerObject.getInstance().addObject(PuzzleHack.virus);
	}

}
