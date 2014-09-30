package com.eddienicole.checkers;

public interface MoveInterface {
	@Override
	boolean equals(Object obj);

	PlayableSpaceInterface getFrom();

	PlayableSpaceInterface getTo();

}
