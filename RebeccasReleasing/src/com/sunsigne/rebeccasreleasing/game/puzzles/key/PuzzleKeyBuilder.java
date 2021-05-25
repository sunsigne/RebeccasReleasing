
package com.sunsigne.rebeccasreleasing.game.puzzles.key;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyForward;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyObject;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyReversed;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.Lock;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.WallPuzzle;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public abstract class PuzzleKeyBuilder<T> extends Puzzle {

	public PuzzleKeyBuilder(IPuzzler puzzler, DIFFICULTY difficulty, boolean reversed) {
		super(STATE.PUZZLE, puzzler, difficulty, reversed);
		new GameCursor().hideCursor(true);
	}

	////////// OBJECTS ////////////

	private KeyObject key;

	@SuppressWarnings("unchecked")
	protected T getKey() {
		return (T) key;
	}

	protected KeyObject createKey(int x, int y) {
		if (isForward())
			return new KeyForward(x, y);
		return new KeyReversed(x, y);
	}

	private Lock lock;

	protected Lock getLock() {
		return lock;
	}

	////////// PUZZLE ////////////

	@Override
	protected void open() {
		createFrame();
		createPuzzle();
		difficultyModifications();
	}

	protected int getCol(int col) {
		return Size.X0 + col * Size.TILE_PUZZLE;
	}

	protected int getRow(int row) {
		return Size.Y0 + row * Size.TILE_PUZZLE;
	}

	protected void createFrame() {

		BufferedImage img = texture.decor_wall[3];
		HandlerObject handler = HandlerObject.getInstance();

		for (int col = 0; col < 13; col++) {
			handler.addObject(new WallPuzzle(getCol(col), getRow(0), img));
			handler.addObject(new WallPuzzle(getCol(col), getRow(7), img));
		}
		for (int row = 0; row < 8; row++) {
			handler.addObject(new WallPuzzle(getCol(0), getRow(row), img));
			handler.addObject(new WallPuzzle(getCol(13), getRow(row), img));
		}
	}

	protected void createPuzzle() {
		key = createKey(getCol(12), getRow(3));
		lock = new Lock(getCol(1), getRow(3));

		if (isForward()) {
			HandlerObject.getInstance().addObject(key);
		}
		HandlerObject.getInstance().addObject(lock);
	}

	protected void difficultyModifications() {
		difficultyModification(() -> randomWallGeneration(1), 1);
		difficultyModification(() -> randomWallGeneration(4), 2);
		difficultyModification(() -> randomWallGeneration(25), 3, 4, 5);
		difficultyModification(() -> key.setSpeed(16), 4, 5);
		difficultyModification(() -> lock.setInverseMouse(true), 5);
	}

	protected void randomWallGeneration(int numOfWall) {

		BufferedImage img = texture.decor_wall[3];
		HandlerObject handler = HandlerObject.getInstance();

		for (int wall = 0; wall < numOfWall; wall++) {
			int col = 2 + new Random().nextInt(10);
			int row = 1 + new Random().nextInt(6);

			handler.addObject(new WallPuzzle(getCol(col), getRow(row), img));
		}

		if (numOfWall > 5)
			createKeyPass();
	}

	protected void createKeyPass() {

		GameObject tempObject = null;
		HandlerObject handler = HandlerObject.getInstance();
		int row = 1 + new Random().nextInt(6);

		for (int col = 2; col < 12; col++) {

			do {
				handler.removeObject(tempObject);
				tempObject = handler.getObjectAtPos(false, LAYER.WOLRD_GUI_PUZZLE, getCol(col), getRow(row));
			} while (tempObject != null);
		}
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {
		Color green = new Color(15, 45, 10, 240);
		colorRender(g, green);
	}

	////////// SOUND ////////////

	@Override
	public SoundBank getSuccessSound() {
		if (isForward())
			return SoundBank.DOOR_OPEN;
		else
			return SoundBank.REVERSED_DOOR_OPEN;
	}

}
