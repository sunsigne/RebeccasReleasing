package objects.characters.living;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.toverify.Todo;
import com.sunsigne.rebeccasreleasing.toverify.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.clickable.PuzzleCard;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

import objects.GameObject;
import objects.world.loot.ILoot;
import objects.world.loot.LootObject;
import objects.world.puzzler.IPuzzler;

public class FoeObject extends LivingObject implements IPuzzler, ILoot {

	public static final int SPEED = 4 * Size.TILE / 64;
	public static final int SIGHT_RANGE = 400 * Size.TILE / 64;
	public static final int MULTIPLE_FOE_RANGE = 200 * Size.TILE / 64;
	public static final int MAX_ADDITIONAL_FOES_AT_SAME_FIGHT = 4;

	private Animation[][] animation = new Animation[7][4];

	private EventListener eventOnVictory, eventOnDefeat;

	private DIFFICULTY difficulty;
	private DIFFICULTY currentDifficulty;
	private boolean solved;

	private FoeObject[] multipleFoe = new FoeObject[MAX_ADDITIONAL_FOES_AT_SAME_FIGHT];

	private LootObject loot;
	public boolean stunned;
	private int stuntime;
	private boolean statue;

	public FoeObject(int x, int y, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.FOE);

		this.difficulty = difficulty;
		this.currentDifficulty = difficulty;
	}

	// state

	@Override
	public Animation getAnimation(int... array) {

		int difficulty = array[0];
		int facing = array[1];

		if (animation[difficulty][facing] == null)
			animation[difficulty][facing] = new Animation(10, texture.living_foe_walking[difficulty][facing][0],
					texture.living_foe_walking[difficulty][facing][1],
					texture.living_foe_walking[difficulty][facing][2],
					texture.living_foe_walking[difficulty][facing][3]);

		return animation[difficulty][facing];
	}

	@Override
	public EventListener getEventOnClose() {
		if (solved)
			return eventOnVictory;
		else
			return eventOnDefeat;
	}

	@Override
	public void setEventOnClose(EventListener eventOnClose, boolean onVictory) {
		if (onVictory)
			this.eventOnVictory = eventOnClose;
		else
			this.eventOnDefeat = eventOnClose;
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
	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
		if (solved)
			kill();
	}

	@Override
	public LootObject getLootObject() {
		return loot;
	}

	@Override
	public void setLootObject(LootObject loot) {
		this.loot = loot;
	}

	public float getDistanceBetween(GameObject objectA, GameObject objectB) {
		float distance = (float) Math
				.sqrt(Math.pow(objectA.getX() - objectB.getX(), 2) + Math.pow(objectA.getY() - objectB.getY(), 2));

		return distance;
	}

	private boolean isPlayerInSight() {
		float distance = getDistanceBetween(this, HandlerObject.getInstance().getPlayer());

		if (distance <= SIGHT_RANGE)
			return true;
		else
			return false;
	}

	// behavior

	@Override
	public void tick() {
		runAnimation(this.currentDifficulty.getLvl(), getFacing().getNum());
		livingTickBehavior(false);

		if (!statue) {
			checkMultipleFoes();

			if (!stunned) {
				if (isPlayerInSight())
					movingtoPlayer();
//			else setMotionless();
			}

			else {
				setMotionless();
				if (stuntime > 0)
					--stuntime;
				else
					stunned = false;
			}
		}
	}

	public void stun() {
		stunned = true;
		stuntime = 30;
	}

	public void setStatue(boolean statue) {
		this.statue = statue;
		if (statue) {
			setMotionless();
			setFacing(FACING.DOWN);
			setDifficulty(difficulty);
		}
	}

	public void kill() {
		HandlerObject.getInstance().removeObject(this);
		loot();
	}

	@Override
	public void loot() {
		if (getLootObject() != null) {
			getLootObject().setX(x);
			getLootObject().setY(y);
			HandlerObject.getInstance().addObject(getLootObject());
		}
	}

	@Todo("create a pathfinding")
	private void movingtoPlayer() {
		float diffX = x - HandlerObject.getInstance().getPlayer().getX();
		float diffY = y - HandlerObject.getInstance().getPlayer().getY();
		float distance = (float) Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));

		velX = SPEED * Math.round((-1 / distance) * diffX);
		velY = SPEED * Math.round((-1 / distance) * diffY);
	}

	private void checkMultipleFoes() {
		currentDifficulty = difficulty;
		int count = 0;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant(), getCameraLayer());
		for (GameObject tempObject : list) {
			if (tempObject != this && tempObject.getId() == OBJECTID.FOE) {
				float distance = (float) Math
						.sqrt(Math.pow(getX() - tempObject.getX(), 2) + Math.pow(getY() - tempObject.getY(), 2));
				if (distance < FoeObject.MULTIPLE_FOE_RANGE) {
					if (count < MAX_ADDITIONAL_FOES_AT_SAME_FIGHT)
						multipleFoe[count] = (FoeObject) tempObject;
					count++;
				}
			}
		}
		updateDifficulty(count);
	}

	private void updateDifficulty(int numberOfLvl) {

		if (difficulty.getLvl() + numberOfLvl < DIFFICULTY.MAX)
			currentDifficulty = DIFFICULTY.getDifficulty(difficulty.getLvl() + numberOfLvl);
		else
			currentDifficulty = DIFFICULTY.RED;
	}

	// design

	@Override
	public void render(Graphics g) {

		renderingFoe(g);
		drawLootable(g);
	}
	
	private void drawLootable(Graphics g) {
		if (Game.isDebugMode()) {
			if (loot != null)
				loot.render(g);
		}
	}


	private void renderingFoe(Graphics g) {
		int difficulty = this.currentDifficulty.getLvl();
		if (statue)
			difficulty = this.difficulty.getLvl();
		int facing = getFacing().getNum();

		if (isMotionless() || !isPlayerActive())
			g.drawImage(texture.living_foe_walking[difficulty][facing][1], x, y, w, h, null);
		else
			drawAnimation(g, x, y, w, h, difficulty, facing);

	}

	// collision

	public Rectangle getBigBounds() {
		return new Rectangle(x, y, Size.TILE, Size.TILE);
	}

	@Override
	public void collision(LivingObject living) {

		if (living.isPlayer()) {
			if (statue)
				living.getCollisionDetector().collidingBehaviorBetweenFoes(living, this);
			else {
				if (!stunned) {
					if (touchingPlayer(living) && HandlerObject.getInstance().getPlayer().isPlayerActive()) {
						if (hasToolLvl(currentDifficulty, Tool.SWORD) || Game.isMultiToolMode())
							updatePuzzler(living);
						else
							pushPlayer();
					}
				}
			}

		} else if (living != this)
			living.getCollisionDetector().collidingBehaviorBetweenFoes(living, this);
	}

	private boolean touchingPlayer(LivingObject living) {
		if (living.getBounds().intersects(getBigBounds()))
			return true;
		if (living.getBoundsTop().intersects(getBigBounds()))
			return true;
		if (living.getBoundsLeft().intersects(getBigBounds()))
			return true;
		if (living.getBoundsRight().intersects(getBigBounds()))
			return true;
		return false;
	}

	private void pushPlayer() {
		stun();
		for (int direction = 0; direction < 4; direction++) {
			if (watching[direction])
				HandlerObject.getInstance().getPlayer().pushed(direction);
		}
	}

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleCard(this, multipleFoe, currentDifficulty);
	}

}
