package com.eddienicole.checkers;

public class MockPlayableSpace implements PlayableSpaceInterface {

	SpaceState spaceState;
	boolean isKing;
	private int position;

	public MockPlayableSpace() {
		this.spaceState = SpaceState.UNOCCUPIED;
		this.isKing = false;
	}

	public MockPlayableSpace(int position) {
		this.spaceState = SpaceState.UNOCCUPIED;
		this.isKing = false;
		this.position = position;
	}

	public MockPlayableSpace(SpaceState spaceState, boolean isKing, int position) {
		super();
		this.spaceState = spaceState;
		this.isKing = isKing;
		this.position = position;
	}

	@Override
	public SpaceState getState() {
		return this.spaceState;
	}

	@Override
	public void setState(SpaceState spaceState) {
		this.spaceState = spaceState;
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
	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
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

}
