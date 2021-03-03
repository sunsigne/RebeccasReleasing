package com.sunsigne.rebeccasreleasing.ressources.characters;

public class BufferedCharacter {

	private int col, row;
	private int id;

	public BufferedCharacter(int col, int row) {

		this.col = col;
		this.row = row;

	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	// this id is automatically generated by TextureBank
	// Do not touch
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
