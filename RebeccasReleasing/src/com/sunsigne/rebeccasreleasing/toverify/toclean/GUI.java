package com.sunsigne.rebeccasreleasing.toverify.toclean;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.toverify.Todo;
import com.sunsigne.rebeccasreleasing.toverify.game.world.World;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

import objects.GameObject;

@Todo("creer une class � part qui s'occuperait de tout la partie \"redtool\" & quand la clef apparait, on a envie de la prendre ...")
public class GUI extends GameObject implements Characteristics {

	private Tool[] tools = new Tool[5];

	private int maxhp, hp;
	private boolean infiniteHp;

	private int points;

	private int invulnerabitilyTime;
	private boolean isInvulnerable;

	public GUI() {
		super(false, 0, 0, OBJECTID.DISPLAYER);

		tools[Tool.KEY] = getToolFromFile(Tool.KEY);
		tools[Tool.SWORD] = getToolFromFile(Tool.SWORD);
		tools[Tool.BOMB] = getToolFromFile(Tool.BOMB);
		tools[Tool.GLASS] = getToolFromFile(Tool.GLASS);
		tools[Tool.PLIERS] = getToolFromFile(Tool.PLIERS);

		setMaxHp(getMaxHpFromFile());
		setHp(getMaxHp());
	}

	// state

	@Override
	public Tool getTool(int num) {
		return tools[num];
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

	@Todo("le systeme doit �tre plus intelligent : il doit dessiner les outils sans laisser d'espace pour les outils de lvl 0")
	private void drawTools(Graphics g) {

		int size = tools.length;
		int currentToolLvl = 0;
		int currentToolMaxLvl = 0;

		for (int i = 0; i < size; i++) {
			currentToolLvl = Game.isMultiToolMode() ? 5 : getTool(i).getCurrentLvl();
			currentToolMaxLvl = Game.isMultiToolMode() ? 5 : getTool(i).getMaxLvl();

			if (currentToolLvl != 0) {
				g.drawImage(texture.gui_tool[i], x + 20 + i * (2 * Size.TILE_PUZZLE + 10),
						Size.HEIGHT - Size.TILE_PUZZLE - 20, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
				g.drawImage(texture.gui_battery[currentToolLvl][currentToolMaxLvl],
						x + 20 + Size.TILE_PUZZLE * (2 * i + 1), Size.HEIGHT - Size.TILE_PUZZLE - 20, Size.TILE_PUZZLE,
						Size.TILE_PUZZLE, null);
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	@Todo("put a verification : if the player is suddently tasking, he should no longer be invulnerable")
	public void setInvulnerable(boolean invulnerable) {
	this.isInvulnerable=invulnerable;invulnerabitilyTime=invulnerable?30:0;

	}

	private void killPlayer() {

		World.currentWorld.restart();
	}

}
