package com.eddienicole.checkers;

public class PlayableSpace implements PlayableSpaceInterface {

	private boolean isOccupied;
	private boolean isRed;
	private boolean isKing;
	private final int position;

	public PlayableSpace(int position) {
		this.isOccupied = false;
		this.isRed = false;
		this.isKing = false;
		this.position = position;
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

	@Override
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
		if (!(obj instanceof PlayableSpaceInterface))
			return false;
		PlayableSpaceInterface other = (PlayableSpaceInterface) obj;
		if (isKing != other.isKing())
			return false;
		if (isOccupied != other.isOccupied())
			return false;
		if (isRed != other.isRed())
			return false;
		if (position != other.getPosition())
			return false;
		return true;
	}

}
