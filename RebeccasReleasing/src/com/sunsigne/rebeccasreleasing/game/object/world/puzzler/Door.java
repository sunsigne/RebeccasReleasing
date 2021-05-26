package com.sunsigne.rebeccasreleasing.game.object.world.puzzler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.clickable.PuzzleKeyForward;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.AXIS;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Door extends GameObject implements IPuzzler {

	public Door(int x, int y, AXIS axis, DIFFICULTY difficulty) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y);

		this.axis = axis;
		this.difficulty = difficulty;
		setSize(axis);
	}

	////////// SIZE ////////////

	private AXIS axis;

	private void setSize(AXIS axis) {
		if (axis == AXIS.HORIZONTAL)
			w = 2 * Size.TILE;
		if (axis == AXIS.VERTICAL)
			h = 2 * Size.TILE;
	}

	////////// PUZZLE ////////////

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleKeyForward(this, getDifficulty());
	}

	private EventListener eventOnVictory, eventOnDefeat;

	@Override
	public EventListener getEventOnClose() {
		return solved ? eventOnVictory : eventOnDefeat;
	}

	@Override
	public void setEventOnClose(EventListener eventOnClose, boolean onVictory) {
		if (onVictory)
			this.eventOnVictory = eventOnClose;
		else
			this.eventOnDefeat = eventOnClose;
	}

	////////// PUZZLER ////////////

	private DIFFICULTY difficulty;
	private boolean solved;

	@Override
	public DIFFICULTY getDifficulty() {
		return difficulty;
	}

	@Override
	public void setDifficulty(DIFFICULTY difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public boolean isSolved() {
		return solved;
	}

	@Override
	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	////////// TICK ////////////

	@Override
	public void tick() {
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {

		BufferedImage img = paintingDoor();
		g.drawImage(img, x, y, w, h, null);
	}

	private BufferedImage paintingDoor() {

		BufferedImage img = null;
		int difficultyLvl = getDifficulty().getLvl();

		if (!isSolved()) {
			if (axis == AXIS.VERTICAL)
				img = texture.puzzler_door[difficultyLvl][0];
			if (axis == AXIS.HORIZONTAL)
				img = texture.puzzler_door[difficultyLvl][2];
		}

		else {
			if (axis == AXIS.VERTICAL)
				img = texture.puzzler_door[difficultyLvl][1];
			if (axis == AXIS.HORIZONTAL)
				img = texture.puzzler_door[difficultyLvl][3];
		}

		return img;
	}

	////////// COLLISION ////////////

	@Override
	public void collidingReaction(GameObject collidingObject) {

		if (!isSolved()) {

			if (collidingObject.isPlayer() && hasToolLvl(ToolBank.KEY))
				openPuzzle(collidingObject, this);
			else
				blockPass(collidingObject, this);
		}
	}
}
