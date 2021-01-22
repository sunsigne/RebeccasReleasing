package com.sunsigne.rebeccasreleasing.toclean.rebuild;

import com.sunsigne.rebeccasreleasing.game.world.World;

public class Tool {

	private int toolnum;
	public static final int KEY = 0;
	public static final int SWORD = 1;

	private int lvl;

	public Tool(int toolnum, int lvl) {
		this.toolnum = toolnum;
		this.lvl = lvl;
	}
	
	public String getName()
	{
		switch(toolnum)
		{
		case 0 : return "Key";
		case 1 : return "Sword";
		default : return "Unknown";
		}
	}
	
	public int getToolNum()
	{
		return toolnum;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public void upgradeLvlTo(int lvl) {

		int currentLvl = World.gui.getCharacteristics().getTool(toolnum).getLvl();
		int lvlMax = CharacteristicsSaved.batterySize[toolnum];
		
		if(currentLvl < lvl)
		{
			if (lvl < lvlMax)
				setLvl(lvl);
			else 
				setLvl(lvlMax);
		}
	
	}

}
