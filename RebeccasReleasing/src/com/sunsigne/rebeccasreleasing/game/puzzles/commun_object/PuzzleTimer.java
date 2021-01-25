package com.sunsigne.rebeccasreleasing.game.puzzles.commun_object;

import objects.TimerObject;

import com.sunsigne.rebeccasreleasing.Todo;

import objects.TimerListener;

@Todo("pour tuto : attirer l'attention sur le timer !!")
public class PuzzleTimer extends TimerObject {

	public PuzzleTimer(int timeinSec, TimerListener listener) {
		super(timeinSec, listener);
	}

	// behavior
	
	@Override
	protected void tickTimer()
	{
		--timeinSec;
	};
	
	@Override
	protected boolean finishCondition()
	{
		return timeinSec <= 0;
	};
	
	// design

	protected int getIntToDisplay()
	{
		return timeinSec;
	}


}
