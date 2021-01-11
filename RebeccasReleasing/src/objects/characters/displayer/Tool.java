package objects.characters.displayer;

public class Tool {

	private int toolnum;
	public static final int KEY = 0;
	public static final int SWORD = 1;

	private int lvl;

	public Tool(int toolnum, int lvl) {
		this.toolnum = toolnum;
		setLvl(lvl);
	}

	public int getLvl() {
		return lvl;
	}

	private void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public void upgradeTool() {

		if (lvl < CharacteristicsSaved.batterySize[toolnum]) {
			setLvl(lvl + 1);
		}
	}

}
