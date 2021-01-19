package com.sunsigne.rebeccasreleasing.game.puzzles.card.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.IFacing;
import objects.IFacing.FACING;

public class CardFolder extends CommunCardObject implements IFacing, IAnimation {

	private Animation animation;
	
	private FACING facing;
	
	protected int startingX, startingY;
	private int attackTime, defenseTime;
	

	public CardFolder(int x, int y, CARDTYPE cardtype) {
		super(x, y, OBJECTID.P_CARDFOLDER, cardtype);

		startingX = x;
		startingY = y;
		
		if(getCardtype() == CARDTYPE.ATTACK) facing = FACING.LEFT;
		if(getCardtype() == CARDTYPE.DEFENSE) facing = FACING.RIGHT;
		
		w = Size.TILE_PUZZLE * 2;
		h = Size.TILE_PUZZLE * 4;
	}

	// state
	
	@Override
	public Animation getAnimation(int array, int secondarray) {
		
		if (animation == null)
			if(getCardtype() == CARDTYPE.DEFENSE)
			{
			animation = new Animation(12, texture.living_rebecca_battle[array][0],
					texture.living_rebecca_battle[array][1], texture.living_rebecca_battle[array][2],
					texture.living_rebecca_battle[array][3]);
			}
			else animation = new Animation(12, texture.living_foe_battle[array][0],
					texture.living_foe_battle[array][1], texture.living_foe_battle[array][2],
					texture.living_foe_battle[array][3]);
		return animation;
	}

	@Override
	public FACING getFacing() {
		return facing;
	}

	@Override
	public void setFacing(FACING facing) {
		this.facing = facing;		
	}
	
	// behavior

	public void playCard(CARDTYPE type) {
		if (type != getCardtype()) attack();
		else defense();
	}

	private void attack() {
		if(attackTime <= 0)
		attackTime = 30;
	}

	private void defense() {
		if(defenseTime <= 0)
		defenseTime = 30;
	}
	
	@Override
	public void tick() {
		runAnimation(getFacing().getNum());
		
		velocity();		
		playAttackAnimation();
		playDefenseAnimation();
	}

	private void playAttackAnimation() {
		int speed = 8;
		if(getCardtype() != CARDTYPE.DEFENSE) speed = - speed;
		
		if(attackTime > 0)
		{
			attackTime--;
			velX = velX + speed;
			if (attackTime == 15)
			velX = - velX;
		}
		
		if(getCardtype() == CARDTYPE.DEFENSE)
		{
			if(x < startingX && defenseTime <= 0)
				x = startingX;
		}
		
		if(getCardtype() == CARDTYPE.ATTACK)
		{
			if(x > startingX && defenseTime <= 0)
				x = startingX;
		}
		
		
	}
		
	private void playDefenseAnimation() {
		int step = 50;
		defenseTime --;
		
		if(defenseTime > 0 && getCardtype() != CARDTYPE.ATTACK)
		{
			if(defenseTime == 18)
				x = x - step;
			
			if(defenseTime == 14)
				x = x + step;
		}
	}


	// design
	
	@Override
	public void render(Graphics g) {

		int w0 = 5 *Size.TILE_PUZZLE / 2;
		int h0 = 5 *Size.TILE_PUZZLE / 2;
		
		if (getCardtype() == CARDTYPE.DEFENSE)
		{
			if(attackTime > 0)
				g.drawImage(texture.living_rebecca_battle[getFacing().getNum()][4], x + 30, y + 220, w0, h0, null);
			else if (defenseTime > 0 && defenseTime < 20)
				g.drawImage(texture.living_rebecca_battle[getFacing().getNum()][5], x + 30, y + 220, w0, h0, null);
			else drawAnimation(getFacing().getNum(), g, x + 30, y + 220, w0, h0);
		}

		if (getCardtype() == CARDTYPE.ATTACK) {
			if(attackTime > 0)
				g.drawImage(texture.living_foe_battle[getFacing().getNum()][4], x + 30, y + 220, w0, h0, null);
			else if (defenseTime > 0 && defenseTime < 16)
				g.drawImage(texture.living_foe_battle[getFacing().getNum()][7], x + 30, y + 220, w0, h0, null);
			else drawAnimation(getFacing().getNum(), g, x + 30, y + 220, w0, h0);
		}
		drawHitbox(g);
	}

	// collision
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w, h);
	}


}
