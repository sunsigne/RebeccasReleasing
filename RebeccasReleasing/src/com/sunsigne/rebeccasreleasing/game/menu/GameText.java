package com.sunsigne.rebeccasreleasing.game.menu;

public class GameText {

	private int gap;
	private String text;
	
	public GameText(int gap, String text)
	{
		this.gap = gap;
		this.text = text;
	}

	public int getGap() {
		return gap;
	}
	
	public String getText() {
		return text;
	}
}
