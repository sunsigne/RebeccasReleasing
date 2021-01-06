package com.sunsigne.rebeccasreleasing.game.puzzles;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.living.FoeObject;
import objects.world.puzzler.PuzzlerObject;

@Todo("difficulty : moving bomb, bigger count, more bomb")
public abstract class Puzzle extends Clickable {

	private PuzzlerObject puzzler;
	private DIFFICULTY difficulty;

	private FoeObject foe;
	private GameObject dualfoe;
	protected boolean isDualFight;

	private boolean reversed, winning;

	public Puzzle(STATE state, PuzzlerObject puzzler, DIFFICULTY difficulty, boolean reversed) {
		super(state);
		this.puzzler = puzzler;
		this.difficulty = difficulty;
		this.reversed = reversed;
		open();
	}

	public Puzzle(STATE state, PuzzlerObject puzzler, DIFFICULTY difficulty) {
		this(state, puzzler, difficulty, false);
	}

	public Puzzle(STATE state, FoeObject foe, GameObject dualfoe, DIFFICULTY difficulty, boolean reversed) {
		super(state);
		this.foe = foe;
		this.dualfoe = dualfoe;
		this.difficulty = difficulty;
		this.reversed = reversed;
		dualChecker(dualfoe);
		open();
	}	

	public Puzzle(STATE state, FoeObject foe, GameObject dualfoe, DIFFICULTY difficulty) {
		this(state, foe, dualfoe, difficulty, false);
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

	protected void dualAdaptation() {

	}

	protected abstract void createPuzzle();

	@Todo("tous les puzzle n'ont accuellement pas de son de victoire")
	protected abstract String getSuccessSound();

	public void open() {

		HandlerObject.getInstance().clearFront();
		createFrame();
		randomGeneration();
		dualAdaptation();
		createPuzzle();
	}

	private void dualChecker(GameObject dualfoe) {
		if (dualfoe.getId() == OBJECTID.FOE)
			isDualFight = true;
	}

	public void close() {
		
		GameMouseListener.getInstance().clearClickable();
		HandlerObject.getInstance().addObject(World.gui);

		if (puzzler != null)
			puzzler.setSolved(winning);
		if (foe != null)
			foe.setSolved(winning);
		if (isDualFight)
			((FoeObject) dualfoe).setSolved(winning);

		World.stunAllFoes();
		Conductor.setState(STATE.LEVEL);
		HandlerObject.getInstance().player.loadBasicState();

		if (!winning) {
			if (!reversed)
				AudioTask.playSound(AudioBank.fail);
			else
				AudioTask.playSound(AudioBank.r_fail);
			World.gui.removeHp();
		} else if (winning)
			AudioTask.playSound(getSuccessSound());
	}

}
