package com.sunsigne.rebeccasreleasing.ressources.font;

public class BufferedFontBank {

	public static final BufferedFontBank dogica_bold = new BufferedFontBank("dogicabold");
	
	
	private String fontName;
	
	private BufferedFontBank(String fontName)
	{
		this.fontName = fontName;
	}

	public String getFontName() {
		return fontName;
	}
}
