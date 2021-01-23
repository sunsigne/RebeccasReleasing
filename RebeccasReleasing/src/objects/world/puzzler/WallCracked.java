package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.bomb.clickable.PuzzleBomb;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.living.LivingObject;

public class WallCracked extends GameObject implements IPuzzler {

	private EventListener eventOnVictory, eventOnDefeat;
	
	private DIFFICULTY difficulty;
	private boolean solved;

	public WallCracked(int x, int y, DIFFICULTY difficulty) {
		super(true, x, y, OBJECTID.WALLCRACKED);

		this.difficulty = difficulty;
	}

	// state

	@Override
	public EventListener getEventOnClose() {
		if(solved) return eventOnVictory;
		else return eventOnDefeat;
	}

	@Override
	public void setEventOnClose(EventListener eventOnClose, boolean onVictory) {
		if(onVictory) this.eventOnVictory = eventOnClose;	
		else this.eventOnDefeat = eventOnClose;
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

	@Override
	public void tick() {

	}

	// behavior
	
	@Override
	public void render(Graphics g) {

		BufferedImage img = texture.puzzler_wallcracked[difficulty.getLvl()];
		if (!isSolved())
			g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}
	
	// collision

	@Override
	public Rectangle getBounds() {

		return new Rectangle(x, y, w, h);
	}

	@Override
	public void collision(LivingObject living) {

		if (!isSolved()) {

			if (hasToolLvl(Tool.BOMB))
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
