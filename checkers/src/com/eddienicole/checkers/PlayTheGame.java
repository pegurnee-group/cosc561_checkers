package com.eddienicole.checkers;

public class PlayTheGame {

	public static void main(String[] args) {
		boolean isRed = true;
		boolean isBlack = false;

		boolean redPlayerHasWon;

		PlayerInterface playerRed;
		PlayerInterface playerBlack;

		int kindOfGame = 2;
		switch (kindOfGame) {
		case 1:
			playerRed = new HumanPlayer(isRed);
			playerBlack = new AI(isBlack);
			break;
		case 2:
			playerRed = new HumanPlayer(isRed);
			playerBlack = new HumanPlayer(isBlack);
			break;
		case 3:
			playerRed = new AI(isRed);
			playerBlack = new AI(isBlack);
			break;
		default:
			playerRed = new HumanPlayer(isRed);
			playerBlack = new AI(isBlack);
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
	}
}
