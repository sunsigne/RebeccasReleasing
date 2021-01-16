package com.sunsigne.rebeccasreleasing.game.puzzles.normal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.IPuzzler;

import objects.characters.living.FoeObject;
import objects.puzzle.FakeWallPuzzle;
import objects.puzzle.GameTimer;
import objects.puzzle.card.Card;
import objects.puzzle.card.CardFolder;
import objects.puzzle.card.CardType;

@Todo("pour tuto : simplifier le jeu ? Il doit être plus instinctif")
public class PuzzleCard extends Puzzle {

	private static final int NUMOFCARD = 5;
	private static Card[] card = new Card[NUMOFCARD];
	private static CardFolder attackFolder, defenseFolder;

	public PuzzleCard(IPuzzler puzzler, FoeObject[] multipleFoe, DIFFICULTY difficulty) {
		super(STATE.PUZZLECARD, puzzler, multipleFoe, difficulty);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new FakeWallPuzzle(Size.X0, Size.Y0, FakeWallPuzzle.WALLTYPE.CARD));
		HandlerObject.getInstance().addObject(new GameTimer(GameTimer.TIME, () -> close()));
	}

	@Override
	public void randomGeneration() {

		CardType[] randomType = randomTypeGeneration();

		int lvl = getDifficulty().getLvl();
		int[] randomOrder = new int[NUMOFCARD];
		if (lvl >= 3)
			randomOrder = randomOrderGeneration(NUMOFCARD);

		for (int i = 0; i < NUMOFCARD; i++) {

			card[i] = new Card(520 + i * 150, 925, randomType[i]);
			if (lvl >= 3)
				card[i].setOrderNum(randomOrder[i]);
		}
	}

	private CardType[] randomTypeGeneration() {
		CardType[] type = new CardType[NUMOFCARD];
		double[] r = new double[NUMOFCARD];
		float defenseChance = 0.4f;

		for (int i = 0; i < NUMOFCARD; i++) {
			// creation of 5 attack card
			type[i] = CardType.ATTACK;
			r[i] = Math.random();
			// 40% of them are turned into defense card
			if (r[i] < defenseChance)
				type[i] = CardType.DEFENSE;
		}
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
		attackFolder = new CardFolder(1300, 150, CardType.ATTACK);
		defenseFolder = new CardFolder(215, 150, CardType.DEFENSE);

		HandlerObject.getInstance().addObject(attackFolder);
		HandlerObject.getInstance().addObject(defenseFolder);

		switch (getDifficulty()) {
		case RED:
			hideOneCard(true);
			imposeOrder();
			createFiveCard();
			break;
		case ORANGE:
			hideOneCard(false);
		case YELLOW:
			imposeOrder();
		case GREEN:
			createFiveCard();
			break;
		case CYAN:
			createThreeCard();
			break;

		default:
			break;

		}
	}

	private void hideOneCard(boolean twoInstead) {
		int random = new Random().nextInt(NUMOFCARD);
		int random2 = new Random().nextInt(NUMOFCARD);
		while (random == random2)
			random2 = new Random().nextInt(NUMOFCARD);

		card[random].willHide();
		if(twoInstead) card[random2].willHide();
	}

	private void imposeOrder() {
		attackFolder.setOrderNum(1);
		defenseFolder.setOrderNum(1);
	}

	private void createFiveCard() {
		HandlerObject.getInstance().addObject(card[4]);
		HandlerObject.getInstance().addObject(card[3]);
		HandlerObject.getInstance().addObject(card[2]);
		HandlerObject.getInstance().addObject(card[1]);
		HandlerObject.getInstance().addObject(card[0]);
	}

	private void createThreeCard() {
		card[4].setExist(false);
		HandlerObject.getInstance().addObject(card[3]);
		HandlerObject.getInstance().addObject(card[2]);
		HandlerObject.getInstance().addObject(card[1]);
		card[0].setExist(false);
	}

	@Override
	public void mousePressed(int mx, int my) {

		for (int i = 0; i < NUMOFCARD; i++) {
			if (card[i].doesExist() && GameMouseListener.mouseOver(mx, my, card[i].getRect())) {
				card[i].setDragged(true);
				return;
			}
		}

	}

	@Override
	public void mouseReleased(int mx, int my) {

		for (int i = 0; i < NUMOFCARD; i++) {
			card[i].setDragged(false);
		}

		boolean winning = true;
		for (int i = 0; i < NUMOFCARD; i++) {

			if (card[i].doesExist()) {
				if (!card[i].isAboveRightFolder()) {
					if (!card[i].isAboveWrongFolder())
						card[i].resetPos();
					else
						close();

				} else if (card[i].isAboveRightFolder()) {
					card[i].playCard();
					card[i].setX(0);
					card[i].setY(0);
					updateFolderNum(card[i]);
				}
			}
			if (card[i].doesExist())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}

	private void updateFolderNum(Card card) {

		int currentOrderNum = card.getOrderNum();
		if (currentOrderNum != 0) {
			attackFolder.setOrderNum(currentOrderNum + 1);
			defenseFolder.setOrderNum(currentOrderNum + 1);
		}

	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(70, 70, 10, 240));

	}

	@Override
	public BufferedSound getSuccessSound() {
		return null;
	}

}
