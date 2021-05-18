package com.sunsigne.rebeccasreleasing.toverify.game.menu.options;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.system.util.Cycloid;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.title.Title;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;

public class Options extends Clickable {

	private static final ChatMap fr = new ChatMap(LANGUAGE.FRENCH, new GameFile("texts/french/menu"));
	private static final ChatMap eng = new ChatMap(LANGUAGE.ENGLISH, new GameFile("texts/english/menu"));
	private static final ChatMap custom = new ChatMap(LANGUAGE.CUSTOM, new GameFile("texts/custom/menu"));
	
	private static Cycloid<LANGUAGE> language = createLanguageCycloid();
	private static final GameFile options = new GameFile("data/options");
	public static final int[] languageRect = { 900, 210, 730, 90 };
	public static final int[] backRect = { 260, 810, 500, 90 };

	private static GameObject object;
	
	public Options() {
		super(STATE.OPTION);

		object = new OptionObject(fr, eng, custom);
		HandlerObject.getInstance().addObject(object);
	}
	
	private static Cycloid<LANGUAGE> createLanguageCycloid() {
		
		int totalLanguage = LANGUAGE.getTotalLanguages();
		LANGUAGE[] languages = new LANGUAGE[totalLanguage];
		
		for(int i = 0; i < totalLanguage; i++)
		{
			languages[i] = LANGUAGE.getLanguage(i + 1);
		}
		
		Cycloid<LANGUAGE> cycloid = new Cycloid<>(languages);
		return cycloid;
	}

	@Override
	public LAYER getLayer() {
		return LAYER.WOLRD_GUI_PUZZLE;
	}

	public static void loadSavedSettings() {
		language.setState(getLanguageSaved());
	}

	@Override
	public void mousePressed(int mx, int my) {
		if (GameMouseInput.mouseOver(mx, my, languageRect))
		{
			language.cycle();
			registerNewLanguage();
		}
		if (GameMouseInput.mouseOver(mx, my, backRect))
			close();
	}

	@Override
	public void mouseReleased(int mx, int my) {

	}

	// other

	private static void registerNewLanguage() {
		int languagevalue = language.getState().getNum();
		FileTask.write(options, "LANGUAGE=" + languagevalue);
	}

	public static LANGUAGE getLanguage() {
		return language.getState();
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
/*
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
*/
	@Override
	public void render(Graphics g) {
		gradientRender(g);
	}

	@Override
	public void close() {
		clearClickable();
		HandlerObject.getInstance().clear(false, LAYER.WOLRD_GUI_PUZZLE);
		new Title();
	}

}
