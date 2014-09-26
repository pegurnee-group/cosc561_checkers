package com.eddienicole.checkers;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

public class MoveFigurerOuterTest extends TestCase {
	@Test
	public void testFigureOutAdjacentMovesBottomCornerAsBlack()
			throws Exception {

		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace();
			}
		}

		MockPlayableSpace fromSpace = playableSpaces[7][0];

		fromSpace.setState(SpaceState.RED);

		boolean itIsRedsTurn = false;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				playableSpaces, itIsRedsTurn);

		assertEquals(0, legalMoves.size());
	}

	@Test
	public void testFigureOutAdjacentMovesBottomCornerAsRed() throws Exception {

		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace();
			}
		}

		MockPlayableSpace fromSpace = playableSpaces[7][0];

		fromSpace.setState(SpaceState.RED);

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				playableSpaces, itIsRedsTurn);

		assertEquals(1, legalMoves.size());

		MockMove expectedLegalMove = new MockMove();

		MockPlayableSpace expectedToSpace = playableSpaces[6][0];

		expectedLegalMove.setFrom(fromSpace);
		expectedLegalMove.setTo(expectedToSpace);

		assertEquals(expectedLegalMove, legalMoves.get(0));
	}

	@Test
	public void testFigureOutAdjacentMovesBottomRowAsRed() throws Exception {

		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace();
			}
		}

		for (int i = 0; i < playableSpaces[7].length; i++) {
			MockPlayableSpace fromSpace = playableSpaces[7][i];

			fromSpace.setState(SpaceState.RED);
		}

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				playableSpaces, itIsRedsTurn);

		assertEquals(7, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		for (int i = 0; i < playableSpaces[7].length; i++) {
			MockPlayableSpace fromSpace = playableSpaces[7][i];
			MockPlayableSpace toSpace = playableSpaces[6][i];

			MockMove expectedMockMove = new MockMove();
			expectedMockMove.setFrom(fromSpace);
			expectedMockMove.setTo(toSpace);

			expectedLegalMoves.add(expectedMockMove);

			if (i > 0) {
				toSpace = playableSpaces[6][i - 1];
				expectedMockMove.setTo(toSpace);
				expectedLegalMoves.add(expectedMockMove);
			}
		}

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));

	}
}
