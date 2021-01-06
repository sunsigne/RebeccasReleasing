package com.sunsigne.rebeccasreleasing.game.puzzles.normal;

import java.awt.Color;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.characters.living.FoeObject;
import objects.puzzle.GameTimer;
import objects.puzzle.WallPuzzle;
import objects.puzzle.card.Card;
import objects.puzzle.card.CardFolder;
import objects.puzzle.card.CardType;

@Todo("pour tuto : simplifier le jeu ? Il doit être plus instinctif")
public class PuzzleCard extends Puzzle {

	private static Card[] card = new Card[5];

	public PuzzleCard(FoeObject foe, GameObject dualfoe, DIFFICULTY difficulty) {
		super(STATE.PUZZLECARD, foe, dualfoe, difficulty);
	}

	@Override
	public void createFrame() {
		HandlerObject.getInstance().addObject(new WallPuzzle(Size.X0, Size.Y0, WallPuzzle.WALLTYPE.CARD));
		HandlerObject.getInstance().addObject(new GameTimer(GameTimer.TIME, () -> close()));
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

		if (World.levelnum != 1) {
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
		}

		card[4] = new Card(1120, 850, type4);
		card[2] = new Card(970, 850, type2);
		card[1] = new Card(820, 850, type1);
		card[0] = new Card(670, 850, type0);
		card[3] = new Card(520, 850, type3);
	}

	@Override
	public void dualAdaptation() {

		if (isDualFight) {
			if (World.gui.getCharacteristics().isSureCrit())
				card[3].setCardtype(CardType.critical);
		} else {
			if (World.gui.getCharacteristics().isSureCrit())
				card[0].setCardtype(CardType.critical);
			card[4].setExist(false);
			card[3].setExist(false);
		}

	}

	@Override
	public void createPuzzle() {
		HandlerObject.getInstance().addObject(new CardFolder(1300, 150, CardType.attack));
		HandlerObject.getInstance().addObject(new CardFolder(215, 150, CardType.defense));

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
		if (card[3].doesExist()
				&& GameMouseListener.mouseOver(mx, my, card[3].getX(), card[3].getY(), Size.TILE_PUZZLE * 2, Size.TILE_PUZZLE * 3)) {
			card[3].setDragged(true);
			return;
		}

		if (card[0].doesExist()
				&& GameMouseListener.mouseOver(mx, my, card[0].getX(), card[0].getY(), Size.TILE_PUZZLE * 2, Size.TILE_PUZZLE * 3)) {
			card[0].setDragged(true);
			return;
		}

		if (card[1].doesExist()
				&& GameMouseListener.mouseOver(mx, my, card[1].getX(), card[1].getY(), Size.TILE_PUZZLE * 2, Size.TILE_PUZZLE * 3)) {
			card[1].setDragged(true);
			return;
		}

		if (card[2].doesExist()
				&& GameMouseListener.mouseOver(mx, my, card[2].getX(), card[2].getY(), Size.TILE_PUZZLE * 2, Size.TILE_PUZZLE * 3)) {
			card[2].setDragged(true);
			return;
		}

		if (card[4].doesExist()
				&& GameMouseListener.mouseOver(mx, my, card[4].getX(), card[4].getY(), Size.TILE_PUZZLE * 2, Size.TILE_PUZZLE * 3)) {
			card[4].setDragged(true);
			return;
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {
		card[3].setDragged(false);
		card[0].setDragged(false);
		card[1].setDragged(false);
		card[2].setDragged(false);
		card[4].setDragged(false);

		boolean winning = true;
		for (int i = 0; i <= 4; i++) {

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
				}
			}
			if (card[i].doesExist())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(70, 70, 10, 240));

	}

	@Override
	public String getSuccessSound() {
		return null;
	}

}
