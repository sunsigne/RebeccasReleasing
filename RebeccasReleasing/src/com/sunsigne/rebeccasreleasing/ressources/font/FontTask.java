package com.sunsigne.rebeccasreleasing.ressources.font;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class FontTask {

	// I prefere to let it public
	// to make it easier for modders and devellopers in adding content
	public static Font createNewFont(BufferedFontBank bufferedFontBank, float size) {

		Font font = null;

		try {
			File file = new File("ressources\\font\\" + bufferedFontBank.getFontName() + ".ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(size);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);

		} catch (Exception e) {
			e.printStackTrace();
			font = new Font("arial", 1, 55);
		}

		return font;

	}
}
