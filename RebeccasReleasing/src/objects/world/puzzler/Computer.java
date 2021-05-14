package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.toverify.Todo;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.hack.PuzzleHack;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

import objects.GameObject;
import objects.characters.living.LivingObject;

@Todo("redesign")
public class Computer extends GameObject implements IPuzzler {

	private EventListener eventOnVictory, eventOnDefeat;

	private DIFFICULTY difficulty;
	private boolean solved;

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
	}

	private BufferedImage paintingComputer() {

		BufferedImage img = null;
		int difficulty = getDifficulty().getLvl();

		if (!isSolved())
			img = texture.puzzler_computer[difficulty][0];
		else
			img = texture.puzzler_computer[difficulty][1];
		return img;
	}

	// collision

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

	@Override
	public void collision(LivingObject living) {

		if (!isSolved()) {

			if (hasToolLvl(Tool.KEY) || Game.isMultiToolMode())
				openPuzzle(living, this);
			else
				blockPass(living, this);
		} else
			blockPass(living, this);
	}

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleHack(this, getDifficulty());
	}

}
