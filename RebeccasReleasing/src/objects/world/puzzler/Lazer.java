package objects.world.puzzler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.clickable.PuzzleLazer;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.IFacing.FACING;
import objects.characters.living.LivingObject;

public class Lazer extends GameObject implements IPuzzler {

	private EventListener eventOnVictory, eventOnDefeat;

	private DIFFICULTY difficulty;
	private boolean solved;
	private int facing;

	private boolean horizontal;
	
	public Lazer(int x, int y, int facing, boolean solved, DIFFICULTY difficulty) {
		super(true, x, y, OBJECTID.LAZER);

		this.difficulty = difficulty;
		this.solved = solved;
		setSize(facing);
	}

	// state

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

	@Override
	public void setSolved(boolean solved) {
		this.solved = solved;
		if(solved) solveNeighbors();
	}

	private void setSize(int facing) {
		this.facing = facing;
		if(facing == 0 || facing == 1 || facing == 4)
		{
			horizontal = true;
			h = Size.TILE/3;
			miniY = Size.TILE/3;
		}
		else
		{
			horizontal = false;
			w = Size.TILE/3;
			miniX = Size.TILE/3;
		}
			
	}
	
	// behavior

	private void solveNeighbors() {
		GameObject firstNeighbor = horizontal ? getObjectAtPos(x - Size.TILE, y) : getObjectAtPos(x, y - Size.TILE);
		GameObject secondNeighbor = horizontal ? getObjectAtPos(x + Size.TILE, y) : getObjectAtPos(x, y + Size.TILE);
		Lazer firstLazer;
		Lazer secondLazer;
		
		if (firstNeighbor != null && firstNeighbor.getId() == OBJECTID.LAZER)
		{
			firstLazer = (Lazer) firstNeighbor;
			if(!firstLazer.isSolved()) firstLazer.setSolved(true);
		}
			
		if (secondNeighbor != null && secondNeighbor.getId() == OBJECTID.LAZER)
		{
			secondLazer = (Lazer) secondNeighbor;
			if(!secondLazer.isSolved()) secondLazer.setSolved(true);
		}
	}
	
	private GameObject getObjectAtPos(int x, int y) {
		return HandlerObject.getInstance().getObjectAtPos(x, y);
	}
	
	@Override
	public void tick() {
	}

	// design

	@Override
	public void render(Graphics g) {

		BufferedImage img = paintingLazer();
		g.drawImage(img, x, y, Size.TILE, Size.TILE, null);
		drawHitbox(g);
	}

	private BufferedImage paintingLazer() {

		BufferedImage img = null;
		int difficulty = getDifficulty().getLvl();
		int solved = isSolved() ? 1 : 0;
		img = texture.puzzler_lazer[difficulty][facing][solved];

		return img;
	}

	// collision

	@Override
	public Rectangle getBounds() {

		if(horizontal)
		return new Rectangle(x, y + miniY, w, h);
		else return new Rectangle(x + miniX, y, w, h);
	}

	@Override
	public void collision(LivingObject living) {

		if (!isSolved()) {

			if (hasToolLvl(Tool.PLIERS))
				openPuzzle(living, this);
			else
/*				{
				if (living.isPlayer()) {
					living.getCollisionDetector().collidingBehavior(true, this, () -> pushPlayer());
				}
				else*/ blockPass(living, this);
//				}
		}
	}
	

	private void pushPlayer() {

		int velX = HandlerObject.getInstance().player.getVelX();
		int velY = HandlerObject.getInstance().player.getVelY();
		int direction = 0;
		
		if(!horizontal)
		{
			if(velX > 0) direction = FACING.LEFT.getNum();
			else direction = FACING.RIGHT.getNum();
		}
		
		else
		{
			if(velY > 0) direction = FACING.UP.getNum();
			else direction = FACING.DOWN.getNum();
		}
		
		HandlerObject.getInstance().player.pushed(direction);
	}


	@Override
	public Puzzle getPuzzle() {
		return new PuzzleLazer(this, getDifficulty());
	}

}
