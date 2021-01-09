package objects.characters.living;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleCard;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.NullObject;
import objects.OBJECTID;
import objects.characters.collision.CollisionDetector;
import objects.characters.collision.ICollision;
import objects.world.storing.LOOTID;
import objects.world.storing.Loot;
import objects.world.storing.Looting;

public class FoeObject extends LivingObject implements Looting, ICollision {

	public static final int foespeed = 4 * Size.TILE / 64;
	public static final int foesight = 400 * Size.TILE / 64;
	public static final int foedualrange = 200 * Size.TILE / 64;

	private boolean solved;
	private DIFFICULTY difficulty;

	public boolean stunned;
	private int stuntime;

	public FoeObject(int x, int y) {
		this(x, y, DIFFICULTY.CYAN);
	}
	
	public FoeObject(int x, int y, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.FOE, FOE);

		this.difficulty = difficulty;
		collisionDetector = new CollisionDetector(false, this);
	}

	// state

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
		if (solved) {
			kill();
			checkEvent(2);
		} else
			checkEvent(1);
	}

	@Override
	public void tick() {

		getAnimation().runAnimation();
		updateWatchingDirection();
		if (isPlayerActive() && Conductor.getState() != STATE.CHATTING)
			velocity();
		collisionDetector.update();

		if (isPlayerInSight() && !stunned)
			movingtoPlayer();
		if (stunned) {
			setMotionless();
			if (stuntime > 0)
				--stuntime;
			else
				stunned = false;
		}
	}

	@Override
	public void render(Graphics g) {

		getAnimation().drawAnimation(g, x, y, w, h);
		
		drawDifficulty(g);
		drawHitbox(g);
	}
	
	@Todo("Improve graphism, here are some basic layers to identify the difficulty")
	private void drawDifficulty(Graphics g) {
		
		Color color = new Color(0,0,0,0);
		if(difficulty.getNum() == 1) color = new Color(0, 255, 255, 100);
		if(difficulty.getNum() == 2) color = new Color(0, 255, 0, 100);
		if(difficulty.getNum() == 3) color = new Color(255, 255, 0, 100);
		if(difficulty.getNum() == 4) color = new Color(255, 128, 0, 100);
		if(difficulty.getNum() == 5) color = new Color(255, 0, 0, 100);
		g.setColor(color);
		g.fillRect(x,  y,  w,  h);
	}
	

	@Override
	public void collision(LivingObject living) {

		if (living.collisionDetector.isPlayer) {
			if (!stunned) {
				if (living.getBounds().intersects(getBigBounds()))
					updateFoe(living);
				if (living.getBoundsTop().intersects(getBigBounds()))
					updateFoe(living);
				if (living.getBoundsLeft().intersects(getBigBounds()))
					updateFoe(living);
				if (living.getBoundsRight().intersects(getBigBounds()))
					updateFoe(living);
			}
		}
	}

	private void verify() {
		if (Conductor.getState() == STATE.LEVEL && !HandlerObject.getInstance().player.isMotionless())
			HandlerObject.getInstance().player.loadBasicState();
	}

	private void updateFoe(LivingObject living) {
		if (living.collisionDetector.isPlayer) {
			GameObject dualfoe = new NullObject();

			LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
			for (GameObject tempObject2 : list) {
				if (tempObject2.getId() == OBJECTID.FOE) {
					FoeObject foe2 = (FoeObject) tempObject2;
					if (foe2 != this) {
						float distance = (float) Math
								.sqrt(Math.pow(getX() - foe2.getX(), 2) + Math.pow(getY() - foe2.getY(), 2));
						if (distance < FoeObject.foedualrange)
							dualfoe = tempObject2;
					}
				}
			}

			if (!HandlerObject.getInstance().player.isTasking() && living.isPlayerActive()
					&& Conductor.getState() != STATE.CHATTING) {
				HandlerObject.getInstance().player.setTasking(true);
				HandlerObject.getInstance().player.puzzle = new PuzzleCard(this, dualfoe, difficulty);
			} else
				verify();
		}
	}

	public Rectangle getBigBounds() {
		return new Rectangle(x, y, Size.TILE, Size.TILE);
	}

	private boolean isPlayerInSight() {
		float distance = (float) Math.sqrt(Math.pow(x - HandlerObject.getInstance().player.getX(), 2)
				+ Math.pow(y - HandlerObject.getInstance().player.getY(), 2));

		if (distance <= foesight)
			return true;
		else
			return false;
	}

	private void movingtoPlayer() {
		float diffX = x - HandlerObject.getInstance().player.getX();
		float diffY = y - HandlerObject.getInstance().player.getY();
		float distance = (float) Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));

		velX = foespeed * Math.round((-1 / distance) * diffX);
		velY = foespeed * Math.round((-1 / distance) * diffY);
	}

	public void stun() {
		stunned = true;
		stuntime = 30;
	}

	public void kill() {
		World.gui.getCharacteristics().setSureCrit(false);
		if (World.levelnum != 1)
			drop(0.05, new Loot(getX(), getY(), LOOTID.CRITCARD));
		HandlerObject.getInstance().removeObject(this);
	}

	private void checkEvent(int number) {
		if (World.levelnum == 1) {
			if (number == 1 && !World.world.getIEvent().hasOccured(9))
				World.world.getIEvent().setMustoccur(true, 8);
			if (number == 2)
				World.world.getIEvent().setMustoccur(true, 9);
		}

	}

}
