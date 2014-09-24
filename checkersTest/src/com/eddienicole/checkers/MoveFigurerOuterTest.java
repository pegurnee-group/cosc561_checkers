package com.eddienicole.checkers;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

public class MoveFigurerOuterTest extends TestCase {
	@Test
	public void testFigureOutAdjacentMoves() throws Exception {

		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace();
			}
		}

		MockPlayableSpace fromSpace = playableSpaces[7][0];

		fromSpace.setOccupied(true);
		fromSpace.setRed(true);

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
}
