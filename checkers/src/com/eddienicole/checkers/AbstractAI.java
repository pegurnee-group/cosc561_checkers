package com.eddienicole.checkers;

import java.util.ArrayList;

public abstract class AbstractAI extends AbstractPlayer {

	public AbstractAI(boolean isRed) {
		super(isRed);
	}

	public abstract MoveInterface computeMove(
			ArrayList<MoveInterface> legalMoves);

	public abstract double evaluateBoard(
			ImaginaryBoard theImaginaryBoardToReturn);

	@Override
	public MoveInterface getMove(ArrayList<MoveInterface> legalMoves) {
		return this.computeMove(legalMoves);
	}
}
