package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class CheckerboardViewTest extends TestCase {

	@Test
	public void testDeclareConqueringHero() throws Exception {
		CheckerboardView checkerboardView = new CheckerboardView();

		String expectedLossScreen = "Red player has emerged victorious!";
		boolean victoryForTheRedPlayer = true;

		assertEquals(expectedLossScreen,
				checkerboardView.declareConqueringHero(victoryForTheRedPlayer));

		victoryForTheRedPlayer = false;
		expectedLossScreen = "Black player has emerged victorious!";

		assertEquals(expectedLossScreen,
				checkerboardView.declareConqueringHero(victoryForTheRedPlayer));
	}

	@Test
	public void testDrawBoard() throws Exception {
		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace();
			}
		}

		playableSpaces[0][1].setState(SpaceState.RED);

		playableSpaces[1][0].setState(SpaceState.BLACK);
		playableSpaces[1][0].setKing(true);

		playableSpaces[4][1].setState(SpaceState.RED);
		playableSpaces[4][1].setKing(true);

		playableSpaces[6][3].setState(SpaceState.BLACK);

		playableSpaces[7][0].setState(SpaceState.BLACK);

		playableSpaces[7][2].setState(SpaceState.BLACK);

		CheckerboardView checkerboardView = new CheckerboardView();

		String expectedString = "   0 0 1 1 2 2 3 3\n"
				+ "  =================\n" + "0 | | | |r| | | | |\n"
				+ "1 |B| | | | | | | |\n" + "2 | | | | | | | | |\n"
				+ "3 | | | | | | | | |\n" + "4 | | | |R| | | | |\n"
				+ "5 | | | | | | | | |\n" + "6 | | | | | | | |b|\n"
				+ "7 |b| | | |b| | | |\n" + "  =================\n";

		String actualString = checkerboardView.drawBoard(playableSpaces);

		assertEquals(expectedString, actualString);
	}
}
