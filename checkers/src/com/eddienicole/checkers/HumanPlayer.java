package com.eddienicole.checkers;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer implements PlayerInterface {

	private final Scanner keyboard = new Scanner(System.in);

	@Override
	public MoveInterface getMove(ArrayList<MoveInterface> legalMoves) {
		System.out.println("Legal moves:");
		int numberOfLegalMoves = legalMoves.size();
		for (int index = 0; index < numberOfLegalMoves; index++) {
			System.out.printf("%3d %2d%2d\n", index + 1, legalMoves.get(index)
					.getFrom().getPosition(), legalMoves.get(index).getTo()
					.getPosition());
		}
		MoveInterface moveToReturn = legalMoves.get(keyboard.nextInt());
		keyboard.nextLine();
		return moveToReturn;
	}

}
