package com.sunsigne.rebeccasreleasing.game.object.world.puzzler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.search.clickable.PuzzleSearch;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Case extends GameObject implements IPuzzler {

	public Case(int x, int y, DIFFICULTY difficulty) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y);

		this.difficulty = difficulty;
		h = Size.TILE * 2;
	}

	////////// PUZZLE ////////////

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleSearch(this, getDifficulty());
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

		BufferedImage img = paintingCase();
		g.drawImage(img, x, y, w, h, null);
	}

	private BufferedImage paintingCase() {

		BufferedImage img = null;
		int difficultyLvl = getDifficulty().getLvl();

		if (isSolved())
			img = texture.puzzler_case[difficultyLvl][1];
		else
			img = texture.puzzler_case[difficultyLvl][0];

		return img;
	}

	////////// COLLISION ////////////

	@Override
	public void collidingReaction(GameObject collidingObject) {

		if (!isSolved()) {

			if (collidingObject.isPlayer() && hasToolLvl(ToolBank.GLASS))
				openPuzzle(collidingObject, this);
			else
				blockPass(collidingObject, this);
		}
		else
			blockPass(collidingObject, this);
	}

}
