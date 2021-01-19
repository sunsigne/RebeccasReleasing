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

public class CardFolder extends CommunCardObject implements IAnimation {

	private Animation animation;

	public CardFolder(int x, int y, CARDTYPE cardtype) {
		super(x, y, OBJECTID.P_CARDFOLDER, cardtype);

		w = Size.TILE_PUZZLE * 2;
		h = Size.TILE_PUZZLE * 4;
	}

	@Override
	public Animation getAnimation(int array, int secondarray) {
		if (animation == null)
			animation = new Animation(12, texture.living_rebecca_battle[array][0],
					texture.living_rebecca_battle[array][1], texture.living_rebecca_battle[array][2],
					texture.living_rebecca_battle[array][3]);
		return animation;
	}

	@Override
	public void tick() {
		runAnimation(FACING.RIGHT.getNum());
	}

	@Override
	public void render(Graphics g) {

		if (getCardtype() == CARDTYPE.DEFENSE)
			drawAnimation(FACING.RIGHT.getNum(), g, x + 30, y + 220, 5 *Size.TILE_PUZZLE / 2, 5 * Size.TILE_PUZZLE / 2);
//			g.drawImage(ImageBank.getImage(ImageBank.card_folder_gamma), x - 30, y + 10, Size.TILE_PUZZLE * 4, Size.TILE_PUZZLE * 6, null);
		if (getCardtype() == CARDTYPE.ATTACK) {
			g.drawImage(ImageBank.getImage(ImageBank.card_folder_soldier), x - 130, y + 10, Size.TILE_PUZZLE * 4,
					Size.TILE_PUZZLE * 6, null);
		}
		drawHitbox(g);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w, h);
	}

}
