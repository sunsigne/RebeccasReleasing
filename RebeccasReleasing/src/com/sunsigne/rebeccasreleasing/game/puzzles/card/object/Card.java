package com.sunsigne.rebeccasreleasing.game.puzzles.card.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;

public class Card extends CardObject {

	private boolean aboveRightFolder, aboveWrongFolder;

	public Card(int x, int y, CARDTYPE cardtype) {
		super(x, y, cardtype);
		setExist(true);
	}

	// state

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

	// behavior

	@Override
	public void tick() {

		hiddingTime--;
		goUpward();

		if (isDragged()) {
			x = GameCursor.getPos().x - w / 2;
			y = GameCursor.getPos().y - h / 2;
		}
		collision();
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

	// collision

	private void collision() {

		boolean flag = false;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list) {
			if (!flag && tempObject.getId() == OBJECTID.P_CARDFOLDER) {
				CardFolder folder = (CardFolder) tempObject;

				if (getBounds().intersects(folder.getBounds())) {
					if (folder.getOrderNum() == getOrderNum() || folder.getOrderNum() == 0) {
						if (folder.getCardtype() == getCardtype() || getCardtype() == CARDTYPE.CRITICAL)
							setAboveRightFolder(true);
						else if (folder.getCardtype() != getCardtype() && getCardtype() != CARDTYPE.CRITICAL)
							setAboveWrongFolder(true);
						flag = true;
					} else {
						setAboveWrongFolder(true);
						flag = true;
					}
				}

				if (!getBounds().intersects(folder.getBounds())) {
					setAboveRightFolder(false);
					setAboveWrongFolder(false);
				}
			}
		}
	}

	public void playCard() {
		setExist(false);

		if (getCardtype() == CARDTYPE.ATTACK)
			SoundTask.playSound(SoundBank.getSound(SoundBank.hit_critical));
		if (getCardtype() == CARDTYPE.DEFENSE)
			SoundTask.playSound(SoundBank.getSound(SoundBank.hit_defense));
		if (getCardtype() == CARDTYPE.CRITICAL) {
			SoundTask.playSound(SoundBank.getSound(SoundBank.hit_critical));
			{
				HandlerObject.getInstance().player.puzzle.setWinning(true);
				HandlerObject.getInstance().player.puzzle.close();
			}
		}
		HandlerObject.getInstance().removeObject(this);
	}

}
