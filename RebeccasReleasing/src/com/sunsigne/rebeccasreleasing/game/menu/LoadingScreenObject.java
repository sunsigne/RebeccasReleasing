package com.sunsigne.rebeccasreleasing.game.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;

public class LoadingScreenObject extends GameObject {

	private boolean running;

	public LoadingScreenObject() {
		super(false, 0, 0, OBJECTID.LOADING);
	}

	public void start() {
		running = true;
	}

	public void stop() {
		running = false;
	}

	@Override
	public void tick() {
		if (running) {

		}
	}

	@Override
	public void render(Graphics g) {
		if (running) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Size.WIDHT, Size.HEIGHT);

			int gap = getGapFromLanguage();
			String text = getTxtFromLanguage();
			Font font = new Font("arial", 1, 150);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString(text, 480 + gap, Size.HEIGHT / 2 + 50);
		}
	}

	private int getGapFromLanguage() {
		switch (Options.getLanguage()) {
		case ENGLISH:
			return 160;
		case FRENCH:
		default:
			return 0;
		}
	}

	private String getTxtFromLanguage() {
		String text;
		switch (Options.getLanguage()) {

		case FRENCH:
			text = "Chargement";
			break;
		case ENGLISH:
		default:
			text = "Loading";
			break;
		}
		return text;
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
