package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class CheckersModelTest extends TestCase {

	@Test
	public void testGetters() throws Exception {
		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];
		MockPlayableSpace[] expectedSpaces = new MockPlayableSpace[32];

		for (int i = 0; i < expectedSpaces.length; i++) {
			expectedSpaces[i] = new MockPlayableSpace();
		}
		int i = 0;
		for (int j = 0; j < playableSpaces.length; j++) {
			for (int k = 0; k < playableSpaces[j].length; k++) {
				playableSpaces[j][k] = expectedSpaces[i++];
			}
		}
		CheckersModel checkersModel = new CheckersModel(playableSpaces);
		assertSame(expectedSpaces[0], checkersModel.getPlayableSpaces()[0][0]);
	}

	@Test
	public void testEmptyConstructorInitializesPositionsCorrectly()
			throws Exception {
		CheckersModel checkersModel = new CheckersModel();

		PlayableSpaceInterface[][] playableSpaces = checkersModel
				.getPlayableSpaces();

		int expectedPosition = 1;

		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				assertEquals(expectedPosition++,
						playableSpaces[i][j].getPosition());
			}
		}
	}

	public void testConstructorPopulatesPlayableSpacesWithStartingLayout()
			throws Exception {
		CheckersModel checkersModel = new CheckersModel();

		PlayableSpace[][] modelSpaces = (PlayableSpace[][]) checkersModel
				.getPlayableSpaces();

		for (int i = 0; i < modelSpaces.length; i++) {
			for (int j = 0; j < modelSpaces[i].length; j++) {
				assertTrue(modelSpaces[i][j] instanceof PlayableSpaceInterface);
				if (i >= 0 && i < 3) {
					assertTrue(modelSpaces[i][j].getState() == SpaceState.RED);
					assertFalse(modelSpaces[i][j].isKing());
				} else if (i < 5) {
					assertTrue(modelSpaces[i][j].getState() == SpaceState.UNOCCUPIED);
				} else {
					assertTrue(modelSpaces[i][j].getState() == SpaceState.BLACK);
					assertFalse(modelSpaces[i][j].isKing());
				}
			}
		}

		MockPlayableSpace[][] mockSpaces = new MockPlayableSpace[8][4];
		for (int i = 0; i < mockSpaces.length; i++) {
			for (int j = 0; j < mockSpaces[i].length; j++) {
				mockSpaces[i][j] = new MockPlayableSpace();
			}
		}
	}
}
