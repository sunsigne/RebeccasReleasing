package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

public enum WIRECOLOR {

		RED(0),
		ORANGE(1),
		YELLOW(2),
		GREEN(3),
		BLUE(4),
		PURPLE(5);
		
		private int num;

		WIRECOLOR(int num) {

			this.num = num;
		}

		public int getNum() {
			return num;
		}
		
		public static WIRECOLOR getColor(int num) {

			WIRECOLOR color = null;

			for (WIRECOLOR allcolor : WIRECOLOR.values()) {
				if (allcolor.getNum() == num)
					color = allcolor;
			}

			return color;
		}
		

	
}
