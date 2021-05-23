package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.search.object;

import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;

public class SearchWordReversed extends SearchWordObject {

	public SearchWordReversed(int wordnumber, int x, int y) {
		super(wordnumber, x, y);

		if(!isGoodWord()) setExist(true);
	}

	// behavior
	
	@Override
	public void placeWord() {
		setX(new GameCursor().getPos().x);
		setY(new GameCursor().getPos().y);
		setExist(true);
		setDragged(true);
		HandlerObject.getInstance().addObject(this);
		new SoundTask().playSound(0.6, SoundBank.r_place_word);
	}

	// collision

	@Override
	protected void collision() {

	}

}
