package command.specific;

import static org.junit.Assert.*;

import org.junit.Test;

import mathieu.pglp_4_2.command.specific.Addition;

public class AdditionTest {
	@Test
	public void test() {
		Addition a = new Addition();
		assertTrue(a.apply(1.0, 1.0) == 2.0);
	}
}
