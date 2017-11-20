package de.techvikings.arithmetic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import pub.mayer.arithmetic.Arithmetic;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ArithmeticTest {

	@Parameters
	public static Object[][] parameters() {
		return new Object[][]{
				{"1+1", 2.},
				{"2.0-1", 1.},
				{"2.5*1", 2.5},
				{"1+2*3", 7.},
				{"1*2+3/4", 2.75},
				{"2*(3+4)/7", 2.},
				{"42÷2", 21.},
				{"4×4", 16.},
				{"42.", 42.},
				{"+2.", 2.},
				{"+42.0", 42.},
				{"-42.", -42.},
				{".5", .5},
				{"+.42", .42},
				{"-.4", -.4},
		};
	}

	@Parameter
	public String expression;

	@Parameter(1)
	public Double expected;

	@Test
	public void testEvaluate() {
		Arithmetic arithmetic = new Arithmetic();
		Double actual = arithmetic.evaluate(expression);
		assertEquals(expected, actual);
	}
}
