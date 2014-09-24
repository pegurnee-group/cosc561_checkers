package com.eddienicole.checkers;

public class Move implements MoveInterface {

	private final PlayableSpaceInterface from;
	private final PlayableSpaceInterface to;

	public Move(PlayableSpaceInterface from, PlayableSpaceInterface to) {
		this.from = from;
		this.to = to;
	}

	public PlayableSpaceInterface getFrom() {
		return this.from;
	}

	public PlayableSpaceInterface getTo() {
		return this.to;
	}

}
