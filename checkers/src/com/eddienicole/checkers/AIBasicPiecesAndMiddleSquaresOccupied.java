package com.eddienicole.checkers;

import java.util.ArrayList;

public class AIBasicPiecesAndMiddleSquaresOccupied extends AbstractAI {

	public AIBasicPiecesAndMiddleSquaresOccupied(boolean isRed) {
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

		return this.evaluateBoardBasedOnMiddlePieces(theImaginaryBoardToReturn)
				+ this.evaluateBoardBasedOnPieces(theImaginaryBoardToReturn);
	}

	private double evaluateBoardBasedOnMiddlePieces(
			ImaginaryBoard theImaginaryBoardToReturn) {
		SpaceState targetState = this.isRed ? SpaceState.RED : SpaceState.BLACK;
		PlayableSpaceInterface[][] imaginaryBoardSpaces = theImaginaryBoardToReturn
				.getPlayableSpaces();

		int[] spacesKeyBoring = { 0, 0 };
		for (int i = 1; i < (imaginaryBoardSpaces.length - 1); i++) {
			for (int j = 0; j < imaginaryBoardSpaces[i].length; j++) {
				PlayableSpaceInterface spaceUnderObservation = imaginaryBoardSpaces[i][j];
				if (spaceUnderObservation.getState() == targetState) {
					if ((i == 1) || (i == (imaginaryBoardSpaces.length - 2))
							|| (j == 0)
							|| (j == (imaginaryBoardSpaces[i].length - 1))) {
						spacesKeyBoring[1]++;
					} else {
						spacesKeyBoring[0]++;
					}
				}
			}
		}

		int rawData = ((spacesKeyBoring[0] * 3) - (spacesKeyBoring[1] * 2));
		return rawData;
	}

	private double evaluateBoardBasedOnPieces(
			ImaginaryBoard theImaginaryBoardToReturn) {
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

		return rawData;
	}
}
