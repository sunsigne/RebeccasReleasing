package objects.puzzle.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;

public class Card extends CardObject {

	private boolean exist;
	private boolean dragged;
	private boolean aboveRightFolder, aboveWrongFolder;
	private int startingX, startingY;
	private int upwardTime = 15;

	private boolean shouldHide;
	private int hiddingTime = 40;

	public Card(int x, int y, CardType cardtype) {
		super(x, y, OBJECTID.P_CARD, cardtype);

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

	public void willHide() {
		shouldHide = true;
	}

	@Override
	public void tick() {

		hiddingTime--;
		goUpward();

		if (isDragged()) {
			x = (int) GameMouseListener.getInstance().getPos().getX() - Size.TILE_PUZZLE / 2;
			y = (int) GameMouseListener.getInstance().getPos().getY() - Size.TILE_PUZZLE / 2;
		}
		collision();
	}

	private void goUpward() {
		if (upwardTime > 0) {
			if (hasSameOrderNumThanFolder(false) || (upwardTime > 10 && hasSameOrderNumThanFolder(true))) {
				upwardTime--;
				y = y - 7;
				startingY = startingY - 7;
			}
		}
	}

	@Override
	public void render(Graphics g) {

		Font font = new Font("arial", 1, 50);
		g.setFont(font);

		g.drawImage(ImageBank.getImage(ImageBank.card_frame), x, y, w, h, null);

		if (hiddingTime > 0 || !shouldHide) {
			drawCardContent(g);
			drawOrderLayer(g);
		} else
			drawMystery(g);

		drawHitbox(g);
	}

	private void drawCardContent(Graphics g) {

		if (getCardtype() == CardType.ATTACK) {
			g.setColor(Color.red);
			g.drawImage(ImageBank.getImage(ImageBank.card_attack), x, y, w, h, null);
			g.drawString("attack", x + 55, y + 45);
		}
		if (getCardtype() == CardType.CRITICAL) {
			g.setColor(new Color(255, 255, 0)); // yellow
			g.drawImage(ImageBank.getImage(ImageBank.card_critical), x, y, w, h, null);
			g.drawString("critical", x + 40, y + 45);
		}
		if (getCardtype() == CardType.DEFENSE) {
			g.setColor(new Color(0, 170, 0)); // green
			g.drawImage(ImageBank.getImage(ImageBank.card_defense), x, y, w, h, null);
			g.drawString("defense", x + 30, y + 45);
		}
	}

	private void drawMystery(Graphics g) {
		Font font = new Font("arial", 1, 300);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("?", x + w / 2 - 90, y + h / 2 + 50);
	}

	private void drawOrderLayer(Graphics g) {
		if (getOrderNum() != 0) {
			/*
			 * // write number Font font = new Font("arial", 1, 50); g.setFont(font);
			 * g.setColor(Color.BLACK); g.drawString(String.valueOf(getOrderNum()), x + w -
			 * 40, y + 45);
			 */
			// grey layer
			if (!hasSameOrderNumThanFolder(false)) {
				int alpha = 200;
				if (hasSameOrderNumThanFolder(true))
					alpha = 100;
				g.setColor(new Color(64, 64, 64, alpha));
				g.fillRect(x, y, w, h);
			}
		}
	}

	private boolean hasSameOrderNumThanFolder(boolean oneUnderInstead) {
		CardFolder folder = null;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list)
			if (tempObject.getId() == OBJECTID.P_CARDFOLDER) {
				folder = (CardFolder) tempObject;
				break;
			}

		if (oneUnderInstead)
			return folder.getOrderNum() == getOrderNum() - 1;
		else
			return folder.getOrderNum() == getOrderNum();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

	private void collision() {

		boolean flag = false;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());
		for (GameObject tempObject : list) {
			if (!flag && tempObject.getId() == OBJECTID.P_CARDFOLDER) {
				CardFolder folder = (CardFolder) tempObject;

				if (getBounds().intersects(folder.getBounds())) {
					if (folder.getOrderNum() == getOrderNum()) {
						if (folder.getCardtype() == getCardtype() || getCardtype() == CardType.CRITICAL)
							setAboveRightFolder(true);
						else if (folder.getCardtype() != getCardtype() && getCardtype() != CardType.CRITICAL)
							setAboveWrongFolder(true);
						flag = true;
					} else {
						setAboveWrongFolder(true);
						flag = true;
					}
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

		if (getCardtype() == CardType.ATTACK)
			SoundTask.playSound(SoundBank.getSound(SoundBank.hit_attack));
		if (getCardtype() == CardType.DEFENSE)
			SoundTask.playSound(SoundBank.getSound(SoundBank.hit_defense));
		if (getCardtype() == CardType.CRITICAL) {
			SoundTask.playSound(SoundBank.getSound(SoundBank.hit_critical));
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
