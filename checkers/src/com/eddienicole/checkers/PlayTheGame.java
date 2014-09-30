package com.eddienicole.checkers;

public class PlayTheGame {

	public static void main(String[] args) {
		boolean red = true;
		boolean black = false;
		PlayerInterface redPlayer;
		PlayerInterface blackPlayer;

		int kindOfGame = 1;
		switch (kindOfGame) {
		case 1:
			redPlayer = new HumanPlayer(red);
			blackPlayer = new AI(black);
			break;
		case 2:
			redPlayer = new HumanPlayer(red);
			blackPlayer = new HumanPlayer(black);
			break;
		case 3:
			redPlayer = new AI(red);
			blackPlayer = new AI(black);
			break;
		default:
			redPlayer = new HumanPlayer(red);
			blackPlayer = new AI(black);
			break;
		}
		Controller controller = new Controller(redPlayer, blackPlayer);

		controller.drawCurrentBoard();

	}
}
