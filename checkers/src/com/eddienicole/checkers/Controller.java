package com.eddienicole.checkers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

	private AI ai;
	private final CheckerboardView checkerboardView;
	private final CheckersModel checkersModel;
	private final PlayerInterface redPlayer;
	private final PlayerInterface blackPlayer;

	public Controller(PlayerInterface redPlayer, PlayerInterface blackPlayer) {
		this.checkersModel = new CheckersModel();
		this.checkerboardView = new CheckerboardView();
		this.redPlayer = redPlayer;
		this.blackPlayer = blackPlayer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public String drawCurrentBoard() {
		return this.checkerboardView.drawBoard(this.checkersModel
				.getPlayableSpaces());
	}

	private String doMoveAndRedrawBoard(boolean isRedLookingAtTheBoard) {
		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.checkersModel.getPlayableSpaces(), isRedLookingAtTheBoard);
		if (legalMoves.size() > 0) {
			redPlayer.getMove(legalMoves);
		} else {
			// YOU LOOOOSE
		}

		return drawCurrentBoard();
	}

}
