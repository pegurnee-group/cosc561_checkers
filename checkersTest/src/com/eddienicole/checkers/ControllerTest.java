package com.eddienicole.checkers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ControllerTest {
	@Test
	public void testConstructorAndInitalBoard() throws Exception {
		Controller controller = new Controller(null, null);

		String expectedStartingBoard = "   1 2 3 4 5 6 7 8\n"
				+ "  =================\n" + "A | |b| |b| |b| |b|\n"
				+ "B |b| |b| |b| |b| |\n" + "C | |b| |b| |b| |b|\n"
				+ "D | | | | | | | | |\n" + "E | | | | | | | | |\n"
				+ "F |r| |r| |r| |r| |\n" + "G | |r| |r| |r| |r|\n"
				+ "H |r| |r| |r| |r| |\n" + "  =================\n";

		assertEquals(expectedStartingBoard, controller.drawCurrentBoard());
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

		Controller controller = new Controller(null, null);

		controller.doMove(mockPlayer);

		String expectedNewBoard = "   1 2 3 4 5 6 7 8\n"
				+ "  =================\n" + "A | |b| |b| |b| |b|\n"
				+ "B |b| |b| |b| |b| |\n" + "C | |b| |b| |b| |b|\n"
				+ "D | | | | | | | | |\n" + "E | | | |r| | | | |\n"
				+ "F |r| | | |r| |r| |\n" + "G | |r| |r| |r| |r|\n"
				+ "H |r| |r| |r| |r| |\n" + "  =================\n";
		assertEquals(expectedNewBoard, controller.drawCurrentBoard());

		expectedFromSpace = new MockPlayableSpace(9);
		expectedToSpace = new MockPlayableSpace(14);

		expectedMove.setFrom(expectedFromSpace);
		expectedMove.setTo(expectedToSpace);

		mockPlayer.setTheMoveThatThisGuyIsOftenProneToDoing(expectedMove);

		controller.doMove(mockPlayer);
		expectedNewBoard = "   1 2 3 4 5 6 7 8\n" + "  =================\n"
				+ "A | |b| |b| |b| |b|\n" + "B |b| |b| |b| |b| |\n"
				+ "C | | | |b| |b| |b|\n" + "D | | |b| | | | | |\n"
				+ "E | | | |r| | | | |\n" + "F |r| | | |r| |r| |\n"
				+ "G | |r| |r| |r| |r|\n" + "H |r| |r| |r| |r| |\n"
				+ "  =================\n";
		assertEquals(expectedNewBoard, controller.drawCurrentBoard());
	}
}
