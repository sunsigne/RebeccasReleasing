package objects.characters.displayer;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;

public class CharacteristicsTemp {

	private boolean sureCrit;
	
	/*
	 * 0 - key
	 * 1 - foe
	 */
	private DIFFICULTY[] tools = {DIFFICULTY.CYAN, DIFFICULTY.CYAN};

	
	public boolean isSureCrit() {
		return sureCrit;
	}

	public void setSureCrit(boolean sureCrit) {
		this.sureCrit = sureCrit;
	}


	public void setTool(DIFFICULTY lvl, int num) {
		this.tools[num] = lvl;
	}	

	public DIFFICULTY getTool(int num) {
		return tools[num];
	}
	
	public void upgradeTool(int toolnum) {

		int tool_lvl = tools[toolnum].getNum();
		if(tool_lvl < CharacteristicsSaved.batterySize[toolnum])
		{
			DIFFICULTY better_lvl = DIFFICULTY.getDifficulty(tool_lvl + 1);
			setTool(better_lvl, toolnum);
		}			
	}

}
