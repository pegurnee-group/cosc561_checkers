package com.eddienicole.checkers;

public class Move implements MoveInterface {

	private final PlayableSpaceInterface from;
	private final PlayableSpaceInterface to;

	public Move(PlayableSpaceInterface from, PlayableSpaceInterface to) {
		this.from = from;
		this.to = to;
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
		if (this.from == null) {
			if (other.getFrom() != null) {
				return false;
			}
		} else if (!this.from.equals(other.getFrom())) {
			return false;
		}
		if (this.to == null) {
			if (other.getTo() != null) {
				return false;
			}
		} else if (!this.to.equals(other.getTo())) {
			return false;
		}
		return true;
	}

	@Override
	public PlayableSpaceInterface getFrom() {
		return this.from;
	}

	@Override
	public PlayableSpaceInterface getTo() {
		return this.to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.from == null) ? 0 : this.from.hashCode());
		result = (prime * result)
				+ ((this.to == null) ? 0 : this.to.hashCode());
		return result;
	}

}
