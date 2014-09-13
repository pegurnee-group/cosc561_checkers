package com.eddienicole.checkers;

public class PlayableSpace implements PlayableSpaceInterface {

	private boolean isOccupied;
	private boolean isRed;
	private boolean isKing;

	public PlayableSpace() {
		this.isOccupied = false;
		this.isRed = false;
		this.isKing = false;
	}

	@Override
	public boolean isOccupied() {
		return isOccupied;
	}

	@Override
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	@Override
	public boolean isRed() {
		return this.isRed;
	}

	@Override
	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}

	@Override
	public boolean isKing() {
		return this.isKing;
	}

	@Override
	public void setKing(boolean isKing) {
		this.isKing = isKing;
	}

}
