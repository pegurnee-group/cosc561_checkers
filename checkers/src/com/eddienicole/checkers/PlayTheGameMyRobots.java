package com.eddienicole.checkers;

import java.util.Scanner;

public class PlayTheGameMyRobots {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		AbstractAI playerBlack;
		AbstractAI playerRed;

		boolean black = false;
		boolean red = true;

		System.out.println("How many games? ");
		int numOfGames = keyboard.nextInt();

		System.out.println("What type of AI for black?");
		int blackLevelAI = keyboard.nextInt();

		switch (blackLevelAI) {
		case 1:
			playerBlack = new AIFirstChoice(black);
			break;
		case 2:
			playerBlack = new AIRandom(black);
			break;
		case 3:
			playerBlack = new AIBasicPieces(black);
			break;
		default:
			playerBlack = null;
			break;
		}

		System.out.println("What type of AI for Red?");
		int redLevelAI = keyboard.nextInt();

		switch (redLevelAI) {
		case 1:
			playerRed = new AIFirstChoice(red);
			break;
		case 2:
			playerRed = new AIRandom(red);
			break;
		case 3:
			playerRed = new AIBasicPieces(red);
			break;
		default:
			playerRed = null;
			break;
		}

		Controller controller = new Controller(playerRed, playerBlack);
		// black wins, red wins, ties
		int[] data = new int[3];
		for (int i = 0; i < numOfGames; i++) {
			CheckersBoard.getInstance().resetBoard();
			int currentTurns = 0;
			while (true) {
				if (!controller.doMove(playerBlack)) {
					data[1]++;
					break;
				}
				if (!controller.doMove(playerRed)) {
					data[0]++;
					break;
				}
				currentTurns++;
				if (currentTurns >= 60) {
					data[2]++;
					break;
				}
			}

		}
		System.out.printf("Data:\nBlack Wins: %6d\nRed Wins: %6d\nTies: %6d",
				data[0], data[1], data[2]);
		keyboard.close();
	}

}
