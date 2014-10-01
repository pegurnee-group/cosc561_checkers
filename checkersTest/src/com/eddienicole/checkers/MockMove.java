package com.eddienicole.checkers;

import java.util.Stack;

public class MockMove implements MoveInterface {

	private boolean jump;
	private final Stack<PlayableSpaceInterface> jumpedStack;
	private PlayableSpaceInterface spaceFrom;
	private PlayableSpaceInterface spaceTo;

	public MockMove() {
		this.jumpedStack = new Stack<>();

	}

	public MockMove(PlayableSpaceInterface spaceFrom,
			PlayableSpaceInterface spaceTo, boolean jump) {
		this.spaceFrom = spaceFrom;
		this.spaceTo = spaceTo;
		this.jump = jump;
		this.jumpedStack = new Stack<>();
	}

	@Override
	public void addToJumped(PlayableSpaceInterface jumpedSpace) {
		this.getJumpedStack().add(jumpedSpace);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MoveInterface)) {
			return false;
		}
		MoveInterface other = (MoveInterface) obj;
		if (this.jump != other.isJump()) {
			return false;
		}
		if (this.spaceFrom == null) {
			if (other.getFrom() != null) {
				return false;
			}
		} else if (!this.spaceFrom.equals(other.getFrom())) {
			return false;
		}
		if (this.spaceTo == null) {
			if (other.getTo() != null) {
				return false;
			}
		} else if (!this.spaceTo.equals(other.getTo())) {
			return false;
		}
		return true;
	}

	@Override
	public PlayableSpaceInterface getFrom() {
		return this.spaceFrom;
	}

	@Override
	public Stack<PlayableSpaceInterface> getJumpedStack() {
		return this.jumpedStack;
	}

	@Override
	public PlayableSpaceInterface getTo() {
		return this.spaceTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.spaceFrom == null) ? 0 : this.spaceFrom.hashCode());
		result = (prime * result)
				+ ((this.spaceTo == null) ? 0 : this.spaceTo.hashCode());
		return result;
	}

	@Override
	public boolean isJump() {
		return this.jump;
	}

	public void setFrom(PlayableSpaceInterface from) {
		this.spaceFrom = from;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	public void setTo(PlayableSpaceInterface to) {
		this.spaceTo = to;
	}

}
