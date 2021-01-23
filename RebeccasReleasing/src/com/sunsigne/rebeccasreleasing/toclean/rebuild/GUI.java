package com.sunsigne.rebeccasreleasing.toclean.rebuild;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.verify.BonusText;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;

@Todo("creer une class à part qui s'occuperait de tout la partie \"redtool\" & quand la clef apparait, on a envie de la prendre ...")
public class GUI extends GameObject {

	private CharacteristicsTemp characteristics;

	private int fullhp, hp;
	private int points;
	private boolean infiniteHp;

	private int invulnerabitilyTime;
	private boolean isInvulnerable;

	public GUI() {
		super(false, 0, 0, OBJECTID.DISPLAYER);

		characteristics = new CharacteristicsTemp();
		fullhp = 3;
		setHp(fullhp);
	}

	public CharacteristicsTemp getCharacteristics() {
		return characteristics;
	}

	// hp gestion

	public void setInfinitHp(boolean infiniteHp) {
		if (infiniteHp)
			setHp(fullhp);
		this.infiniteHp = infiniteHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * Add one hp to the GUI
	 */
	public void addHp() {
		addHp(1);
	}

	/**
	 * Add hp to the GUI. Set no parameter to add only one.
	 * 
	 * @param amount of hp to add
	 */
	public void addHp(int amount) {
		hp = hp + amount;
	}

	/**
	 * Remove one hp to the GUI
	 */
	public void removeHp() {
		removeHp(1);
	}

	/**
	 * Remove hp to the GUI. Set no parameter to remove only one.
	 * 
	 * @param amount
	 */
	public void removeHp(int amount) {
		if (!infiniteHp && !isInvulnerable) {
			hp = hp - amount;
			setInvulnerable();
		}
	}

	public boolean isFullHp() {
		if (hp == fullhp)
			return true;
		else
			return false;
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

	@Todo("first, this function should depends on the player. Second, the player should blink or something. Third, the player shouln't not be invulnerable when anymore when tasking")
	private void tickInvunerability() {
		if (isInvulnerable) {
			if (invulnerabitilyTime > 0)
				invulnerabitilyTime--;
			else {
				isInvulnerable = false;
			}
		}
	}

	@Override
	public void render(Graphics g) {

		drawHearts(g);
		drawPoints(g);
		drawTools(g);
	}

	private void drawHearts(Graphics g) {

		int heart3 = 0;
		int heart2 = 0;
		int heart1 = 0;

		if (hp <= 2)
			heart3 = 1;
		if (hp <= 1)
			heart2 = 1;
		if (hp <= 0)
			heart1 = 1;

		if (!infiniteHp) {
			g.drawImage(texture.gui_data[heart3], x + (Size.TILE_PUZZLE + Size.TILE_PUZZLE / 2), y, Size.TILE_PUZZLE,
					Size.TILE_PUZZLE, null);
			g.drawImage(texture.gui_data[heart2], x + (Size.TILE_PUZZLE / 2 + Size.TILE_PUZZLE / 4), y,
					Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
			g.drawImage(texture.gui_data[heart1], x, y, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
		}
	}

	private void drawPoints(Graphics g) {

		Font font = new Font("arial", 1, 75);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("" + points, x + Size.WIDHT / 2 - 50, y + 90);
	}

	private void drawTools(Graphics g) {

		int numberofTools = CharacteristicsSaved.batterySize.length;
		int currentToolLvl = 0;
		int savedBatterySize = 0;

		for (int i = 0; i < numberofTools; i++) {
			currentToolLvl = characteristics.getTool(i).getLvl();
			savedBatterySize = CharacteristicsSaved.batterySize[i];

			if (currentToolLvl != 0) {
				g.drawImage(texture.gui_tool[i], x + 20 + i * (2 * Size.TILE_PUZZLE + 10),
						Size.HEIGHT - Size.TILE_PUZZLE - 20, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
				g.drawImage(texture.gui_battery[currentToolLvl][savedBatterySize],
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
	public void setInvulnerable() {
		isInvulnerable = true;
		invulnerabitilyTime = 30;
	}

	private void killPlayer() {

		World.currentWorld.restart();
	}

}
