package com.eddienicole.checkers;

public class CheckersModel {
	private final CheckersBoard checkersBoard;

	public CheckersModel() {
		this.checkersBoard = CheckersBoard.getInstance();
		this.checkersBoard.resetBoard();
	}

	public CheckersModel(PlayableSpaceInterface[][] playableSpaces) {
		this();
		this.checkersBoard.applyBoard(playableSpaces);
	}

	public PlayableSpaceInterface[][] getPlayableSpaces() {
		return this.checkersBoard.getPlayableSpaces();
	}

}
