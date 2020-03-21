package command.specific;

import static org.junit.Assert.*;

import org.junit.Test;

import mathieu.pglp_4_2.command.specific.Soustraction;

public class SoustractionTest {

	@Test
	public void test() {
		Soustraction a = new Soustraction();
		assertTrue(a.apply(1.0, 1.0) == 0.0);
	}
}
