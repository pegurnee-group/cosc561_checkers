package com.eddienicole.checkers;

import java.util.ArrayList;

public class MoveFigurerOuter {

	public static ArrayList<MoveInterface> figure(
			PlayableSpaceInterface[][] playableSpaces, boolean isRed) {
		ArrayList<MoveInterface> toReturn = new ArrayList<>();
		if (isRed) {
			for (int i = 0; i < playableSpaces.length; i++) {
				for (int j = 0; j < playableSpaces[i].length; j++) {
					if (playableSpaces[i][j].isRed()) {
						if ((i % 2) == 0) {
							try {
								if (!playableSpaces[i - 1][j].isOccupied()) {
									toReturn.add(new Move(playableSpaces[i][j],
											playableSpaces[i - 1][j]));
								}
							} catch (ArrayIndexOutOfBoundsException e) {

							}

							try {
								if (!playableSpaces[i - 1][j + 1].isOccupied()) {
									toReturn.add(new Move(playableSpaces[i][j],
											playableSpaces[i - 1][j + 1]));
								}
							} catch (ArrayIndexOutOfBoundsException e) {

							}
						} else {
							try {
								if (!playableSpaces[i - 1][j - 1].isOccupied()) {
									toReturn.add(new Move(playableSpaces[i][j],
											playableSpaces[i - 1][j - 1]));
								}
							} catch (ArrayIndexOutOfBoundsException e) {

							}
							try {
								if (!playableSpaces[i - 1][j].isOccupied()) {
									toReturn.add(new Move(playableSpaces[i][j],
											playableSpaces[i - 1][j]));
								}
							} catch (ArrayIndexOutOfBoundsException e) {

							}
						}
					}
				}
			}

			// toReturn.add(new Move(playableSpaces[7][0],
			// playableSpaces[6][0]));
		}

		return toReturn;

	}

}
