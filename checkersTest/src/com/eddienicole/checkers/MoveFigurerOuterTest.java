package com.eddienicole.checkers;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoveFigurerOuterTest extends TestCase {
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
	}

	@Override
	@After
	public void tearDown() {
		this.playableSpaces = null;
	}

	@Test
	public void testFigureOutAdjacentMovesBottomCornerAsBlack()
			throws Exception {
		MockPlayableSpace fromSpace = this.playableSpaces[7][0];

		fromSpace.setState(SpaceState.RED);

		boolean itIsRedsTurn = false;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.playableSpaces, itIsRedsTurn);

		assertEquals(0, legalMoves.size());
	}

	@Test
	public void testFigureOutAdjacentMovesBottomCornerAsRed() throws Exception {
		MockPlayableSpace fromSpace = this.playableSpaces[7][0];

		fromSpace.setState(SpaceState.RED);

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.playableSpaces, itIsRedsTurn);

		assertEquals(1, legalMoves.size());

		MockMove expectedLegalMove = new MockMove();

		MockPlayableSpace expectedToSpace = this.playableSpaces[6][0];

		expectedLegalMove.setFrom(fromSpace);
		expectedLegalMove.setTo(expectedToSpace);

		assertEquals(expectedLegalMove, legalMoves.get(0));
	}

	@Test
	public void testFigureOutAdjacentMovesBottomRowAsRed() throws Exception {
		for (int i = 0; i < this.playableSpaces[7].length; i++) {
			MockPlayableSpace fromSpace = this.playableSpaces[7][i];

			fromSpace.setState(SpaceState.RED);
		}

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.playableSpaces, itIsRedsTurn);

		assertEquals(7, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		for (int i = 0; i < this.playableSpaces[7].length; i++) {
			MockPlayableSpace fromSpace = this.playableSpaces[7][i];
			MockPlayableSpace toSpace = this.playableSpaces[6][i];

			MockMove expectedMockMove = new MockMove();
			expectedMockMove.setFrom(fromSpace);
			expectedMockMove.setTo(toSpace);

			expectedLegalMoves.add(expectedMockMove);

			if (i > 0) {
				toSpace = this.playableSpaces[6][i - 1];
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
		for (int i = 0; i < this.playableSpaces[0].length; i++) {
			MockPlayableSpace fromSpace = this.playableSpaces[0][i];

			fromSpace.setState(SpaceState.BLACK);
		}

		boolean itIsRedsTurn = false;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.playableSpaces, itIsRedsTurn);

		assertEquals(7, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		for (int column = 0; column < this.playableSpaces[0].length; column++) {
			MockPlayableSpace fromSpace = this.playableSpaces[0][column];
			MockPlayableSpace toSpace = this.playableSpaces[1][column];

			MockMove expectedMockMove = new MockMove();
			expectedMockMove.setFrom(fromSpace);
			expectedMockMove.setTo(toSpace);

			expectedLegalMoves.add(expectedMockMove);

			if (column < (this.playableSpaces[0].length - 1)) {
				toSpace = this.playableSpaces[1][column + 1];
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
		MockPlayableSpace theRedKing = this.playableSpaces[3][3];
		theRedKing.setState(SpaceState.RED);
		theRedKing.setKing(true);

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.playableSpaces, itIsRedsTurn);

		assertEquals(4, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		MockMove expectedMockMove = new MockMove();
		expectedMockMove.setFrom(theRedKing);

		boolean isAJump = false;

		MockPlayableSpace toSpace1 = this.playableSpaces[2][3];
		expectedLegalMoves.add(new MockMove(theRedKing, toSpace1, isAJump));

		MockPlayableSpace toSpace2 = this.playableSpaces[4][3];
		expectedLegalMoves.add(new MockMove(theRedKing, toSpace2, isAJump));

		MockPlayableSpace toSpace3 = this.playableSpaces[2][2];
		expectedLegalMoves.add(new MockMove(theRedKing, toSpace3, isAJump));

		MockPlayableSpace toSpace4 = this.playableSpaces[4][2];
		expectedLegalMoves.add(new MockMove(theRedKing, toSpace4, isAJump));

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));

		itIsRedsTurn = false;
		legalMoves = MoveFigurerOuter.figure(this.playableSpaces, itIsRedsTurn);

		assertEquals(0, legalMoves.size());
	}

	@Test
	public void testJumpsForRedInTheMiddle() throws Exception {
		MockPlayableSpace firstPiece = this.playableSpaces[2][1];
		MockPlayableSpace secondPiece = this.playableSpaces[1][2];
		MockPlayableSpace destination = this.playableSpaces[0][2];

		firstPiece.setState(SpaceState.RED);
		secondPiece.setState(SpaceState.BLACK);
		destination.setState(SpaceState.UNOCCUPIED);

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.playableSpaces, itIsRedsTurn);

		assertEquals(1, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		MockMove expectedMockMove = new MockMove();
		expectedMockMove.setFrom(firstPiece);
		expectedMockMove.setTo(destination);
		expectedMockMove.setJump(true);
		expectedMockMove.jumped(secondPiece);
		expectedLegalMoves.add(expectedMockMove);

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));

		MockPlayableSpace thirdPiece = this.playableSpaces[1][1];
		MockPlayableSpace secondDestination = this.playableSpaces[0][0];

		thirdPiece.setState(SpaceState.BLACK);
		secondDestination.setState(SpaceState.UNOCCUPIED);

		legalMoves = MoveFigurerOuter.figure(this.playableSpaces, itIsRedsTurn);

		assertEquals(2, legalMoves.size());

		expectedLegalMoves = new ArrayList<>();

		MockMove expectedSecondMockMove = new MockMove();
		expectedSecondMockMove.setFrom(firstPiece);
		expectedSecondMockMove.setTo(secondDestination);
		expectedSecondMockMove.setJump(true);
		expectedSecondMockMove.jumped(thirdPiece);

		expectedLegalMoves.add(expectedMockMove);
		expectedLegalMoves.add(expectedSecondMockMove);

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));
	}

	@Test
	public void testRedsCannotMoveIntoItself() throws Exception {
		MockPlayableSpace firstPiece = this.playableSpaces[2][2];
		MockPlayableSpace secondPiece = this.playableSpaces[1][2];

		firstPiece.setState(SpaceState.RED);
		secondPiece.setState(SpaceState.RED);

		boolean itIsRedsTurn = true;

		ArrayList<MoveInterface> legalMoves = MoveFigurerOuter.figure(
				this.playableSpaces, itIsRedsTurn);

		assertEquals(3, legalMoves.size());

		ArrayList<MoveInterface> expectedLegalMoves = new ArrayList<>();

		MockMove expectedMockMove = new MockMove();
		expectedMockMove.setFrom(firstPiece);

		boolean isAJump = false;

		MockPlayableSpace firstPieceOnlyTarget = this.playableSpaces[1][3];
		expectedLegalMoves.add(new MockMove(firstPiece, firstPieceOnlyTarget,
				isAJump));

		MockPlayableSpace secondPieceFirstTarget = this.playableSpaces[0][2];
		expectedLegalMoves.add(new MockMove(secondPiece,
				secondPieceFirstTarget, isAJump));

		MockPlayableSpace secondPieceSecondTarget = this.playableSpaces[0][1];
		expectedLegalMoves.add(new MockMove(secondPiece,
				secondPieceSecondTarget, isAJump));

		assertTrue(legalMoves.containsAll(expectedLegalMoves));
		assertTrue(expectedLegalMoves.containsAll(legalMoves));
	}
}
