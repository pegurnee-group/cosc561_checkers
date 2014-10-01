package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckersModelTest extends TestCase {
	private CheckersModel checkersModel;
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

		this.checkersModel = new CheckersModel();
	}

	@Override
	@After
	public void tearDown() {
		this.playableSpaces = null;
		this.checkersModel = null;
	}

	@Test
	public void testConstructorPopulatesPlayableSpacesWithStartingLayout()
			throws Exception {
		PlayableSpaceInterface[][] modelSpaces = this.checkersModel
				.getPlayableSpaces();

		for (int i = 0; i < modelSpaces.length; i++) {
			for (int j = 0; j < modelSpaces[i].length; j++) {
				assertTrue(modelSpaces[i][j] instanceof PlayableSpaceInterface);
				if ((i >= 0) && (i < 3)) {
					assertTrue(modelSpaces[i][j].getState() == SpaceState.BLACK);
				} else if (i < 5) {
					assertTrue(modelSpaces[i][j].getState() == SpaceState.UNOCCUPIED);
				} else {
					assertTrue(modelSpaces[i][j].getState() == SpaceState.RED);
				}
				assertFalse(modelSpaces[i][j].isKing());
			}
		}
	}

	@Test
	public void testEmptyConstructorInitializesPositionsCorrectly()
			throws Exception {
		int expectedPosition = 1;

		for (int i = 0; i < this.playableSpaces.length; i++) {
			for (int j = 0; j < this.playableSpaces[i].length; j++) {
				assertEquals(expectedPosition++,
						this.playableSpaces[i][j].getPosition());
			}
		}
	}

	@Test
	public void testGetters() throws Exception {
		CheckersModel checkersModel = new CheckersModel(this.playableSpaces);

		for (int j = 0; j < this.playableSpaces.length; j++) {
			for (int k = 0; k < this.playableSpaces[j].length; k++) {
				assertSame(this.playableSpaces[j][k],
						checkersModel.getPlayableSpaces()[j][k]);
			}
		}
	}
}
