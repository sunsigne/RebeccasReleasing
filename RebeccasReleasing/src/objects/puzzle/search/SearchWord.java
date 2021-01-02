package objects.puzzle.search;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;
import objects.puzzle.PuzzleObject;

public class SearchWord extends PuzzleObject {

	private boolean movingUP, movingLeft;
	private int startingX, startingY;
	private boolean exist, dragged, aboveFolder, stable;
	private boolean isGoodWord;
	private int speed = 4;

	private int wordnumber;
	private String text;

	public SearchWord(int wordnumber, int x, int y) {
		super(x, y, OBJECTID.HEAD);

		setExist(true);
		setStable(true);
		this.wordnumber = wordnumber;

		startingX = x;
		startingY = y;

		w = Size.TILE_PUZZLE * 3;
		h = Size.TILE_PUZZLE;

		RandomMovement();
		RandomWord();

	}

	// state

	private void RandomMovement() {
		double r0 = Math.random();
		double r1 = Math.random();
		if (r0 <= 0.5)
			movingUP = true;
		if (r1 <= 0.5)
			movingLeft = true;
	}

	private void RandomWord() {
		if (wordnumber == 1) {
			setGoodWord(true);
			setStable(false);
			text = "    TOP";
		}
		if (wordnumber == 2) {
			setGoodWord(true);
			setStable(false);
			text = "SECRET";
		}
		if (wordnumber == 3) {
			text = "    T0P";
		}
		if (wordnumber == 4) {
			text = "    IOP";
		}
		if (wordnumber == 5) {
			text = "SECR3T";
		}
		if (wordnumber == 6) {
			text = "SEC2ET";
		}
		if (wordnumber == 7) {
			text = "5ECRET";
		}
		if (wordnumber == 8) {
			text = "SECREI";
		}
	}

	public void setGoodWord(boolean isGood) {
		this.isGoodWord = isGood;
	}

	public boolean isGoodWord() {
		return isGoodWord;
	}

	// state

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public void setDragged(boolean dragged) {
		this.dragged = dragged;
	}

	public void setAboveFolder(boolean aboveFolder) {
		this.aboveFolder = aboveFolder;
	}

	public void setStable(boolean stable) {
		this.stable = stable;
	}

	public boolean doesExist() {
		return exist;
	}

	public boolean isDragged() {
		return dragged;
	}

	public boolean isAboveFolder() {
		return aboveFolder;
	}

	public boolean isStable() {
		return stable;
	}

	@Override
	public void tick() {

		if (!isDragged())
			velocity();
		if (isDragged()) {
			x = (int) GameMouseListener.getInstance().getPos().getX() - Size.TILE_PUZZLE;
			y = (int) GameMouseListener.getInstance().getPos().getY() - Size.TILE_PUZZLE / 2;
		}
		collision();
		goUpandDown();
		goLeftandRight();
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font(Font.DIALOG, 1, 70);
		g.setFont(font);
		g.setColor(new Color(255, 80, 80));
		g.drawRect(x + 25, y, 8 * Size.TILE_PUZZLE / 3, Size.TILE_PUZZLE);
		g.drawRect(x + 24, y - 1, 8 * Size.TILE_PUZZLE / 3 + 2, Size.TILE_PUZZLE + 2);
		g.drawRect(x + 23, y - 2, 8 * Size.TILE_PUZZLE / 3 + 4, Size.TILE_PUZZLE + 4);
		g.drawString(text, x + 5 * Size.TILE_PUZZLE / 12, y + 2 * Size.TILE_PUZZLE / 3);

		drawHitbox(g);
	}	

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

	private void collision() {

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.TAIL) {
				if (getBounds().intersects(tempObject.getBounds()))
					setAboveFolder(true);
				if (!getBounds().intersects(tempObject.getBounds()))
					setAboveFolder(false);
			}
		}
	}

	private void goUpandDown() {
		if (movingUP) {
			velY = -speed;
			if (y < Size.Y0 + h + Size.TILE_PUZZLE/12)
				movingUP = false;
		} else {
			velY = speed;
			if (y > Size.HEIGHT - 9 * Size.TILE_PUZZLE / 4)
				movingUP = true;
		}
	}

	private void goLeftandRight() {
		if (movingLeft) {
			velX = -speed;
			if (x < 11 * Size.TILE_PUZZLE / 8)
				movingLeft = false;
		} else {
			velX = speed;
			if (x > 127 * Size.TILE_PUZZLE / 12)
				movingLeft = true;
		}
	}

	public void placeWord() {
		if (isGoodWord) {
			setExist(false);
			setStable(true);
			HandlerObject.getInstance().removeObject(this);
			AudioTask.playSound(0.6, AudioBank.place_word);
		} else
			HandlerObject.getInstance().player.puzzle.close();
	}

	public void resetPos() {
		x = startingX;
		y = startingY;
	}

}
