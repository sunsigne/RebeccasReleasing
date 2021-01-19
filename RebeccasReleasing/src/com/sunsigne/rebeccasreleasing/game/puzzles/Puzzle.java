package com.sunsigne.rebeccasreleasing.game.puzzles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleTimer;
import com.sunsigne.rebeccasreleasing.game.puzzles.commun_object.PuzzleTimerReversed;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.onlyconductortorebuild.Conductor;

import objects.TimerObject;
import objects.characters.living.FoeObject;
import objects.world.puzzler.IPuzzler;

@Todo("difficulty : moving bomb, bigger count, more bomb")
public abstract class Puzzle extends Clickable {

	protected TextureBank texture = TextureBank.getInstance();

	private IPuzzler puzzler;
	private DIFFICULTY difficulty;

	private FoeObject[] multipleFoe = new FoeObject[FoeObject.MAX_ADDITIONAL_FOES_AT_SAME_FIGHT];

	protected boolean isDualFight;

	private boolean reversed, winning;
	private TimerObject timer;

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

	// state

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

	public boolean isReversed() {
		return reversed;
	}

	public TimerObject getTimer() {
		if (timer == null) {
			if (isReversed())
				timer = new PuzzleTimerReversed(PuzzleTimer.TIME, () -> close());
			else
				timer = new PuzzleTimer(PuzzleTimer.TIME, () -> close());
		}
		return timer;
	}

	// behavior

	public void open() {

		HandlerObject.getInstance().clearFront();
		createFrame();
		randomGeneration();
		createPuzzle();
	}

	protected void createFrame() {

		HandlerObject.getInstance().addObject(getTimer());
	}

	protected abstract void randomGeneration();

	protected abstract void createPuzzle();

	@Todo("tous les puzzle n'ont accuellement pas de son de victoire")
	protected abstract BufferedSound getSuccessSound();

	@Override
	public void close() {

		GameMouseInput.getInstance().clearClickable();
		HandlerObject.getInstance().addObject(World.gui);

		if (puzzler != null)
			puzzler.setSolved(winning);
		if (puzzler.getEventOnClose() != null)
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
		for (int i = 0; i < FoeObject.MAX_ADDITIONAL_FOES_AT_SAME_FIGHT; i++) {
			if (multipleFoe[i] != null)
				multipleFoe[i].setSolved(winning);
		}
	}
		
	protected void difficultyModification(DifficultyListener listener, int... lvl)
	{
		int size = lvl.length;
		for(int i = 0; i < size; i++)
		{
			if(getDifficulty().getLvl() == lvl[i])
				listener.modify();
		}
	}
	
	// design

	protected void renderingFakeWall(Graphics g, BufferedImage texture) {
		int x = Size.X0;
		int y = Size.Y0;
		int w = Size.TILE_PUZZLE;
		int h = Size.TILE_PUZZLE;

		for (int i = 0; i < 13; i++) {
			// up line
			g.drawImage(texture, x + i * w, y, w, h, null);
			// down line
			g.drawImage(texture, x + i * w, y + 7 * h, w, h, null);
		}

		for (int i = 0; i < 8; i++) {
			// left line
			g.drawImage(texture, x, y + i * h, w, h, null);
			// right line
			g.drawImage(texture, x + 13 * w, y + i * h, w, h, null);
		}
	}


}
