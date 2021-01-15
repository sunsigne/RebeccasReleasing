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

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.living.FoeObject;
import objects.world.puzzler.IPuzzler;

@Todo("difficulty : moving bomb, bigger count, more bomb")
public abstract class Puzzle extends Clickable {

	private IPuzzler puzzler;
	private DIFFICULTY difficulty;

	private GameObject dualfoe;
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

	public Puzzle(STATE state, IPuzzler puzzler, GameObject dualfoe, DIFFICULTY difficulty, boolean reversed) {
		super(state);
		this.puzzler = puzzler;
		this.dualfoe = dualfoe;
		this.difficulty = difficulty;
		this.reversed = reversed;
		dualChecker(dualfoe);
		open();
	}	

	public Puzzle(STATE state, IPuzzler puzzler, GameObject dualfoe, DIFFICULTY difficulty) {
		this(state, puzzler, dualfoe, difficulty, false);
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
	protected abstract BufferedSound getSuccessSound();

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

	@Override
	public void close() {
		
		GameMouseListener.getInstance().clearClickable();
		HandlerObject.getInstance().addObject(World.gui);

		if (puzzler != null)
			puzzler.setSolved(winning);
		if (isDualFight)
			((FoeObject) dualfoe).setSolved(winning);

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

}
