package com.eddienicole.checkers;

public class MockPlayableSpace implements PlayableSpaceInterface {

	boolean isOccupied;
	boolean isRed;
	boolean isKing;

	public MockPlayableSpace() {
		this.isOccupied = false;
		this.isRed = false;
		this.isKing = false;
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

	public boolean isRed() {
		return isRed;
	}

	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}

}
