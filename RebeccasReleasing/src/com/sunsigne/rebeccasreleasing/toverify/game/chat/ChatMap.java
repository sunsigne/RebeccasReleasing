package com.sunsigne.rebeccasreleasing.toverify.game.chat;

import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;

public class ChatMap {

	private LANGUAGE language;
	private GameFile gamefile;
	
	public ChatMap(LANGUAGE language, GameFile gamefile)
	{
		this.language = language;
		this.gamefile = gamefile;
	}

	public LANGUAGE getLanguage() {
		return language;
	}

	public GameFile getGameFile() {
		return gamefile;
	}

}
