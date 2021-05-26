package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.hack;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Virus extends PuzzleObject implements IAnimation {

	private Animation animation;
	private boolean clicking;

	int xmin = Size.X0 + Size.TILE_PUZZLE, xmax = 105 + 12 * Size.TILE_PUZZLE;
	int ymin = Size.Y0 + Size.TILE_PUZZLE, ymax = 32 + 13 * Size.TILE_PUZZLE / 2;

	public Virus() {
		super(0, 0);

		w = Size.TILE_PUZZLE / 2;
		h = Size.TILE_PUZZLE / 2;
	}

	@Override
	public Animation getAnimation(int... array) {
		if (animation == null)
			animation = new Animation(15, texture.puzzle_hack[0], texture.puzzle_hack[1]);
		return animation;
	}

	// state

	public boolean isClicking() {
		return clicking;
	}

	public void setClicking(boolean clicking) {
		this.clicking = clicking;
	}

	@Override
	public void tick() {
		runAnimation();

		Point mouse = new GameCursor().getPos();

		if (mouse.y < ymin)
			y = ymin;
		else if (mouse.y > ymax)
			y = ymax;
		else
			y = mouse.y;

		if (mouse.x < xmin)
			x = xmin;
		else if (mouse.x > xmax)
			x = xmax;
		else
			x = mouse.x;
	}

	@Override
	public void render(Graphics g) {

		drawAnimation(g, x, y, Size.TILE_PUZZLE, Size.TILE_PUZZLE);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 5, y, w, h);
	}

	public void doAction() {

		try {
			LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getLayer());
			for (GameObject tempObject : list) {

				if (tempObject instanceof ProcessorObject) {
					ProcessorObject processorObject = (ProcessorObject) tempObject;

					switch (processorObject.getProcessorID()) {
					case CPU:
						doEatAction(tempObject);
						break;
					case FOLDER:
						doOpenAction(tempObject);
						break;
					case LOCKER:
						doEatAction(tempObject);
						break;
					case TRASH:
						doTrashAction(tempObject);
						break;
					case DESKTOP:
						break;
					}
				}

			}
		} catch (Exception e) {
			// For unkown reasons, those lines often cause desynchronisation with some
			// lists.
			// This simple throws avoid crashs without creating unwanted behavior.
		}
	}

	private void doEatAction(GameObject tempObject) {
		ProcessorObject processorObject = (ProcessorObject) tempObject;

		if (!isClicking() && getBounds().intersects(tempObject.getBounds())) {
			if (processorObject.isLocked()) {
				setClicking(true);
				new SoundTask().playSound(SoundBank.PLAYER_FAIL);
				updateLocker(processorObject);
			} else {
				processorObject.delete();
				setClicking(true);
				new SoundTask().playSound(SoundBank.VIRUS_BITE);
				updateLocker(processorObject);
			}

		}
	}

	private void doOpenAction(GameObject tempObject) {
		ProcessorObject processorObject = (ProcessorObject) tempObject;

		if (!isClicking() && getBounds().intersects(tempObject.getBounds())) {
			if (!processorObject.isLocked()) {
				processorObject.open();
				setClicking(true);
				new SoundTask().playSound(SoundBank.VIRUS_EXPLORE);
			} else {
				setClicking(true);
				new SoundTask().playSound(SoundBank.PLAYER_FAIL);
			}
		}
	}

	private void doTrashAction(GameObject tempObject) {
		ProcessorTrash trash = (ProcessorTrash) tempObject;

		if (!isClicking() && getBounds().intersects(tempObject.getBounds())) {
			if (trash.isEmpty()) {
				trash.delete();
				setClicking(true);
				new SoundTask().playSound(SoundBank.VIRUS_BITE);
			}
			if (!trash.isEmpty()) {
				trash.setEmpty(true);
				setClicking(true);
				new SoundTask().playSound(SoundBank.VIRUS_BITE);
			}
		}
	}

	private void updateLocker(ProcessorObject processorObject) {
		if (processorObject.getProcessorID() == PROCESSORID.LOCKER) {
			ProcessorLocker locker = (ProcessorLocker) processorObject;
			locker.unlocking();
		}
	}

}
