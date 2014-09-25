package com.eddienicole.checkers;

public interface MoveInterface {
	@Override
	public boolean equals(Object obj);

	public PlayableSpaceInterface getFrom();

	public PlayableSpaceInterface getTo();

}
