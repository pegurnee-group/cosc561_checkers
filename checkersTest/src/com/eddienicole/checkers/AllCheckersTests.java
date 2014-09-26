package com.eddienicole.checkers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CheckerboardViewTest.class, CheckersModelTest.class,
		ControllerTest.class, MoveTest.class, MoveFigurerOuterTest.class,
		PlayableSpaceTest.class // , HumanPlayerTest.class
})
public class AllCheckersTests {

}
