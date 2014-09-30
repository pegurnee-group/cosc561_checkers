package com.eddienicole.checkers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {
	private final CheckerboardView checkerboardView;
	private final CheckersModel checkersModel;
	private final PlayerInterface playerBlack;
	private final PlayerInterface playerRed;

	public Controller(PlayerInterface redPlayer, PlayerInterface blackPlayer) {
		this.checkersModel = new CheckersModel();
		this.checkerboardView = new CheckerboardView();
		this.playerRed = redPlayer;
		this.playerBlack = blackPlayer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private void applyMove(MoveInterface moveToApply) {
		PlayableSpaceInterface fromSpace = null;
		PlayableSpaceInterface toSpace = null;

		PlayableSpaceInterface[][] spaces = this.checkersModel
				.getPlayableSpaces();
		for (int i = 0; i < spaces.length; i++) {
			for (int j = 0; j < spaces[i].length; j++) {
				if (spaces[i][j].getPosition() == moveToApply.getFrom()
						.getPosition()) {
					fromSpace = spaces[i][j];
				}
				if (spaces[i][j].getPosition() == moveToApply.getTo()
						.getPosition()) {
					toSpace = spaces[i][j];
				}
			}
		}

		toSpace.setState(fromSpace.getState());
		toSpace.setKing(fromSpace.isKing());

		fromSpace.setState(SpaceState.UNOCCUPIED);
		fromSpace.setKing(false);
	}

	public String doMoveAndRedrawBoard(PlayerInterface playerWhoseTurnItIs) {
		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.checkersModel.getPlayableSpaces(),
				playerWhoseTurnItIs.isRed());
		if (legalMoves.size() > 0) {
			this.applyMove(playerWhoseTurnItIs.getMove(legalMoves));
		} else {
			// YOU LOOOOSE
		}

		return this.drawCurrentBoard();
	}

	public String drawCurrentBoard() {
		return this.checkerboardView.drawBoard(this.checkersModel
				.getPlayableSpaces());
	}

}
