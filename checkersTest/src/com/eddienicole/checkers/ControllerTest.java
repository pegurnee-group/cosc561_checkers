package com.eddienicole.checkers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ControllerTest {
	@Test
	public void testConstructorAndInitalBoard() throws Exception {
		Controller controller = new Controller(null, null);

		String expectedStartingBoard = "   a b c d e f g h\n"
				+ "  =================\n" + "1 | |b| |b| |b| |b|\n"
				+ "2 |b| |b| |b| |b| |\n" + "3 | |b| |b| |b| |b|\n"
				+ "4 | | | | | | | | |\n" + "5 | | | | | | | | |\n"
				+ "6 |r| |r| |r| |r| |\n" + "7 | |r| |r| |r| |r|\n"
				+ "8 |r| |r| |r| |r| |\n" + "  =================\n";

		assertEquals(expectedStartingBoard, controller.drawCurrentBoard());
	}

	@Test
	public void testDoMoveAndRedrawBoard() throws Exception {

		MockPlayableSpace expectedFromSpace = new MockPlayableSpace(22);
		MockPlayableSpace expectedToSpace = new MockPlayableSpace(18);

		MockMove expectedMove = new MockMove();
		expectedMove.setFrom(expectedFromSpace);
		expectedMove.setTo(expectedToSpace);

		MockPlayer mockPlayer = new MockPlayer();
		mockPlayer.setRed(true);
		mockPlayer.setTheMoveThatThisGuyIsOftenProneToDoing(expectedMove);

		Controller controller = new Controller(null, null);

		controller.doMoveAndRedrawBoard(mockPlayer);

		String expectedNewBoard = "   a b c d e f g h\n"
				+ "  =================\n" + "1 | |b| |b| |b| |b|\n"
				+ "2 |b| |b| |b| |b| |\n" + "3 | |b| |b| |b| |b|\n"
				+ "4 | | | | | | | | |\n" + "5 | | | |r| | | | |\n"
				+ "6 |r| | | |r| |r| |\n" + "7 | |r| |r| |r| |r|\n"
				+ "8 |r| |r| |r| |r| |\n" + "  =================\n";
		assertEquals(expectedNewBoard, controller.drawCurrentBoard());

		expectedFromSpace = new MockPlayableSpace(9);
		expectedToSpace = new MockPlayableSpace(14);

		expectedMove.setFrom(expectedFromSpace);
		expectedMove.setTo(expectedToSpace);

		mockPlayer.setTheMoveThatThisGuyIsOftenProneToDoing(expectedMove);

		controller.doMoveAndRedrawBoard(mockPlayer);
		expectedNewBoard = "   a b c d e f g h\n" + "  =================\n"
				+ "1 | |b| |b| |b| |b|\n" + "2 |b| |b| |b| |b| |\n"
				+ "3 | | | |b| |b| |b|\n" + "4 | | |b| | | | | |\n"
				+ "5 | | | |r| | | | |\n" + "6 |r| | | |r| |r| |\n"
				+ "7 | |r| |r| |r| |r|\n" + "8 |r| |r| |r| |r| |\n"
				+ "  =================\n";
		assertEquals(expectedNewBoard, controller.drawCurrentBoard());
	}
}
