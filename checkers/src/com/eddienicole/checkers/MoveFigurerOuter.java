package com.eddienicole.checkers;

import java.util.ArrayList;
import java.util.Iterator;

public class MoveFigurerOuter {
	private static boolean jumpHasOccurred;

	public static ArrayList<MoveInterface> figure(
			PlayableSpaceInterface[][] playableSpaces,
			boolean redIsLookingAtTheBoard) {
		ArrayList<MoveInterface> toReturn = new ArrayList<>();
		SpaceState targetState = redIsLookingAtTheBoard ? SpaceState.RED
				: SpaceState.BLACK;
		PlayableSpaceInterface from;

		for (int row = 0; row < playableSpaces.length; row++) {
			for (int column = 0; column < playableSpaces[row].length; column++) {
				from = playableSpaces[row][column];
				if (from.getState() == targetState) {
					toReturn.addAll(findPotentialMoves(playableSpaces, from,
							row, column));
				}
			}
		}

		if (jumpHasOccurred) {
			removeNonJumpMoves(toReturn);
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

		toReturn[0] = isSpaceKingOrRed(playableSpaces[row][column]) ? findNeighborsUpperLeft(
				playableSpaces, row, column, onAnEvenRow) : null;
		toReturn[1] = isSpaceKingOrRed(playableSpaces[row][column]) ? findNeighborsUpperRight(
				playableSpaces, row, column, onAnEvenRow) : null;
		toReturn[2] = isSpaceKingOrBlack(playableSpaces[row][column]) ? findNeighborsLowerRight(
				playableSpaces, row, column, onAnEvenRow) : null;
		toReturn[3] = isSpaceKingOrBlack(playableSpaces[row][column]) ? findNeighborsLowerLeft(
				playableSpaces, row, column, onAnEvenRow) : null;
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
		switch (location) {
		case 0:
			return isSpaceKingOrRed(playableSpaces[row][column]) ? findPotentialJumpsUpperLeft(
					playableSpaces, row, column) : null;
		case 1:
			return isSpaceKingOrRed(playableSpaces[row][column]) ? findPotentialJumpsUpperRight(
					playableSpaces, row, column) : null;
		case 2:
			return isSpaceKingOrBlack(playableSpaces[row][column]) ? findPotentialJumpsLowerRight(
					playableSpaces, row, column) : null;
		case 3:
			return isSpaceKingOrBlack(playableSpaces[row][column]) ? findPotentialJumpsLowerLeft(
					playableSpaces, row, column) : null;
		default:
			return null;
		}
	}

	private static PlayableSpaceInterface[] findPotentialJumps(
			PlayableSpaceInterface[][] playableSpaces, int row, int column) {
		PlayableSpaceInterface[] toReturn = new PlayableSpaceInterface[4];

		toReturn[0] = isSpaceKingOrRed(playableSpaces[row][column]) ? findPotentialJumpsUpperLeft(
				playableSpaces, row, column) : null;
		toReturn[1] = isSpaceKingOrRed(playableSpaces[row][column]) ? findPotentialJumpsUpperRight(
				playableSpaces, row, column) : null;
		toReturn[2] = isSpaceKingOrBlack(playableSpaces[row][column]) ? findPotentialJumpsLowerRight(
				playableSpaces, row, column) : null;
		toReturn[3] = isSpaceKingOrBlack(playableSpaces[row][column]) ? findPotentialJumpsLowerLeft(
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

	private static ArrayList<MoveInterface> findPotentialMoves(
			PlayableSpaceInterface[][] playableSpaces,
			PlayableSpaceInterface from, int row, int column) {
		ArrayList<MoveInterface> toReturn = new ArrayList<>();

		PlayableSpaceInterface[] neighbors = findNeighbors(playableSpaces, row,
				column, isEven(row));
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] != null) {
				if (neighbors[i].getState() == SpaceState.UNOCCUPIED) {
					toReturn.add(new Move(from, neighbors[i], false));
				} else if (neighbors[i].getState() != from.getState()) {
					PlayableSpaceInterface jumpSite = findPotentialJump(
							playableSpaces, row, column, i);
					if (jumpSite != null) {
						toReturn.add(new Move(from, jumpSite, true));
						jumpHasOccurred = true;
					}
				}
			}
		}
		return toReturn;
	}

	private static boolean isEven(int row) {
		return (row % 2) == 0;
	}

	private static boolean isSpaceKingOrBlack(PlayableSpaceInterface space) {
		return (space.isKing() || (space.getState() == SpaceState.BLACK));
	}

	private static boolean isSpaceKingOrRed(PlayableSpaceInterface space) {
		return (space.isKing() || (space.getState() == SpaceState.RED));
	}

	private static void removeNonJumpMoves(ArrayList<MoveInterface> toReturn) {
		Iterator<MoveInterface> moveIterator = toReturn.iterator();
		while (moveIterator.hasNext()) {
			if (!moveIterator.next().isJump()) {
				moveIterator.remove();
			}
		}
	}
}
