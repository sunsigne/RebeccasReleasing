package objects.world.puzzler;

import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.onlyconductortorebuild.Conductor;

import objects.GameObject;
import objects.characters.collision.ICollision;
import objects.characters.living.LivingObject;

public interface IPuzzler extends ICollision {

	public EventListener getEventOnClose();

	public void setEventOnClose(EventListener eventOnClose, boolean onVictory);

	public DIFFICULTY getDifficulty();

	public void setDifficulty(DIFFICULTY difficulty);

	public boolean isSolved();

	public void setSolved(boolean solved);

	public default boolean hasToolLvl(int toolnum) {
		return hasToolLvl(getDifficulty(), toolnum);
	}

	public default boolean hasToolLvl(DIFFICULTY difficulty, int toolnum) {
		boolean toolhasLvl = false;
		Tool current_tool = World.gui.getCharacteristics().getTool(toolnum);
		int current_tool_lvl = current_tool.getCurrentLvl();
		if (current_tool_lvl >= difficulty.getLvl())
			toolhasLvl = true;
		return toolhasLvl;
	}

	public default void openPuzzle(LivingObject living, GameObject currentObject) {
		living.getCollisionDetector().collidingBehavior(true, currentObject, () -> updatePuzzler(living));
	}

	public default void blockPass(LivingObject living, GameObject currentObject) {
		living.getCollisionDetector().collidingBehavior(true, currentObject, null);
	}

	public default void updatePuzzler(LivingObject living) {
		if (living.isPlayer()) {

			World.stunAllFoes();
			if (!HandlerObject.getInstance().player.isTasking() && living.isPlayerActive()
					&& Conductor.getState() != STATE.CHATTING) {
				HandlerObject.getInstance().player.setTasking(true);
				HandlerObject.getInstance().player.puzzle = getPuzzle();
			} else
				verify();
		}
	}

	private void verify() {
		if (Conductor.getState() == STATE.LEVEL && !HandlerObject.getInstance().player.isMotionless())
			HandlerObject.getInstance().player.loadBasicState();
	}

	public Puzzle getPuzzle();

}
