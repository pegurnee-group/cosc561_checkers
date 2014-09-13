package com.eddienicole.checkers;

public class Move {
	
	private PlayableSpaceInterface from;
	private PlayableSpaceInterface to;
	
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
