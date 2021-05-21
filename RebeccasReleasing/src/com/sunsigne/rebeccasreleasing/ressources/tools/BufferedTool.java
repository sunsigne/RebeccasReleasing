package com.sunsigne.rebeccasreleasing.ressources.tools;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.toverify.ressources.images.TextureBank;

public class BufferedTool {

	public BufferedTool(ToolBank toolBank, String name, int currentLvl, int maxLvl) {
		this.toolBank = toolBank;
		this.name = name;
		this.currentLvl = currentLvl;
		this.maxLvl = maxLvl;
	}

	private ToolBank toolBank;
	private String name;

	public ToolBank getToolBank() {
		return toolBank;
	}

	public String getName() {
		return name;
	}

	////////// LEVEL ////////////

	private int currentLvl;
	private int maxLvl;

	public int getCurrentLvl() {
		return currentLvl;
	}

	private void setCurrentLvl(int lvl) {
		this.currentLvl = lvl;
	}

	public int getMaxLvl() {
		return maxLvl;
	}

	public void upgradeLvlTo(int lvl) {

		if (currentLvl < lvl) {
			if (lvl < maxLvl)
				setCurrentLvl(lvl);
			else
				setCurrentLvl(maxLvl);
		}
	}

	////////// RENDER ////////////

	public BufferedImage getTexture() {
		return TextureBank.getInstance().gui_tool[toolBank.getIndex()];
	}
}
