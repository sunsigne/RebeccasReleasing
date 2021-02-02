package com.sunsigne.rebeccasreleasing.game.puzzles.card.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.IFacing;
import objects.characters.CHARA;

public class CardFolder extends CommunCardObject implements IFacing, IAnimation {

	private Animation animation;

	private FACING facing;
	private CHARA chara;

	private int attackTime, defenseTime;

	public CardFolder(FACING facing, CHARA chara, CARDTYPE cardtype) {
		super(1300, 250, OBJECTID.P_CARDFOLDER, cardtype);

		setFacing(facing);
		this.chara = chara;

		if (getFacing() == FACING.RIGHT)
		{
			setX(215);
			initX = getX();
		}
	}

	// state

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];
		
		if (animation == null)
			animation = new Animation(12, getTextureFromChara()[facing][7], getTextureFromChara()[facing][8],
					getTextureFromChara()[facing][9], getTextureFromChara()[facing][10]);
		return animation;
	}

	private BufferedImage[][] getTextureFromChara() {
		if (chara == CHARA.REBECCA)
			return texture.living_rebecca_battle;
		else if (chara == CHARA.FOE)
			return texture.living_foe_battle;
		else
			return texture.living_err_battle;
	}

	@Override
	public FACING getFacing() {
		return facing;
	}

	@Override
	public void setFacing(FACING facing) {
		if (facing == FACING.UP)
			this.facing = FACING.LEFT;
		else if (facing == FACING.DOWN)
			this.facing = FACING.RIGHT;
		else this.facing = facing;
	}

	public void playCard(CARDTYPE type) {
		if (type != getCardtype())
			attack();
		else
			defense();
	}

	private void attack() {
		if (attackTime <= 0)
			attackTime = 30;
	}

	private void defense() {
		if (defenseTime <= 0)
			defenseTime = 30;
	}
	

	// behavior

	@Override
	public void tick() {
		runAnimation(getFacing().getNum());

		velocity();
		playAttackAnimation();
		playDefenseAnimation();
	}

	private void playAttackAnimation() {
		int speed = 8;
		if (getFacing() == FACING.LEFT)
			speed = -speed;

		if (attackTime > 0) {
			attackTime--;
			velX = velX + speed;
			if (attackTime == 15)
				velX = -velX;
		}

		if (defenseTime <= 0) {
			if ((getFacing() == FACING.RIGHT && x < initX) || (getFacing() == FACING.LEFT && x > initX))
				x = initX;
		}

	}

	private void playDefenseAnimation() {
		int step = 50;
		defenseTime--;

		if (defenseTime > 0 && getCardtype() == CARDTYPE.DEFENSE) {
			if (defenseTime == 18)
				x = x - step;

			if (defenseTime == 14)
				x = x + step;
		}
	}

	// design

	@Override
	public void render(Graphics g) {

		int x0 = x + 30;
		int y0 = y + 120;
		int w0 = 5 * Size.TILE_PUZZLE / 2;
		int h0 = 5 * Size.TILE_PUZZLE / 2;

		if (attackTime > 0)
			g.drawImage(getTextureFromChara()[getFacing().getNum()][16], x0, y0, w0, h0, null);
		else if (defenseTime > 0) {
			if (getCardtype() == CARDTYPE.DEFENSE && defenseTime < 20)
				g.drawImage(getTextureFromChara()[getFacing().getNum()][17], x0, y0, w0, h0, null);
			else if (getCardtype() == CARDTYPE.ATTACK && defenseTime < 16)
				g.drawImage(getTextureFromChara()[getFacing().getNum()][19], x0, y0, w0, h0, null);
			else
				drawAnimation(g, x0, y0, w0, h0, getFacing().getNum());
		} else
			drawAnimation(g, x0, y0, w0, h0, getFacing().getNum());

		drawHitbox(g);
	}

	// collision

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w, h);
	}

}
