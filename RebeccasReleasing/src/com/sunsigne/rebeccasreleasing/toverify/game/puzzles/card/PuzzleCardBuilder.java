package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.RandomGenerator;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.living.FoeObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object.CARDTYPE;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object.Card;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object.CardFolder;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object.CardObject;
import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;

public abstract class PuzzleCardBuilder<T> extends Puzzle {

	public PuzzleCardBuilder(IPuzzler puzzler, FoeObject[] multipleFoe, DIFFICULTY difficulty, boolean reversed) {
		super(STATE.PUZZLE, puzzler, multipleFoe, difficulty, false);
	}

	////////// OBJECTS ////////////

	private CardObject[] card;

	@SuppressWarnings("unchecked")
	protected T getCard(int number) {
		return (T) card[number];
	}

	protected CardObject createCard(int x, int y) {
//		if (isForward())
		return new Card(x, y, CARDTYPE.ATTACK);
//		return new CardReversed(x, y, type);
	}

	protected int getNumOfCards() {
		return card.length;
	}
	
	private CardFolder folderAttack, folderDefense;

	protected CardFolder getFolderAttack() {
		return folderAttack;
	}

	protected CardFolder getFolderDefense() {
		return folderDefense;
	}

	////////// PUZZLE ////////////

	@Override
	protected void open() {
		createPuzzle();
		difficultyModifications();
	}

	private void createPuzzle() {
		folderAttack = new CardFolder(DIRECTION.LEFT, CharacterBank.gamma, CARDTYPE.ATTACK);
		folderDefense = new CardFolder(DIRECTION.RIGHT, CharacterBank.rebecca, CARDTYPE.DEFENSE);

		HandlerObject.getInstance().addObject(folderAttack);
		HandlerObject.getInstance().addObject(folderDefense);
	}

	private void difficultyModifications() {
		difficultyModification(() -> randomCardGeneration(3), 1);
		difficultyModification(() -> randomCardGeneration(5), 2, 3, 4, 5);
		difficultyModification(() -> imposeOrder(), 3, 4, 5);
		difficultyModification(() -> hideCards(1), 4);
		difficultyModification(() -> hideCards(2), 5);
	}

	protected void randomCardGeneration(int numOfCards) {

		card = new CardObject[numOfCards];
		HandlerObject handler = HandlerObject.getInstance();
		int[] randomOrder = new RandomGenerator().randomOrderGenerationFromOneTo(numOfCards);

		for (int index = 0; index < numOfCards; index++) {

			if (numOfCards == 3)
				card[index] = createCard(670 + index * 150, 925);
			if (numOfCards == 5)
				card[index] = createCard(520 + index * 150, 925);
			
			card[index].setOrderNum(randomOrder[index]);

			float defenseChance = 0.4f;
			if (Math.random() < defenseChance)
				card[index].setCardtype(CARDTYPE.DEFENSE);

			handler.addObject(card[index]);
		}
	}

	private void imposeOrder() {
		folderAttack.setOrderNum(1);
		folderDefense.setOrderNum(1);
	}

	private void hideCards(int numOfCards) {
		int[] randomIndex = new RandomGenerator().randomOrderGenerationFromOneTo(5);

		for (int index = 0; index < numOfCards; index++) {
			card[randomIndex[index] - 1].setMustHide(true);
		}
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {
		Color yellow = new Color(70, 70, 10, 240);
		BufferedImage img = texture.decor_wall[1];
		colorRender(g, yellow);
		renderingFakeWall(g, img);

	}

	////////// SOUND ////////////

	@Override
	public SoundBank getSuccessSound() {
		if (!isForward())
			return SoundBank.NOPE;
		else
			return SoundBank.NOPE;
	}

}
