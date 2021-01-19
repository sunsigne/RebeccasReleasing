package com.sunsigne.rebeccasreleasing.game.chat;

import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;

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
