package com.eddienicole.checkers;

public class PlayableSpace implements PlayableSpaceInterface {

	boolean isOccupied;
	boolean isRed;
	boolean isKing;

	public PlayableSpace() {
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

	public boolean isRed() {
		return this.isRed;
	}

	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}

	public boolean isKing() {
		return this.isKing;
	}

	public void setKing(boolean isKing) {
		this.isKing = isKing;
	}

}
