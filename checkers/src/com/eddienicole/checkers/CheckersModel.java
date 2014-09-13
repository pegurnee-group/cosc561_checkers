package com.eddienicole.checkers;

public class CheckersModel {

	private PlayableSpaceInterface[][] playableSpaces;

	public CheckersModel() {

	}

	public CheckersModel(PlayableSpaceInterface[][] playableSpaces) {
		this.playableSpaces = playableSpaces;
	}

	public PlayableSpaceInterface[][] getPlayableSpaces() {
		return this.playableSpaces;
	}

}
