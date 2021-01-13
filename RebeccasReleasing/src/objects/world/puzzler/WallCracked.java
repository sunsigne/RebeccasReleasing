package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleBomb;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.displayer.Tool;
import objects.characters.living.LivingObject;

public class WallCracked extends GameObject implements IPuzzler {

	private boolean solved;
	private DIFFICULTY difficulty;

	public WallCracked(int x, int y, DIFFICULTY difficulty) {
		super(true, x, y, OBJECTID.WALLCRACKED);

		this.difficulty = difficulty;
	}

	// state

	@Override
	public boolean isSolved() {
		return solved;
	}

	@Override
	public void setSolved(boolean solved) {
		this.solved = solved;
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
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		BufferedImage img = texture.wallcracked[difficulty.getLvl()];
		if (!isSolved())
			g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

	@Override
	public void collision(LivingObject living) {

		if (!isSolved()) {

			if (hasToolLvl(Tool.KEY))
				openPuzzle(living, this);
			else
				blockPass(living, this);
		}
	}

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleBomb(this, getDifficulty());
	}

}
