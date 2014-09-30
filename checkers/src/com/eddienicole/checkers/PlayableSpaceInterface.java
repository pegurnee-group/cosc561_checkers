package com.eddienicole.checkers;

public interface PlayableSpaceInterface {

	@Override
	boolean equals(Object obj);

	int getPosition();

	SpaceState getState();

	boolean isKing();

	void setKing(boolean b);

	void setState(SpaceState spaceState);

}
