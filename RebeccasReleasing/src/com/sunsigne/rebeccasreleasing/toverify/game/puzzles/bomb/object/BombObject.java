package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.bomb.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.common_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public abstract class BombObject extends PuzzleObject implements IAnimation {

	protected Animation animation;
	
	private DIFFICULTY difficulty;
	
	private boolean movingUP;
	protected boolean enlarging;
	private boolean exploding;	
	
	protected int enlargeTime = 32;
	protected int boomtime = 30;
	protected int totalcount, count;
	
	public BombObject(int x, int y, DIFFICULTY difficulty) {
		super(x, y, OBJECTID.P_BOMB);
		
		this.difficulty = difficulty;
		w = 2 * Size.TILE_PUZZLE;
		h = 2 * Size.TILE_PUZZLE;
	}

	// state	

	public DIFFICULTY getDifficulty() {
		return difficulty;
	}
	
	public boolean isExploding() {
		return exploding;
	}
	

	public void setExploding(boolean exploding) {
		this.exploding = exploding;
	}
	
	protected void randomCountGeneration(boolean reversed) {		
		int delta = 0;
		if(getDifficulty().getLvl() > 1) delta = 1;
		if(!reversed)
		count = 1 + delta + new Random().nextInt(3 + 2*delta);
		else totalcount = 1 + delta + new Random().nextInt(3 + 2*delta);
		totalcount = count;
	}
	
	// behavior
	
	protected void goUpandDown() {
		velocity();
		
		int speed = 0;	
		if(getDifficulty().getLvl() > 2) speed = 6;
		if(getDifficulty().getLvl() > 3) speed = 10;
		if (movingUP) {
			velY = -speed;
			if (y < 5 * Size.TILE_PUZZLE / 4 + 15)
				movingUP = false;
		} else {
			velY = speed;
			if (y > Size.HEIGHT - 6 * Size.TILE_PUZZLE / 2 - 35)
				movingUP = true;
		}
	}
	
	protected void goBigandSmall()
	{
		if(getDifficulty().getLvl() > 4)
		{
			if(enlarging)
				{
				if (enlargeTime < 32) enlargeTime ++;
				else enlarging = false;
				}
				
			else if(!enlarging)
			{
				if(enlargeTime > 0) enlargeTime --;
				else enlarging = true;
			}
		}
	}

	// design
	
	protected void paintCount (Graphics g)
	{
		int alpha = 160;
		int gap = 0;
		if(getDifficulty().getLvl() > 4) gap = 16 + enlargeTime;
		Font font = new Font("arial", 1, 120 - 7*gap/4);
		g.setFont(font);
		if (count == totalcount)
			g.setColor(new Color(250, 50, 50, alpha));
		else
			g.setColor(Color.yellow);
	}
	
	// collision
	
	@Override
	public Rectangle getBounds() {
		int gap = 0;
		if(getDifficulty().getLvl() > 4) gap = 16 + enlargeTime;
		return new Rectangle(x + 2*gap, y + 2*gap, w - 4*gap, h - 4*gap);
	}


}
