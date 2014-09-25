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

	public MockPlayableSpace(int position) {
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
	public boolean isKing() {
		return isKing;
	}

	@Override
	public void setKing(boolean isKing) {
		this.isKing = isKing;
	}

	@Override
	public boolean isRed() {
		return isRed;
	}

	@Override
	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}

	@Override
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

	public void setPosition(int position) {
		this.position = position;
	}

}
