package com.sunsigne.rebeccasreleasing.toclean.redesign;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleHack;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.IPuzzler;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.displayer.Tool;
import objects.characters.living.LivingObject;

@Todo("redesign")
public class Computer extends GameObject implements IPuzzler {

	private EventListener eventOnVictory;
	private EventListener eventOnDefeat;

	private DIFFICULTY difficulty;
	private boolean solved;

	public Computer(int x, int y) {
		this(x, y, DIFFICULTY.CYAN);
	}

	public Computer(int x, int y, DIFFICULTY difficulty) {
		super(true, x, y + Size.TILE / 64, OBJECTID.COMPUTER);

		this.difficulty = difficulty;
		// to change
		w = Size.TILE + Size.TILE / 2;
		h = Size.TILE + Size.TILE / 2;
	}

	// state

	@Override
	public EventListener getEventOnClose() {
		if (solved)
			return eventOnVictory;
		else
			return eventOnDefeat;
	}

	@Override
	public void setEventOnClose(EventListener eventOnClose, boolean onVictory) {
		if (onVictory)
			this.eventOnVictory = eventOnClose;
		else
			this.eventOnDefeat = eventOnClose;
	}

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

	// behavior

	@Override
	public void tick() {

	}

	// design
	
	@Override
	public void render(Graphics g) {

		BufferedImage img = paintingComputer();
		g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	private BufferedImage paintingComputer() {
		
		BufferedImage img = null;
		if (!isSolved())
			img = texture.item[33];
		else
			img = texture.item[34];
		return img;
	}
/*	
	private BufferedImage paintingComputer() {

		BufferedImage img = null;
		int difficulty = getDifficulty().getLvl();

		if (!isSolved())
			img = texture.door[difficulty][2];
		if (isSolved())
			img = texture.door[difficulty][3];

		return img;
	}
*/
	// collision

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

	@Override
	public void collision(LivingObject living) {

		if (!isSolved()) {

			if (hasToolLvl(Tool.KEY))
				openPuzzle(living, this);
		} else
			blockPass(living, this);
	}

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleHack(this, getDifficulty());
	}

}
