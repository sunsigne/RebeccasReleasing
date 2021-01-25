package com.sunsigne.rebeccasreleasing.game.puzzles.search.object;

import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class SearchWordReversed extends SearchWordObject {

	public SearchWordReversed(int wordnumber, int x, int y) {
		super(wordnumber, x, y);

		if(!isGoodWord()) setExist(true);
	}

	// behavior
	
	@Override
	public void placeWord() {
		setX(GameCursor.getPos().x);
		setY(GameCursor.getPos().y);
		setExist(true);
		setDragged(true);
		HandlerObject.getInstance().addObject(this);
		SoundTask.playSound(0.6, SoundBank.getSound(SoundBank.r_place_word));
	}

	// collision

	@Override
	protected void collision() {

	}

}
