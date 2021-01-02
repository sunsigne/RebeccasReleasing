package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleSearch;
import com.sunsigne.rebeccasreleasing.main.Size;

import objects.OBJECTID;

@Todo("à redesinger absoluement")
public class Case extends PuzzlerObject {

	public Case(int x, int y) {
		super(x, y, OBJECTID.CASE);

		w = Size.TILE;
		h = Size.TILE * 2;
	}

	// state

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		if (!isSolved()) {
			g.drawImage(texture.item[21], x, y, Size.TILE, Size.TILE, null);
			g.drawImage(texture.item[22], x, y + Size.TILE, Size.TILE, Size.TILE, null);
		} else {
			g.drawImage(texture.item[23], x, y, Size.TILE, Size.TILE, null);
			g.drawImage(texture.item[24], x, y + Size.TILE, Size.TILE, Size.TILE, null);
		}

		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);

	}

	@Override
	protected Puzzle getPuzzle() {
		if (!isSolved())
			return new PuzzleSearch(this);
		else
			return null;
	}

}
