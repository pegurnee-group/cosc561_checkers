package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckerboardViewTest extends TestCase {
	private CheckerboardView checkerboardView;
	private MockPlayableSpace[][] playableSpaces;

	@Override
	@Before
	public void setUp() throws Exception {
		this.playableSpaces = new MockPlayableSpace[8][4];

		int positionToBeAssigned = 1;
		for (int i = 0; i < this.playableSpaces.length; i++) {
			for (int j = 0; j < this.playableSpaces[i].length; j++) {
				this.playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
			}
		}

		this.checkerboardView = new CheckerboardView();
	}

	@Override
	@After
	public void tearDown() {
		this.playableSpaces = null;
		this.checkerboardView = null;
	}

	@Test
	public void testDeclareConqueringHero() throws Exception {
		String expectedLossScreen = "Red player has emerged victorious!";
		boolean victoryForTheRedPlayer = true;

		assertEquals(expectedLossScreen,
				this.checkerboardView
						.declareConqueringHero(victoryForTheRedPlayer));

		victoryForTheRedPlayer = false;
		expectedLossScreen = "Black player has emerged victorious!";

		assertEquals(expectedLossScreen,
				this.checkerboardView
						.declareConqueringHero(victoryForTheRedPlayer));
	}

	@Test
	public void testDrawBoard() throws Exception {
		this.playableSpaces[0][1].setState(SpaceState.RED);

		this.playableSpaces[1][0].setState(SpaceState.BLACK);
		this.playableSpaces[1][0].setKing(true);

		this.playableSpaces[4][1].setState(SpaceState.RED);
		this.playableSpaces[4][1].setKing(true);

		this.playableSpaces[6][3].setState(SpaceState.BLACK);

		this.playableSpaces[7][0].setState(SpaceState.BLACK);

		this.playableSpaces[7][2].setState(SpaceState.BLACK);

		String expectedString = "   1 2 3 4 5 6 7 8\n"
				+ "  =================\n" + "A | | | |r| | | | |\n"
				+ "B |B| | | | | | | |\n" + "C | | | | | | | | |\n"
				+ "D | | | | | | | | |\n" + "E | | | |R| | | | |\n"
				+ "F | | | | | | | | |\n" + "G | | | | | | | |b|\n"
				+ "H |b| | | |b| | | |\n" + "  =================\n";

		String actualString = this.checkerboardView
				.drawBoard(this.playableSpaces);

		assertEquals(expectedString, actualString);
	}
}
