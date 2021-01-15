package com.sunsigne.rebeccasreleasing.game.chat;

import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;

public class ChatMap {

	private LANGUAGE language;
	private String filename;
	
	public ChatMap(LANGUAGE language, String filename)
	{
		this.language = language;
		this.filename = filename;
	}

	public LANGUAGE getLanguage() {
		return language;
	}

	public String getFilename() {
		return filename;
	}

}
