package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.Animation;
import com.sunsigne.rebeccasreleasing.toverify.ressources.images.IAnimation;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class CardFolder extends CommunCardObject implements IAnimation {

	private Animation animation;

	private DIRECTION facing;
	private CharacterBank characterBank;

	private int attackTime, defenseTime;

	public CardFolder(DIRECTION facing, CharacterBank characterBank, CARDTYPE cardtype) {
		super(1300, 250, OBJECTID.DELETE, cardtype);

		this.facing = facing;
		this.characterBank = characterBank;

		if (getFacing() == DIRECTION.RIGHT) {
			setX(215);
			initX = getX();
		}
	}

	// state

	@Override
	public Animation getAnimation(int... array) {

		int facing = array[0];

		if (animation == null)
			animation = new Animation(12, texture.getLivingBattle(characterBank, facing, 6),
					texture.getLivingBattle(characterBank, facing, 7),
					texture.getLivingBattle(characterBank, facing, 8),
					texture.getLivingBattle(characterBank, facing, 7));
		return animation;
	}

	public DIRECTION getFacing() {
		return facing;
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
		if (getFacing() == DIRECTION.LEFT)
			speed = -speed;

		if (attackTime > 0) {
			attackTime--;
			velX = velX + speed;
			if (attackTime == 15)
				velX = -velX;
		}

		if (defenseTime <= 0) {
			if ((getFacing() == DIRECTION.RIGHT && x < initX) || (getFacing() == DIRECTION.LEFT && x > initX))
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
			g.drawImage(texture.getLivingBattle(characterBank, getFacing().getNum(), 13), x0, y0, w0, h0, null);
		else if (defenseTime > 0) {
			if (getCardtype() == CARDTYPE.DEFENSE && defenseTime < 20)
				g.drawImage(texture.getLivingBattle(characterBank, getFacing().getNum(), 14), x0, y0, w0, h0, null);
			else if (getCardtype() == CARDTYPE.ATTACK && defenseTime < 16)
				g.drawImage(texture.getLivingBattle(characterBank, getFacing().getNum(), 16), x0, y0, w0, h0, null);
			else
				drawAnimation(g, x0, y0, w0, h0, getFacing().getNum());
		} else
			drawAnimation(g, x0, y0, w0, h0, getFacing().getNum());

	}

	// collision

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w, h);
	}

}
