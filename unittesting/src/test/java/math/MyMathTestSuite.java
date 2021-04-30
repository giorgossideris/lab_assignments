package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	                 MyMathFactorialParameterizedTest.class,
	                 MyMathTest.class,
	                 MyMathIsPrimeParameterizedTest.class
	                })
public class MyMathTestSuite {
	// This class remains empty, it is used only as a holder for the above annotations		
}
