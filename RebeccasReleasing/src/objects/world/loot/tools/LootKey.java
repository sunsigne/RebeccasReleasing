package objects.world.loot.tools;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;

import objects.characters.displayer.Tool;

public class LootKey extends LootTool {

	public LootKey(int x, int y, DIFFICULTY difficulty) {
		super(x, y, difficulty);
	}

	@Override
	public String getName() {
		return "Key";
	}

	@Override
	public int getTool() {
		return Tool.KEY;
	}

	@Override
	public BufferedImage[] getTexture() {
		return texture.key;
	}

}
