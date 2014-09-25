package com.eddienicole.checkers;

public class MockPlayableSpace implements PlayableSpaceInterface {

	boolean isOccupied;
	boolean isRed;
	boolean isKing;
	private int position;

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

	public int getPosition() {
		return this.position;
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
