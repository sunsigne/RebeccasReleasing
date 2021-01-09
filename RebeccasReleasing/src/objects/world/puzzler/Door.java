package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleKey;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;

import objects.OBJECTID;
import objects.characters.living.LivingObject;

@Todo("pour tuto : le joueur ne devrait pas se retrouver au pied de la porte en cas d'echec (risque de ne pas comprendre)")
public class Door extends PuzzlerObject {

	private boolean horizontal;

	public Door(int x, int y, boolean horizontal) {
		this(x, y, horizontal, DIFFICULTY.CYAN);
	}

	public Door(int x, int y, boolean horizontal, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.DOOR, difficulty);

		w = Size.TILE;
		h = Size.TILE;

		setHorizontal(horizontal);

	}

	// state

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
		drawDifficulty(g);
		drawHitbox(g);
	}

	private BufferedImage paintingDoor() {

		BufferedImage img = null;

		if (horizontal && !isSolved())
			img = texture.door[2];
		if (horizontal && isSolved())
			img = texture.door[3];
		if (!horizontal && !isSolved())
			img = texture.door[0];
		if (!horizontal && isSolved())
			img = texture.door[1];
		return img;
	}

	@Override
	public void collision(LivingObject living) {

		if (!isSolved()) {
			int current_key = World.gui.getCharacteristics().getTool(0).getNum();
			if (current_key >= getDifficulty().getNum())
				living.collisionDetector.collidingBehavior(true, this, () -> updatePuzzler(living, this));
			else 
				living.collisionDetector.collidingBehavior(true, this, null);
		}
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);

	}

	@Override
	protected Puzzle getPuzzle() {
		return new PuzzleKey(this, getDifficulty());
	}

}
