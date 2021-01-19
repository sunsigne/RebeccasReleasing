package com.sunsigne.rebeccasreleasing.game.puzzles.commun_object;

import objects.TimerObject;
import objects.TimerListener;

public class PuzzleTimerReversed extends TimerObject {

	private int count = 1;
	
	public PuzzleTimerReversed(int timeinSec, TimerListener listener) {
		super(timeinSec, listener);
		this.timeinSec = timeinSec + 1;
	}
	
	// behavior

	@Override
	protected void tickTimer()
	{
		++count;
	};
		
	@Override
	protected boolean finishCondition()
	{
		return count >= timeinSec;
	};

	// design

	@Override
	protected int getIntToDisplay()
	{
		return count;
	}
	
}
