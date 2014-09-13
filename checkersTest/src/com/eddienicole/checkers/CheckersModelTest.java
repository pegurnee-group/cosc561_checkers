package com.eddienicole.checkers;

import junit.framework.TestCase;

import org.junit.Test;

public class CheckersModelTest extends TestCase {

	@Test
	public void testGetters() throws Exception {
		MockPlayableSpace[][] playableSpaces = new MockPlayableSpace[8][4];

		MockPlayableSpace[] expectedSpaces = new MockPlayableSpace[32];

		for (int i = 0; i < expectedSpaces.length; i++) {
			expectedSpaces[i] = new MockPlayableSpace();
		}

		int i = 0;

		for (int j = 0; j < playableSpaces.length; j++) {
			for (int k = 0; k < playableSpaces[j].length; k++) {
				playableSpaces[j][k] = expectedSpaces[i++];
			}
		}

		CheckersModel checkersModel = new CheckersModel(playableSpaces);

		assertSame(expectedSpaces[0], checkersModel.getPlayableSpaces()[0][0]);
	}

}
