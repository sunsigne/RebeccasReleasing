package objects.characters.living;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.card.clickable.PuzzleCard;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.IFacing.FACING;
import objects.world.puzzler.IPuzzler;

public class FoeObject extends LivingObject implements IPuzzler {

	public static final int SPEED = 4 * Size.TILE / 64;
	public static final int SIGHT_RANGE = 400 * Size.TILE / 64;
	public static final int MULTIPLE_FOE_RANGE = 200 * Size.TILE / 64;
	public static final int MAX_ADDITIONAL_FOES_AT_SAME_FIGHT = 4;

	private Animation[][] animation = new Animation[DIFFICULTY.MAX + 1][4];

	private EventListener eventOnVictory, eventOnDefeat;

	private DIFFICULTY difficulty;
	private DIFFICULTY currentDifficulty;
	private boolean solved;

	private FoeObject[] multipleFoe = new FoeObject[MAX_ADDITIONAL_FOES_AT_SAME_FIGHT];

	public boolean stunned;
	private int stuntime;

	public FoeObject(int x, int y, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.FOE);

		this.difficulty = difficulty;
		this.currentDifficulty = difficulty;
	}

	// state

	@Override
	public Animation getAnimation(int array, int secondarray) {

		if (animation[array][secondarray] == null) {
			if (secondarray == FACING.LEFT.getNum())
				animation[array][secondarray] = new Animation(10, texture.foe_walking[array][6],
						texture.foe_walking[array][7], texture.foe_walking[array][8], texture.foe_walking[array][7]);
			else if (secondarray == FACING.RIGHT.getNum())
				animation[array][secondarray] = new Animation(10, texture.foe_walking[array][9],
						texture.foe_walking[array][10], texture.foe_walking[array][11], texture.foe_walking[array][10]);
			else if (secondarray == FACING.UP.getNum())
				animation[array][secondarray] = new Animation(10, texture.foe_walking[array][0],
						texture.foe_walking[array][1], texture.foe_walking[array][2], texture.foe_walking[array][1]);
			else if (secondarray == FACING.DOWN.getNum())
				animation[array][secondarray] = new Animation(10, texture.foe_walking[array][3],
						texture.foe_walking[array][4], texture.foe_walking[array][5], texture.foe_walking[array][4]);

			else
				animation[array][secondarray] = new Animation(1);
		}
		return animation[array][secondarray];
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

	public float getDistanceBetween(GameObject objectA, GameObject objectB) {
		float distance = (float) Math
				.sqrt(Math.pow(objectA.getX() - objectB.getX(), 2) + Math.pow(objectA.getY() - objectB.getY(), 2));

		return distance;
	}

	private boolean isPlayerInSight() {
		float distance = getDistanceBetween(this, HandlerObject.getInstance().player);

		if (distance <= SIGHT_RANGE)
			return true;
		else
			return false;
	}

	// behavior

	@Override
	public void tick() {
		runAnimations();
		livingTickBehavior(false);

		checkMultipleFoes();

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

	private void runAnimations() {
		for (int i = DIFFICULTY.MIN; i < DIFFICULTY.MAX + 1; i++) {
			runAnimation(i, FACING.LEFT.getNum());
			runAnimation(i, FACING.RIGHT.getNum());
			runAnimation(i, FACING.UP.getNum());
			runAnimation(i, FACING.DOWN.getNum());			
		}
	}

	public void stun() {
		stunned = true;
		stuntime = 30;
	}

	public void kill() {
		World.gui.getCharacteristics().setSureCrit(false);
		HandlerObject.getInstance().removeObject(this);
	}

	private void movingtoPlayer() {
		float diffX = x - HandlerObject.getInstance().player.getX();
		float diffY = y - HandlerObject.getInstance().player.getY();
		float distance = (float) Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));

		velX = SPEED * Math.round((-1 / distance) * diffX);
		velY = SPEED * Math.round((-1 / distance) * diffY);
	}

	private void checkMultipleFoes() {
		currentDifficulty = difficulty;
		int count = 0;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
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
		drawHitbox(g);
	}

	private void renderingFoe(Graphics g) {

		int difficulty = this.currentDifficulty.getLvl();

		if (isMotionless() || !isPlayerActive()) {
			if (watching[FACING.LEFT.getNum()])
				g.drawImage(texture.foe_walking[difficulty][7], x, y, w, h, null);
			if (watching[FACING.RIGHT.getNum()])
				g.drawImage(texture.foe_walking[difficulty][10], x, y, w, h, null);
			if (watching[FACING.UP.getNum()])
				g.drawImage(texture.foe_walking[difficulty][1], x, y, w, h, null);
			if (watching[FACING.DOWN.getNum()])
				g.drawImage(texture.foe_walking[difficulty][4], x, y, w, h, null);
		}

		else {
			if (watching[FACING.LEFT.getNum()])
				drawAnimation(difficulty, FACING.LEFT.getNum(), g, x, y, w, h);
			if (watching[FACING.RIGHT.getNum()])
				drawAnimation(difficulty, FACING.RIGHT.getNum(), g, x, y, w, h);
			if (watching[FACING.UP.getNum()])
				drawAnimation(difficulty, FACING.UP.getNum(), g, x, y, w, h);
			if (watching[FACING.DOWN.getNum()])
				drawAnimation(difficulty, FACING.DOWN.getNum(), g, x, y, w, h);
		}

	}

	// collision

	public Rectangle getBigBounds() {
		return new Rectangle(x, y, Size.TILE, Size.TILE);
	}

	@Override
	public void collision(LivingObject living) {

		if (living.isPlayer()) {
			if (!stunned) {
				if (touchingPlayer(living) && HandlerObject.getInstance().player.isPlayerActive()) {
					if (hasToolLvl(currentDifficulty, Tool.SWORD))
						updatePuzzler(living);
					else
						pushPlayer();
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
				HandlerObject.getInstance().player.pushed(direction);
		}
	}

	@Override
	public Puzzle getPuzzle() {
		return new PuzzleCard(this, multipleFoe, currentDifficulty);
	}

}
