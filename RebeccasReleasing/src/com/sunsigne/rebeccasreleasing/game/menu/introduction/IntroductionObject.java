package com.sunsigne.rebeccasreleasing.game.menu.introduction;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.game.menu.GameText;
import com.sunsigne.rebeccasreleasing.game.menu.ITranslation;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.IFacing.FACING;

public class IntroductionObject extends CommunIntroductionObject implements IAnimation, ITranslation {

	private Animation animation;
	private GameFile[] gamefileFromLang = new GameFile[LANGUAGE.TOTALNUM + 1];
	private CommunIntroductionObject[] object = new CommunIntroductionObject[1];

	private float opacity = 0f;

	public IntroductionObject(ChatMap chatMap, ChatMap... chatMaps) {
		super();

		languageMapping(chatMap, chatMaps);

		for (int i = 0; i < 1; i++) {
			object[i] = new IntroductionRebeccaObject();
			HandlerObject.getInstance().addObject(object[i]);
		}
	}

	// state

	@Override
	public Animation getAnimation(int... array) {
		if (animation == null)
			animation = new Animation(10, texture.pierre_feuille_ciseaux[0], texture.pierre_feuille_ciseaux[1],
					texture.pierre_feuille_ciseaux[2], texture.pierre_feuille_ciseaux[3]);
		return animation;
	}

	@Override
	public GameFile getGameFile(int number) {
		return gamefileFromLang[number];
	}

	@Override
	public void setGameFile(int number, GameFile gameFile) {
		this.gamefileFromLang[number] = gameFile;
	}

	private void setPhaseAll(int phase) {
		setPhase(phase);
		for (CommunIntroductionObject tempObject : object) {
			tempObject.setPhase(phase);
		}
	}

	// behavior

	@Override
	public void tick() {
		runAnimation();
		runPhase();
	}

	private void runPhase() {
		switch (getPhase()) {
		case 0:
			creditBrighten();
			break;
		case 1:
			break;
		case 2:
			creditFade();
			break;
		case 3:
			rebeccaArrive();
			break;
		case 4:
			break;
		}

	}

	private void creditBrighten() {
		if (opacity < 0.99f)
			opacity += 0.04999f;
		else {
			setPhaseAll(1);
			new AutomaticTimerObject(120, () -> setPhaseAll(2));
		}
	}

	private void creditFade() {
		if (opacity > 0f)
			opacity -= 0.05f;
		else
			setPhaseAll(3);
	}

	private void rebeccaArrive() {
		if (object[0].getX() >= initX + 800) {
			setPhaseAll(4);
			new AutomaticTimerObject(120, () -> setPhaseAll(5));
			new AutomaticTimerObject(170, () -> setPhaseAll(6));
			new AutomaticTimerObject(280, () -> setPhaseAll(7));
		}
	}

	// render

	@Override
	public void render(Graphics g) {

		GameText gametext;

		switch (getPhase()) {
		case 0:
		case 1:
		case 2:
			drawCredits(g);
			break;
		case 3:
			break;
		case 4:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(2);
			drawText(g, gametext.getGap(), gametext.getText());
			break;
		case 5:
			break;
		case 6:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(3);
			drawText(g, gametext.getGap(), gametext.getText());
			break;
		case 7:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(3);
			drawText(g, gametext.getGap(), gametext.getText(), FACING.UP);
			gametext = getGameTextFromFile(4);
			drawText(g, gametext.getGap(), gametext.getText(), FACING.DOWN);
			break;
		}
	}

	private void drawCredits(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

		drawAnimation(g, 360, 80, 1186, 613);
		g2d.drawImage(ImageBank.getImage(ImageBank.pierre_feuille_ciseaux_com), 555, 750, 850, 190, null);
	}

	private void drawText(Graphics g, int gap, String text) {
		drawText(g, gap, text, null);
	}

	private void drawText(Graphics g, int gap, String text, FACING facing) {
		Font font = new Font("arial", 1, 110);
		int h0 = 0;
		
		if (facing == FACING.UP)
			h0 = -40;
		if (facing == FACING.DOWN) {
			font = new Font("arial", 1, 70);
			h0 = 60;
		}
		g.setFont(font);
		g.setColor(Color.white);

		g.drawString(text, 100 + gap, 240 + h0);
	}

}
