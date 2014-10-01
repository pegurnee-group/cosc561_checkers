package com.eddienicole.checkers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

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

	public void declareConqueringHero(boolean redPlayerHasWon) {
		this.checkerboardView.declareConqueringHero(redPlayerHasWon);
	}

	public boolean doMove(PlayerInterface playerWhoseTurnItIs) {
		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.checkersModel.getPlayableSpaces(),
				playerWhoseTurnItIs.isRed());
		if (legalMoves.size() > 0) {
			MoveInterface move = playerWhoseTurnItIs.getMove(legalMoves);
			this.applyMove(move);
			this.kingMe(move, playerWhoseTurnItIs.isRed());
			return true;
		} else {
			return false;
		}
	}

	public String drawCurrentBoard() {
		return this.checkerboardView.drawBoard(this.checkersModel
				.getPlayableSpaces());
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

		if (moveToApply.isJump()) {
			Stack<PlayableSpaceInterface> jumpedStack = moveToApply
					.getJumpedStack();
			while (!jumpedStack.isEmpty()) {
				PlayableSpaceInterface jumpedPiece = jumpedStack.pop();
				jumpedPiece.setState(SpaceState.UNOCCUPIED);
				jumpedPiece.setKing(false);
			}

		}

		toSpace.setState(fromSpace.getState());
		toSpace.setKing(fromSpace.isKing());

		fromSpace.setState(SpaceState.UNOCCUPIED);
		fromSpace.setKing(false);
	}

	private void kingMe(MoveInterface move, boolean itIsRedsTurn) {
		if (itIsRedsTurn) {
			if (move.getTo().getPosition() < 5) {
				move.getTo().setKing(true);
			}
		} else {
			if (move.getTo().getPosition() > 28) {
				move.getTo().setKing(true);
			}
		}
	}

}
