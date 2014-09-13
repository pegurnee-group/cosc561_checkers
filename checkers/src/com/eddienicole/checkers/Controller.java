package com.eddienicole.checkers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private final CheckersModel checkersModel;
	private final CheckerboardView checkerboardView;
	private AI ai;

	public Controller() {
		this.checkersModel = new CheckersModel();
		this.checkerboardView = new CheckerboardView();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
