package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleBomb;
import com.sunsigne.rebeccasreleasing.main.Size;

import objects.OBJECTID;
import objects.characters.living.LivingObject;

public class WallCracked extends PuzzlerObject {

	public  WallCracked(int x, int y) {
		this(x, y, DIFFICULTY.CYAN);
	}	
	
	public WallCracked(int x, int y, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.WALLCRACKED, difficulty);

		w = Size.TILE;
		h = Size.TILE;
	}

	// state

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		if (!isSolved())
			g.drawImage(texture.item[31], x, y, w, h, null);
		
		drawDifficulty(g);
		drawHitbox(g);
	}
	
	@Override
	public void collision(LivingObject living) {

		if (!isSolved())
			living.collisionDetector.collidingBehavior(true, this, () -> updatePuzzler(living, this));
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

	@Override
	protected Puzzle getPuzzle() {
		return new PuzzleBomb(this, getDifficulty());
	}

	
}
