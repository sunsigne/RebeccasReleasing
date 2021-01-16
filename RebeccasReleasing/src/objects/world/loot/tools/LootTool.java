package objects.world.loot.tools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.world.World;

import objects.world.loot.LootObject;

public abstract class LootTool extends LootObject {

	private DIFFICULTY difficulty;
	
	public LootTool(int x, int y, DIFFICULTY difficulty) {
		super(x, y);
		this.setDifficulty(difficulty);
	}
	
	// state

	public DIFFICULTY getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(DIFFICULTY difficulty) {
		this.difficulty = difficulty;
	}	
	
	public abstract String getName();
	
	public abstract int getTool();
	
	// design

	public abstract BufferedImage [] getTexture();
	
	@Override
	public void render(Graphics g) {

		BufferedImage img = getTexture()[difficulty.getLvl()];
		g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	// collision

	@Override
	protected String displayTextOnPickup() {
		return "Lvl" + " " + difficulty.getLvl() +  " " + getName();
	}
	
	@Override
	protected void triggerActionOnPickup() {

		World.gui.getCharacteristics().getTool(getTool()).upgradeLvlTo(difficulty.getLvl());
	}




}
