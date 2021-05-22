package com.sunsigne.rebeccasreleasing.ressources.tools;

public class ToolIndex {

	private static int maxIndex = -1;

	public static int getTotalNumOfTools() {
		return maxIndex + 1;
	};
	
	public ToolIndex() {
		maxIndex++;
		index = maxIndex;
	}

	private int index;

	public int getIndex() {
		return index;
	}

}
