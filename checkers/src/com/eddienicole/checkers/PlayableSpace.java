package com.eddienicole.checkers;

public class PlayableSpace implements PlayableSpaceInterface {

	char column;
	int row;
	boolean isOccupied;
	boolean isRed;
	boolean isKing;

	public PlayableSpace(char column, int row, boolean isOccupied,
			boolean isRed, boolean isKing) {
		this.column = column;
		this.row = row;
		this.isOccupied = isOccupied;
		this.isRed = isRed;
		this.isKing = isKing;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean isRed() {
		return this.isRed;
	}

	public boolean isKing() {
		return this.isKing;
	}

}
