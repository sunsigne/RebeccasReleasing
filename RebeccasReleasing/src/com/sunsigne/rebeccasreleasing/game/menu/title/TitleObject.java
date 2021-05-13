package com.sunsigne.rebeccasreleasing.game.menu.title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sunsigne.rebeccasreleasing.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.game.menu.GameText;
import com.sunsigne.rebeccasreleasing.game.menu.MenuObject;
import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.ressources.font.BufferedFontBank;
import com.sunsigne.rebeccasreleasing.ressources.font.FontTask;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.system.Game;

public class TitleObject extends MenuObject {

	private boolean enlarging;
	private double rotation;
	private int gap;

	public TitleObject(ChatMap chatMap, ChatMap... chatMaps) {
		super(chatMap, chatMaps);
	}

	@Override
	public void tick() {
		if (enlarging) {
			rotation += 0.05;
			gap++;
			if (rotation > 10)
				enlarging = false;
		} else {
			rotation -= 0.05;
			gap--;
			if (rotation <= 0)
				enlarging = true;
		}
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		drawFoe(g2d);
		drawPlayer(g2d);
		drawTitle(g);
		drawText(g);

		drawHitbox(g);
	}

	private void drawFoe(Graphics2D g2d) {
		g2d.rotate(Math.toRadians(-rotation), 150, 965);
		g2d.drawImage(ImageBank.getImage(ImageBank.foe), -50 - gap / 4, 270, 1050, 900, null);
		g2d.rotate(Math.toRadians(-10), 150, 965);
		g2d.rotate(Math.toRadians(-rotation), 150, 965);
		g2d.drawImage(ImageBank.getImage(ImageBank.hat), 325 - gap / 16, 300 - gap / 32, 230, 220, null);
		g2d.rotate(Math.toRadians(rotation), 150, 965);
		g2d.rotate(Math.toRadians(10), 150, 965);
		g2d.rotate(Math.toRadians(rotation), 150, 965);
	}

	private void drawPlayer(Graphics2D g2d) {
		g2d.rotate(Math.toRadians(rotation), 1555, 745);
		g2d.drawImage(ImageBank.getImage(ImageBank.chest), 1070 - gap / 4, 330 - gap / 8, 880 + gap / 2, 730 + gap / 4,
				null);
		g2d.rotate(Math.toRadians(-2 * rotation), 1555, 745);
		g2d.drawImage(ImageBank.getImage(ImageBank.arms), 1070 + gap / 4 - gap / 4, 330 - gap / 4 - gap / 8,
				880 + gap / 2, 730 + gap / 4, null);
		g2d.rotate(Math.toRadians(rotation), 1555, 745);
		g2d.rotate(Math.toRadians(-rotation), 1425, 540);
		g2d.drawImage(ImageBank.getImage(ImageBank.head), 1070 + gap / 8 - gap / 8, 330 - gap / 16, 860 + gap / 4,
				710 + gap / 8, null);
		g2d.rotate(Math.toRadians(rotation), 1425, 540);
	}

	private void drawTitle(Graphics g) {
		g.drawImage(ImageBank.getImage(ImageBank.title_1), 300, 00 + gap / 12, 1350, 250, null);
		g.drawImage(ImageBank.getImage(ImageBank.title_2), 470, 235 + gap / 12, 1000, 180, null);
	}

	private void drawText(Graphics g) {

		GameText gametext;
		gametext = getGameTextFromFile(2);
		drawShadowing(g, gametext.getText(), gametext.getGap(), 787, 640); // PLAY
		gametext = getGameTextFromFile(3);
		drawShadowing(g, gametext.getText(), gametext.getGap(), 725, 810); // OPTIONS
		gametext = getGameTextFromFile(4);
		drawShadowing(g, gametext.getText(), gametext.getGap(), 725, 980 + 10); // QUIT

	}

	private void drawShadowing(Graphics g, String text, int gap, int x, int y) {
		Font font = FontTask.createNewFont(BufferedFontBank.dogica_bold, 66f);
		g.setColor(new Color(255, 163, 0, 80));
		g.setFont(font);
		g.drawString(text, x + 4 + gap, y + 4);

		g.setColor(new Color(255, 204, 0));
		g.setFont(font);
		g.drawString(text, x + gap, y);

	}

	@Override
	public void drawHitbox(Graphics g) {
		if (Game.isDebugMode()) {
			g.setColor(Color.white);
			drawRect(g, Title.playRect);
			drawRect(g, Title.optionsRect);
			drawRect(g, Title.quitRect);
		}
//		g.drawImage(ImageLoader.cross, Width - 85, 10, 80, 80, null);
	}

}
