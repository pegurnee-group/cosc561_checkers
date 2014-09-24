package com.eddienicole.checkers;

public class PlayableSpace implements PlayableSpaceInterface {

	private boolean isOccupied;
	private boolean isRed;
	private boolean isKing;
	private int position;

	public int getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isKing ? 1231 : 1237);
		result = prime * result + (isOccupied ? 1231 : 1237);
		result = prime * result + (isRed ? 1231 : 1237);
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayableSpace other = (PlayableSpace) obj;
		if (isKing != other.isKing)
			return false;
		if (isOccupied != other.isOccupied)
			return false;
		if (isRed != other.isRed)
			return false;
		if (position != other.position)
			return false;
		return true;
	}

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
