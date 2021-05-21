package com.sunsigne.rebeccasreleasing.game.object.world.puzzler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.hack.PuzzleHack;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

import objects.world.puzzler.IPuzzler;

public class Computer extends GameObject implements IPuzzler {

	public Computer(int x, int y, DIFFICULTY difficulty) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y + Size.TILE / 64, OBJECTID.COMPUTER);

		this.difficulty = difficulty;
		setSize();
	}

	////////// SIZE ////////////

	private void setSize() {
		w = Size.TILE + Size.TILE / 2;
		h = Size.TILE + Size.TILE / 2;
	}

	////////// PUZZLE ////////////

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleHack(this, getDifficulty());
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

		BufferedImage img = paintingComputer();
		g.drawImage(img, x, y, w, h, null);
	}

	private BufferedImage paintingComputer() {

		BufferedImage img = null;
		int difficultyLvl = getDifficulty().getLvl();

		if (isSolved())
			img = texture.puzzler_computer[difficultyLvl][1];
		else
			img = texture.puzzler_computer[difficultyLvl][0];

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
		} else
			blockPass(collidingObject, this);
	}
}
