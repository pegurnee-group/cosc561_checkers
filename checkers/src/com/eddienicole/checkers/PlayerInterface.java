package com.eddienicole.checkers;

import java.util.ArrayList;

public interface PlayerInterface {

	MoveInterface getMove(ArrayList<MoveInterface> legalMoves);

	boolean isRed();

}
