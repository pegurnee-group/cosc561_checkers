package com.eddienicole.checkers;

public class PlayableSpace implements PlayableSpaceInterface {

	private boolean isKing;

	private final int position;
	private SpaceState spaceState;

	public PlayableSpace(int position) {
		this.spaceState = SpaceState.UNOCCUPIED;
		this.isKing = false;
		this.position = position;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PlayableSpaceInterface)) {
			return false;
		}
		PlayableSpaceInterface other = (PlayableSpaceInterface) obj;
		if (this.isKing != other.isKing()) {
			return false;
		}
		if (this.position != other.getPosition()) {
			return false;
		}
		if (this.spaceState != other.getState()) {
			return false;
		}
		return true;
	}

	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public SpaceState getState() {
		return this.spaceState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (this.isKing ? 1231 : 1237);
		result = (prime * result) + this.position;
		result = (prime * result)
				+ ((this.spaceState == null) ? 0 : this.spaceState.hashCode());
		return result;
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
	public void setState(SpaceState spaceState) {
		this.spaceState = spaceState;
	}

	@Override
	public String toString() {
		String toReturn = "" + this.position;
		String state = "";
		if (this.spaceState == SpaceState.UNOCCUPIED) {
			state = "u";
		} else {
			char color;
			if (this.spaceState == SpaceState.RED) {
				color = 'r';
			} else {
				color = 'b';
			}
			if (this.isKing) {
				color -= 32;
			}
			state = "" + color;
		}

		return toReturn + state;
	}

}
