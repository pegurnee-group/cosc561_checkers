package com.eddienicole.checkers;

public class PlayTheGame {

	public static void main(String[] args) {

		PlayerInterface redPlayer;
		PlayerInterface blackPlayer;

		int kindOfGame = 1;
		switch (kindOfGame) {
		case 1:
			redPlayer = new HumanPlayer();
			blackPlayer = new AI();
			break;
		case 2:
			redPlayer = new HumanPlayer();
			blackPlayer = new HumanPlayer();
			break;
		case 3:
			redPlayer = new AI();
			blackPlayer = new AI();
			break;
		default:
			redPlayer = new HumanPlayer();
			blackPlayer = new AI();
			break;
		}
		Controller controller = new Controller(redPlayer, blackPlayer);

		controller.drawCurrentBoard();

	}

}
