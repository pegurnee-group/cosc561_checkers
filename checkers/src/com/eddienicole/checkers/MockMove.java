package com.eddienicole.checkers;

public class MockMove implements MoveInterface {

	private PlayableSpaceInterface from;
	private PlayableSpaceInterface to;

	public MockMove() {

	}

	@Override
	public PlayableSpaceInterface getFrom() {
		return this.from;
	}

	@Override
	public PlayableSpaceInterface getTo() {
		return this.to;
	}

	public void setFrom(PlayableSpaceInterface from) {
		this.from = from;
	}

	public void setTo(PlayableSpaceInterface to) {
		this.to = to;
	}

}
