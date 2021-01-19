package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.search.PuzzleSearch;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.living.LivingObject;

@Todo("redesign")
public class Case extends GameObject implements IPuzzler {

	private EventListener eventOnVictory, eventOnDefeat;

	private DIFFICULTY difficulty;
	private boolean solved;

	public Case(int x, int y) {
		this(x, y, DIFFICULTY.CYAN);
	}

	public Case(int x, int y, DIFFICULTY difficulty) {
		super(true, x, y, OBJECTID.CASE);

		this.difficulty = difficulty;

		w = Size.TILE;
		h = Size.TILE * 2;
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

		BufferedImage img = paintingCase();
		g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	private BufferedImage paintingCase() {

		BufferedImage img = null;
		int difficulty = getDifficulty().getLvl();

		if (!isSolved())
			img = texture.puzzler_case[difficulty][0];
		else
			img = texture.puzzler_case[difficulty][1];
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

			if (hasToolLvl(Tool.KEY))
				openPuzzle(living, this);
		} else
			blockPass(living, this);
	}

	@Override
	public Puzzle getPuzzle() {

		return new PuzzleSearch(this, getDifficulty());

	}

}
