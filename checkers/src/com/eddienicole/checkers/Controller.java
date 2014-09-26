package com.eddienicole.checkers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private AI ai;
	private final CheckerboardView checkerboardView;
	private final CheckersModel checkersModel;

	public Controller() {
		this.checkersModel = new CheckersModel();
		this.checkerboardView = new CheckerboardView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public String drawCurrentBoard() {
		return this.checkerboardView.drawBoard(this.checkersModel
				.getPlayableSpaces());
	}

}
