package com.sunsigne.rebeccasreleasing.game.object.world.puzzler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.clickable.PuzzleBomb;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

import objects.world.puzzler.IPuzzler;

public class WallCracked extends GameObject implements IPuzzler {

	public WallCracked(int x, int y, DIFFICULTY difficulty) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y, OBJECTID.WALLCRACKED);

		this.difficulty = difficulty;
	}

	////////// PUZZLE ////////////

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleBomb(this, getDifficulty());
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

		int difficultyLvl = getDifficulty().getLvl();
		BufferedImage img = texture.puzzler_wallcracked[difficultyLvl];
		if (!isSolved())
			g.drawImage(img, x, y, w, h, null);
	}

	////////// COLLISION ////////////

	@Override
	public void collidingReaction(GameObject collidingObject) {

		if (!isSolved()) {

			if (collidingObject.isPlayer() && hasToolLvl(Tool.BOMB))
				openPuzzle(collidingObject, this);
			else
				blockPass(collidingObject, this);
		}
	}
}
