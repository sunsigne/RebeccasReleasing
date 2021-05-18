package com.sunsigne.rebeccasreleasing.toverify.game.menu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.toverify.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.toverify.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public abstract class MenuObject extends GameObject implements ITranslation {

	public MenuObject(ChatMap chatMap, ChatMap... chatMaps) {
		super(false, LAYER.WOLRD_GUI_PUZZLE, 0, 0, OBJECTID.MENU);
		languageMapping(chatMap, chatMaps);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	protected void drawRect(Graphics g, int[] rect)
	{
		if(rect.length == 4)
		g.drawRect(rect[0], rect[1], rect[2], rect[3]);
		else System.err.println("the array rect in method drawRect should be 4 int long");
	}

	////////// LANGUAGE ////////////
	
	private final GameFile[] gamefileFromLang = new GameFile[LANGUAGE.getTotalLanguages() + 1];

	@Override
	public GameFile getGameFile(int number) {
		return gamefileFromLang[number];
	}

	@Override
	public void setGameFile(int number, GameFile gameFile) {
		this.gamefileFromLang[number] = gameFile;
	}

	
	
}
