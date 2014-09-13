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
}
