package com.eddienicole.checkers;

import java.util.ArrayList;

public class AILastChoice extends AbstractAI {

	public AILastChoice(boolean isRed) {
		super(isRed);
	}

	@Override
	public MoveInterface computeMove(ArrayList<MoveInterface> legalMoves) {
		return legalMoves.get(legalMoves.size() - 1);
	}

	@Override
	public double evaluateBoard(ImaginaryBoard theImaginaryBoardToReturn) {
		// TODO Auto-generated method stub
		return 0;
	}

}
