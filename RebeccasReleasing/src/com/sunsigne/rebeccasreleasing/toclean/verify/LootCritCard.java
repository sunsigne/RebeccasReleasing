package com.sunsigne.rebeccasreleasing.toclean.verify;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;

import objects.world.loot.LootObject;

@Todo("mettre à jour le fonctionnement du crit (l'ancien est-il broken ou équilibré ?) -> au moment de l'écriture, je le pense équilibré")
public class LootCritCard extends LootObject {

	public LootCritCard(int x, int y) {
		super(x, y);
	}

	// design

	@Override
	public void render(Graphics g) {

		g.drawImage(ImageBank.getImage(ImageBank.card_frame), x, y, Size.TILE * 2 / 3, Size.TILE, null);
		g.drawImage(ImageBank.getImage(ImageBank.card_critical), x, y, Size.TILE * 2 / 3, Size.TILE, null);
		drawHitbox(g);
	}

	// collision

	@Override
	protected String displayTextOnPickup() {
		return "100% crit";
	}

	@Override
	protected void triggerActionOnPickup() {
		World.gui.getCharacteristics().setSureCrit(true);
	}

}
