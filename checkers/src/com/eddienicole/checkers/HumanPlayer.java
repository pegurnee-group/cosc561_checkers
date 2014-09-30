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
			System.out.println("Legal moves:");
			int numberOfLegalMoves = legalMoves.size();
			for (int index = 0; index < numberOfLegalMoves; index++) {
				System.out.printf("%3d %2d-%2d\n", index + 1,
						legalMoves.get(index).getFrom().getPosition(),
						legalMoves.get(index).getTo().getPosition());
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

	@Override
	public boolean isRed() {
		return this.isRed;
	}

}
