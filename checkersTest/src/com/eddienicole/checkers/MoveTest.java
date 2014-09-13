package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class MoveTest extends TestCase {

	@Test
	public void testGetters() throws Exception {
		MockPlayableSpace from = new MockPlayableSpace();
		MockPlayableSpace to = new MockPlayableSpace();
		Move move = new Move(from, to);

		assertSame(from, move.getFrom());
		assertSame(to, move.getTo());
	}

}
