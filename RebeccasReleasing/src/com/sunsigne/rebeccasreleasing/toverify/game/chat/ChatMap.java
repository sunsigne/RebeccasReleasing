package com.sunsigne.rebeccasreleasing.toverify.game.chat;

import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.ressources.GameFile;

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
