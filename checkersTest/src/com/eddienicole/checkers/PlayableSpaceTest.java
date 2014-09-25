package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class PlayableSpaceTest extends TestCase {

	@Test
	public void testGetters() throws Exception {
		boolean isOccupied = false;
		boolean isRed = false;
		boolean isKing = false;
		int position = 1;

		PlayableSpace playableSpace = new PlayableSpace(position);

		assertSame(isOccupied, playableSpace.isOccupied());
		assertSame(isRed, playableSpace.isRed());
		assertSame(isKing, playableSpace.isKing());
		assertSame(position, playableSpace.getPosition());

	}

	@Test
	public void testEqualsMethodRecognizesMockPlayableSpace() throws Exception {
		int position = 1;

		PlayableSpace realPlayableSpace = new PlayableSpace(position);
		MockPlayableSpace mockPlayableSpace = new MockPlayableSpace(position);

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
