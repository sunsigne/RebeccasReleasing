package objects.world.loot.tools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;

import objects.world.loot.LootObject;

public class LootTool extends LootObject {

	private Tool tool;
	
	public LootTool(int x, int y, Tool tool) {
		super(x, y);
		this.tool = tool;
	}

	// design

	@Override
	public void render(Graphics g) {

		BufferedImage img = texture.loot_tool[tool.getLvl()][tool.getToolNum()];
		g.drawImage(img, x, y, w, h, null);
		drawHitbox(g);
	}

	// collision

	@Override
	protected String displayTextOnPickup() {
		return "Lvl" + " " + tool.getLvl() +  " " + tool.getName();
	}
	
	@Override
	protected void triggerActionOnPickup() {

		World.gui.getCharacteristics().getTool(tool.getToolNum()).upgradeLvlTo(tool.getLvl());
	}




}
