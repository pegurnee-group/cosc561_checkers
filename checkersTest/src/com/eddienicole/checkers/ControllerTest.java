package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest extends TestCase {
	private Controller controller;
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

		this.controller = new Controller(null, null);
	}

	@Override
	@After
	public void tearDown() {
		this.playableSpaces = null;
		this.controller = null;
	}

	@Test
	public void testConstructorAndInitalBoard() throws Exception {
		String expectedStartingBoard = "   1 2 3 4 5 6 7 8\n"
				+ "  =================\n" + "A | |b| |b| |b| |b|\n"
				+ "B |b| |b| |b| |b| |\n" + "C | |b| |b| |b| |b|\n"
				+ "D | | | | | | | | |\n" + "E | | | | | | | | |\n"
				+ "F |r| |r| |r| |r| |\n" + "G | |r| |r| |r| |r|\n"
				+ "H |r| |r| |r| |r| |\n" + "  =================\n";

		assertEquals(expectedStartingBoard, this.controller.drawCurrentBoard());
	}

	@Test
	public void testDoMove() throws Exception {
		MockPlayableSpace expectedFromSpace = new MockPlayableSpace(22);
		MockPlayableSpace expectedToSpace = new MockPlayableSpace(18);

		MockMove expectedMove = new MockMove();
		expectedMove.setFrom(expectedFromSpace);
		expectedMove.setTo(expectedToSpace);

		MockPlayer mockPlayer = new MockPlayer();
		mockPlayer.setRed(true);
		mockPlayer.setTheMoveThatThisGuyIsOftenProneToDoing(expectedMove);

		this.controller.doMove(mockPlayer);

		String expectedNewBoard = "   1 2 3 4 5 6 7 8\n"
				+ "  =================\n" + "A | |b| |b| |b| |b|\n"
				+ "B |b| |b| |b| |b| |\n" + "C | |b| |b| |b| |b|\n"
				+ "D | | | | | | | | |\n" + "E | | | |r| | | | |\n"
				+ "F |r| | | |r| |r| |\n" + "G | |r| |r| |r| |r|\n"
				+ "H |r| |r| |r| |r| |\n" + "  =================\n";
		assertEquals(expectedNewBoard, this.controller.drawCurrentBoard());

		expectedFromSpace = new MockPlayableSpace(9);
		expectedToSpace = new MockPlayableSpace(14);

		expectedMove.setFrom(expectedFromSpace);
		expectedMove.setTo(expectedToSpace);

		mockPlayer.setTheMoveThatThisGuyIsOftenProneToDoing(expectedMove);

		this.controller.doMove(mockPlayer);
		expectedNewBoard = "   1 2 3 4 5 6 7 8\n" + "  =================\n"
				+ "A | |b| |b| |b| |b|\n" + "B |b| |b| |b| |b| |\n"
				+ "C | | | |b| |b| |b|\n" + "D | | |b| | | | | |\n"
				+ "E | | | |r| | | | |\n" + "F |r| | | |r| |r| |\n"
				+ "G | |r| |r| |r| |r|\n" + "H |r| |r| |r| |r| |\n"
				+ "  =================\n";
		assertEquals(expectedNewBoard, this.controller.drawCurrentBoard());
	}
}
