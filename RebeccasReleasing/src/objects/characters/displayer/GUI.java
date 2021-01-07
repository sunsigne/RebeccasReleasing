package objects.characters.displayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.GameObject;
import objects.OBJECTID;

public class GUI extends GameObject {

	private Characteristics characteristics;
	
	private int fullhp, hp;
	private int points;
	private boolean infiniteHp;

	public GUI() {
		super(0, 0, OBJECTID.DISPLAYER);
		
		characteristics = new Characteristics();		
		fullhp = 3;
		setHp(fullhp);
	}

	public GUI(boolean infiniteHp) {
		super(0, 0, OBJECTID.DISPLAYER);
		this.infiniteHp = infiniteHp;
		
		characteristics = new Characteristics();
		fullhp = 3;
		setHp(fullhp);
	}
	
	public Characteristics getCharacteristics() {
		return characteristics;
	}
	
	// hp gestion

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 *  Add one hp to the GUI
	 */
	public void addHp() {
		hp = hp + 1;
	}

	/** Add hp to the GUI. Set no parameter to add only one.
	 * 
	 * @param amount of hp to add
	 */
	public void addHp(int amount) {
		hp = hp + amount;
	}

	/**
	 *  Remove one hp to the GUI
	 */
	public void removeHp() {
		if (!infiniteHp)
			hp = hp - 1;
	}

	/** Remove hp to the GUI. Set no parameter to remove only one.
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
	
	// item gestion
	
	public void upgradeKey()
	{
		int current_key = characteristics.getKey().getNum();
		if(current_key < DIFFICULTY.TOTALNUM)
		{
			DIFFICULTY better_key = DIFFICULTY.getDifficulty(current_key + 1);
			characteristics.setKey(better_key);
		}			
	}

	@Override
	public boolean isCameraDependant() {
		return false;
	}

	@Override
	public void tick() {

		if (hp == 0)
			killPlayer();
	}

	@Override
	public void render(Graphics g) {

		drawHearts(g);
		drawPoints(g);
		drawKey(g);
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
			g.drawImage(texture.item[heart3], x + (Size.TILE_PUZZLE + Size.TILE_PUZZLE / 2), y, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
			g.drawImage(texture.item[heart2], x + (Size.TILE_PUZZLE / 2 + Size.TILE_PUZZLE / 4), y, Size.TILE_PUZZLE, Size.TILE_PUZZLE,
					null);
			g.drawImage(texture.item[heart1], x, y, Size.TILE_PUZZLE, Size.TILE_PUZZLE, null);
		}
	}


	private void drawPoints(Graphics g) {

		Font font = new Font("arial", 1, 75);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("" + points, x + Size.WIDHT / 2 - 50, y + 90);
	}
		
	private void drawKey(Graphics g) {
		
		g.drawImage(texture.item[0], x + 20, y + 200, w, h, null);
		drawDifficulty(g);
	}
	
	
	@Todo("Improve graphism, here are some basic layers to identify the difficulty")
	protected void drawDifficulty(Graphics g) {
		
		Color color = new Color(0,0,0,0);
		if(characteristics.getKey().getNum() == 1) color = new Color(0, 255, 0, 100);
		if(characteristics.getKey().getNum() == 2) color = new Color(255, 255, 0, 100);
		if(characteristics.getKey().getNum() == 3) color = new Color(255, 115, 0, 100);
		if(characteristics.getKey().getNum() == 4) color = new Color(255, 0, 0, 100);
		g.setColor(color);
		g.fillRect(x + 20,  y + 200,  w,  h);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

	private void killPlayer() {

		World.world.restart();
	}


}
