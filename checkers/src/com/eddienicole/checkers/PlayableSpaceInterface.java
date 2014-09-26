package com.eddienicole.checkers;

public interface PlayableSpaceInterface {

	SpaceState getState();

	boolean isKing();

	void setState(SpaceState spaceState);

	void setKing(boolean b);

	@Override
	public boolean equals(Object obj);

	int getPosition();

}
