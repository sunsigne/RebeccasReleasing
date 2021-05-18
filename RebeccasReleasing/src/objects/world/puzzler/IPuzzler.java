package objects.world.puzzler;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

import objects.characters.living.PlayerObject;

public interface IPuzzler extends ICollisionReaction {

	public DIFFICULTY getDifficulty();

	public void setDifficulty(DIFFICULTY difficulty);

	public boolean isSolved();

	public void setSolved(boolean solved);

	public EventListener getEventOnClose();

	public void setEventOnClose(EventListener eventOnClose, boolean onVictory);

	public Puzzle getPuzzle();

	public default boolean hasToolLvl(int toolnum) {
		if (Game.getMultiToolMode().getState())
			return true;
		return hasToolLvl(getDifficulty(), toolnum);
	}

	public default boolean hasToolLvl(DIFFICULTY difficulty, int toolnum) {
		if (Game.getMultiToolMode().getState())
			return true;
		boolean toolhasLvl = false;
		Tool current_tool = World.gui.getTool(toolnum);
		int current_tool_lvl = current_tool.getCurrentLvl();
		if (current_tool_lvl >= difficulty.getLvl())
			toolhasLvl = true;
		return toolhasLvl;
	}

	public default void openPuzzle(GameObject collidingObject, GameObject currentObject) {
		collidingReaction(collidingObject, true, currentObject, () -> updatePuzzler(collidingObject));
	}

	public default void updatePuzzler(GameObject collidingObject) {
		if (collidingObject.isPlayer()) {

			World.stunAllFoes();
			if (!HandlerObject.getInstance().getPlayer().isTasking()
					&& ((PlayerObject) collidingObject).isPlayerActive() && Conductor.getState() != STATE.CHATTING) {
				HandlerObject.getInstance().getPlayer().setTasking(true);
				HandlerObject.getInstance().getPlayer().puzzle = getPuzzle();
			} else
				verify();
		}
	}

	private void verify() {
		if (Conductor.getState() == STATE.LEVEL && !HandlerObject.getInstance().getPlayer().isMotionless())
			HandlerObject.getInstance().getPlayer().loadBasicState();
	}

}
