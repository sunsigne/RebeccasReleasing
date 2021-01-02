package objects.puzzle.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;

public class Card extends CardObject {

	private boolean exist;
	private boolean dragged;
	private boolean aboveRightFolder, aboveWrongFolder;
	private int startingX, startingY;

	public Card(int x, int y, CardType cardtype) {
		super(x, y, OBJECTID.HEAD, cardtype);

		setExist(true);
		startingX = x;
		startingY = y;

		w = Size.TILE_PUZZLE * 2;
		h = Size.TILE_PUZZLE * 3;
	}

	// state

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public void setDragged(boolean dragged) {
		this.dragged = dragged;
	}

	public void setAboveRightFolder(boolean aboveFolder) {
		this.aboveRightFolder = aboveFolder;
	}

	public void setAboveWrongFolder(boolean aboveWrongFolder) {
		this.aboveWrongFolder = aboveWrongFolder;
	}

	public boolean doesExist() {
		return exist;
	}

	public boolean isDragged() {
		return dragged;
	}

	public boolean isAboveRightFolder() {
		return aboveRightFolder;
	}

	public boolean isAboveWrongFolder() {
		return aboveWrongFolder;
	}

	@Override
	public void tick() {

		if (isDragged()) {
			x = (int) GameMouseListener.getInstance().getPos().getX() - Size.TILE_PUZZLE / 2;
			y = (int) GameMouseListener.getInstance().getPos().getY() - Size.TILE_PUZZLE / 2;
		}
		collision();
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font("arial", 1, 50);
		g.setFont(font);

		g.drawImage(ImageBank.card_frame, x, y, w, h, null);
		if (getCardtype() == CardType.attack) {
			g.setColor(Color.red);
			g.drawImage(ImageBank.card_attack, x, y, w, h, null);
			g.drawString("attack", x + 55, y + 45);
		}
		if (getCardtype() == CardType.critical) {
			g.setColor(new Color(255, 255, 0)); // yellow
			g.drawImage(ImageBank.card_critical, x, y, w, h, null);
			g.drawString("critical", x + 40, y + 45);
		}
		if (getCardtype() == CardType.defense) {
			g.setColor(new Color(0, 170, 0)); // green
			g.drawImage(ImageBank.card_defense, x, y, w, h, null);
			g.drawString("defense", x + 30, y + 45);
		}

		drawHitbox(g);
	}
		
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

	private void collision() {

		boolean flag = false;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list) {
			if (!flag && tempObject.getId() == OBJECTID.TAIL) {
				CardFolder folder = (CardFolder) tempObject;

				if (getBounds().intersects(folder.getBounds())) {
					if (folder.getCardtype() == getCardtype() || getCardtype() == CardType.critical)
						setAboveRightFolder(true);
					else if (folder.getCardtype() != getCardtype() && getCardtype() != CardType.critical)
						setAboveWrongFolder(true);
					flag = true;
				}

				if (!getBounds().intersects(folder.getBounds())) {
					setAboveRightFolder(false);
					setAboveWrongFolder(false);
				}
			}
		}
	}

	public void playCard() {
		setExist(false);

		if (getCardtype() == CardType.attack)
			AudioTask.playSound(AudioBank.hit_attack);
		if (getCardtype() == CardType.defense)
			AudioTask.playSound(AudioBank.hit_defense);
		if (getCardtype() == CardType.critical) {
			AudioTask.playSound(AudioBank.hit_critical);
			{
			HandlerObject.getInstance().player.puzzle.setWinning(true);
			HandlerObject.getInstance().player.puzzle.close();
			}
		}
		HandlerObject.getInstance().removeObject(this);
	}

	public void resetPos() {
		x = startingX;
		y = startingY;
	}


}
