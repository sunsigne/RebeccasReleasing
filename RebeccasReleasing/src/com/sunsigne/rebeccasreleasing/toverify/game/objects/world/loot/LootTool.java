package com.sunsigne.rebeccasreleasing.toverify.game.objects.world.loot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.tools.BufferedTool;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.IRender;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;

public class LootTool extends LootObject {

	public LootTool(int x, int y, ToolBank toolBank, DIFFICULTY difficulty) {
		super(x, y);
		String name = ToolBank.getTool(toolBank).getName();
		int maxLvl = ToolBank.getTool(toolBank).getMaxLvl();

		this.tool = new BufferedTool(toolBank, name, difficulty.getLvl(), maxLvl);
	}

	private BufferedTool tool;

	public BufferedTool getTool() {
		return tool;
	}

	// design

	@Override
	public void render(Graphics g) {

		renderingTrueTool(g);
		renderingFakeTool(g);
	}

	private void renderingTrueTool(Graphics g) {

		if (!fake)
			g.drawImage(getTexture(), x, y, w, h, null);
	}

	private void renderingFakeTool(Graphics g) {

		if (Conductor.getDebugMode().getHitboxMode().getState()) {
			Graphics2D g2d = (Graphics2D) g;

			IRender.setTransluant(g2d, () -> {
				if (fake)
					g.drawImage(getTexture(), x, y, w, h, null);
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

		World.gui.getTool(tool.getToolBank()).upgradeLvlTo(tool.getCurrentLvl());
	}

	public BufferedImage getTexture() {
		return TextureBank.getInstance().loot_tool[tool.getCurrentLvl()][tool.getToolBank().getIndex()];
	}

}
