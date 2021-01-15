package com.sunsigne.rebeccasreleasing.game.puzzles.reversed;

import java.awt.Color;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.puzzle.GameTimer;
import objects.puzzle.GameTimerReversed;
import objects.puzzle.FakeWallPuzzle;
import objects.puzzle.card.CardFolderReversed;
import objects.puzzle.card.CardReversed;
import objects.puzzle.card.CardType;
import objects.world.puzzler.IPuzzler;

public class PuzzleCardReversed extends Puzzle {

	private static final int NUMOFCARD = 5;
	private static CardReversed[] card = new CardReversed[NUMOFCARD];

	private static CardFolderReversed folderattack, folderdefense, folderreversed;

	public PuzzleCardReversed(IPuzzler puzzler, GameObject dualfoe, DIFFICULTY difficulty) {
		super(STATE.PUZZLECARD, puzzler, dualfoe, difficulty, true);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new FakeWallPuzzle(Size.X0, Size.Y0, FakeWallPuzzle.WALLTYPE.CARD));
		HandlerObject.getInstance().addObject(new GameTimerReversed(GameTimer.TIME, () -> close()));
	}

	@Override
	public void randomGeneration() {

		CardType[] type = new CardType[NUMOFCARD];
		double[] r = new double[NUMOFCARD];
		float defenseChance = 0.4f;
		float critChance = 0.98f;

		for (int i = 0; i < NUMOFCARD; i++) {
			//creation of 5 attack card
			type[i] = CardType.ATTACK;
			r[i] = Math.random();
			// 40% of them are turned into defense card
			if (r[i] < defenseChance)
				type[i] = CardType.DEFENSE;
			if (World.levelnum != 1) {
				// 2% of all card become critical
				if (r[i] >= critChance)
					type[i] = CardType.CRITICAL;
			}
		}
		
		card[4] = new CardReversed(1120, 850, type[4]);
		card[2] = new CardReversed(970, 850, type[2]);
		card[1] = new CardReversed(820, 850, type[1]);
		card[0] = new CardReversed(670, 850, type[0]);
		card[3] = new CardReversed(520, 850, type[3]);

	}	

	@Override
	public void dualAdaptation() {

		boolean surecrit = World.gui.getCharacteristics().isSureCrit();
		
		card[4].setDual(true);
		card[3].setDual(true);
		
		if (isDualFight) {
			if (surecrit)
				card[3].setCardtype(CardType.CRITICAL);
			card[4].setDual(false);
			card[3].setDual(false);
		} else {
			if (surecrit)
				card[0].setCardtype(CardType.CRITICAL);
			card[4].setStable(true);
			card[3].setStable(true);
		}
	}

	@Override
	public void createPuzzle() {
		folderattack = new CardFolderReversed(1300, 150, CardType.ATTACK);
		folderdefense = new CardFolderReversed(215, 150, CardType.DEFENSE);
		folderreversed = new CardFolderReversed(520, 850, CardType.REVERSED);

		HandlerObject.getInstance().addObject(folderattack);
		HandlerObject.getInstance().addObject(folderdefense);
		HandlerObject.getInstance().addObject(folderreversed);

		if (isDualFight)
			HandlerObject.getInstance().addObject(card[4]);
		HandlerObject.getInstance().addObject(card[2]);
		HandlerObject.getInstance().addObject(card[1]);
		HandlerObject.getInstance().addObject(card[0]);
		if (isDualFight)
			HandlerObject.getInstance().addObject(card[3]);
	}

	@Override
	public void mousePressed(int mx, int my) {

		if (GameMouseListener.mouseOver(mx, my, folderattack.getRect())) {
			for (int i = NUMOFCARD - 1; i >= 0; i--) {
				if (!card[i].doesExist() && !card[i].isDual() && card[i].getCardtype() != CardType.DEFENSE) {
					card[i].playCard();
					return;
				}
			}
		}
		if (GameMouseListener.mouseOver(mx, my, folderdefense.getRect())) {
			for (int i = NUMOFCARD - 1; i >= 0; i--) {
				if (!card[i].doesExist() && !card[i].isDual() && card[i].getCardtype() != CardType.ATTACK) {
					card[i].playCard();
					return;
				}
			}
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {
		
		for (int i = NUMOFCARD - 1; i >= 0; i--) {
			card[i].setDragged(false);
		}
		
		boolean winning = true;
		for (int i = NUMOFCARD - 1; i >= 0; i--) {
			if (card[i].doesExist() && card[i].isAboveFolder())
				card[i].resetPos();
			if (card[i].doesExist() && !card[i].isAboveFolder())
				close();
			
			if (!card[i].isStable())
				winning = false;
		}
		setWinning(winning);
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
