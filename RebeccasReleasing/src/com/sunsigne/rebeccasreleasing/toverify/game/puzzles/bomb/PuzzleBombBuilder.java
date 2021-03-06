
package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.object.BombForward;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.object.BombObject;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.object.BombReversed;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public abstract class PuzzleBombBuilder<T> extends Puzzle {

	private static BombObject[] bomb = new BombObject[4];

	public PuzzleBombBuilder(IPuzzler puzzler, DIFFICULTY difficulty, boolean reversed) {
		super(STATE.PUZZLE, puzzler, difficulty, reversed);

	}

	@SuppressWarnings("unchecked")
	protected T getBomb(int number) {
		return (T) bomb[number];
	}

	protected BombObject createBomb(int x, int y) {
		if (!isForward())
			return new BombForward(x, y, getDifficulty());
		return new BombReversed(x, y, getDifficulty());
	}

	@Override
	public void randomGenerationTODELETE() {

		bomb[0] = createBomb(setCol(1), setRandomLine());
		bomb[1] = createBomb(setCol(2), setRandomLine());
		bomb[2] = createBomb(setCol(3), setRandomLine());
		bomb[3] = createBomb(setCol(4), setRandomLine());
	}

	private int setCol(int col) {
		return Size.X0 + (-3 + 6 * col) * (Size.TILE_PUZZLE / 2);
	}

	private int setRandomLine() {
		return Size.Y0 + (1 + new Random().nextInt(5)) * Size.TILE_PUZZLE;
	}

	@Override
	public void createPuzzleTODELETE() {

		HandlerObject.getInstance().addObject(bomb[0]);
		HandlerObject.getInstance().addObject(bomb[1]);
		HandlerObject.getInstance().addObject(bomb[2]);
		HandlerObject.getInstance().addObject(bomb[3]);

	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(50, 10, 10, 240));
		renderingFakeWall(g, texture.decor_wall[0]);
	}

	@Override
	public SoundBank getSuccessSound() {

		if (!isForward())
			return SoundBank.EXPLOSION_BIG;
		else
			return SoundBank.REVERSED_EXPLOSION_BIG;
	}

}
