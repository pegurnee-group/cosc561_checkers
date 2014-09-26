package com.eddienicole.checkers;

import java.util.ArrayList;

public class MoveFigurerOuter {

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
			PlayableSpaceInterface[][] playableSpaces, boolean isRedLookingAtTheBoard) {
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
						} else {
							checkUpLeftIfOdd(playableSpaces, toReturn, from, i,
									j);
							checkUpLeftIfEvenRightIfOdd(playableSpaces,
									toReturn, from, i, j);
						}
					}
				}
			}
		}

		return toReturn;

	}

}
