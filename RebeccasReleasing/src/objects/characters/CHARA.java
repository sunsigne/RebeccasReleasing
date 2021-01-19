package objects.characters;

public enum CHARA {

	NONE(0),
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

		for (CHARA allchara : CHARA.values()) {
			if (allchara.getNum() == num)
				chara = allchara;
		}

		return chara;
	}

}
