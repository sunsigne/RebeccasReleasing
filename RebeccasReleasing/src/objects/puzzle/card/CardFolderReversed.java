package objects.puzzle.card;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.OBJECTID;

public class CardFolderReversed extends CardObject {

	public CardFolderReversed(int x, int y, CardType cardtype) {
		super(x, y, OBJECTID.P_CARDFOLDER, cardtype);

		w = Size.TILE_PUZZLE * 2;
		h = Size.TILE_PUZZLE * 4;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		if (getCardtype() == CardType.DEFENSE)
			g.drawImage(ImageBank.getImage(ImageBank.card_folder_gamma), x - 30, y + 10, Size.TILE_PUZZLE * 4, Size.TILE_PUZZLE * 6, null);
		if (getCardtype() == CardType.ATTACK) {
			if (!HandlerObject.getInstance().player.puzzle.isDualFight())
				g.drawImage(ImageBank.getImage(ImageBank.card_folder_soldier), x - 130, y + 10, Size.TILE_PUZZLE * 4, Size.TILE_PUZZLE * 6, null);
			if (HandlerObject.getInstance().player.puzzle.isDualFight()) {
				g.drawImage(ImageBank.getImage(ImageBank.card_folder_soldier), x - 280, y + 10, Size.TILE_PUZZLE * 4, Size.TILE_PUZZLE * 6, null);
				g.drawImage(ImageBank.getImage(ImageBank.card_folder_soldier), x - 70, y + 10, Size.TILE_PUZZLE * 4, Size.TILE_PUZZLE * 6, null);
			}
		}
		drawHitbox(g);
	}
	
	@Override
	public Rectangle getBounds() {
		if (getCardtype() == CardType.REVERSED)
			return new Rectangle(x, y, Size.TILE_PUZZLE * 6, Size.TILE_PUZZLE * 3);
		else
			return new Rectangle(x + w / 4, y + h / 4, w, h);
	}

}
