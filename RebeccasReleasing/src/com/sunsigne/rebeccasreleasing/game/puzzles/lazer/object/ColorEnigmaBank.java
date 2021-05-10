package com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.ressources.images.TextureBank;

public class ColorEnigmaBank {

	protected TextureBank texture = TextureBank.getInstance();

	public static ColorEnigma[] index = new ColorEnigma[36];

	public void loadRessources() {
		index[0] = new ColorEnigma(DIFFICULTY.CYAN, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[0]);
		index[1] = new ColorEnigma(DIFFICULTY.CYAN, WIRECOLOR.GREEN, texture.puzzle_lazer_color[1]);
		index[2] = new ColorEnigma(DIFFICULTY.CYAN, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[2]);

		index[3] = new ColorEnigma(DIFFICULTY.GREEN, WIRECOLOR.RED, texture.puzzle_lazer_color[3]);
		index[4] = new ColorEnigma(DIFFICULTY.GREEN, WIRECOLOR.YELLOW, texture.puzzle_lazer_color[4]);
		index[5] = new ColorEnigma(DIFFICULTY.GREEN, WIRECOLOR.BLUE, texture.puzzle_lazer_color[5]);
		index[6] = new ColorEnigma(DIFFICULTY.GREEN, WIRECOLOR.YELLOW, texture.puzzle_lazer_color[6]);
		index[7] = new ColorEnigma(DIFFICULTY.GREEN, WIRECOLOR.BLUE, texture.puzzle_lazer_color[7]);
		index[8] = new ColorEnigma(DIFFICULTY.GREEN, WIRECOLOR.RED, texture.puzzle_lazer_color[8]);

		index[9] = new ColorEnigma(DIFFICULTY.NONE, WIRECOLOR.RED, texture.puzzle_lazer_color[9]);
		index[10] = new ColorEnigma(DIFFICULTY.NONE, WIRECOLOR.RED, texture.puzzle_lazer_color[10]);
		index[11] = new ColorEnigma(DIFFICULTY.NONE, WIRECOLOR.RED, texture.puzzle_lazer_color[11]);

		index[12] = new ColorEnigma(DIFFICULTY.YELLOW, WIRECOLOR.GREEN, texture.puzzle_lazer_color[12]);
		index[13] = new ColorEnigma(DIFFICULTY.YELLOW, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[13]);
		index[14] = new ColorEnigma(DIFFICULTY.YELLOW, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[14]);
		index[15] = new ColorEnigma(DIFFICULTY.YELLOW, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[15]);
		index[16] = new ColorEnigma(DIFFICULTY.YELLOW, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[16]);
		index[17] = new ColorEnigma(DIFFICULTY.YELLOW, WIRECOLOR.GREEN, texture.puzzle_lazer_color[17]);
		
		index[18] = new ColorEnigma(DIFFICULTY.RED, WIRECOLOR.RED, texture.puzzle_lazer_color[18]);
		index[19] = new ColorEnigma(DIFFICULTY.RED, WIRECOLOR.YELLOW, texture.puzzle_lazer_color[19]);
		index[20] = new ColorEnigma(DIFFICULTY.RED, WIRECOLOR.YELLOW, texture.puzzle_lazer_color[20]);
		index[21] = new ColorEnigma(DIFFICULTY.RED, WIRECOLOR.BLUE, texture.puzzle_lazer_color[21]);
		index[22] = new ColorEnigma(DIFFICULTY.RED, WIRECOLOR.BLUE, texture.puzzle_lazer_color[22]);
		index[23] = new ColorEnigma(DIFFICULTY.RED, WIRECOLOR.RED, texture.puzzle_lazer_color[23]);
		
		index[24] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.GREEN, texture.puzzle_lazer_color[24]);
		index[25] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.GREEN, texture.puzzle_lazer_color[25]);
		index[26] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[26]);
		index[27] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[27]);
		index[28] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[28]);
		index[29] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.PURPLE, texture.puzzle_lazer_color[29]);
		index[30] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[30]);
		index[31] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[31]);
		index[32] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[32]);
		index[33] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.ORANGE, texture.puzzle_lazer_color[33]);
		index[34] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.GREEN, texture.puzzle_lazer_color[34]);
		index[35] = new ColorEnigma(DIFFICULTY.ORANGE, WIRECOLOR.GREEN, texture.puzzle_lazer_color[35]);
	}
}
