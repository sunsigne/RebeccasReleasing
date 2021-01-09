package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleHack;
import com.sunsigne.rebeccasreleasing.main.Size;

import objects.OBJECTID;

public class Computer extends PuzzlerObject {

	public  Computer(int x, int y) {
		this(x, y, DIFFICULTY.CYAN);
	}
	
	public Computer(int x, int y, DIFFICULTY difficulty) {
		super(x, y + Size.TILE / 64, OBJECTID.COMPUTER, difficulty);

		// to change
		w = Size.TILE + Size.TILE / 2;
		h = Size.TILE + Size.TILE / 2;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

		if (!isSolved())
			g.drawImage(texture.item[33], x, y, Size.TILE + Size.TILE / 2, Size.TILE + Size.TILE / 2, null);
		else
			g.drawImage(texture.item[34], x, y, Size.TILE + Size.TILE / 2, Size.TILE + Size.TILE / 2, null);
		
		drawDifficulty(g);
		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, Size.TILE + Size.TILE / 2, Size.TILE + Size.TILE / 2);
	}

	@Override
	protected Puzzle getPuzzle() {
		if (!isSolved())
			return new PuzzleHack(this, getDifficulty());
		else
			return null;
	}

}
