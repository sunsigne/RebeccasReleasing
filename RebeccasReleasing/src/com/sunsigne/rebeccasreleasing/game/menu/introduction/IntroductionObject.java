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
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.GenerticListener;
import com.sunsigne.rebeccasreleasing.system.util.Size;

import objects.IFacing.FACING;

public class IntroductionObject extends CommunIntroductionObject implements IAnimation, ITranslation {

	private Animation animation;
	private GameFile[] gamefileFromLang = new GameFile[LANGUAGE.TOTALNUM + 1];
	private CommunIntroductionObject[] object = new CommunIntroductionObject[3];

	public IntroductionObject(ChatMap chatMap, ChatMap... chatMaps) {
		super();

		setOpacity(0f);

		languageMapping(chatMap, chatMaps);

		object[0] = new IntroductionHelmetObject();
		object[1] = new IntroductionRebeccaObject();
		object[2] = new IntroductionVladimirObject();
		for (CommunIntroductionObject tempobject : object) {
			HandlerObject.getInstance().addObject(tempobject);
		}
		setPhaseAll(3);
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

			// the credits appear
			brightenObject(this, () -> {
				setPhaseAll(1);
				// the credits stay a little
				new AutomaticTimerObject(120, () -> setPhaseAll(2));
			});
			break;
		case 2:
			// the credits desappear & Rebecca moves
			fadeObject(this, () -> setPhaseAll(3));
			break;
		case 3:
			rebeccaArrived();
			break;
		case 8:
			rebeccaJumped();
			break;
		case 10:
			// Rebecca desappear
			fadeObject(object[0], null);
			fadeObject(object[1], () -> {
				setPhaseAll(11);
				// A little wait before Vladimir apparition
				new AutomaticTimerObject(30, () -> setPhaseAll(12));
			});
			break;
		case 12:
			// Vladimir appear
			brightenObject(object[2], () -> vladimirApparead());
			break;
		case 17 :
			VladimirJumped();
			break;
/*		case 17:
			// Vladimir desappear
			fadeObject(object[2], () -> {
				setPhaseAll(18);
				// A little wait before Text apparition
				new AutomaticTimerObject(30, () -> setPhaseAll(19));
			});
			break;
*/		}

	}

	private void brightenObject(CommunIntroductionObject object, GenerticListener listener) {
		if (object.getOpacity() < 0.99f)
			object.setOpacity(object.getOpacity() + 0.04999f);
		else {
			object.setOpacity(1.0f);
			if (listener != null)
				listener.doAction();
		}
	}

	private void fadeObject(CommunIntroductionObject object, GenerticListener listener) {
		if (object.getOpacity() > 0f) {
			object.setOpacity(object.getOpacity() - 0.05f);
		} else if (listener != null)
			listener.doAction();
	}

	private void rebeccaArrived() {
		if (object[1].getX() >= initX + 800) {

			// Text This is Rebecca
			setPhaseAll(4);
			// Text desappear
			new AutomaticTimerObject(120, () -> setPhaseAll(5));
			// Text Rebecca is happy
			new AutomaticTimerObject(170, () -> setPhaseAll(6));
			// Text (She will get a super power)
			new AutomaticTimerObject(300, () -> setPhaseAll(7));
			// Text desappear
			new AutomaticTimerObject(460, () -> setPhaseAll(8));
		}
	}

	private void rebeccaJumped() {
		if (((IntroductionRebeccaObject) object[1]).getJumpCount() >= 4) {

			// Text All thanks to her helmet & Text (That's what give super powers)
			setPhaseAll(9);
			// Text and Rebecca desappear
			new AutomaticTimerObject(340, () -> setPhaseAll(10));
		}
	}

	private void vladimirApparead() {
		// Text This is Vladimir
		setPhaseAll(13);
		// Text desapear
		new AutomaticTimerObject(120, () -> setPhaseAll(14));
		// Text Vladimir is jealous
		new AutomaticTimerObject(170, () -> {
//			SoundTask.playSound(0.7f, SoundBank.getSound(SoundBank.jump));		
			setPhaseAll(15);
		});
		// Text (He also want a super power)
		new AutomaticTimerObject(300, () -> setPhaseAll(16));
		// Vladimir jumps twice
		new AutomaticTimerObject(440, () -> setPhaseAll(17));
	}
	
	private void VladimirJumped() {
		if (((IntroductionVladimirObject) object[2]).getJumpCount() >= 2) {

			// A little wait before Vladimir leaves
			setPhaseAll(18);
			// Vladimir moves
			new AutomaticTimerObject(20, () -> setPhaseAll(19));
			// Text and Vladimir desappear
			new AutomaticTimerObject(70, () -> setPhaseAll(20));
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
		case 4:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(2);
			drawText(g, gametext.getGap(), gametext.getText());
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
		case 9:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(5);
			drawText(g, gametext.getGap(), gametext.getText(), FACING.UP);
			gametext = getGameTextFromFile(6);
			drawText(g, gametext.getGap(), gametext.getText(), FACING.DOWN);
			break;
		case 13:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(7);
			drawText(g, gametext.getGap(), gametext.getText());
			break;
		case 15:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(8);
			drawText(g, gametext.getGap(), gametext.getText());
			break;
		case 16:
		case 17:
		case 18:
		case 19:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(8);
			drawText(g, gametext.getGap(), gametext.getText(), FACING.UP);
			gametext = getGameTextFromFile(9);
			drawText(g, gametext.getGap(), gametext.getText(), FACING.DOWN);
			break;
		}
	}

	private void drawCredits(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getOpacity()));

		drawAnimation(g, 360, 80, 1186, 613);
		g2d.drawImage(ImageBank.getImage(ImageBank.pierre_feuille_ciseaux_com), 555, 750, 850, 190, null);
	}

	private void drawText(Graphics g, int gap, String text) {
		drawText(g, gap, text, null);
	}

	private void drawText(Graphics g, int gap, String text, FACING facing) {
		Font font = new Font("arial", 1, 100);
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
