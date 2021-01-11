package objects.characters.displayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;

@Todo("creer une class � part qui s'occuperait de tout la partie \"redtool\" & quand la clef apparait, on a envie de la prendre ...")
public class GUI extends GameObject {

	private CharacteristicsTemp characteristics;

	private int fullhp, hp;
	private int points;
	private boolean infiniteHp;

	private boolean[] redtool = new boolean[2];
	private boolean[] redMoment = new boolean[2];
	private int redTime, redNum;

	public GUI() {
		super(0, 0, OBJECTID.DISPLAYER);

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
		hp = hp + 1;
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
		if (!infiniteHp)
			hp = hp - 1;
	}

	/**
	 * Remove hp to the GUI. Set no parameter to remove only one.
	 * 
	 * @param amount
	 */
	public void removeHp(int amount) {
		if (!infiniteHp)
			hp = hp - amount;
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
	public boolean isCameraDependant() {
		return false;
	}

	public void setRedtool(boolean beRed, int toolnum) {
		this.redtool[toolnum] = beRed;
		if (beRed) {
			redNum = 20;
			redTime = 10;
		}
	}

	@Override
	public void tick() {

		if (hp == 0)
			killPlayer();

		tickRedTool();
	}

	private void tickRedTool() {

		int size = redtool.length;
		for (int i = 0; i < size; i++) {

			if (redtool[i]) {
				if (redTime > 0) {
					boolean flag = true;
					if (redNum % 2 == 0)
						flag = false;
					redTime--;
					redMoment[i] = flag;
				} else if (redNum > 0) {
					redNum--;
					redTime = 10;
				} else
					setRedtool(false, i);
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

		int heart3 = 13;
		int heart2 = 13;
		int heart1 = 13;

		if (hp <= 2)
			heart3 = 14;
		if (hp <= 1)
			heart2 = 14;
		if (hp <= 0)
			heart1 = 14;

		if (!infiniteHp) {
			g.drawImage(texture.item[heart3], x + (Size.TILE_PUZZLE + Size.TILE_PUZZLE / 2), y, Size.TILE_PUZZLE,
					Size.TILE_PUZZLE, null);
			g.drawImage(texture.item[heart2], x + (Size.TILE_PUZZLE / 2 + Size.TILE_PUZZLE / 4), y, Size.TILE_PUZZLE,
					Size.TILE_PUZZLE, null);
			g.drawImage(texture.item[heart1], x, y, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
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
			currentToolLvl = characteristics.getTool(i).getNum();
			savedBatterySize = CharacteristicsSaved.batterySize[i];

			if (currentToolLvl != 0) {
				g.drawImage(texture.tool[i], x + 20 + i * (2 * Size.TILE_PUZZLE + 10),
						Size.HEIGHT - Size.TILE_PUZZLE - 20, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
				if (redMoment[i])
					g.drawImage(texture.tool_cutout[i], x + 20 + i * (2 * Size.TILE_PUZZLE + 10),
							Size.HEIGHT - Size.TILE_PUZZLE - 20, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
				g.drawImage(texture.battery[currentToolLvl][savedBatterySize], x + 20 + Size.TILE_PUZZLE * (2 * i + 1),
						Size.HEIGHT - Size.TILE_PUZZLE - 20, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
			}

		}
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	private void killPlayer() {

		World.world.restart();
	}

}
