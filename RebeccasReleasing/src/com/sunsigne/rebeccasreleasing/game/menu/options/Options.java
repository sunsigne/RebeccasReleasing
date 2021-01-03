package com.sunsigne.rebeccasreleasing.game.menu.options;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class Options extends Clickable {

	private static LANGUAGE language;
	private static final String options = "options";
	public static final int[] languageRect = { 300, 720, 360, 90 };

	public Options() {
		super(STATE.OPTION);

		HandlerObject.getInstance().addObject(new OptionObject());
	}

	public static void loadLanguage() {
		language = getLanguageSaved();
	}

	@Override
	public void mousePressed(int mx, int my) {
		if (GameMouseListener.mouseOver(mx, my, languageRect)) {
			setNextLanguage();
		} else
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
			String languagetxt = FileTask.read(options, 0);
			String languagetxtnum = languagetxt.substring(9);
			int languagenum = Integer.valueOf(languagetxtnum);

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

	public void close() {
		GameMouseListener.getInstance().clearClickable();
		HandlerObject.getInstance().clearAll();
		new Title();
	}

}
