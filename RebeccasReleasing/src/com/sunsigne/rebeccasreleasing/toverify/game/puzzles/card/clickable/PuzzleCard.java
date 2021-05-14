package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.clickable;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.PuzzleCardBuilder;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object.CARDTYPE;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object.Card;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;

import objects.characters.living.FoeObject;
import objects.world.puzzler.IPuzzler;

public class PuzzleCard extends PuzzleCardBuilder<Card> {

	public PuzzleCard(IPuzzler puzzler, FoeObject[] multipleFoe, DIFFICULTY difficulty) {
		super(puzzler, multipleFoe, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {

		for (int i = 0; i < 5; i++) {
			if (getCard(i).doesExist() && GameMouseInput.mouseOver(mx, my, getCard(i).getRect())) {
				getCard(i).setDragged(true);
				return;
			}
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		for (int i = 0; i < 5; i++) {
			getCard(i).setDragged(false);
		}

		boolean winning = true;
		for (int i = 0; i < 5; i++) {

			if (getCard(i).doesExist()) {
				if (!getCard(i).isAboveRightFolder()) {
					if (!getCard(i).isAboveWrongFolder())
						getCard(i).resetPos();
					else
						close();

				} else if (getCard(i).isAboveRightFolder()) {
					getCard(i).playCard();
					getCard(i).setX(0);
					getCard(i).setY(0);
					updateFolderAnimation(getCard(i));
					updateFolderNum(getCard(i));
				}
			}
			if (getCard(i).doesExist())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}

	private void updateFolderAnimation(Card card) {
		CARDTYPE type = card.getCardtype();
		attackFolder.playCard(type);
		defenseFolder.playCard(type);
	}

	private void updateFolderNum(Card card) {

		int currentOrderNum = card.getOrderNum();
		if (currentOrderNum != 0 && attackFolder.getOrderNum() != 0) {
			attackFolder.setOrderNum(currentOrderNum + 1);
			defenseFolder.setOrderNum(currentOrderNum + 1);
		}

	}

}
