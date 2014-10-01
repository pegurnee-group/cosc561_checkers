package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayableSpaceTest extends TestCase {
	private PlayableSpace playableSpace;
	private final int positionToBeAssigned = 1;

	@Override
	@Before
	public void setUp() throws Exception {
		this.playableSpace = new PlayableSpace(this.positionToBeAssigned);
	}

	@Override
	@After
	public void tearDown() {
		this.playableSpace = null;
	}

	@Test
	public void testConstrutorAndGetters() throws Exception {
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
		MockPlayableSpace mockPlayableSpace = new MockPlayableSpace(position);

		assertEquals(this.playableSpace, mockPlayableSpace);

		this.playableSpace.setState(SpaceState.RED);
		mockPlayableSpace.setState(SpaceState.BLACK);

		assertFalse(this.playableSpace.equals(mockPlayableSpace));

		mockPlayableSpace.setState(SpaceState.RED);

		this.playableSpace.setKing(true);

		mockPlayableSpace.setKing(true);

		assertEquals(this.playableSpace, mockPlayableSpace);
		assertTrue(this.playableSpace.equals(mockPlayableSpace));
	}
}
