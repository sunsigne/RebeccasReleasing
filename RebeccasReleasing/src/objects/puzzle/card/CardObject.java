package objects.puzzle.card;

import objects.OBJECTID;
import objects.puzzle.PuzzleObject;

public abstract class CardObject extends PuzzleObject {

	private CardType cardtype;
	
	public CardObject(int x, int y, OBJECTID id, CardType cardtype) {
		super(x, y, id);

		setCardtype(cardtype);
	}


	public void setCardtype(CardType cardtype) {
		this.cardtype = cardtype;
	}

	public CardType getCardtype() {
		return cardtype;
	}

	
}
