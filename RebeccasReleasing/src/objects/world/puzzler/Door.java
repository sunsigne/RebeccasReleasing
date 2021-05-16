package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.key.clickable.PuzzleKey;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

import objects.GameObject;
import objects.characters.living.LivingObject;

public class Door extends GameObject implements IPuzzler {

	private EventListener eventOnVictory, eventOnDefeat;

	private DIFFICULTY difficulty;
	private boolean solved;

	private boolean horizontal;

	public Door(int x, int y, boolean horizontal, DIFFICULTY difficulty) {
		super(true, 0, x, y, OBJECTID.DOOR);

		this.difficulty = difficulty;
		setHorizontal(horizontal);
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

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
		if (horizontal)
			w = 2 * Size.TILE;
		if (!horizontal)
			h = 2 * Size.TILE;
	}

	// behavior

	@Override
	public void tick() {
	}

	// design

	@Override
	public void render(Graphics g) {

		BufferedImage img = paintingDoor();
		g.drawImage(img, x, y, w, h, null);
	}

	private BufferedImage paintingDoor() {

		BufferedImage img = null;
		int difficulty = getDifficulty().getLvl();

		if (!horizontal && !isSolved())
			img = texture.puzzler_door[difficulty][0];
		if (!horizontal && isSolved())
			img = texture.puzzler_door[difficulty][1];
		if (horizontal && !isSolved())
			img = texture.puzzler_door[difficulty][2];
		if (horizontal && isSolved())
			img = texture.puzzler_door[difficulty][3];

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
		}
	}

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleKey(this, getDifficulty());
	}

}
