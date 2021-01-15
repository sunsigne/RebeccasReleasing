package com.sunsigne.rebeccasreleasing.game.puzzles.normal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.puzzle.FakeWallPuzzle;
import objects.puzzle.GameTimer;
import objects.puzzle.card.Card;
import objects.puzzle.card.CardFolder;
import objects.puzzle.card.CardType;
import objects.world.puzzler.IPuzzler;

@Todo("pour tuto : simplifier le jeu ? Il doit être plus instinctif")
public class PuzzleCard extends Puzzle {

	/*
	 * 3 - 5 card with order 4 - 5 card with order and a mystery (type and order
	 * shown by quickly replaced with question mark) 5 - 7 card with order and 2
	 * mystery (because i want the player to suffer !!
	 */
	private static final int NUMOFCARD = 7;
	private static Card[] card = new Card[NUMOFCARD];
	private static CardFolder attackFolder, defenseFolder;

	public PuzzleCard(IPuzzler puzzler, GameObject dualfoe, DIFFICULTY difficulty) {
		super(STATE.PUZZLECARD, puzzler, dualfoe, difficulty);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new FakeWallPuzzle(Size.X0, Size.Y0, FakeWallPuzzle.WALLTYPE.CARD));
		HandlerObject.getInstance().addObject(new GameTimer(999, () -> close()));
	}

	@Override
	public void randomGeneration() {

		CardType[] randomType = randomTypeGeneration();

		int lvl = getDifficulty().getLvl();
		int[] randomOrder = new int[NUMOFCARD];
		if (lvl == 3 || lvl == 4)
			randomOrder = randomOrderGeneration(5);
		if (lvl == 5)
			randomOrder = randomOrderGeneration(7);

		for (int i = 0; i < NUMOFCARD; i++) {

			card[i] = new Card(370 + i * 150, 850, randomType[i]);
			if (lvl == 3 || lvl == 4) {
				if (i > 0 && i < 6)
					card[i].setOrderNum(randomOrder[i - 1]);
			} else if (lvl == 5)
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
	public void dualAdaptation() {

		boolean surecrit = World.gui.getCharacteristics().isSureCrit();

		/*
		 * if (isDualFight) { if (surecrit) card[3].setCardtype(CardType.CRITICAL); }
		 * else { if (surecrit) card[0].setCardtype(CardType.CRITICAL);
		 * card[4].setExist(false); card[3].setExist(false); }
		 */
	}

	@Override
	public void createPuzzle() {
		attackFolder = new CardFolder(1300, 150, CardType.ATTACK);
		defenseFolder = new CardFolder(215, 150, CardType.DEFENSE);

		HandlerObject.getInstance().addObject(attackFolder);
		HandlerObject.getInstance().addObject(defenseFolder);

		switch (getDifficulty()) {
		case RED:
			hideTwoCardIntoSeven();
			imposeOrder();
			createSevenCard();
			break;
		case ORANGE:
			hideOneCardIntoFive();
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


	private void hideTwoCardIntoSeven() {
		int random = new Random().nextInt(6);
		int random2 = new Random().nextInt(6);
		while (random == random2)
			random2 = new Random().nextInt(6);
		
		for (int i = 0; i < 7; i++)
			card[i].hideTemporarly();	
		card[random].hidePermanently();
		card[random2].hidePermanently();
	}

	private void createSevenCard() {
		HandlerObject.getInstance().addObject(card[6]);
		HandlerObject.getInstance().addObject(card[5]);
		HandlerObject.getInstance().addObject(card[4]);
		HandlerObject.getInstance().addObject(card[3]);
		HandlerObject.getInstance().addObject(card[2]);
		HandlerObject.getInstance().addObject(card[1]);
		HandlerObject.getInstance().addObject(card[0]);
	}
	

	private void hideOneCardIntoFive() {
		int random = 1 + new Random().nextInt(5);
		
		for (int i = 1; i < 6; i++)
			card[i].hideTemporarly();	
		card[random].hidePermanently();
	}

	private void imposeOrder() {
		attackFolder.setOrderNum(1);
		defenseFolder.setOrderNum(1);
	}

	private void createFiveCard() {
		card[6].setExist(false);
		HandlerObject.getInstance().addObject(card[5]);
		HandlerObject.getInstance().addObject(card[4]);
		HandlerObject.getInstance().addObject(card[3]);
		HandlerObject.getInstance().addObject(card[2]);
		HandlerObject.getInstance().addObject(card[1]);
		card[0].setExist(false);
	}

	private void createThreeCard() {
		card[6].setExist(false);
		card[5].setExist(false);
		HandlerObject.getInstance().addObject(card[4]);
		HandlerObject.getInstance().addObject(card[3]);
		HandlerObject.getInstance().addObject(card[2]);
		card[1].setExist(false);
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
