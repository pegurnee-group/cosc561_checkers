package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class CheckersBoardTest extends TestCase {
	private CheckersBoard instanceOfBoard;
	private PlayableSpaceInterface[][] playableSpaces;

	@Override
	@Before
	public void setUp() throws Exception {
		this.instanceOfBoard = CheckersBoard.getInstance();

		this.playableSpaces = new MockPlayableSpace[8][4];

		int positionToBeAssigned = 1;
		for (int i = 0; i < this.playableSpaces.length; i++) {
			for (int j = 0; j < this.playableSpaces[i].length; j++) {
				this.playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
			}
		}
	}

	@Test
	public void testGettersAndSettersForTheBoardAndBoardSpaces() throws Exception {
		for (int i = 0; i < this.playableSpaces.length; i++) {
			for (int j = 0; j < this.playableSpaces[i].length; j++) {
				switch ((int) Math.floor(Math.random() * 8)) {
				case 0:
					this.playableSpaces[i][j].setState(SpaceState.RED);
					if (Math.floor(Math.random() * 2) < 1) {
						this.playableSpaces[i][j].setKing(true);
					}
					break;
				case 1:
					this.playableSpaces[i][j].setState(SpaceState.BLACK);
					if (Math.floor(Math.random() * 2) < 1) {
						this.playableSpaces[i][j].setKing(true);
					}
					break;
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				default:
					break;
				}
			}
		}
		this.instanceOfBoard.applyBoard(this.playableSpaces);

		for (int i = 0; i < this.playableSpaces.length; i++) {
			for (int j = 0; j < this.playableSpaces[i].length; j++) {
				assertSame(this.playableSpaces[i][j],
						this.instanceOfBoard.getPlayableSpaces()[i][j]);
				assertSame(this.playableSpaces[i][j],
						this.instanceOfBoard.getSpace(i, j));
			}
		}

	}

	@Test
	public void testResetPopulatesPlayableSpacesWithStartingLayout()
			throws Exception {
		this.instanceOfBoard.resetBoard();
		PlayableSpaceInterface[][] modelSpaces = this.instanceOfBoard
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
}
