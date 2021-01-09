package objects.world.puzzler;

import java.awt.Color;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public abstract class PuzzlerObject extends GameObject implements ICollision {

	private boolean solved;
	private DIFFICULTY difficulty;
	
	public PuzzlerObject(int x, int y, OBJECTID id, DIFFICULTY difficulty) {
		super(x, y, id);
		this.difficulty = difficulty;
	}

	@Override
	public boolean isCameraDependant() {
		return true;
	}
	
	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	
	public DIFFICULTY getDifficulty() {
		return difficulty;
	}

	
	@Override
	public void collision(LivingObject living) {

		living.collisionDetector.collidingBehavior(true, this, () -> updatePuzzler(living, this));
	}
	
	@Todo("Improve graphism, here are some basic layers to identify the difficulty")
	protected void drawDifficulty(Graphics g) {
		
		Color color = new Color(0,0,0,0);
		if(getDifficulty().getNum() == 1) color = new Color(0, 255, 255, 100);
		if(getDifficulty().getNum() == 2) color = new Color(0, 255, 0, 100);
		if(getDifficulty().getNum() == 3) color = new Color(255, 255, 0, 100);
		if(getDifficulty().getNum() == 4) color = new Color(255, 128, 0, 100);
		if(getDifficulty().getNum() == 5) color = new Color(255, 0, 0, 100);
		g.setColor(color);
		g.fillRect(x,  y,  w,  h);
	}


	protected abstract Puzzle getPuzzle();

	private void verify() {
		if (Conductor.getState() == STATE.LEVEL && !HandlerObject.getInstance().player.isMotionless())
			HandlerObject.getInstance().player.loadBasicState();
	}

	protected void updatePuzzler(LivingObject living, GameObject tempObject) {
		if (living.collisionDetector.isPlayer) {
			if (!HandlerObject.getInstance().player.isTasking()) {
				HandlerObject.getInstance().player.setTasking(true);
				HandlerObject.getInstance().player.puzzle = getPuzzle();
			} else
				verify();
		}

	}

}
