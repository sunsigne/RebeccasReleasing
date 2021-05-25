package com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.lazer.clickable.PuzzleLazer;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Lazer extends GameObject implements IPuzzler {

	public Lazer(int x, int y, Facing facing, DIFFICULTY difficulty) {
		super(true, LAYER.WOLRD_GUI_PUZZLE, x, y, OBJECTID.DELETE);

		this.facing = facing;
		this.difficulty = difficulty;
		setSize(facing);
	}

	////////// SIZE ////////////

	private Facing facing;

	private void setSize(Facing facing) {
		if (facing.isHorizontal()) {
			h = Size.TILE / 3;
			miniY = Size.TILE / 3;
		}
		if (!facing.isHorizontal()) {
			w = Size.TILE / 3;
			miniX = Size.TILE / 3;
		}
	}

	////////// PUZZLE ////////////

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleLazer(this, getDifficulty());
	}

	private EventListener eventOnVictory, eventOnDefeat;

	@Override
	public EventListener getEventOnClose() {
		return solved ? eventOnVictory : eventOnDefeat;
	}

	@Override
	public void setEventOnClose(EventListener eventOnClose, boolean onVictory) {
		if (onVictory)
			this.eventOnVictory = eventOnClose;
		else
			this.eventOnDefeat = eventOnClose;
	}

	////////// PUZZLER ////////////

	private DIFFICULTY difficulty;
	private boolean solved;

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

		boolean flag = false;
		if (this.solved != solved)
			flag = true;

		this.solved = solved;

		if (flag)
			updateNeighbors();
	}

	private GameObject getObjectAtPos(int x, int y) {
		return HandlerObject.getInstance().getObjectAtPos(true, getLayer(), x, y);
	}

	private void updateNeighbors() {

		GameObject[] neighbors = new GameObject[2];

		neighbors[0] = facing.isHorizontal() ? getObjectAtPos(x - Size.TILE, y) : getObjectAtPos(x, y - Size.TILE);
		neighbors[1] = facing.isHorizontal() ? getObjectAtPos(x + Size.TILE, y) : getObjectAtPos(x, y + Size.TILE);

		Lazer[] lazers = new Lazer[2];

		for (int i = 0; i < 2; i++) {
			if (neighbors[i] != null) {
				if (neighbors[i] instanceof Lazer) {
					lazers[i] = (Lazer) neighbors[i];
					lazers[i].setSolved(solved);
				}
			}
		}
	}

	////////// TICK ////////////

	@Override
	public void tick() {
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {

		BufferedImage img = paintingLazer();
		g.drawImage(img, x, y, Size.TILE, Size.TILE, null);
	}

	private BufferedImage paintingLazer() {

		BufferedImage img = null;
		int difficultyLvl = getDifficulty().getLvl();

		if (isSolved())
			img = texture.puzzler_lazer[difficultyLvl][facing.getNum()][1];
		else
			img = texture.puzzler_lazer[difficultyLvl][facing.getNum()][0];

		return img;
	}

	////////// COLLISION ////////////

	@Override
	public void collidingReaction(GameObject collidingObject) {

		if (!isSolved()) {

			if (collidingObject.isPlayer() && hasToolLvl(ToolBank.PLIERS))
				openPuzzle(collidingObject, this);
			else {
				if (collidingObject.isPlayer())
					collidingReaction(collidingObject, true, this, () -> pushPlayer());
				else
					blockPass(collidingObject, this);
			}
		}
	}

	private void pushPlayer() {

		int velX = HandlerObject.getInstance().getPlayer().getVelX();
		int velY = HandlerObject.getInstance().getPlayer().getVelY();
		int direction = 0;

		if (!facing.isHorizontal()) {
			if (velX > 0)
				direction = DIRECTION.LEFT.getNum();
			else
				direction = DIRECTION.RIGHT.getNum();
		}

		else {
			if (velY > 0)
				direction = DIRECTION.UP.getNum();
			else
				direction = DIRECTION.DOWN.getNum();
		}

		HandlerObject.getInstance().getPlayer().pushed(direction);
	}

}
