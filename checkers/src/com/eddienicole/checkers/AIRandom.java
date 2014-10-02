package com.eddienicole.checkers;

import java.util.ArrayList;

public class AIRandom extends AbstractAI {

	public AIRandom(boolean isRed) {
		super(isRed);
	}

	@Override
	public MoveInterface computeMove(ArrayList<MoveInterface> legalMoves) {
		int randomIndexForMove = (int) (Math.random() * legalMoves.size());
		return legalMoves.get(randomIndexForMove);
	}
}
