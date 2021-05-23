package com.sunsigne.rebeccasreleasing.ressources.tools;

public class ToolIndex {

	private static int TotalNumOfTools;

	public static int getTotalNumOfTools() {
		return TotalNumOfTools;
	};
	
	public ToolIndex() {
		index = TotalNumOfTools;
		TotalNumOfTools++;
	}

	private int index;

	public int getIndex() {
		return index;
	}

}
