package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleKey;
import com.sunsigne.rebeccasreleasing.main.Size;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.displayer.Tool;
import objects.characters.living.LivingObject;

public class Door extends GameObject implements IPuzzler {

	private boolean solved;
	private DIFFICULTY difficulty;

	private boolean horizontal;

	public Door(int x, int y, boolean horizontal) {
		this(x, y, horizontal, DIFFICULTY.CYAN);
	}

	public Door(int x, int y, boolean horizontal, DIFFICULTY difficulty) {
		super(true, x, y, OBJECTID.DOOR);

		this.difficulty = difficulty;
		setHorizontal(horizontal);

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

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
		if (horizontal)
			w = 2 * Size.TILE;
		if (!horizontal)
			h = 2 * Size.TILE;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		BufferedImage img = paintingDoor();
		g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	private BufferedImage paintingDoor() {

		BufferedImage img = null;
		int difficulty = getDifficulty().getLvl();

		if (!horizontal && !isSolved())
			img = texture.door[difficulty][0];
		if (!horizontal && isSolved())
			img = texture.door[difficulty][1];
		if (horizontal && !isSolved())
			img = texture.door[difficulty][2];
		if (horizontal && isSolved())
			img = texture.door[difficulty][3];

		return img;
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
		return new PuzzleKey(this, getDifficulty());
	}

}
