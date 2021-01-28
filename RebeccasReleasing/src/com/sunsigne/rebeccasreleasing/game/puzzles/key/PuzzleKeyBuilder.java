
package com.sunsigne.rebeccasreleasing.game.puzzles.key;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.WallPuzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.Key;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyObject;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.KeyReversed;
import com.sunsigne.rebeccasreleasing.game.puzzles.key.object.Lock;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.world.puzzler.IPuzzler;


public abstract class PuzzleKeyBuilder<T> extends Puzzle {

	private static KeyObject key;
	private static Lock lock;

	public PuzzleKeyBuilder(IPuzzler puzzler, DIFFICULTY difficulty, boolean reversed) {
		super(STATE.PUZZLE, puzzler, difficulty, reversed);
		GameCursor.hideCursor(true);
	}

	@SuppressWarnings("unchecked")
	protected T getKey() {
		return (T) key;
	}
	
	protected Lock getLock()
	{
		return lock;
	}

	protected KeyObject createKey(int x, int y) {
		if (!isReversed())
			return new Key(x, y);
		return new KeyReversed(x, y);
	}
	
	protected void replaceKey(T key)
	{
		PuzzleKeyBuilder.key = (KeyObject) key;
	}
	
	@Override
	public void createFrame() {
		for (int i = 0; i < 13; i++) {
			HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0 + i * Size.TILE_PUZZLE, Size.Y0, texture.decor_wall[3]));
			HandlerObject.getInstance()
					.addObject(new WallPuzzle(Size.X0 + i * Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE, texture.decor_wall[3]));
		}
		for (int i = 0; i < 8; i++) {
			HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0, Size.Y0 + i * Size.TILE_PUZZLE, texture.decor_wall[3]));
			HandlerObject.getInstance()
					.addObject(new WallPuzzle(Size.X0 + 13 * Size.TILE_PUZZLE, Size.Y0 + i * Size.TILE_PUZZLE, texture.decor_wall[3]));
		}

		HandlerObject.getInstance().addObject(getTimer());
	}

	@Override
	public void randomGeneration() {
		int j = 1;
		if (getDifficulty().getLvl() >= 2)
			j = 5;

		for (int i = 0; i < j; i++) {
			int col = 2 + new Random().nextInt(10);
			int row = 1 + new Random().nextInt(5);

			HandlerObject.getInstance()
					.addObject(new WallPuzzle(Size.X0 + col * Size.TILE_PUZZLE, Size.Y0 + row * Size.TILE_PUZZLE, texture.decor_wall[3]));
		}
	}

	@Override
	public void createPuzzle() {
		key = createKey(Size.X0 + 12 * Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE / 2);
		lock = new Lock(Size.X0 + Size.TILE_PUZZLE, Size.Y0 + 7 * Size.TILE_PUZZLE / 2);
		HandlerObject.getInstance().addObject(lock);
		if (!isReversed())
			HandlerObject.getInstance().addObject(key);
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(15, 45, 10, 240));
	}

	@Override
	public BufferedSound getSuccessSound() {
		return SoundBank.getSound(SoundBank.opening_door);
	}

}
