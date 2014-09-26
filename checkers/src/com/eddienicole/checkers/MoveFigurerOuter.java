package com.eddienicole.checkers;

import java.util.ArrayList;

public class MoveFigurerOuter {

	private static void checkDownLeftIfEvenRightIfOdd(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int i, int j) {
		try {
			if (playableSpaces[i + 1][j].getState() == SpaceState.UNOCCUPIED) {
				toReturn.add(new Move(from, playableSpaces[i + 1][j]));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	private static void checkDownLeftIfOdd(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int i, int j) {
		try {
			if (playableSpaces[i + 1][j - 1].getState() == SpaceState.UNOCCUPIED) {
				toReturn.add(new Move(from, playableSpaces[i + 1][j - 1]));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	private static void checkDownRightIfEven(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int i, int j) {
		try {
			if (playableSpaces[i + 1][j + 1].getState() == SpaceState.UNOCCUPIED) {
				toReturn.add(new Move(from, playableSpaces[i + 1][j + 1]));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	private static void checkUpLeftIfEvenRightIfOdd(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int i, int j) {
		try {
			if (playableSpaces[i - 1][j].getState() == SpaceState.UNOCCUPIED) {
				toReturn.add(new Move(from, playableSpaces[i - 1][j]));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	private static void checkUpLeftIfOdd(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int i, int j) {
		try {
			if (playableSpaces[i - 1][j - 1].getState() == SpaceState.UNOCCUPIED) {
				toReturn.add(new Move(from, playableSpaces[i - 1][j - 1]));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	private static void checkUpRightIfEven(
			PlayableSpaceInterface[][] playableSpaces,
			ArrayList<MoveInterface> toReturn, PlayableSpaceInterface from,
			int i, int j) {
		try {
			if (playableSpaces[i - 1][j + 1].getState() == SpaceState.UNOCCUPIED) {
				toReturn.add(new Move(from, playableSpaces[i - 1][j + 1]));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	public static ArrayList<MoveInterface> figure(
			PlayableSpaceInterface[][] playableSpaces,
			boolean isRedLookingAtTheBoard) {
		ArrayList<MoveInterface> toReturn = new ArrayList<>();
		PlayableSpaceInterface from;
		if (isRedLookingAtTheBoard) {
			for (int i = 0; i < playableSpaces.length; i++) {
				for (int j = 0; j < playableSpaces[i].length; j++) {
					from = playableSpaces[i][j];
					if (from.getState() == SpaceState.RED) {
						if ((i % 2) == 0) {
							checkUpLeftIfEvenRightIfOdd(playableSpaces,
									toReturn, from, i, j);
							checkUpRightIfEven(playableSpaces, toReturn, from,
									i, j);
							if (from.isKing()) {
								checkDownLeftIfEvenRightIfOdd(playableSpaces,
										toReturn, from, i, j);
								checkDownRightIfEven(playableSpaces, toReturn,
										from, i, j);
							}
						} else {
							checkUpLeftIfOdd(playableSpaces, toReturn, from, i,
									j);
							checkUpLeftIfEvenRightIfOdd(playableSpaces,
									toReturn, from, i, j);
							if (from.isKing()) {
								checkDownLeftIfOdd(playableSpaces, toReturn,
										from, i, j);
								checkDownLeftIfEvenRightIfOdd(playableSpaces,
										toReturn, from, i, j);
							}
						}
					}
				}
			}
		} else {
			for (int i = 0; i < playableSpaces.length; i++) {
				for (int j = 0; j < playableSpaces[i].length; j++) {
					from = playableSpaces[i][j];
					if (from.getState() == SpaceState.BLACK) {
						if ((i % 2) == 0) {
							checkDownLeftIfEvenRightIfOdd(playableSpaces,
									toReturn, from, i, j);
							checkDownRightIfEven(playableSpaces, toReturn,
									from, i, j);
							if (from.isKing()) {
								checkUpLeftIfEvenRightIfOdd(playableSpaces,
										toReturn, from, i, j);
								checkUpRightIfEven(playableSpaces, toReturn,
										from, i, j);
							}
						} else {
							checkDownLeftIfOdd(playableSpaces, toReturn, from,
									i, j);
							checkDownLeftIfEvenRightIfOdd(playableSpaces,
									toReturn, from, i, j);
							if (from.isKing()) {
								checkUpLeftIfOdd(playableSpaces, toReturn,
										from, i, j);
								checkUpLeftIfEvenRightIfOdd(playableSpaces,
										toReturn, from, i, j);
							}
						}
					}
				}
			}
		}

		return toReturn;

	}

}
