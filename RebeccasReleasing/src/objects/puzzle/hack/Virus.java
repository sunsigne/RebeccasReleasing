package objects.puzzle.hack;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;
import objects.puzzle.PuzzleObject;

public class Virus extends PuzzleObject implements IAnimation {

	private Animation animation;
	private boolean clicking;

	int xmin = Size.X0 + Size.TILE_PUZZLE, xmax = 104 + 12 * Size.TILE_PUZZLE;
	int ymin = Size.Y0 + Size.TILE_PUZZLE, ymax = 32 + 13 * Size.TILE_PUZZLE / 2;

	public Virus() {
		super(0, 0, OBJECTID.P_VIRUS);

		w = Size.TILE_PUZZLE / 2;
		h = Size.TILE_PUZZLE / 2;
	}
	
	@Override
	public Animation getAnimation(int array, int secondarray) {
		if (animation == null)
			animation = new Animation(15, texture.virus[0], texture.virus[1]);
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

		GameMouseListener mouse = GameMouseListener.getInstance();

		if (mouse.getPos().y < ymin)
			y = ymin;
		else if (mouse.getPos().y > ymax)
			y = ymax;
		else
			y = mouse.getPos().y;

		if (mouse.getPos().x < xmin)
			x = xmin;
		else if (mouse.getPos().x > xmax)
			x = xmax;
		else
			x = mouse.getPos().x;
	}

	@Override
	public void render(Graphics g) {

		drawAnimation(g, x, y, Size.TILE_PUZZLE, Size.TILE_PUZZLE);
		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 5, y, w, h);
	}

	public void doAction() {

		try {
			LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
			for (GameObject tempObject : list) {

				if (tempObject.getId() == OBJECTID.PROCESSOR) {
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
			// For unkown reasons, those lines often cause desynchronisation with some lists.
			// This simple throws avoid crashs without creating unwanted behavior.
		}
	}

	private void doEatAction(GameObject tempObject) {
		ProcessorObject processorObject = (ProcessorObject) tempObject;

		if (!isClicking() && getBounds().intersects(tempObject.getBounds())) {
			if (processorObject.isLocked()) {
				setClicking(true);
				SoundTask.playSound(SoundBank.getSound(SoundBank.fail));
				updateLocker(processorObject);
			} else {
				processorObject.delete();
				setClicking(true);
				SoundTask.playSound(SoundBank.getSound(SoundBank.virus_bite));
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
				SoundTask.playSound(SoundBank.getSound(SoundBank.virus_explore));
			} else {
				setClicking(true);
				SoundTask.playSound(SoundBank.getSound(SoundBank.fail));
			}
		}
	}

	private void doTrashAction(GameObject tempObject) {
		ProcessorTrash trash = (ProcessorTrash) tempObject;

		if (!isClicking() && getBounds().intersects(tempObject.getBounds())) {
			if (trash.isEmpty()) {
				trash.delete();
				setClicking(true);
				SoundTask.playSound(SoundBank.getSound(SoundBank.virus_bite));
			}
			if (!trash.isEmpty()) {
				trash.setEmpty(true);
				setClicking(true);
				SoundTask.playSound(SoundBank.getSound(SoundBank.virus_bite));
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
