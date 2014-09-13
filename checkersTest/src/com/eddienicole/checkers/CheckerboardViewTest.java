package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class CheckerboardViewTest extends TestCase {

	@Test
	public void testDrawBoard() throws Exception {
		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace();
			}
		}

		playableSpaces[0][1].setOccupied(true);
		playableSpaces[0][1].setRed(true);

		playableSpaces[1][0].setOccupied(true);
		playableSpaces[1][0].setKing(true);

		playableSpaces[4][1].setOccupied(true);
		playableSpaces[4][1].setRed(true);
		playableSpaces[4][1].setKing(true);

		playableSpaces[6][3].setOccupied(true);

		playableSpaces[7][0].setOccupied(true);

		playableSpaces[7][2].setOccupied(true);

		CheckerboardView checkerboardView = new CheckerboardView();

		String expectedString = "   a b c d e f g h\n"
				+ "  =================\n" + "1 | | | |r| | | | |\n"
				+ "2 |B| | | | | | | |\n" + "3 | | | | | | | | |\n"
				+ "4 | | | | | | | | |\n" + "5 | | | |R| | | | |\n"
				+ "6 | | | | | | | | |\n" + "7 | | | | | | | |b|\n"
				+ "8 |b| | | |b| | | |\n" + "  =================\n";

		String actualString = checkerboardView.drawBoard(playableSpaces);

		assertEquals(expectedString, actualString);
	}
}
