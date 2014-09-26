package com.eddienicole.checkers;


public class CheckerboardView {

	public CheckerboardView() {

	}

	public String drawBoard(PlayableSpaceInterface[][] playableSpaces) {

		String boardString = "   a b c d e f g h\n" + "  =================\n";

		for (int i = 0; i < playableSpaces.length; i++) {
			boardString += "" + (i + 1) + " |";
			for (int j = 0; j < playableSpaces[i].length; j++) {
				if (i % 2 == 0) {
					boardString += " |" + drawSpace(playableSpaces[i][j]) + "|";
				} else {
					boardString += drawSpace(playableSpaces[i][j]) + "| |";
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

		if (playableSpace.getState() != SpaceState.UNOCCUPIED
				&& playableSpace.isKing()) {
			piece -= 32;
		}

		return piece;
	}

}