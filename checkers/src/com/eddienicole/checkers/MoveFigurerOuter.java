package com.eddienicole.checkers;

import java.util.ArrayList;

public class MoveFigurerOuter {

	public static ArrayList<MoveInterface> figure(
			PlayableSpaceInterface[][] playableSpaces,
			boolean redIsLookingAtTheBoard) {
		ArrayList<MoveInterface> toReturn = new ArrayList<>();
		PlayableSpaceInterface from;

		for (int row = 0; row < playableSpaces.length; row++) {
			for (int column = 0; column < playableSpaces[row].length; column++) {
				from = playableSpaces[row][column];
				if (redIsLookingAtTheBoard
						&& (from.getState() == SpaceState.RED)) {
					figureOutMovesForOneRedPiece(playableSpaces, toReturn,
							from, row, column);
				} else if (!redIsLookingAtTheBoard
						&& (from.getState() == SpaceState.BLACK)) {
					figureOutMovesForOneBlackPiece(playableSpaces, toReturn,
							from, row, column);
				}
			}
		}

		return toReturn;
	}

	private static void checkDownLeftIfEvenDownRightIfOdd(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int row, int column) {
		try {
			PlayableSpaceInterface to = playableSpaces[row + 1][column];
			ifToIsUnoccupiedAddNewMoveToLegalMoves(toReturn, from, to);
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	private static void checkDownLeftIfOdd(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int row, int column) {
		try {
			PlayableSpaceInterface to = playableSpaces[row + 1][column - 1];
			if (!ifToIsUnoccupiedAddNewMoveToLegalMoves(toReturn, from, to)) {
				to = playableSpaces[row + 2][column - 1];
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	private static void checkDownRightIfEven(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int row, int column) {
		try {
			PlayableSpaceInterface to = playableSpaces[row + 1][column + 1];
			ifToIsUnoccupiedAddNewMoveToLegalMoves(toReturn, from, to);
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	private static void checkUpLeftIfEvenUpRightIfOdd(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int row, int column) {
		try {
			PlayableSpaceInterface to = playableSpaces[row - 1][column];
			ifToIsUnoccupiedAddNewMoveToLegalMoves(toReturn, from, to);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	private static void checkUpLeftIfOdd(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int row, int column) {
		try {
			PlayableSpaceInterface to = playableSpaces[row - 1][column - 1];
			ifToIsUnoccupiedAddNewMoveToLegalMoves(toReturn, from, to);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	private static void checkUpRightIfEven(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int row, int column) {
		try {
			PlayableSpaceInterface to = playableSpaces[row - 1][column + 1];
			ifToIsUnoccupiedAddNewMoveToLegalMoves(toReturn, from, to);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	private static void figureOutMovesForOneBlackPiece(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int row, int column) {
		checkDownLeftIfEvenDownRightIfOdd(playableSpaces, toReturn, from, row,
				column);
		if (isEven(row)) {
			checkDownRightIfEven(playableSpaces, toReturn, from, row, column);
			if (from.isKing()) {
				checkUpLeftIfEvenUpRightIfOdd(playableSpaces, toReturn, from,
						row, column);
				checkUpRightIfEven(playableSpaces, toReturn, from, row, column);
			}
		} else {
			checkDownLeftIfOdd(playableSpaces, toReturn, from, row, column);
			if (from.isKing()) {
				checkUpLeftIfOdd(playableSpaces, toReturn, from, row, column);
				checkUpLeftIfEvenUpRightIfOdd(playableSpaces, toReturn, from,
						row, column);
			}
		}
	}

	private static void figureOutMovesForOneRedPiece(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int row, int column) {
		checkUpLeftIfEvenUpRightIfOdd(playableSpaces, toReturn, from, row,
				column);
		if (isEven(row)) {
			checkUpRightIfEven(playableSpaces, toReturn, from, row, column);
			if (from.isKing()) {
				checkDownLeftIfEvenDownRightIfOdd(playableSpaces, toReturn,
						from, row, column);
				checkDownRightIfEven(playableSpaces, toReturn, from, row,
						column);
			}
		} else {
			checkUpLeftIfOdd(playableSpaces, toReturn, from, row, column);
			if (from.isKing()) {
				checkDownLeftIfOdd(playableSpaces, toReturn, from, row, column);
				checkDownLeftIfEvenDownRightIfOdd(playableSpaces, toReturn,
						from, row, column);
			}
		}
	}

	private static boolean ifToIsUnoccupiedAddNewMoveToLegalMoves(
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			PlayableSpaceInterface to) {
		if (to.getState() == SpaceState.UNOCCUPIED) {
			toReturn.add(new Move(from, to, false));
			return true;
		}
		return false;
	}

	private static boolean isEven(int row) {
		return (row % 2) == 0;
	}
}
