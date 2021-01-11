package com.sunsigne.rebeccasreleasing.game.puzzles.reversed;

import java.awt.Color;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.characters.living.FoeObject;
import objects.puzzle.GameTimer;
import objects.puzzle.GameTimerReversed;
import objects.puzzle.WallPuzzle;
import objects.puzzle.card.CardFolderReversed;
import objects.puzzle.card.CardReversed;
import objects.puzzle.card.CardType;

public class PuzzleCardReversed extends Puzzle {

	private static CardReversed[] card = new CardReversed[5];
	public static boolean surecrit;

	private static CardFolderReversed folderattack, folderdefense, folderreversed;

	public PuzzleCardReversed(FoeObject foe, GameObject dualfoe, DIFFICULTY difficulty) {
		super(STATE.PUZZLECARD, foe, dualfoe, difficulty, true);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0, Size.Y0, WallPuzzle.WALLTYPE.CARD));
		HandlerObject.getInstance().addObject(new GameTimerReversed(GameTimer.TIME, () -> close()));
	}

	@Override
	public void randomGeneration() {

		CardType type0 = CardType.attack;
		CardType type1 = CardType.attack;
		CardType type2 = CardType.attack;
		CardType type3 = CardType.attack;
		CardType type4 = CardType.attack;

		double r0 = Math.random();
		double r1 = Math.random();
		double r2 = Math.random();
		double r3 = Math.random();
		double r4 = Math.random();

		float chance = 0.4f;
		float critchance = 0.98f;
		if (r0 <= chance)
			type0 = CardType.defense;
		if (r1 <= chance)
			type1 = CardType.defense;
		if (r2 <= chance)
			type2 = CardType.defense;
		if (r3 <= chance)
			type3 = CardType.defense;
		if (r4 <= chance)
			type4 = CardType.defense;

		if (r0 >= critchance)
			type0 = CardType.critical;
		if (r1 >= critchance)
			type1 = CardType.critical;
		if (r2 >= critchance)
			type2 = CardType.critical;
		if (r3 >= critchance)
			type3 = CardType.critical;
		if (r4 >= critchance)
			type4 = CardType.critical;

		card[4] = new CardReversed(1120, 850, type4);
		card[2] = new CardReversed(970, 850, type2);
		card[1] = new CardReversed(820, 850, type1);
		card[0] = new CardReversed(670, 850, type0);
		card[3] = new CardReversed(520, 850, type3);

	}	

	@Override
	public void dualAdaptation() {

		card[4].setDual(true);
		card[3].setDual(true);
		
		if (isDualFight) {
			if (surecrit)
				card[3].setCardtype(CardType.critical);
			card[4].setDual(false);
			card[3].setDual(false);
		} else {
			if (surecrit)
				card[0].setCardtype(CardType.critical);
			card[4].setStable(true);
			card[3].setStable(true);
		}
	}

	@Override
	public void createPuzzle() {
		folderattack = new CardFolderReversed(1300, 150, CardType.attack);
		folderdefense = new CardFolderReversed(215, 150, CardType.defense);
		folderreversed = new CardFolderReversed(520, 850, CardType.reversed);

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

		if (GameMouseListener.mouseOver(mx, my, folderattack.getX(), folderattack.getY(), Size.TILE_PUZZLE * 2,
				Size.TILE_PUZZLE * 4)) {
			for (int i = 4; i >= 0; i--) {
				if (!card[i].doesExist() && !card[i].isDual() && card[i].getCardtype() != CardType.defense) {
					card[i].playCard();
					return;
				}
			}
		}
		if (GameMouseListener.mouseOver(mx, my, folderdefense.getX(), folderdefense.getY(), Size.TILE_PUZZLE * 2,
				Size.TILE_PUZZLE * 4)) {
			for (int i = 4; i >= 0; i--) {
				if (!card[i].doesExist() && !card[i].isDual() && card[i].getCardtype() != CardType.attack) {
					card[i].playCard();
					return;
				}
			}
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {
		card[4].setDragged(false);
		card[3].setDragged(false);
		card[2].setDragged(false);
		card[1].setDragged(false);
		card[0].setDragged(false);

		boolean winning = true;
		for (int i = 4; i >= 0; i--) {
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
	public AudioBank getSuccessSound() {
		return null;
	}
}
