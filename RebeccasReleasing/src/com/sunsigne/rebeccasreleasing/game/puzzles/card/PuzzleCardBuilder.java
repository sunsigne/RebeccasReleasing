package com.sunsigne.rebeccasreleasing.game.puzzles.card;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.card.object.CARDTYPE;
import com.sunsigne.rebeccasreleasing.game.puzzles.card.object.Card;
import com.sunsigne.rebeccasreleasing.game.puzzles.card.object.CardFolder;
import com.sunsigne.rebeccasreleasing.game.puzzles.card.object.CardObject;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.IFacing.FACING;
import objects.characters.CHARA;
import objects.characters.living.FoeObject;
import objects.world.puzzler.IPuzzler;

public abstract class PuzzleCardBuilder<T> extends Puzzle {

	private static CardObject[] card = new CardObject[5];
	protected static CardFolder attackFolder, defenseFolder;

	public PuzzleCardBuilder(IPuzzler puzzler, FoeObject[] multipleFoe, DIFFICULTY difficulty, boolean reversed) {
		super(STATE.PUZZLE, puzzler, multipleFoe, difficulty, false);
	}
	
	@SuppressWarnings("unchecked")
	protected T getCard(int number) {
		return (T) card[number];
	}

	protected CardObject createCard(int x, int y, CARDTYPE type) {
//		if (!isReversed())
			return new Card(x, y, type);
//		return new CardReversed(x, y, type);
	}

	@Override
	public void randomGeneration() {
		CARDTYPE[] randomType = randomTypeGeneration();

		card[0] = createCard(520, 925, randomType[0]);
		card[1] = createCard(670, 925, randomType[1]);
		card[2] = createCard(820, 925, randomType[2]);
		card[3] = createCard(970, 925, randomType[3]);
		card[4] = createCard(1120, 925, randomType[4]);

		randomOrderAttribution();
	}

	private void randomOrderAttribution() {

		int[] randomOrder = randomOrderGeneration(5);

		card[0].setOrderNum(randomOrder[0]);
		card[1].setOrderNum(randomOrder[1]);
		card[2].setOrderNum(randomOrder[2]);
		card[3].setOrderNum(randomOrder[3]);
		card[4].setOrderNum(randomOrder[4]);
	}

	private CARDTYPE[] randomTypeGeneration() {

		CARDTYPE[] type = new CARDTYPE[5];
		type[0] = CARDTYPE.ATTACK;
		type[1] = CARDTYPE.ATTACK;
		type[2] = CARDTYPE.ATTACK;
		type[3] = CARDTYPE.ATTACK;
		type[4] = CARDTYPE.ATTACK;

		float defenseChance = 0.4f;

		if (Math.random() < defenseChance)
			type[0] = CARDTYPE.DEFENSE;
		if (Math.random() < defenseChance)
			type[1] = CARDTYPE.DEFENSE;
		if (Math.random() < defenseChance)
			type[2] = CARDTYPE.DEFENSE;
		if (Math.random() < defenseChance)
			type[3] = CARDTYPE.DEFENSE;
		if (Math.random() < defenseChance)
			type[4] = CARDTYPE.DEFENSE;

		return type;
	}

	private int[] randomOrderGeneration(int currentNumofCard) {

		int[] randomOrder = new int[currentNumofCard];

		// creation of numbers from 1 to currentNumofCard
		LinkedList<Integer> numbers = new LinkedList<>();
		for (int i = 1; i < currentNumofCard + 1; i++) {
			numbers.add(i);
		}

		// shuffle of the numbers
		Random r = new Random();
		for (int i = 0; i < currentNumofCard; i++) {
			Collections.swap(numbers, i, r.nextInt(currentNumofCard));
		}

		// register of this new order into randomOrder.
		for (int i = 0; i < currentNumofCard; i++) {
			randomOrder[i] = numbers.get(0);
			numbers.remove(0);
		}

		return randomOrder;
	}

	@Override
	public void createPuzzle() {
		attackFolder = new CardFolder(FACING.LEFT, CHARA.FOE, CARDTYPE.ATTACK);
		defenseFolder = new CardFolder(FACING.RIGHT, CHARA.REBECCA, CARDTYPE.DEFENSE);

		HandlerObject.getInstance().addObject(attackFolder);
		HandlerObject.getInstance().addObject(defenseFolder);

		difficultyModification(() -> createThreeCard(), 1);
		difficultyModification(() -> createFiveCard(), 2, 3, 4, 5);
		difficultyModification(() -> imposeOrder(), 3, 4, 5);
		difficultyModification(() -> hideOneCard(false), 4);
		difficultyModification(() -> hideOneCard(true), 5);
	}

	private void createThreeCard() {
		card[4].setExist(false);
		HandlerObject.getInstance().addObject(card[3]);
		HandlerObject.getInstance().addObject(card[2]);
		HandlerObject.getInstance().addObject(card[1]);
		card[0].setExist(false);
	}

	private void createFiveCard() {
		HandlerObject.getInstance().addObject(card[4]);
		HandlerObject.getInstance().addObject(card[3]);
		HandlerObject.getInstance().addObject(card[2]);
		HandlerObject.getInstance().addObject(card[1]);
		HandlerObject.getInstance().addObject(card[0]);
	}

	private void imposeOrder() {
		attackFolder.setOrderNum(1);
		defenseFolder.setOrderNum(1);
	}

	private void hideOneCard(boolean twoInstead) {
		int random = new Random().nextInt(5);
		int random2 = new Random().nextInt(5);
		while (random == random2)
			random2 = new Random().nextInt(5);

		card[random].willHide();
		if (twoInstead)
			card[random2].willHide();
	}

	@Override
	public void render(Graphics g) {
		renderingFakeWall(g, texture.item[25]);
		colorRender(g, new Color(70, 70, 10, 240));

	}

	@Override
	public BufferedSound getSuccessSound() {
		return null;
	}

}
