
package com.sunsigne.rebeccasreleasing.game.puzzles.lazer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object.ColorAnswer;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object.ColorEnigma;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object.ColorEnigmaBank;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object.WIRECOLOR;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object.WireObject;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.world.puzzler.IPuzzler;

public abstract class PuzzleLazerBuilder extends Puzzle {

//	private static BombObject[] bomb = new BombObject[4];
	protected static final int NUMBEROFWIRES = 4;
	private static WireObject[] wire = new WireObject[6];
	private static ColorAnswer answer;
	private static int enigmaMinIndex = 0;
	private static int enigmaMaxIndex = 35;

	public PuzzleLazerBuilder(IPuzzler puzzler, DIFFICULTY difficulty, boolean reversed) {
		super(STATE.PUZZLE, puzzler, difficulty, reversed);

	}

//	@SuppressWarnings("unchecked")
	protected WireObject getWire(int number) {
		return wire[number];
	}

	protected ColorAnswer getColorAnswer() {
		return answer;
	}

//	protected BombObject createBomb(int x, int y) {
//		if (!isReversed())
//			return new Bomb(x, y, getDifficulty());
//		return new BombReversed(x, y, getDifficulty());
//	}

	@Override
	public void randomGeneration() {

		int x0 = 450 + Size.TILE_PUZZLE * 4;
		int y0 = 160 + Size.TILE_PUZZLE * 3;

		difficultyModifications();

		answer = new ColorAnswer(x0, y0, randomEnigma(enigmaMinIndex, enigmaMaxIndex));

		creatingWires();
		shuffleWires(NUMBEROFWIRES);
	}

	private ColorEnigma randomEnigma(int enigmaMinIndex, int enigmaMaxIndex) {
		int rad = enigmaMinIndex + new Random().nextInt(enigmaMaxIndex + 1 - enigmaMinIndex);
		return ColorEnigmaBank.index[rad];
	}

	private void difficultyModifications() {

		difficultyModification(() -> {
			enigmaMinIndex = 0;
			enigmaMaxIndex = 2;
		}, 1);

		difficultyModification(() -> {
			enigmaMinIndex = 3;
			enigmaMaxIndex = 8;
		}, 2);

		difficultyModification(() -> {
			enigmaMinIndex = 12;
			enigmaMaxIndex = 17;
		}, 3);

		difficultyModification(() -> {
			enigmaMinIndex = 24;
			enigmaMaxIndex = 35;
		}, 4);

		difficultyModification(() -> {
			enigmaMinIndex = 18;
			enigmaMaxIndex = 23;
		}, 5);
	}

	private void creatingWires() {

		int x0 = 352;
		int y0 = 160;

		wire[0] = new WireObject(x0, y0, WIRECOLOR.RED);
		wire[1] = new WireObject(x0, y0, WIRECOLOR.ORANGE);
		wire[2] = new WireObject(x0, y0, WIRECOLOR.YELLOW);
		wire[3] = new WireObject(x0, y0, WIRECOLOR.GREEN);
		wire[4] = new WireObject(x0, y0, WIRECOLOR.BLUE);
		wire[5] = new WireObject(x0, y0, WIRECOLOR.PURPLE);

		for (int i = 0; i < 6; i++) {
			wire[i].setExist(false);
		}
	}

	private static WireObject getGoodWire() {
		for (int i = 0; i < 6; i++) {
			if (wire[i].getColor() == answer.getColor())
				return wire[i];
		}
		Conductor.fatalError(
				"An unknown error has occured : no match have been found between the color of wires and the expected answer");
		return null;
	}

	private static WireObject getRandomBadWire() {
		int rad = new Random().nextInt(6);
		while (wire[rad].getColor() == answer.getColor())
			rad = new Random().nextInt(6);
		return wire[rad];
	}

	public static void shuffleWires(int numberOfWires) {

		numberOfWires = numberOfWires < 1 ? 1 : numberOfWires;
		numberOfWires = numberOfWires > 5 ? 5 : numberOfWires;

		LinkedList<WireObject> wires = new LinkedList<>();
		WireObject tempWire = getRandomBadWire();

		wires.add(getGoodWire());

		// addition of n wires to a list
		for (int i = 0; i < numberOfWires - 1; i++) {
			while (wires.contains(tempWire))
				tempWire = getRandomBadWire();
			wires.add(tempWire);
		}

		// shuffle of the list
		Random r = new Random();
		for (int i = 0; i < numberOfWires; i++) {
			Collections.swap(wires, i, r.nextInt(numberOfWires));
		}

		// shift of wires
		for (int i = 0; i < numberOfWires; i++) {
			wire[i] = wires.get(i);
			wire[i].setX(wire[i].getX() + Size.TILE_PUZZLE * i);
		}
	}

	@Override
	public void createPuzzle() {

		HandlerObject.getInstance().addObject(answer);
		for (int i = 0; i < NUMBEROFWIRES; i++) {
			wire[i].setExist(true);
			HandlerObject.getInstance().addObject(wire[i]);
		}
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(70, 130, 130, 240));
		renderingFakeWall(g, texture.decor_wall[5]);
	}

	@Override
	public BufferedSound getSuccessSound() {

		if (!isReversed())
			return SoundBank.getSound(SoundBank.nope);
		else
			return SoundBank.getSound(SoundBank.nope);
	}

}
