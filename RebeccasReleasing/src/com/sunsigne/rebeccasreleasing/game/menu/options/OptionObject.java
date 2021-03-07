package com.sunsigne.rebeccasreleasing.game.menu.options;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.menu.MenuObject;
import com.sunsigne.rebeccasreleasing.system.Game;

public class OptionObject extends MenuObject {

	public OptionObject() {
		super();

	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		Font font = new Font("arial", 1, 80);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("No option yet", 300, 200);
		g.drawString("options to creater :", 300, 350);
		g.drawString("music, sound, languages, keys", 300, 500);
		g.drawString("click anywhere to return to title", 300, 650);

		drawButtons(g);

		drawHitbox(g);

	}

	private void drawButtons(Graphics g) {
		switch (Options.getLanguage()) {
		case FRENCH:
			g.drawString("Français", 300, 800);
			break;

		case ENGLISH:
		default:
			g.drawString("English", 300, 800);
			break;
		}

	}

	@Override
	public void drawHitbox(Graphics g) {
		if (Game.isDebugMode()) {
			g.setColor(Color.white);
			drawRect(g, Options.languageRect);
		}
//		g.drawImage(ImageLoader.cross, Width - 85, 10, 80, 80, null);
	}

}
