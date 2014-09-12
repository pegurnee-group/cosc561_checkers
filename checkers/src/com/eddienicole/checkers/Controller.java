package com.eddienicole.checkers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private CheckersModel checkersModel;
	private CheckerboardView checkerboardView;
	private AI ai;

	public Controller() {
		this.checkersModel = new CheckersModel();
		this.checkerboardView = new CheckerboardView();

		this.checkerboardView.addActionListeners(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
