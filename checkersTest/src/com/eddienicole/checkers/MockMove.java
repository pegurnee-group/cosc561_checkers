package com.eddienicole.checkers;

public class MockMove implements MoveInterface {

	private PlayableSpaceInterface from;
	private PlayableSpaceInterface to;

	public MockMove() {

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
		MockMove other = (MockMove) obj;
		if (this.from == null) {
			if (other.from != null) {
				return false;
			}
		} else if (!this.from.equals(other.from)) {
			return false;
		}
		if (this.to == null) {
			if (other.to != null) {
				return false;
			}
		} else if (!this.to.equals(other.to)) {
			return false;
		}
		return true;
	}

	public PlayableSpaceInterface getFrom() {
		return this.from;
	}

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

	public void setFrom(PlayableSpaceInterface from) {
		this.from = from;
	}

	public void setTo(PlayableSpaceInterface to) {
		this.to = to;
	}

}
