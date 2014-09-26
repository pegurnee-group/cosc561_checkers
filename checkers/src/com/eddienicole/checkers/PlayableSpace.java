package com.eddienicole.checkers;

public class PlayableSpace implements PlayableSpaceInterface {

	private SpaceState spaceState;
	private boolean isKing;
	private final int position;

	public PlayableSpace(int position) {
		this.spaceState = SpaceState.UNOCCUPIED;
		this.isKing = false;
		this.position = position;
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
		if (position != other.getPosition())
			return false;
		if (spaceState != other.getState())
			return false;
		return true;
	}

	@Override
	public int getPosition() {
		return position;
	}

	@Override
	public SpaceState getState() {
		return this.spaceState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isKing ? 1231 : 1237);
		result = prime * result + position;
		result = prime * result
				+ ((spaceState == null) ? 0 : spaceState.hashCode());
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

}
