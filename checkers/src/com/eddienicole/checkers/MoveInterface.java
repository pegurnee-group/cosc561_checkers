package com.eddienicole.checkers;


public interface MoveInterface {
	@Override
	boolean equals(Object obj);

	PlayableSpaceInterface getFrom();

	PlayableSpaceInterface getJumped();

	PlayableSpaceInterface getTo();

	boolean isJump();

	void jumped(PlayableSpaceInterface jumpedSpace);

}
