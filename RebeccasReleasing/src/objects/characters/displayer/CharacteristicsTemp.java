package objects.characters.displayer;

public class CharacteristicsTemp {

	private boolean sureCrit;

	private Tool[] tools = new Tool[6];

	public CharacteristicsTemp() {
		tools[Tool.KEY] = new Tool(Tool.KEY, 1);
		tools[Tool.SWORD] = new Tool(Tool.SWORD, 5);
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
