package com.eddienicole.checkers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ControllerTest {
	@Test
	public void testConstructorAndInitalBoard() throws Exception {
		Controller controller = new Controller();

		String expectedStartingBoard = "   a b c d e f g h\n"
				+ "  =================\n" + "1 | |b| |b| |b| |b|\n"
				+ "2 |b| |b| |b| |b| |\n" + "3 | |b| |b| |b| |b|\n"
				+ "4 | | | | | | | | |\n" + "5 | | | | | | | | |\n"
				+ "6 |r| |r| |r| |r| |\n" + "7 | |r| |r| |r| |r|\n"
				+ "8 |r| |r| |r| |r| |\n" + "  =================\n";

		assertEquals(expectedStartingBoard, controller.drawCurrentBoard());
	}

}
