package com.eddienicole.checkers;

public class CheckerboardView {

	public CheckerboardView() {

	}

	public String declareConqueringHero(boolean redPlayerHasWon) {
		String output = (redPlayerHasWon ? "Red " : "Black ")
				+ "player has emerged victorious!";
		System.out.println(output);
		return output;
	}

	public String drawBoard(PlayableSpaceInterface[][] playableSpaces) {

		String boardString = "   0 0 1 1 2 2 3 3\n" + "  =================\n";

		for (int i = 0; i < playableSpaces.length; i++) {
			boardString += "" + (i) + " |";
			for (int j = 0; j < playableSpaces[i].length; j++) {
				if ((i % 2) == 0) {
					boardString += " |" + this.drawSpace(playableSpaces[i][j])
							+ "|";
				} else {
					boardString += this.drawSpace(playableSpaces[i][j]) + "| |";
				}
			}
			boardString += "\n";
		}
		boardString += "  =================\n";

		System.out.println(boardString);

		return boardString;
	}

	private char drawSpace(PlayableSpaceInterface playableSpace) {
		char piece;

		switch (playableSpace.getState()) {
		case BLACK:
			piece = 'b';
			break;
		case RED:
			piece = 'r';
			break;
		case UNOCCUPIED:
			piece = ' ';
			break;
		default:
			piece = ' ';
			break;

		}

		if ((playableSpace.getState() != SpaceState.UNOCCUPIED)
				&& playableSpace.isKing()) {
			piece -= 32;
		}

		return piece;
	}

}