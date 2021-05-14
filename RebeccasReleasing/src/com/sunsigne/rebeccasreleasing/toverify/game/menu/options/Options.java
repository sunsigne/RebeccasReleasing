package com.sunsigne.rebeccasreleasing.toverify.game.menu.options;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.toverify.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;

import objects.GameObject;

public class Options extends Clickable {

	private static final ChatMap fr = new ChatMap(LANGUAGE.FRENCH, new GameFile("texts/french/menu"));
	private static final ChatMap eng = new ChatMap(LANGUAGE.ENGLISH, new GameFile("texts/english/menu"));
	private static final ChatMap custom = new ChatMap(LANGUAGE.CUSTOM, new GameFile("texts/custom/menu"));
	
	private static LANGUAGE language;
	private static final GameFile options = new GameFile("data/options");
	public static final int[] languageRect = { 900, 210, 730, 90 };
	public static final int[] backRect = { 260, 810, 500, 90 };

	private static GameObject object;
	
	public Options() {
		super(STATE.OPTION);

		object = new OptionObject(fr, eng, custom);
//		object.add();
		HandlerObject.getInstance().addObject(object);
	}

	public static void loadSavedSettings() {
		language = getLanguageSaved();
	}

	@Override
	public void mousePressed(int mx, int my) {
		if (GameMouseInput.mouseOver(mx, my, languageRect))
			setNextLanguage();
		if (GameMouseInput.mouseOver(mx, my, backRect))
			close();
	}

	@Override
	public void mouseReleased(int mx, int my) {

	}

	// other

	private static void setLanguage(LANGUAGE language) {
		Options.language = language;
		int languagevalue = language.getNum();
		FileTask.write(options, "LANGUAGE=" + languagevalue);
	}

	public static LANGUAGE getLanguage() {
		return language;
	}

	private static LANGUAGE getLanguageSaved() {

		LANGUAGE language;
		try {
			String languagetxt = FileTask.read(options);
			int languagenum = Integer.valueOf(languagetxt.split("=")[1]);

			language = LANGUAGE.getLanguage(languagenum);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("As the saved language can't be found, default language is set as English");
			language = LANGUAGE.ENGLISH;
		}
		return language;

	}

	private static void setNextLanguage() {
		LANGUAGE firstlanguage = LANGUAGE.getLanguage(1);
		LANGUAGE currentlanguage = getLanguageSaved();
		int currentlanguagenum = currentlanguage.getNum();

		if (currentlanguagenum + 1 > LANGUAGE.getTotalLanguages())
			setLanguage(firstlanguage);
		else {
			LANGUAGE nextlanguage = LANGUAGE.getLanguage(currentlanguagenum + 1);
			setLanguage(nextlanguage);
		}

	}

	@Override
	public void render(Graphics g) {
		gradientRender(g);
	}

	@Override
	public void close() {
		GameMouseInput.getInstance().clearClickable();
//		object.remove();
		HandlerObject.getInstance().clearFront();
		new Title();
	}

}
