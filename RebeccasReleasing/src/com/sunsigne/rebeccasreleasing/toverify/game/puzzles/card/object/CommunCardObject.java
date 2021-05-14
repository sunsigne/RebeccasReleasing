package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.card.object;

import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.common_object.PuzzleObject;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;
import com.sunsigne.rebeccasreleasing.toverify.toclean.OBJECTID;

public abstract class CommunCardObject extends PuzzleObject {

	private CARDTYPE cardtype;
	private int orderNum;
	
	public CommunCardObject(int x, int y, OBJECTID id, CARDTYPE cardtype) {
		super(x, y, id);

		this.cardtype = cardtype;		

		w = Size.TILE_PUZZLE * 2;
		h = Size.TILE_PUZZLE * 3;
	}

	public void setCardtype(CARDTYPE cardtype) {
		this.cardtype = cardtype;
	}

	public CARDTYPE getCardtype() {
		return cardtype;
	}

	public void setOrderNum(int number) {
		this.orderNum = number;
	}

	public int getOrderNum() {
		return orderNum;
	}

}
