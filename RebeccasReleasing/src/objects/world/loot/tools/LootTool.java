package objects.world.loot.tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.system.handler.IRender;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.toclean.Tool;

import objects.world.loot.LootObject;

public class LootTool extends LootObject {

	private Tool tool;

	public LootTool(int x, int y, Tool tool, boolean fake) {
		super(x, y, fake);
		this.tool = tool;
	}

	// design

	@Override
	public void render(Graphics g) {

		BufferedImage img = texture.loot_tool[tool.getCurrentLvl()][tool.getToolNum()];

		renderingTrueTool(g, img);
		renderingFakeTool(g, img);
	}

	private void renderingTrueTool(Graphics g, BufferedImage img) {

		if (!fake)
			g.drawImage(img, x, y, w, h, null);
	}

	private void renderingFakeTool(Graphics g, BufferedImage img) {

		if (Game.getDebugMode().getState()) {
			Graphics2D g2d = (Graphics2D) g;

			IRender.setTransluant(g2d, () -> {
				if (fake)
					g.drawImage(img, x, y, w, h, null);
			});
		}
	}

	// collision

	@Override
	protected String displayTextOnPickup() {
		return "Lvl" + " " + tool.getCurrentLvl() + " " + tool.getName();
	}

	@Override
	protected void triggerActionOnPickup() {

		World.gui.getTool(tool.getToolNum()).upgradeLvlTo(tool.getCurrentLvl());
	}

}
