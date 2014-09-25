package com.eddienicole.checkers;

public class Move implements MoveInterface {

	private final PlayableSpaceInterface from;
	private final PlayableSpaceInterface to;

	public Move(PlayableSpaceInterface from, PlayableSpaceInterface to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MoveInterface))
			return false;
		Move other = (Move) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
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

}
