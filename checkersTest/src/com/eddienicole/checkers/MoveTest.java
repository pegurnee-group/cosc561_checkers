package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class MoveTest extends TestCase {

	@Test
	public void testEquals() throws Exception {
		MockPlayableSpace from = new MockPlayableSpace();
		MockPlayableSpace to = new MockPlayableSpace();
		Move move1 = new Move(from, to);
		Move move2 = new Move(from, to);

		assertTrue(move1.equals(move2));

		MockMove mockMove = new MockMove();
		mockMove.setFrom(from);
		mockMove.setTo(to);

		assertTrue(move1.equals(mockMove));
		assertTrue(move2.equals(mockMove));
		assertTrue(mockMove.equals(move1));

	}

	@Test
	public void testGetters() throws Exception {
		MockPlayableSpace from = new MockPlayableSpace();
		MockPlayableSpace to = new MockPlayableSpace();
		Move move = new Move(from, to);

		assertSame(from, move.getFrom());
		assertSame(to, move.getTo());
	}

}
