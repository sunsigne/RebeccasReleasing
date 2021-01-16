package com.sunsigne.rebeccasreleasing.game.puzzles;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Conductor;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.IPuzzler;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.living.FoeObject;

@Todo("difficulty : moving bomb, bigger count, more bomb")
public abstract class Puzzle extends Clickable {

	private IPuzzler puzzler;
	private DIFFICULTY difficulty;

	private FoeObject[] multipleFoe = new FoeObject[FoeObject.MAX_ADDITIONAL_FOES_AT_SAME_FIGHT];
	protected boolean isDualFight;

	private boolean reversed, winning;

	public Puzzle(STATE state, IPuzzler puzzler, DIFFICULTY difficulty, boolean reversed) {
		super(state);
		this.puzzler = puzzler;
		this.difficulty = difficulty;
		this.reversed = reversed;
		open();
	}

	public Puzzle(STATE state, IPuzzler puzzler, DIFFICULTY difficulty) {
		this(state, puzzler, difficulty, false);
	}

	public Puzzle(STATE state, IPuzzler puzzler, FoeObject[] multipleFoe, DIFFICULTY difficulty, boolean reversed) {
		super(state);
		this.puzzler = puzzler;
		this.multipleFoe = multipleFoe;
		this.difficulty = difficulty;
		this.reversed = reversed;
		open();
	}	

	public Puzzle(STATE state, IPuzzler puzzler, FoeObject[] mutlipleFoe, DIFFICULTY difficulty) {
		this(state, puzzler, mutlipleFoe, difficulty, false);
	}

	public DIFFICULTY getDifficulty() {
		return difficulty;
	}

	public void setWinning(boolean winning) {
		this.winning = winning;
	}

	public boolean isWinning() {
		return winning;
	}

	public boolean isDualFight() {
		return isDualFight;
	}

	protected abstract void createFrame();

	protected abstract void randomGeneration();

	protected abstract void createPuzzle();

	@Todo("tous les puzzle n'ont accuellement pas de son de victoire")
	protected abstract BufferedSound getSuccessSound();

	public void open() {

		HandlerObject.getInstance().clearFront();
		createFrame();
		randomGeneration();
		createPuzzle();
	}

	@Override
	public void close() {
		
		GameMouseListener.getInstance().clearClickable();
		HandlerObject.getInstance().addObject(World.gui);

		if (puzzler != null)
			puzzler.setSolved(winning);
		if(puzzler.getEventOnClose() != null)
			puzzler.getEventOnClose().startEvent();
		checkMultipleFoes(winning);

		World.stunAllFoes();
		Conductor.setState(STATE.LEVEL);
		HandlerObject.getInstance().player.loadBasicState();

		if (!winning) {
			if (!reversed)
				SoundTask.playSound(SoundBank.getSound(SoundBank.fail));
			else
				SoundTask.playSound(SoundBank.getSound(SoundBank.r_fail));
			World.gui.removeHp();
		} else if (winning)
			SoundTask.playSound(getSuccessSound());
	}

	private void checkMultipleFoes(boolean winning) {
		for (int i = 0; i < FoeObject.MAX_ADDITIONAL_FOES_AT_SAME_FIGHT; i++)
		{
			if(multipleFoe[i] != null) multipleFoe[i].setSolved(winning);
		}
	}

}
