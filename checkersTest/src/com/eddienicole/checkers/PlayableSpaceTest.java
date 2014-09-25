package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class PlayableSpaceTest extends TestCase {

	@Test
	public void testGetters() throws Exception {
		boolean isOccupied = false;
		boolean isRed = false;
		boolean isKing = false;

		PlayableSpace playableSpace = new PlayableSpace();

		assertSame(isOccupied, playableSpace.isOccupied());
		assertSame(isRed, playableSpace.isRed());
		assertSame(isKing, playableSpace.isKing());

	}

	@Test
	public void testEqualsMethodRecognizesMockPlayableSpace() throws Exception {
		PlayableSpace realPlayableSpace = new PlayableSpace();
		MockPlayableSpace mockPlayableSpace = new MockPlayableSpace();

		assertEquals(realPlayableSpace, mockPlayableSpace);

		realPlayableSpace.setRed(true);
		mockPlayableSpace.setRed(false);

		assertFalse(realPlayableSpace.equals(mockPlayableSpace));

		mockPlayableSpace.setRed(true);

		realPlayableSpace.setKing(true);
		realPlayableSpace.setOccupied(true);

		mockPlayableSpace.setKing(true);
		mockPlayableSpace.setOccupied(true);

		assertEquals(realPlayableSpace, mockPlayableSpace);
		assertTrue(mockPlayableSpace.equals(realPlayableSpace));

	}
}
