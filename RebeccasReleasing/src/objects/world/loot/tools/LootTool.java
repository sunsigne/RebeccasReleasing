package objects.world.loot.tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.system.handler.IRender;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.tools.BufferedTool;
import com.sunsigne.rebeccasreleasing.toverify.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;

import objects.world.loot.LootObject;

public class LootTool extends LootObject {

	private ToolBank toolBank;
	private BufferedTool tool;
	private DIFFICULTY difficulty;

	public LootTool(int x, int y, ToolBank toolBank, DIFFICULTY difficulty) {
		super(x, y);
		this.toolBank = toolBank;
		this.difficulty = difficulty;
		tool = createTool(toolBank, difficulty.getLvl());
	}

	public BufferedTool createTool(ToolBank toolBank, int toolLvl) {

		BufferedTool tool = null;

		var tools = ToolBank.getMap();
		for (ToolBank tempToolBank : tools.keySet()) {
			BufferedTool tempTool = tools.get(tempToolBank);
			if (tempToolBank == toolBank)
				tool = new BufferedTool(toolBank, tempTool.getName(), toolLvl, 0);
		}
		return tool;
	}

	public BufferedTool getTool() {
		return tool;
	}

	public DIFFICULTY getDifficulty() {
		return difficulty;
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

		var list = World.gui.getMap();
		for (ToolBank tempToolBank : list.keySet()) {
			if (tempToolBank == toolBank)
				World.gui.getTool(toolBank).upgradeLvlTo(tool.getCurrentLvl());
		}
	}

	public BufferedImage getTexture() {
		return TextureBank.getInstance().loot_tool[difficulty.getLvl()][toolBank.getIndex()];
	}

}
