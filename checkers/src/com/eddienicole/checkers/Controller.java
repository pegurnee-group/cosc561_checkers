package com.eddienicole.checkers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

	private AI ai;
	private final PlayerInterface blackPlayer;
	private final CheckerboardView checkerboardView;
	private final CheckersModel checkersModel;
	private final PlayerInterface redPlayer;

	public Controller(PlayerInterface redPlayer, PlayerInterface blackPlayer) {
		this.checkersModel = new CheckersModel();
		this.checkerboardView = new CheckerboardView();
		this.redPlayer = redPlayer;
		this.blackPlayer = blackPlayer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void applyMove(MoveInterface moveToApply) {
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

	private String doMoveAndRedrawBoard(PlayerInterface playerWhoseTurnItIs) {
		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.checkersModel.getPlayableSpaces(),
				playerWhoseTurnItIs.isRed());
		if (legalMoves.size() > 0) {
			this.redPlayer.getMove(legalMoves);
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
