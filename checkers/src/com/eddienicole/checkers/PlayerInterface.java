package com.eddienicole.checkers;

import java.util.ArrayList;

public interface PlayerInterface {

	public MoveInterface getMove(ArrayList<MoveInterface> legalMoves);

}
