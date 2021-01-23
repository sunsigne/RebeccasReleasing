package com.sunsigne.rebeccasreleasing.toclean.rebuild;

public class CharacteristicsTemp {

	private boolean sureCrit;

	private Tool[] tools = new Tool[6];

	public CharacteristicsTemp() {
		tools[Tool.KEY] = new Tool(Tool.KEY, 1);
		tools[Tool.SWORD] = new Tool(Tool.SWORD, 5);
		tools[Tool.BOMB] = new Tool(Tool.BOMB, 1);
		tools[Tool.SEARCH] = new Tool(Tool.SEARCH, 1);
	}

	public boolean isSureCrit() {
		return sureCrit;
	}

	public void setSureCrit(boolean sureCrit) {
		this.sureCrit = sureCrit;
	}

	public Tool getTool(int num) {
		return tools[num];
	}

}
