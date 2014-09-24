package com.eddienicole.checkers;

import java.util.ArrayList;

public class MoveFigurerOuter {

	public static ArrayList<MoveInterface> figure(
			PlayableSpaceInterface[][] playableSpaces, boolean isRed) {
		ArrayList<MoveInterface> toReturn = new ArrayList<>();
		toReturn.add(new Move(playableSpaces[7][0], playableSpaces[6][0]));

		return toReturn;

	}

}
