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
					PlayableSpaceInterface[] neighbors = findNeighbors(
							playableSpaces, row, column, isEven(row));
					for (int i = 0; i < neighbors.length; i++) {
						if ((neighbors[i] != null)
								&& (neighbors[i].getState() == SpaceState.UNOCCUPIED)) {
							toReturn.add(new Move(from, neighbors[i], false));
						}
					}
				} else if (!redIsLookingAtTheBoard
						&& (from.getState() == SpaceState.BLACK)) {
					PlayableSpaceInterface[] neighbors = findNeighbors(
							playableSpaces, row, column, isEven(row));
					for (int i = 0; i < neighbors.length; i++) {
						if ((neighbors[i] != null)
								&& (neighbors[i].getState() == SpaceState.UNOCCUPIED)) {
							toReturn.add(new Move(from, neighbors[i], false));
						}
					}
				}
			}
		}

		return toReturn;
	}

	private static PlayableSpaceInterface findAnyOldSpace(
			PlayableSpaceInterface[][] playableSpaces, int targetRow,
			int targetColumn) {
		try {
			return playableSpaces[targetRow][targetColumn];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	private static PlayableSpaceInterface[] findNeighbors(
			PlayableSpaceInterface[][] playableSpaces, int row, int column,
			boolean onAnEvenRow) {
		PlayableSpaceInterface[] toReturn = new PlayableSpaceInterface[4];
		boolean red = playableSpaces[row][column].getState() == SpaceState.RED;
		boolean king = playableSpaces[row][column].isKing();

		toReturn[0] = (red || king) ? findNeighborsUpperLeft(playableSpaces,
				row, column, onAnEvenRow) : null;
		toReturn[1] = (red || king) ? findNeighborsUpperRight(playableSpaces,
				row, column, onAnEvenRow) : null;
		toReturn[2] = (!red || king) ? findNeighborsLowerRight(playableSpaces,
				row, column, onAnEvenRow) : null;
		toReturn[3] = (!red || king) ? findNeighborsLowerLeft(playableSpaces,
				row, column, onAnEvenRow) : null;
		return toReturn;
	}

	private static PlayableSpaceInterface findNeighborsLowerLeft(
			PlayableSpaceInterface[][] playableSpaces, int row, int column,
			boolean onAnEvenRow) {
		return findAnyOldSpace(playableSpaces, row + 1, onAnEvenRow ? column
				: column - 1);
	}

	private static PlayableSpaceInterface findNeighborsLowerRight(
			PlayableSpaceInterface[][] playableSpaces, int row, int column,
			boolean onAnEvenRow) {
		return findAnyOldSpace(playableSpaces, row + 1,
				onAnEvenRow ? column + 1 : column);
	}

	private static PlayableSpaceInterface findNeighborsUpperLeft(
			PlayableSpaceInterface[][] playableSpaces, int row, int column,
			boolean onAnEvenRow) {
		return findAnyOldSpace(playableSpaces, row - 1, onAnEvenRow ? column
				: column - 1);
	}

	private static PlayableSpaceInterface findNeighborsUpperRight(
			PlayableSpaceInterface[][] playableSpaces, int row, int column,
			boolean onAnEvenRow) {
		return findAnyOldSpace(playableSpaces, row - 1,
				onAnEvenRow ? column + 1 : column);
	}

	private static boolean isEven(int row) {
		return (row % 2) == 0;
	}
}
