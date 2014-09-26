package com.eddienicole.checkers;

public class CheckersModel {

	private final PlayableSpaceInterface[][] playableSpaces;

	public CheckersModel() {
		this.playableSpaces = new PlayableSpace[8][4];
		for (int i = 0; i < this.playableSpaces.length; i++) {
			for (int j = 0; j < this.playableSpaces[i].length; j++) {
				this.playableSpaces[i][j] = new PlayableSpace((4 * i) + j + 1);
				if (i < 3) {
					this.playableSpaces[i][j].setState(SpaceState.BLACK);
				} else if (i > 4) {
					this.playableSpaces[i][j].setState(SpaceState.RED);
				}
			}
		}
	}

	public CheckersModel(PlayableSpaceInterface[][] playableSpaces) {
		this.playableSpaces = playableSpaces;
	}

	public PlayableSpaceInterface[][] getPlayableSpaces() {
		return this.playableSpaces;
	}

}
