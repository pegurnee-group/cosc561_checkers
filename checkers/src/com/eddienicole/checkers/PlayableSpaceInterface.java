package com.eddienicole.checkers;

public interface PlayableSpaceInterface {

	boolean isOccupied();

	boolean isRed();

	boolean isKing();

	void setOccupied(boolean b);

	void setRed(boolean b);

	void setKing(boolean b);

}
