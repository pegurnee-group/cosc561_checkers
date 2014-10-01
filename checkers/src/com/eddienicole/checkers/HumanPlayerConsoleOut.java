package com.eddienicole.checkers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayerConsoleOut extends AbstractPlayer {
	private final Scanner keyboard = new Scanner(System.in);

	public HumanPlayerConsoleOut(boolean isRed) {
		super(isRed);
	}

	@Override
	public MoveInterface getMove(ArrayList<MoveInterface> legalMoves) {
		MoveInterface moveToReturn;
		while (true) {
			System.out.println("Legal moves for "
					+ (this.isRed ? "RED" : "BLACK") + ":");
			int numberOfLegalMoves = legalMoves.size();
			for (int index = 0; index < numberOfLegalMoves; index++) {
				this.printMoveInTermsOfPositionAndRowColumn(legalMoves, index);
			}
			try {
				moveToReturn = legalMoves.get(this.keyboard.nextInt() - 1);
				break;
			} catch (InputMismatchException | IndexOutOfBoundsException e) {
				System.out.println("Invalid input.");
			}
			this.keyboard.nextLine();
		}
		return moveToReturn;
	}

	@Override
	public boolean isRed() {
		return this.isRed;
	}

	private void printMoveInTermsOfPositionAndRowColumn(
			ArrayList<MoveInterface> legalMoves, int index) {
		int positionFrom = legalMoves.get(index).getFrom().getPosition();
		int positionTo = legalMoves.get(index).getTo().getPosition();

		int positionFromRow = ((positionFrom - 1) * 2) / 8;
		int positionToRow = ((positionTo - 1) * 2) / 8;

		int positionFromColumnAsChar = (((positionFrom - 1) * 2) % 8)
				+ ((positionFromRow % 2) == 0 ? 1 : 0) + 1;
		int positionToColumnAsChar = (((positionTo - 1) * 2) % 8)
				+ ((positionToRow % 2) == 0 ? 1 : 0) + 1;

		System.out.printf("%3d %2d-%-2d  (%c%d-%c%d)\n", index + 1,
				positionFrom, positionTo, positionFromRow + 65,
				positionFromColumnAsChar, positionToRow + 65,
				positionToColumnAsChar);
	}

}
