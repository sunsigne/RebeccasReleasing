package com.sunsigne.rebeccasreleasing.ressources.font;

import java.util.HashMap;
import java.util.Map;

import com.sunsigne.rebeccasreleasing.ressources.Ressource;

public class FontBank implements Ressource {

	////////// MAP OR LIST ////////////

	private static Map<FontBank, BufferedFont> fonts = new HashMap<>();

	// public for devs
	public void addFont(FontBank fontBank, BufferedFont bufferedFound) {

		if (bufferedFound != null)
			fonts.put(fontBank, bufferedFound);
	}

	public BufferedFont getFont(FontBank fontBank) {
		return fonts.get(fontBank);
	}

	////////// BANK ////////////

	public static final FontBank DOGICA_BOLD = new FontBank();
	public static final FontBank FRIZQUADRATATT = new FontBank();

	////////// RESSOURCES ////////////

	@Override
	public void loadBareMinimumRessources() {
	}

	@Override
	public void loadRessources() {

		addFont(DOGICA_BOLD, new BufferedFont("dogicabold"));
		addFont(FRIZQUADRATATT, new BufferedFont("frizQuadrataTT"));
	}
}
