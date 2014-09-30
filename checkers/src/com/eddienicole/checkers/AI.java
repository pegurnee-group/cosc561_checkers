package com.eddienicole.checkers;

import java.util.ArrayList;

public class AI implements PlayerInterface {

	private final boolean isRed;

	public AI(boolean isRed) {
		this.isRed = isRed;
	}

	@Override
	public MoveInterface getMove(ArrayList<MoveInterface> legalMoves) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRed() {
		return this.isRed;
	}

	// figuring this shit out

}
