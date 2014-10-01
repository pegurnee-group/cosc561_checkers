package com.eddienicole.checkers;

import java.util.ArrayList;
import java.util.Iterator;

public class MoveFigurerOuter {
	private static boolean jumpHasOccurred;

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
						if (neighbors[i] != null) {
							if (neighbors[i].getState() == SpaceState.UNOCCUPIED) {
								toReturn.add(new Move(from, neighbors[i], false));
							} else if (neighbors[i].getState() != from
									.getState()) {
								PlayableSpaceInterface jumpSite = findPotentialJump(
										playableSpaces, row, column, i);
								if (jumpSite != null) {
									toReturn.add(new Move(from, jumpSite, true));
									jumpHasOccurred = true;
								}
							}
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

		if (jumpHasOccurred) {
			// int numberOfPossibleMoves = toReturn.size();
			Iterator<MoveInterface> moveIterator = toReturn.iterator();
			while (moveIterator.hasNext()) {
				if (!moveIterator.next().isJump()) {
					moveIterator.remove();
				}
			}
		}

		jumpHasOccurred = false;

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

	private static PlayableSpaceInterface findPotentialJump(
			PlayableSpaceInterface[][] playableSpaces, int row, int column,
			int location) {
		boolean red = playableSpaces[row][column].getState() == SpaceState.RED;
		boolean king = playableSpaces[row][column].isKing();
		switch (location) {
		case 0:
			return (red || king) ? findPotentialJumpsUpperLeft(playableSpaces,
					row, column) : null;
		case 1:
			return (red || king) ? findPotentialJumpsUpperRight(playableSpaces,
					row, column) : null;
		case 2:
			return (!red || king) ? findPotentialJumpsLowerRight(
					playableSpaces, row, column) : null;
		case 3:
			return (!red || king) ? findPotentialJumpsLowerLeft(playableSpaces,
					row, column) : null;
		default:
			return null;
		}
	}

	private static PlayableSpaceInterface[] findPotentialJumps(
			PlayableSpaceInterface[][] playableSpaces, int row, int column) {
		PlayableSpaceInterface[] toReturn = new PlayableSpaceInterface[4];
		boolean red = playableSpaces[row][column].getState() == SpaceState.RED;
		boolean king = playableSpaces[row][column].isKing();

		toReturn[0] = (red || king) ? findPotentialJumpsUpperLeft(
				playableSpaces, row, column) : null;
		toReturn[1] = (red || king) ? findPotentialJumpsUpperRight(
				playableSpaces, row, column) : null;
		toReturn[2] = (!red || king) ? findPotentialJumpsLowerRight(
				playableSpaces, row, column) : null;
		toReturn[3] = (!red || king) ? findPotentialJumpsLowerLeft(
				playableSpaces, row, column) : null;
		return toReturn;
	}

	private static PlayableSpaceInterface findPotentialJumpsLowerLeft(
			PlayableSpaceInterface[][] playableSpaces, int row, int column) {
		return findAnyOldSpace(playableSpaces, row + 2, column - 1);
	}

	private static PlayableSpaceInterface findPotentialJumpsLowerRight(
			PlayableSpaceInterface[][] playableSpaces, int row, int column) {
		return findAnyOldSpace(playableSpaces, row + 2, column + 1);
	}

	private static PlayableSpaceInterface findPotentialJumpsUpperLeft(
			PlayableSpaceInterface[][] playableSpaces, int row, int column) {
		return findAnyOldSpace(playableSpaces, row - 2, column - 1);
	}

	private static PlayableSpaceInterface findPotentialJumpsUpperRight(
			PlayableSpaceInterface[][] playableSpaces, int row, int column) {
		return findAnyOldSpace(playableSpaces, row - 2, column + 1);
	}

	private static boolean isEven(int row) {
		return (row % 2) == 0;
	}
}
