package com.eddienicole.checkers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements PlayerInterface {

	private final boolean isRed;
	private final Scanner keyboard = new Scanner(System.in);

	public HumanPlayer(boolean isRed) {
		this.isRed = isRed;
	}

	@Override
	public MoveInterface getMove(ArrayList<MoveInterface> legalMoves) {
		MoveInterface moveToReturn;
		while (true) {
			System.out.println("Legal moves for " + (isRed ? "RED" : "BLACK")
					+ ":");
			int numberOfLegalMoves = legalMoves.size();
			for (int index = 0; index < numberOfLegalMoves; index++) {
				printMoveInTermsOfPositionAndRowColumn(legalMoves, index);
			}
			try {
				moveToReturn = legalMoves.get(this.keyboard.nextInt() - 1);
				break;
			} catch (InputMismatchException | IndexOutOfBoundsException e) {
				System.out.println("Invalid input.");
			}
		}
		this.keyboard.nextLine();
		return moveToReturn;
	}

	private void printMoveInTermsOfPositionAndRowColumn(
			ArrayList<MoveInterface> legalMoves, int index) {
		int positionFrom = legalMoves.get(index).getFrom().getPosition();
		int positionTo = legalMoves.get(index).getTo().getPosition();

		int positionFromRow = (positionFrom - 1) * 2 / 8;
		int positionToRow = (positionTo - 1) * 2 / 8;

		int positionFromColumnAsChar = (positionFrom - 1) * 2 % 8
				+ (positionFromRow % 2 == 0 ? 1 : 0) + 65;
		int positionToColumnAsChar = (positionTo - 1) * 2 % 8
				+ (positionToRow % 2 == 0 ? 1 : 0) + 65;

		System.out.printf("%3d %2d-%-2d  (%c%d-%c%d)\n", index + 1,
				positionFrom, positionTo, positionFromColumnAsChar,
				positionFromRow + 1, positionToColumnAsChar, positionToRow + 1);
	}

	@Override
	public boolean isRed() {
		return this.isRed;
	}

}
