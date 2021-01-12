package objects.characters.living;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
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
import objects.characters.displayer.Tool;
import objects.world.puzzler.IPuzzler;
import objects.world.storing.LOOTID;
import objects.world.storing.Loot;
import objects.world.storing.Looting;

public class FoeObject extends LivingObject implements Looting, IPuzzler {

	public static final int foespeed = 4 * Size.TILE / 64;
	public static final int foesight = 400 * Size.TILE / 64;

	public static final int foedualrange = 200 * Size.TILE / 64;
	private GameObject dualObject = new NullObject();

	private boolean solved;
	private DIFFICULTY difficulty;
	private DIFFICULTY currentDifficulty;

	public boolean stunned;
	private int stuntime;

	public FoeObject(int x, int y) {
		this(x, y, DIFFICULTY.CYAN);
	}

	public FoeObject(int x, int y, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.FOE, FOE);

		this.difficulty = difficulty;
		this.currentDifficulty = difficulty;
		
		collisionDetector = new CollisionDetector(false, this);
	}

	// state

	@Override
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
	public DIFFICULTY getDifficulty() {
		return difficulty;
	}

	@Override
	public void setDifficulty(DIFFICULTY difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public void tick() {

		runAnimations();
		updateWatchingDirection();
		if (isPlayerActive() && Conductor.getState() != STATE.CHATTING)
			velocity();
		collisionDetector.update();
		updateDual();

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

	private void updateDual() {
		dualObject = new NullObject();
		currentDifficulty = difficulty;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject2 : list) {
			if (tempObject2.getId() == OBJECTID.FOE) {
				FoeObject foe2 = (FoeObject) tempObject2;
				if (foe2 != this) {
					float distance = (float) Math
							.sqrt(Math.pow(getX() - foe2.getX(), 2) + Math.pow(getY() - foe2.getY(), 2));
					if (distance < FoeObject.foedualrange) {
						dualObject = tempObject2;
						currentDifficulty = DIFFICULTY.getDifficulty(difficulty.getNum() + 1);
					}

				}
			}
		}
	}

	private void runAnimations() {
		for (int i = 1; i < 6; i++) {
			getAnimation(i, Size.DIRECTION_UP).runAnimation();
			getAnimation(i, Size.DIRECTION_DOWN).runAnimation();
			getAnimation(i, Size.DIRECTION_LEFT).runAnimation();
			getAnimation(i, Size.DIRECTION_RIGHT).runAnimation();
		}
	}

	@Override
	public void render(Graphics g) {

		renderingFoe(g);
		drawHitbox(g);
	}

	private void renderingFoe(Graphics g) {

		int difficulty = this.currentDifficulty.getNum();

		if (isMotionless()) {
			if (watching[Size.DIRECTION_UP])
				g.drawImage(texture.foe_walking[difficulty][1], x, y, w, h, null);
			if (watching[Size.DIRECTION_DOWN])
				g.drawImage(texture.foe_walking[difficulty][4], x, y, w, h, null);
			if (watching[Size.DIRECTION_LEFT])
				g.drawImage(texture.foe_walking[difficulty][7], x, y, w, h, null);
			if (watching[Size.DIRECTION_RIGHT])
				g.drawImage(texture.foe_walking[difficulty][10], x, y, w, h, null);
		}

		else {
			if (watching[Size.DIRECTION_UP])
				getAnimation(difficulty, Size.DIRECTION_UP).drawAnimation(g, x, y, w, h);
			if (watching[Size.DIRECTION_DOWN])
				getAnimation(difficulty, Size.DIRECTION_DOWN).drawAnimation(g, x, y, w, h);
			if (watching[Size.DIRECTION_LEFT])
				getAnimation(difficulty, Size.DIRECTION_LEFT).drawAnimation(g, x, y, w, h);
			if (watching[Size.DIRECTION_RIGHT])
				getAnimation(difficulty, Size.DIRECTION_RIGHT).drawAnimation(g, x, y, w, h);
		}

	}
	
	public Rectangle getBigBounds() {
		return new Rectangle(x, y, Size.TILE, Size.TILE);
	}


	@Override
	public void collision(LivingObject living) {

		if (living.collisionDetector.isPlayer) {
			if (!stunned) {
				if(touchingPlayer(living, this) && HandlerObject.getInstance().player.isPlayerActive())
				{
					if (hasToolLvl(currentDifficulty, Tool.SWORD))
						updatePuzzler(living, this);
					else pushPlayer();
				}
			}
		}
	}
	
	private boolean touchingPlayer(LivingObject living, GameObject currentObject) {
		if (living.getBounds().intersects(getBigBounds())) return true;
		if (living.getBoundsTop().intersects(getBigBounds())) return true;
		if (living.getBoundsLeft().intersects(getBigBounds())) return true;
		if (living.getBoundsRight().intersects(getBigBounds())) return true;
		return false;
	}

	
	private void pushPlayer() {
		stun();
		for (int direction = 0; direction < 4; direction++)
		{
			if (watching[direction]) HandlerObject.getInstance().player.pushed(direction);	
		}
	}

	@Todo("change FoeObject into instance of IPuzzle")
	@Override
	public Puzzle getPuzzle() {
		return new PuzzleCard(this, dualObject, currentDifficulty);
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
			if (number == 1 && !World.world.getIEvent().hasOccured(11))
				World.world.getIEvent().setMustoccur(true, 10);
			if (number == 2)
				World.world.getIEvent().setMustoccur(true, 11);
		}

	}

}
