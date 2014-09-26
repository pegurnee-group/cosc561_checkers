package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class PlayableSpaceTest extends TestCase {

	@Test
	public void testGetters() throws Exception {
		SpaceState spaceState = SpaceState.UNOCCUPIED;
		boolean isKing = false;
		int position = 1;

		PlayableSpace playableSpace = new PlayableSpace(position);

		assertSame(spaceState, playableSpace.getState());
		assertSame(isKing, playableSpace.isKing());
		assertSame(position, playableSpace.getPosition());

	}

	@Test
	public void testEqualsMethodRecognizesMockPlayableSpace() throws Exception {
		int position = 1;

		PlayableSpace realPlayableSpace = new PlayableSpace(position);
		MockPlayableSpace mockPlayableSpace = new MockPlayableSpace(position);

		assertEquals(realPlayableSpace, mockPlayableSpace);

		realPlayableSpace.setState(SpaceState.RED);
		mockPlayableSpace.setState(SpaceState.BLACK);

		assertFalse(realPlayableSpace.equals(mockPlayableSpace));

		mockPlayableSpace.setState(SpaceState.RED);

		realPlayableSpace.setKing(true);

		mockPlayableSpace.setKing(true);

		assertEquals(realPlayableSpace, mockPlayableSpace);
		assertTrue(mockPlayableSpace.equals(realPlayableSpace));

	}
}
