package com.eddienicole.checkers;

import java.util.ArrayList;

public abstract class AbstractAI extends AbstractPlayer {

	protected class ImaginaryBoard {
		private final PlayableSpaceInterface[][] playableSpaces;

		protected ImaginaryBoard(PlayableSpaceInterface[][] playableSpaces) {
			this.playableSpaces = playableSpaces;
		}

		protected PlayableSpaceInterface[][] getPlayableSpaces() {
			return this.playableSpaces;
		}

	}

	public AbstractAI(boolean isRed) {
		super(isRed);
	}

	public abstract MoveInterface computeMove(
			ArrayList<MoveInterface> legalMoves);

	@Override
	public MoveInterface getMove(ArrayList<MoveInterface> legalMoves) {
		return this.computeMove(legalMoves);
	}
}
