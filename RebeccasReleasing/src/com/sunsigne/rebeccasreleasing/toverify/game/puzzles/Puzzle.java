package com.sunsigne.rebeccasreleasing.toverify.game.puzzles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.ressources.tools.BufferedTool;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

import objects.characters.living.FoeObject;
import objects.world.puzzler.IPuzzler;

public abstract class Puzzle extends Clickable {

	protected TextureBank texture = TextureBank.getInstance();

	private IPuzzler puzzler;
	private DIFFICULTY difficulty;

	private FoeObject[] multipleFoe = new FoeObject[FoeObject.MAX_ADDITIONAL_FOES_AT_SAME_FIGHT];

	private boolean reversed, winning;

	public Puzzle(STATE state, IPuzzler puzzler, DIFFICULTY difficulty, boolean reversed) {
		this(state, puzzler, null, difficulty, reversed);
	}

	public Puzzle(STATE state, IPuzzler puzzler, FoeObject[] multipleFoe, DIFFICULTY difficulty, boolean reversed) {
		super(state);
		this.puzzler = puzzler;
		this.multipleFoe = multipleFoe;
		this.difficulty = difficulty;
		this.reversed = reversed;
		open();
	}

	// state

	@Override
	public LAYER getLayer() {
		return LAYER.WOLRD_GUI_PUZZLE;
	}

	public DIFFICULTY getDifficulty() {
		return difficulty;
	}

	public boolean isReversed() {
		return reversed;
	}

	public boolean isWinning() {
		return winning;
	}

	public void setWinning(boolean winning) {
		this.winning = winning;
	}

	// behavior

	public void open() {

		HandlerObject.getInstance().clear(false, LAYER.WOLRD_GUI_PUZZLE);
		createFrame();
		randomGeneration();
		createPuzzle();
	}

	protected void createFrame() {

//		HandlerObject.getInstance().addObject(getTimer());
	}

	protected abstract void randomGeneration();

	protected abstract void createPuzzle();

	protected abstract SoundBank getSuccessSound();

	@Override
	public void close() {

		clearClickable();
		HandlerObject.getInstance().addObject(World.gui);

		if (puzzler != null)
			puzzler.setSolved(winning);
		if (puzzler.getEventOnClose() != null)
			puzzler.getEventOnClose().startEvent();
		checkMultipleFoes(winning);

		World.stunAllFoes();
		Conductor.setState(STATE.LEVEL);
		HandlerObject.getInstance().getPlayer().loadBasicState();

		if (!winning) {
			if (!reversed)
				new SoundTask().playSound(SoundBank.fail);
			else
				new SoundTask().playSound(SoundBank.r_fail);
			World.gui.removeHp();
		} else if (winning)
			new SoundTask().playSound(getSuccessSound());
		World.gui.setInvulnerable(false);
	}

	private void checkMultipleFoes(boolean winning) {
		for (int i = 0; i < FoeObject.MAX_ADDITIONAL_FOES_AT_SAME_FIGHT; i++) {
			if (multipleFoe != null) {
				if (multipleFoe[i] != null)
					multipleFoe[i].setSolved(winning);
			}
		}
	}

	protected void difficultyModification(DifficultyListener listener, int... lvl) {
		int size = lvl.length;
		for (int i = 0; i < size; i++) {
			if (getDifficulty().getLvl() == lvl[i])
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
