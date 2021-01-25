package com.sunsigne.rebeccasreleasing.game.puzzles.search.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;

public class SearchWord extends SearchWordObject {

	private boolean aboveFolder;
	
	public SearchWord(int wordnumber, int x, int y) {
		super(wordnumber, x, y);

		setExist(true);
	}

	//
	public boolean isAboveFolder() {
		return aboveFolder;
	}

	public void setAboveFolder(boolean aboveFolder) {
		this.aboveFolder = aboveFolder;
	}
	
	// behavior

	@Override
	public void placeWord() {
		if (isGoodWord()) {
			setExist(false);
			setStable(true);
			HandlerObject.getInstance().removeObject(this);
			SoundTask.playSound(0.6, SoundBank.getSound(SoundBank.place_word));
		} else
			HandlerObject.getInstance().player.puzzle.close();
	}

	// collision

	@Override
	protected void collision() {

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.P_WORDFOLDER) {
				if (getBounds().intersects(tempObject.getBounds()))
					setAboveFolder(true);
				if (!getBounds().intersects(tempObject.getBounds()))
					setAboveFolder(false);
			}
		}
	}

}
