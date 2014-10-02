package com.eddienicole.checkers;

import java.util.ArrayList;

public class AIBasic extends AbstractAI {
	public AIBasic(boolean isRed) {
		super(isRed);
	}

	@Override
	public MoveInterface computeMove(ArrayList<MoveInterface> legalMoves) {
		// TODO Auto-generated method stub
		return null;
	}

	private double evaluateBoard(ImaginaryBoard imaginaryBoard) {
		double toReturn = -1.0;

		// TODO: need to do some evaluation

		return toReturn;
	}

	private ImaginaryBoard generateBoardBasedOnMove(MoveInterface moveToApply) {
		ImaginaryBoard toReturn = null;

		// TODO: need to get the board
		return toReturn;
	}

	// figuring this shit out

}
