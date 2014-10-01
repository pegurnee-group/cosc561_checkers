package com.eddienicole.checkers;

import java.util.Scanner;

public class PlayTheGame {

	public static void main(String[] args) {
		boolean isRed = true;
		boolean isBlack = false;

		boolean redPlayerHasWon;

		AbstractPlayer playerRed;
		AbstractPlayer playerBlack;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Select Game Type:");
		for (int i = 0; i < 4; i++) {
			System.out.printf("%3d %s vs. %s%n", i + 1, (i % 2) == 0 ? "AI"
					: "Human", (i % 3) == 0 ? "Human" : "AI");
		}
		int kindOfGame = keyboard.nextInt();

		switch (kindOfGame) {
		case 1:
			playerBlack = new BasicAI(isBlack);
			playerRed = new HumanPlayerConsoleOut(isRed);
			break;
		case 2:
			playerBlack = new HumanPlayerConsoleOut(isBlack);
			playerRed = new BasicAI(isRed);
			break;
		case 3:
			playerBlack = new BasicAI(isBlack);
			playerRed = new BasicAI(isRed);
			break;
		default:
			playerBlack = new HumanPlayerConsoleOut(isBlack);
			playerRed = new HumanPlayerConsoleOut(isRed);
			break;
		}
		Controller controller = new Controller(playerRed, playerBlack);

		controller.drawCurrentBoard();

		while (true) {
			if (!controller.doMove(playerBlack)) {
				redPlayerHasWon = true;
				break;
			}
			controller.drawCurrentBoard();
			if (!controller.doMove(playerRed)) {
				redPlayerHasWon = false;
				break;
			}
			controller.drawCurrentBoard();
		}

		controller.declareConqueringHero(redPlayerHasWon);

		keyboard.close();
	}
}
