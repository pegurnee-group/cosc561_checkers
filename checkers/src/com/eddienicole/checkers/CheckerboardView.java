package com.eddienicole.checkers;

import java.util.ArrayList;

public class CheckerboardView {
	ArrayList<PlayableSpace> spaces;

	public CheckerboardView() {
		spaces = new ArrayList<>();
	}

	public void addActionListeners(Controller controller) {
		for (PlayableSpace space : spaces) {
			// space.addActionListener(controller);
		}

	}

}