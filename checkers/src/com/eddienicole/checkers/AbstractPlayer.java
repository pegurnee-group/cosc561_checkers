package com.eddienicole.checkers;

import java.util.ArrayList;

public abstract class AbstractPlayer {
	protected boolean isRed;

	public AbstractPlayer(boolean isRed) {
		this.isRed = isRed;
	}

	public abstract MoveInterface getMove(ArrayList<MoveInterface> legalMoves);

	public boolean isRed() {
		return this.isRed;
	}

}
