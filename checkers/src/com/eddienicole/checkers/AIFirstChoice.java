package com.eddienicole.checkers;

import java.util.ArrayList;

public class AIFirstChoice extends AbstractAI {

	public AIFirstChoice(boolean isRed) {
		super(isRed);
	}

	@Override
	public MoveInterface computeMove(ArrayList<MoveInterface> legalMoves) {
		return legalMoves.get(0);
	}

	@Override
	public double evaluateBoard(ImaginaryBoard theImaginaryBoardToReturn) {
		// TODO Auto-generated method stub
		return 0;
	}

}
