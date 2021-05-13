package com.sunsigne.rebeccasreleasing.game.menu.options;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class Options extends Clickable {

	private static final ChatMap frOptions = new ChatMap(LANGUAGE.FRENCH, new GameFile("/menu/french/options"));
	private static final ChatMap engOptions = new ChatMap(LANGUAGE.ENGLISH, new GameFile("/menu/english/options"));
	
	private static LANGUAGE language;
	private static final GameFile options = new GameFile("options");
	public static final int[] languageRect = { 900, 210, 730, 90 };
	public static final int[] backRect = { 260, 810, 500, 90 };

	public Options() {
		super(STATE.OPTION);

		HandlerObject.getInstance().addObject(new OptionObject(frOptions, engOptions));
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

		if (currentlanguagenum + 1 > LANGUAGE.TOTALNUM)
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
		HandlerObject.getInstance().clearAll();
		new Title();
	}

}
