package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.lazer.object;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.TextureBank;

public class ColorEnigmaBank {

	protected TextureBank texture = TextureBank.getInstance();

	public static ColorEnigmaMap[] index = new ColorEnigmaMap[36];

	public void loadRessources() {
		index[0] = new ColorEnigmaMap(DIFFICULTY.CYAN, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[0]);
		index[1] = new ColorEnigmaMap(DIFFICULTY.CYAN, WIRECOLOR.GREEN, texture.puzzle_lazer_color[1]);
		index[2] = new ColorEnigmaMap(DIFFICULTY.CYAN, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[2]);

		index[3] = new ColorEnigmaMap(DIFFICULTY.GREEN, WIRECOLOR.RED, texture.puzzle_lazer_color[3]);
		index[4] = new ColorEnigmaMap(DIFFICULTY.GREEN, WIRECOLOR.YELLOW, texture.puzzle_lazer_color[4]);
		index[5] = new ColorEnigmaMap(DIFFICULTY.GREEN, WIRECOLOR.BLUE, texture.puzzle_lazer_color[5]);
		index[6] = new ColorEnigmaMap(DIFFICULTY.GREEN, WIRECOLOR.YELLOW, texture.puzzle_lazer_color[6]);
		index[7] = new ColorEnigmaMap(DIFFICULTY.GREEN, WIRECOLOR.BLUE, texture.puzzle_lazer_color[7]);
		index[8] = new ColorEnigmaMap(DIFFICULTY.GREEN, WIRECOLOR.RED, texture.puzzle_lazer_color[8]);

		index[9] = new ColorEnigmaMap(DIFFICULTY.NONE, WIRECOLOR.RED, texture.puzzle_lazer_color[9]);
		index[10] = new ColorEnigmaMap(DIFFICULTY.NONE, WIRECOLOR.RED, texture.puzzle_lazer_color[10]);
		index[11] = new ColorEnigmaMap(DIFFICULTY.NONE, WIRECOLOR.RED, texture.puzzle_lazer_color[11]);

		index[12] = new ColorEnigmaMap(DIFFICULTY.YELLOW, WIRECOLOR.GREEN, texture.puzzle_lazer_color[12]);
		index[13] = new ColorEnigmaMap(DIFFICULTY.YELLOW, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[13]);
		index[14] = new ColorEnigmaMap(DIFFICULTY.YELLOW, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[14]);
		index[15] = new ColorEnigmaMap(DIFFICULTY.YELLOW, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[15]);
		index[16] = new ColorEnigmaMap(DIFFICULTY.YELLOW, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[16]);
		index[17] = new ColorEnigmaMap(DIFFICULTY.YELLOW, WIRECOLOR.GREEN, texture.puzzle_lazer_color[17]);
		
		index[18] = new ColorEnigmaMap(DIFFICULTY.RED, WIRECOLOR.RED, texture.puzzle_lazer_color[18]);
		index[19] = new ColorEnigmaMap(DIFFICULTY.RED, WIRECOLOR.YELLOW, texture.puzzle_lazer_color[19]);
		index[20] = new ColorEnigmaMap(DIFFICULTY.RED, WIRECOLOR.YELLOW, texture.puzzle_lazer_color[20]);
		index[21] = new ColorEnigmaMap(DIFFICULTY.RED, WIRECOLOR.BLUE, texture.puzzle_lazer_color[21]);
		index[22] = new ColorEnigmaMap(DIFFICULTY.RED, WIRECOLOR.BLUE, texture.puzzle_lazer_color[22]);
		index[23] = new ColorEnigmaMap(DIFFICULTY.RED, WIRECOLOR.RED, texture.puzzle_lazer_color[23]);
		
		index[24] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.GREEN, texture.puzzle_lazer_color[24]);
		index[25] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.GREEN, texture.puzzle_lazer_color[25]);
		index[26] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[26]);
		index[27] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[27]);
		index[28] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[28]);
		index[29] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[29]);
		index[30] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[30]);
		index[31] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[31]);
		index[32] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[32]);
		index[33] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[33]);
		index[34] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.GREEN, texture.puzzle_lazer_color[34]);
		index[35] = new ColorEnigmaMap(DIFFICULTY.ORANGE, WIRECOLOR.GREEN, texture.puzzle_lazer_color[35]);
	}
}
