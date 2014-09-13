package com.eddienicole.checkers;

public class MockPlayableSpace implements PlayableSpaceInterface {

	private char column;
	private int row;
	boolean isOccupied;
	boolean isRed;
	boolean isKing;

	public MockPlayableSpace() {
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean isKing() {
		return isKing;
	}

	public void setKing(boolean isKing) {
		this.isKing = isKing;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	public boolean isRed() {
		return isRed;
	}

}
