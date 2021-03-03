package objects.characters;

public enum CHARA {

	FOE(0),
	REBECCA(1),
	SARAH(2);
	

	private int num;

	CHARA(int num) {

		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public static CHARA getChara(int num) {

		CHARA chara = null;

		for (CHARA tempchara : CHARA.values()) {
			if (tempchara.getNum() == num)
				chara = tempchara;
		}

		return chara;
	}

}
