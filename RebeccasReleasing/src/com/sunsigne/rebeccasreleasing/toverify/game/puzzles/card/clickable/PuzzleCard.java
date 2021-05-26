package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.clickable;

import com.sunsigne.rebeccasreleasing.toverify.game.objects.living.FoeObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.PuzzleCardBuilder;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object.CARDTYPE;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object.Card;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;

public class PuzzleCard extends PuzzleCardBuilder<Card> {

	public PuzzleCard(IPuzzler puzzler, FoeObject[] multipleFoe, DIFFICULTY difficulty) {
		super(puzzler, multipleFoe, difficulty, false);
	}

	@Override
	public void mousePressed(int mx, int my) {

		int numOfCards = getNumOfCards();

		for (int i = numOfCards - 1; i >= 0; i--) {
			if (!getCard(i).isPlayed() && GameMouseInput.mouseOver(mx, my, getCard(i).getRect())) {
				getCard(i).setDragged(true);
				return;
			}
		}
	}

	@Override
	public void mouseReleased(int mx, int my) {

		int numOfCards = getNumOfCards();

		for (int i = 0; i < numOfCards; i++) {
			getCard(i).setDragged(false);
		}

		boolean winning = true;
		for (int i = 0; i < numOfCards; i++) {

			if (!getCard(i).isPlayed()) {

				if (getCard(i).isAboveWrongFolder()) {
					close();
				}

				else if (getCard(i).isAboveRightFolder()) {
					playCard(getCard(i));
				}

				else {
					getCard(i).resetPos();
				}

			}

			if (!getCard(i).isPlayed())
				winning = false;
		}

		setWinning(winning);
		if (isWinning())
			close();
	}

	private void playCard(Card card) {
		card.playCard();
		card.setX(0);
		card.setY(0);
		updateFolderAnimation(card);
		updateFolderNum(card);
	}

	private void updateFolderAnimation(Card card) {
		CARDTYPE type = card.getCardtype();
		getFolderAttack().playCard(type);
		getFolderDefense().playCard(type);
	}

	private void updateFolderNum(Card card) {

		int currentOrderNum = card.getOrderNum();
		if (currentOrderNum != 0 && getFolderAttack().getOrderNum() != 0) {
			getFolderAttack().setOrderNum(currentOrderNum + 1);
			getFolderDefense().setOrderNum(currentOrderNum + 1);
		}

	}

}
