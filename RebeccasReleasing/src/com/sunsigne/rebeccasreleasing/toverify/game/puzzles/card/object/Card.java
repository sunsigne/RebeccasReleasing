package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public class Card extends CardObject {

	private boolean aboveRightFolder, aboveWrongFolder;

	public Card(int x, int y, CARDTYPE cardtype, ChatMap chatMap, ChatMap... chatMaps) {
		super(x, y, cardtype, chatMap, chatMaps);
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

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getLayer());
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
				HandlerObject.getInstance().getPlayer().puzzle.setWinning(true);
				HandlerObject.getInstance().getPlayer().puzzle.close();
			}
		}
		HandlerObject.getInstance().removeObject(this);
	}

}
