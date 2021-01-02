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

public class CardReversed extends CardObject {

	private boolean dual, exist, dragged, abovefolder, stable;
	private int startingX, startingY;

	public CardReversed(int x, int y, CardType cardtype) {
		super(x, y, OBJECTID.HEAD, cardtype);

		startingX = x;
		startingY = y;

		w = Size.TILE_PUZZLE * 2;
		h = Size.TILE_PUZZLE * 3;
	}

	// state

	public void setDual(boolean dual) {
		this.dual = dual;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public void setDragged(boolean dragged) {
		this.dragged = dragged;
	}

	public void setAboveFolder(boolean abovefolder) {
		this.abovefolder = abovefolder;
	}

	public void setStable(boolean stable) {
		this.stable = stable;
	}

	public boolean isDual() {
		return dual;
	}

	public boolean doesExist() {
		return exist;
	}

	public boolean isDragged() {
		return dragged;
	}

	public boolean isAboveFolder() {
		return abovefolder;
	}

	public boolean isStable() {
		return stable;
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

		if (doesExist()) {
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
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

	private void collision() {
		
		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.TAIL) {
				CardFolderReversed folder = (CardFolderReversed) tempObject;
				if (folder.getCardtype() == CardType.reversed) {
					if (getBounds().intersects(folder.getBounds()))
						setAboveFolder(true);
					else if (!getBounds().intersects(folder.getBounds()))
						setAboveFolder(false);
				}
			}
		}
	}

	public void playCard() {
		setExist(true);
		setDragged(true);

		if (getCardtype() == CardType.attack)
			AudioTask.playSound(AudioBank.r_hit_attack);
		if (getCardtype() == CardType.defense)
			AudioTask.playSound(AudioBank.r_hit_defense);
		if (getCardtype() == CardType.critical)
			AudioTask.playSound(AudioBank.r_hit_critical);
	}

	public void resetPos() {
		if (getCardtype() == CardType.critical) {
			HandlerObject.getInstance().player.puzzle.setWinning(true);
		}
		setStable(true);
		x = startingX;
		y = startingY;
	}

}
