package com.eddienicole.checkers;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

public class MoveFigurerOuterTest extends TestCase {
	@Test
	public void testFigureOutAdjacentMovesBottomCornerAsBlack()
			throws Exception {

		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		int positionToBeAssigned = 1;
		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
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

		int positionToBeAssigned = 1;
		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
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

		int positionToBeAssigned = 1;
		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
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
				MockMove expectedAnotherMove = new MockMove();
				expectedAnotherMove.setFrom(fromSpace);
				expectedAnotherMove.setTo(toSpace);
				expectedLegalMoves.add(expectedAnotherMove);
			}
		}

		assertEquals(expectedLegalMoves.size(), legalMoves.size());

		assertTrue(expectedLegalMoves.containsAll(legalMoves));
		assertTrue(legalMoves.containsAll(expectedLegalMoves));
	}

	@Test
	public void testFigureOutAdjacentMovesTopRowAsBlack() throws Exception {

		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		int positionToBeAssigned = 1;
		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
			}
		}

		for (int i = 0; i < playableSpaces[0].length; i++) {
			MockPlayableSpace fromSpace = playableSpaces[0][i];

			fromSpace.setState(SpaceState.BLACK);
		}

		boolean itIsRedsTurn = false;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				playableSpaces, itIsRedsTurn);

		assertEquals(7, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		for (int column = 0; column < playableSpaces[0].length; column++) {
			MockPlayableSpace fromSpace = playableSpaces[0][column];
			MockPlayableSpace toSpace = playableSpaces[1][column];

			MockMove expectedMockMove = new MockMove();
			expectedMockMove.setFrom(fromSpace);
			expectedMockMove.setTo(toSpace);

			expectedLegalMoves.add(expectedMockMove);

			if (column < (playableSpaces[0].length - 1)) {
				toSpace = playableSpaces[1][column + 1];
				MockMove expectedAnotherMove = new MockMove();
				expectedAnotherMove.setFrom(fromSpace);
				expectedAnotherMove.setTo(toSpace);
				expectedLegalMoves.add(expectedAnotherMove);
			}
		}

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));

	}

	@Test
	public void testFigureOutRedsGottaKingInTheMiddle() throws Exception {
		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		int positionToBeAssigned = 1;
		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
			}
		}

		MockPlayableSpace theRedKing = playableSpaces[3][3];
		theRedKing.setState(SpaceState.RED);
		theRedKing.setKing(true);

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				playableSpaces, itIsRedsTurn);

		assertEquals(4, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		MockMove expectedMockMove = new MockMove();
		expectedMockMove.setFrom(theRedKing);

		boolean isAJump = false;

		MockPlayableSpace toSpace1 = playableSpaces[2][3];
		expectedLegalMoves.add(new MockMove(theRedKing, toSpace1, isAJump));

		MockPlayableSpace toSpace2 = playableSpaces[4][3];
		expectedLegalMoves.add(new MockMove(theRedKing, toSpace2, isAJump));

		MockPlayableSpace toSpace3 = playableSpaces[2][2];
		expectedLegalMoves.add(new MockMove(theRedKing, toSpace3, isAJump));

		MockPlayableSpace toSpace4 = playableSpaces[4][2];
		expectedLegalMoves.add(new MockMove(theRedKing, toSpace4, isAJump));

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));

		itIsRedsTurn = false;
		legalMoves = MoveFigurerOuter.figure(playableSpaces, itIsRedsTurn);

		assertEquals(0, legalMoves.size());
	}

	@Test
	public void testJumpsForRedInTheMiddle() throws Exception {
		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];
		int positionToBeAssigned = 1;
		for (int row = 0; row < playableSpaces.length; row++) {
			for (int column = 0; column < playableSpaces[row].length; column++) {
				playableSpaces[row][column] = new MockPlayableSpace(
						positionToBeAssigned++);
			}
		}

		MockPlayableSpace firstPiece = playableSpaces[2][1];
		MockPlayableSpace secondPiece = playableSpaces[1][2];
		MockPlayableSpace destination = playableSpaces[0][2];

		firstPiece.setState(SpaceState.RED);
		secondPiece.setState(SpaceState.BLACK);
		destination.setState(SpaceState.UNOCCUPIED);

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				playableSpaces, itIsRedsTurn);

		assertEquals(1, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		MockMove expectedMockMove = new MockMove();
		expectedMockMove.setFrom(firstPiece);
		expectedMockMove.setTo(destination);
		expectedMockMove.setJump(true);
		expectedLegalMoves.add(expectedMockMove);

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));

	}

	@Test
	public void testRedsCannotMoveIntoItself() throws Exception {
		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		int positionToBeAssigned = 1;
		for (int i = 0; i < playableSpaces.length; i++) {
			for (int j = 0; j < playableSpaces[i].length; j++) {
				playableSpaces[i][j] = new MockPlayableSpace(
						positionToBeAssigned++);
			}
		}

		MockPlayableSpace firstPiece = playableSpaces[2][2];
		MockPlayableSpace secondPiece = playableSpaces[1][2];

		firstPiece.setState(SpaceState.RED);
		secondPiece.setState(SpaceState.RED);

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				playableSpaces, itIsRedsTurn);

		assertEquals(3, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		MockMove expectedMockMove = new MockMove();
		expectedMockMove.setFrom(firstPiece);

		boolean isAJump = false;

		MockPlayableSpace firstPieceOnlyTarget = playableSpaces[1][3];
		expectedLegalMoves.add(new MockMove(firstPiece, firstPieceOnlyTarget,
				isAJump));

		MockPlayableSpace secondPieceFirstTarget = playableSpaces[0][2];
		expectedLegalMoves.add(new MockMove(secondPiece,
				secondPieceFirstTarget, isAJump));

		MockPlayableSpace secondPieceSecondTarget = playableSpaces[0][1];
		expectedLegalMoves.add(new MockMove(secondPiece,
				secondPieceSecondTarget, isAJump));

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));
	}
}
