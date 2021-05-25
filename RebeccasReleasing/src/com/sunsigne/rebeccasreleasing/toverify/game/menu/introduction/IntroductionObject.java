package com.sunsigne.rebeccasreleasing.toverify.game.menu.introduction;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.GenericListener;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.GameText;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.ITranslation;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.BonusText;

public class IntroductionObject extends CommunIntroductionObject implements IAnimation, ITranslation {

	private Animation animation;
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
	}

	// state

	@Override
	public Animation getAnimation(int... array) {
		if (animation == null)
			animation = new Animation(10, texture.pierre_feuille_ciseaux[0], texture.pierre_feuille_ciseaux[1],
					texture.pierre_feuille_ciseaux[2], texture.pierre_feuille_ciseaux[3]);
		return animation;
	}

	private void setPhaseAll(int phase) {
		setPhase(phase);
		for (CommunIntroductionObject tempObject : object) {
			tempObject.setPhase(phase);
		}
	}
	
	@Override
	int getMaxJumpCount() {
		return 0;
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
			rebeccaShownHelmet();
			break;
		case 12:
			// Vladimir appear
			brightenObject(object[2], () -> vladimirApparead());
			break;
		case 17:
			VladimirJumped();
			break;
		case 19:
			VladimirMoved();
			break;
		case 23:
			VladimirWillSteal();
			break;
		case 30:
			VladimirLeft();
			break;
		case 32:
			RebeccaLeft();
			break;
		}

	}

	private void brightenObject(CommunIntroductionObject object, GenericListener listener) {
		if (object.getOpacity() < 0.99f)
			object.setOpacity(object.getOpacity() + 0.04999f);
		else {
			object.setOpacity(1.0f);
			if (listener != null)
				listener.doAction();
		}
	}

	private void fadeObject(CommunIntroductionObject object, GenericListener listener) {
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
		if (object[1].getJumpCount() >= 4) {

			// Text All thanks to her helmet & Text (That's what give super powers)
			setPhaseAll(9);
			// Text and Rebecca desappear
			new AutomaticTimerObject(250, () -> setPhaseAll(10));
		}
	}

	private void rebeccaShownHelmet() {
		// Rebecca desappear
		fadeObject(object[0], null);
		fadeObject(object[1], () -> {
			setPhaseAll(11);
			// A little wait before Vladimir apparition
			new AutomaticTimerObject(30, () -> setPhaseAll(12));
		});
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
		if (object[2].getJumpCount() >= 2) {

			// A little wait before Vladimir leaves
			setPhaseAll(18);
			// Vladimir moves
			new AutomaticTimerObject(50, () -> setPhaseAll(19));
		}
	}

	private void VladimirMoved() {
		// Vladimir desappear
		if (object[2].getX() <= initX + 200) {
			fadeObject(object[2], () -> {
				// A little wait before Text apparition
				setPhaseAll(20);
				// Text So ...
				new AutomaticTimerObject(60, () -> setPhaseAll(21));
				// Text desappear
				new AutomaticTimerObject(150, () -> setPhaseAll(22));
				// A little wait before Rebecca apparition
				new AutomaticTimerObject(190, () -> setPhaseAll(23));
			});
		}
	}

	private void VladimirWillSteal() {
		brightenObject(this, null);
		brightenObject(object[0], null);
		brightenObject(object[1], null);
		brightenObject(object[2], () -> {
			// A little wait before Vladimir moves
			setPhaseAll(24);
			// Vladimir move and hit
			new AutomaticTimerObject(40, () -> 
			{
				object[1].jumpCount = 3;
				setPhaseAll(25);
			});
			// Vladimir move back
			new AutomaticTimerObject(50, () -> setPhaseAll(26));
			// Vladimir stop moving
			new AutomaticTimerObject(60, () -> setPhaseAll(27));
			// Text desappear
			new AutomaticTimerObject(80, () -> setPhaseAll(28));
			// Vladimir loot the helmet
			new AutomaticTimerObject(160, () -> 
			{
				lootHelmet();
				setPhaseAll(29);
			});
			// Vladimir leaves
			new AutomaticTimerObject(220, () -> setPhaseAll(30));
		});
	}
	
	private void lootHelmet()
	{
		new SoundTask().playSound(0.7f, SoundBank.PLAYER_LOOT);
		BonusText text = new BonusText(object[2].getX() + 25, object[2].getY() + 50, "+1 casque");
		HandlerObject.getInstance().addObject(text);
	}
	
	private void VladimirLeft() {
		if (object[2].getX() >= initX + 2800) {
			// A little wait before Rebecca wakes up
			setPhaseAll(31);
			// A little wait before Rebecca leaves
			new AutomaticTimerObject(180, () -> setPhaseAll(32));
		}
	}
	
	private void RebeccaLeft() {
		if (object[1].getX() >= initX + 2000) {
			// Text desappear
			setPhaseAll(33);
			// End of the introduction
			new AutomaticTimerObject(80, () -> Conductor.closeIntroduction());
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
			drawText(g, gametext.getGap(), gametext.getText(), DIRECTION.UP);
			gametext = getGameTextFromFile(4);
			drawText(g, gametext.getGap(), gametext.getText(), DIRECTION.DOWN);
			break;
		case 9:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(5);
			drawText(g, gametext.getGap(), gametext.getText(), DIRECTION.UP);
			gametext = getGameTextFromFile(6);
			drawText(g, gametext.getGap(), gametext.getText(), DIRECTION.DOWN);
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
			drawText(g, gametext.getGap(), gametext.getText(), DIRECTION.UP);
			gametext = getGameTextFromFile(9);
			drawText(g, gametext.getGap(), gametext.getText(), DIRECTION.DOWN);
			break;
		case 21:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(10);
			drawText(g, gametext.getGap(), gametext.getText());
			break;
		case 31:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(11);
			drawText(g, gametext.getGap(), gametext.getText());
			break;
		case 32:
			g.drawImage(texture.interface_chat, 0, -650, Size.WIDHT, Size.HEIGHT, null);
			gametext = getGameTextFromFile(12);
			drawText(g, gametext.getGap(), gametext.getText());
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

	private void drawText(Graphics g, int gap, String text, DIRECTION facing) {
		int h0 = 0;

		if (facing == DIRECTION.UP)
			h0 = -40;
		if (facing == DIRECTION.DOWN) {
			font = new Font("arial", 1, 70);
			h0 = 60;
		}
		g.setFont(font);
		g.setColor(Color.white);

		g.drawString(text, 100 + gap, 240 + h0);
	}
	
	////////// LANGUAGE ////////////

	private final GameFile[] gamefileFromLang = new GameFile[LANGUAGE.getTotalLanguages() + 1];
	private Font font = new Font("arial", 1, 100);
	
	@Override
	public GameFile getGameFile(int number) {
		return gamefileFromLang[number];
	}

	@Override
	public void setGameFile(int number, GameFile gameFile) {
		this.gamefileFromLang[number] = gameFile;
	}


}
