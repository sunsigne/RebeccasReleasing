package com.sunsigne.rebeccasreleasing.toverify.toclean;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.ressources.tools.BufferedTool;
import com.sunsigne.rebeccasreleasing.ressources.tools.ToolBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class GUI extends GameObject implements Characteristics {

	private Map<ToolBank, BufferedTool> tools = new HashMap<>();

	private int maxhp, hp;
	private boolean infiniteHp;

	private int points;

	private int invulnerabitilyTime;
	private boolean isInvulnerable;

	public GUI() {
		super(false, LAYER.WOLRD_GUI_PUZZLE, 0, 0, OBJECTID.DISPLAYER);

		tools = ToolBank.getClonedMap();

		setMaxHp(getMaxHpFromFile());
		setHp(getMaxHp());
	}

	// state

	public Map<ToolBank, BufferedTool> getMap() {
		return tools;
	}

	@Override
	public BufferedTool getTool(ToolBank toolBank) {
		return tools.get(toolBank);
	}

	// hp gestion

	public void setInfinitHp(boolean infiniteHp) {
		if (infiniteHp)
			setHp(maxhp);
		this.infiniteHp = infiniteHp;
	}

	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public int getMaxHp() {
		return maxhp;
	}

	@Override
	public void setMaxHp(int maxhp) {
		this.maxhp = maxhp;
	}

	public void addHp() {
		addHp(1);
	}

	public void addHp(int amount) {
		hp = hp + amount;
	}

	public void removeHp() {
		removeHp(1);
	}

	public void removeHp(int amount) {
		if (!infiniteHp && !isInvulnerable) {
			hp = hp - amount;
			setInvulnerable(true);
		}
	}

	public boolean isFullHp() {
		return hp == maxhp ? true : false;
	}

	// pts gestion

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void addPoints(GameObject object, int amount) {
		HandlerObject.getInstance().addObject(new BonusText(object, amount + " pts"));
		points = points + amount;
	}

	public void removePoints(GameObject object, int amount) {
		HandlerObject.getInstance().addObject(new BonusText(object, "-" + amount + " pts"));
		points = points - amount;
	}

	@Override
	public void tick() {

		tickInvunerability();

		if (hp <= 0)
			killPlayer();
	}

	private void tickInvunerability() {
		if (isInvulnerable) {
			if (invulnerabitilyTime > 0)
				invulnerabitilyTime--;
			else
				setInvulnerable(false);
		}
		HandlerObject.getInstance().getPlayer().blink(invulnerabitilyTime);
	}

	@Override
	public void render(Graphics g) {

		drawHearts(g);
		drawPoints(g);
		drawTools(g);
	}

	private void drawHearts(Graphics g) {

		int x0 = Size.TILE_PUZZLE / 2 + Size.TILE_PUZZLE / 4;
		int currentHp = World.gui.getHp();
		int heart = 0;

		// draw as much heart as Max Hp
		for (int i = 0; i < maxhp; i++) {
			// if Infinite hp, draw nothing
			if (!infiniteHp) {
				// if current hp is lower than max hp, draw that much heart as empty
				if (currentHp < i + 1)
					heart = 1;
				g.drawImage(texture.gui_data[heart], x + i * x0, y, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
			}
		}
	}

	private void drawPoints(Graphics g) {

		Font font = new Font("arial", 1, 75);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("" + points, x + Size.WIDHT / 2 - 50, y + 90);
	}

	private void drawTools(Graphics g) {

		int currentToolLvl = 0;
		int currentToolMaxLvl = 0;
		int count = 0;

		for (ToolBank tempToolBank : tools.keySet()) {
			BufferedTool tempTool = tools.get(tempToolBank);
			currentToolLvl = Conductor.getDebugMode().getMultiToolMode().getState() ? 5 : tempTool.getCurrentLvl();
			currentToolMaxLvl = Conductor.getDebugMode().getMultiToolMode().getState() ? 5 : tempTool.getMaxLvl();

			if (currentToolLvl != 0) {
				g.drawImage(tempTool.getTexture(), x + 20 + count * (2 * Size.TILE_PUZZLE + 10),
						Size.HEIGHT - Size.TILE_PUZZLE - 20, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
				g.drawImage(texture.gui_battery[currentToolLvl][currentToolMaxLvl],
						x + 20 + Size.TILE_PUZZLE * (2 * count + 1), Size.HEIGHT - Size.TILE_PUZZLE - 20,
						Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
				if (tempTool.getCurrentLvl() > 0)
					count++;
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	public void setInvulnerable(boolean invulnerable) {
		this.isInvulnerable = invulnerable;
		invulnerabitilyTime = invulnerable ? 30 : 0;

	}

	private void killPlayer() {

		World.currentWorld.restart();
	}

}
