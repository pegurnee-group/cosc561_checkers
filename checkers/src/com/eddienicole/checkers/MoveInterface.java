package com.eddienicole.checkers;

import java.util.Stack;

public interface MoveInterface {
	void addToJumped(PlayableSpaceInterface jumpedSpace);

	@Override
	boolean equals(Object obj);

	PlayableSpaceInterface getFrom();

	Stack<PlayableSpaceInterface> getJumpedStack();

	PlayableSpaceInterface getTo();

	boolean isJump();

}
