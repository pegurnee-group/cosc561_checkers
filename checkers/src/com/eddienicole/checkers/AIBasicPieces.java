package com.eddienicole.checkers;

import java.util.ArrayList;

public class AIBasicPieces extends AbstractAI {

	public AIBasicPieces(boolean isRed) {
		super(isRed);
	}

	@Override
	public MoveInterface computeMove(ArrayList<MoveInterface> legalMoves) {
		if (legalMoves.size() == 1) {
			return legalMoves.get(0);
		}
		SeeTheFutureTree tree = new SeeTheFutureTree(new ImaginaryBoard(null),
				this);
		return tree.getTheBestMove();
	}

	@Override
	public double evaluateBoard(ImaginaryBoard theImaginaryBoardToReturn) {
		double toReturn = -1.0;

		SpaceState targetState = this.isRed ? SpaceState.RED : SpaceState.BLACK;
		PlayableSpaceInterface[][] imaginaryBoardSpaces = theImaginaryBoardToReturn
				.getPlayableSpaces();

		int[] piecesMineMykingsEnemyEnemykings = { 0, 0, 0, 0 };
		for (int i = 0; i < imaginaryBoardSpaces.length; i++) {
			for (int j = 0; j < imaginaryBoardSpaces[i].length; j++) {
				PlayableSpaceInterface spaceUnderObservation = imaginaryBoardSpaces[i][j];
				if (spaceUnderObservation.getState() == targetState) {
					piecesMineMykingsEnemyEnemykings[0]++;
					if (spaceUnderObservation.isKing()) {
						piecesMineMykingsEnemyEnemykings[1]++;
					}
				} else if (spaceUnderObservation.getState() != SpaceState.UNOCCUPIED) {
					piecesMineMykingsEnemyEnemykings[2]++;
					if (spaceUnderObservation.isKing()) {
						piecesMineMykingsEnemyEnemykings[3]++;
					}
				}
			}
		}

		int rawData = ((piecesMineMykingsEnemyEnemykings[0] * 2) + (piecesMineMykingsEnemyEnemykings[1] * 3))
				- ((piecesMineMykingsEnemyEnemykings[2] * 1) + (piecesMineMykingsEnemyEnemykings[3] * 2));
		// int start = 12;
		// int best = 36;
		// int worst = -24;
		// double average = 24.0;

		return rawData;
	}

}
