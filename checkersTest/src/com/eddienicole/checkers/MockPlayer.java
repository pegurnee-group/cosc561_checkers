package com.eddienicole.checkers;

import java.util.ArrayList;

public class MockPlayer implements PlayerInterface {

	private boolean isRed;
	private MoveInterface theMoveThatThisGuyIsOftenProneToDoing;

	@Override
	public MoveInterface getMove(ArrayList<MoveInterface> legalMoves) {
		return this.theMoveThatThisGuyIsOftenProneToDoing;
	}

	@Override
	public boolean isRed() {
		return this.isRed;
	}

	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}

	public void setTheMoveThatThisGuyIsOftenProneToDoing(
			MoveInterface theMoveThatThisGuyIsOftenProneToDoing) {
		this.theMoveThatThisGuyIsOftenProneToDoing = theMoveThatThisGuyIsOftenProneToDoing;
	}

}
