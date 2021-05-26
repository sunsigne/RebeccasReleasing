package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.CollisionDetector;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionDetection;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;

public class Card extends CardObject {

	public Card(int x, int y, CARDTYPE cardtype) {
		super(x, y, cardtype);
	}

	private boolean aboveRightFolder, aboveWrongFolder;

	public boolean isAboveRightFolder() {
		return aboveRightFolder;
	}

	public boolean isAboveWrongFolder() {
		return aboveWrongFolder;
	}

	public void setAboveRightFolder(boolean aboveFolder) {
		this.aboveRightFolder = aboveFolder;
	}

	public void setAboveWrongFolder(boolean aboveWrongFolder) {
		this.aboveWrongFolder = aboveWrongFolder;
	}

	////////// TICK ////////////

	@Override
	public void tick() {

		setAboveRightFolder(false);
		setAboveWrongFolder(false);
		
		hiddingTime--;
		goUpward();

		if (isDragged()) {
			x = new GameCursor().getPos().x - w / 2;
			y = new GameCursor().getPos().y - h / 2;
		}
	}

	private void goUpward() {
		if (upwardTime > 0) {
			if (hasSameOrderNumThanFolder(false) || (upwardTime > 10 && hasSameOrderNumThanFolder(true))) {
				upwardTime--;
				y = y - 7;
				startingY = startingY - 7;
			}
		}
	}

	public void playCard() {
		setPlayed(true);

		if (getCardtype() == CARDTYPE.ATTACK)
			new SoundTask().playSound(SoundBank.HIT_BIG);
		if (getCardtype() == CARDTYPE.DEFENSE)
			new SoundTask().playSound(SoundBank.HIT_LITTLE);
		HandlerObject.getInstance().removeObject(this);
	}

}
