package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.search.object;

import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

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
			new SoundTask().playSound(0.6, SoundBank.TOP_SECRET);
		} else
			HandlerObject.getInstance().getPlayer().puzzle.close();
	}

	// collision

	@Override
	protected void collision() {

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getLayer());
		for (GameObject tempObject : list) {
			if (tempObject instanceof SearchFolder) {
				if (getBounds().intersects(tempObject.getBounds()))
					setAboveFolder(true);
				if (!getBounds().intersects(tempObject.getBounds()))
					setAboveFolder(false);
			}
		}
	}

}
