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

		int positionToBeAssigned = 1;
		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
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

		String expectedString = "   A B C D E F G H\n"
				+ "  =================\n" + "1 | | | |r| | | | |\n"
				+ "2 |B| | | | | | | |\n" + "3 | | | | | | | | |\n"
				+ "4 | | | | | | | | |\n" + "5 | | | |R| | | | |\n"
				+ "6 | | | | | | | | |\n" + "7 | | | | | | | |b|\n"
				+ "8 |b| | | |b| | | |\n" + "  =================\n";

		String actualString = checkerboardView.drawBoard(playableSpaces);

		assertEquals(expectedString, actualString);
	}
}
