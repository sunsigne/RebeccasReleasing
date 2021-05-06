
package com.sunsigne.rebeccasreleasing.game.puzzles.lazer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.bomb.object.Bomb;
import com.sunsigne.rebeccasreleasing.game.puzzles.bomb.object.BombObject;
import com.sunsigne.rebeccasreleasing.game.puzzles.bomb.object.BombReversed;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object.WireObject;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.world.puzzler.IPuzzler;

public abstract class PuzzleLazerBuilder extends Puzzle {

//	private static BombObject[] bomb = new BombObject[4];
	private static WireObject [] wire = new WireObject[2];;

	public PuzzleLazerBuilder(IPuzzler puzzler, DIFFICULTY difficulty, boolean reversed) {
		super(STATE.PUZZLE, puzzler, difficulty, reversed);

	}

//	@SuppressWarnings("unchecked")
	protected WireObject getWire(int number) {
		return wire[number];
	}

/*	protected BombObject createLazer(int x, int y) {
		if (!isReversed())
			return new Bomb(x, y, getDifficulty());
		return new BombReversed(x, y, getDifficulty());
	}
*/
	@Override
	public void randomGeneration() {
/*
		bomb[0] = createBomb(setCol(1), setRandomLine());
		bomb[1] = createBomb(setCol(2), setRandomLine());
		bomb[2] = createBomb(setCol(3), setRandomLine());
		bomb[3] = createBomb(setCol(4), setRandomLine());
*/	}


	@Override
	public void createPuzzle() {

		wire [0] = new WireObject(500, 80, DIFFICULTY.CYAN);
		wire [1] = new WireObject(700, 80, DIFFICULTY.CYAN);
  		HandlerObject.getInstance().addObject(wire [0]);
  		HandlerObject.getInstance().addObject(wire [1]);
/*		HandlerObject.getInstance().addObject(bomb[0]);
		HandlerObject.getInstance().addObject(bomb[1]);
		HandlerObject.getInstance().addObject(bomb[2]);
		HandlerObject.getInstance().addObject(bomb[3]);
*/
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(70, 130, 130, 240));
		renderingFakeWall(g, texture.decor_wall[5]);
	}

	@Override
	public BufferedSound getSuccessSound() {

		if (!isReversed())
			return SoundBank.getSound(SoundBank.explosion_big);
		else
			return SoundBank.getSound(SoundBank.r_explosion_big);
	}

}
