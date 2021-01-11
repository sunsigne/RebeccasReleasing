package objects.world.puzzler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleBomb;
import com.sunsigne.rebeccasreleasing.main.Size;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.displayer.Tool;
import objects.characters.living.LivingObject;

public class WallCracked extends GameObject implements IPuzzler {

	private boolean solved;
	private DIFFICULTY difficulty;
	
	public  WallCracked(int x, int y) {
		this(x, y, DIFFICULTY.CYAN);
	}	
	
	public WallCracked(int x, int y, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.WALLCRACKED);

		this.difficulty = difficulty;
		
		w = Size.TILE;
		h = Size.TILE;
	}

	// state

	@Override
	public boolean isCameraDependant() {
		return true;
	}

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

		if (!isSolved())
			g.drawImage(texture.item[31], x, y, w, h, null);
		
		drawDifficulty(g);
		drawHitbox(g);
	}
	

	@Todo("Improve graphism, here are some basic layers to identify the difficulty")
	protected void drawDifficulty(Graphics g) {

		Color color = new Color(0, 0, 0, 0);
		if (getDifficulty().getNum() == 1)
			color = new Color(0, 255, 255, 100);
		if (getDifficulty().getNum() == 2)
			color = new Color(0, 255, 0, 100);
		if (getDifficulty().getNum() == 3)
			color = new Color(255, 255, 0, 100);
		if (getDifficulty().getNum() == 4)
			color = new Color(255, 128, 0, 100);
		if (getDifficulty().getNum() == 5)
			color = new Color(255, 0, 0, 100);
		g.setColor(color);
		g.fillRect(x, y, w, h);
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
