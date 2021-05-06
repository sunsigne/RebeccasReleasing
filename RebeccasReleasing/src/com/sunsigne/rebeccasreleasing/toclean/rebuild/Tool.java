package com.sunsigne.rebeccasreleasing.toclean.rebuild;

public class Tool {

	private int toolnum;
	public static final int KEY = 0;
	public static final int SWORD = 1;
	public static final int BOMB = 2;
	public static final int GLASS = 3;
	public static final int PLIERS = 4;

	private int currentLvl;
	private int maxLvl;

	public Tool(int toolnum, int currentLvl, int maxLvl) {
		this.toolnum = toolnum;
		this.currentLvl = currentLvl;
		this.maxLvl = maxLvl;
	}
	
	public String getName()
	{
		switch(toolnum)
		{
		case 0 : return "Key";
		case 1 : return "Sword";
		case 2 : return "Bomb";
		case 3 : return "Glass";
		case 4 : return "Pliers";
		default : return "Unknown";
		}
	}
	
	public int getToolNum()
	{
		return toolnum;
	}

	public int getCurrentLvl() {
		return currentLvl;
	}
	
	public int getMaxLvl() {
		return maxLvl;
	}

	public void setCurrentLvl(int lvl) {
		this.currentLvl = lvl;
	}
	
	public void setMaxLvl(int maxLvl) {
		this.maxLvl = maxLvl;
	}

	public void upgradeLvlTo(int lvl) {

		if(currentLvl < lvl)
		{
			if (lvl < maxLvl)
				setCurrentLvl(lvl);
			else 
				setCurrentLvl(maxLvl);
		}
	
	}




}
