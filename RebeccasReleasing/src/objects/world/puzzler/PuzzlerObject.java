package objects.world.puzzler;

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
	
	public PuzzlerObject(int x, int y, OBJECTID id) {
		super(x, y, id);
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
	
	@Override
	public void collision(LivingObject living) {

		living.collisionDetector.collidingBehavior(true, this, () -> updatePuzzler(living, this));
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
