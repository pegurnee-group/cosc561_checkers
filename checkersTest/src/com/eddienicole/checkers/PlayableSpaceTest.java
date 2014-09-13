package com.eddienicole.checkers;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class PlayableSpaceTest extends TestCase {

	@Test
	public void testGetters() throws Exception {
		char expectedColumn = 'a';
		int expectedRow = 1;
		PlayableSpace playableSpace = new PlayableSpace(expectedColumn, expectedRow);
		
		assertSame(expectedColumn, playableSpace.getColumn());
		assertSame(expectedRow, playableSpace.getRow());
	}

}
