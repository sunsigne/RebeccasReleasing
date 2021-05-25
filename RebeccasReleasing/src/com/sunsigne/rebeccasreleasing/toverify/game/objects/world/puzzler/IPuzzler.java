package com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.ressources.tools.BufferedTool;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.living.PlayerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;

public interface IPuzzler extends ICollisionReaction {

	public DIFFICULTY getDifficulty();

	public void setDifficulty(DIFFICULTY difficulty);

	public boolean isSolved();

	public void setSolved(boolean solved);

	public EventListener getEventOnClose();

	public void setEventOnClose(EventListener eventOnClose, boolean onVictory);

	public Puzzle getPuzzle();

	public default boolean hasToolLvl(ToolBank toolBank) {
		if (Conductor.getDebugMode().getMultiToolMode().getState())
			return true;
		return hasToolLvl(getDifficulty(), toolBank);
	}

	public default boolean hasToolLvl(DIFFICULTY difficulty, ToolBank toolBank) {
		if (Conductor.getDebugMode().getMultiToolMode().getState())
			return true;
		boolean toolhasLvl = false;
		BufferedTool current_tool = World.gui.getTool(toolBank);
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
