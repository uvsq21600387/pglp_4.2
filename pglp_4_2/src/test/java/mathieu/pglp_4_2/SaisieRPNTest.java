package mathieu.pglp_4_2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

public class SaisieRPNTest {

	InputStream stdin = System.in;
	
	@After
	public void tearDown() throws Exception {
		System.setIn(stdin);
	}
	
	@Test
	public void testReussite() throws Exception {
		String expression = "8\n4\n15\n12\n2\n+\n-\n*\n/\nundo\n/\nquit\n";
		System.setIn(new ByteArrayInputStream(expression.getBytes()));
		SaisieRPN s = new SaisieRPN();
		assertTrue(s.calcul() == 2.0);
	}
	
	@Test
	public void testEchecCalcul() throws Exception {
		String expression = "8\n4\n15\n12\n2\n+\n-\n*\n/\n+\nquit\n";
		System.setIn(new ByteArrayInputStream(expression.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
	}
	
	@Test (expected = Exception.class)
	public void testEchecResultat() throws Exception {
		String expression = "8\n4\n15\n12\n2\n+\n-\n*\nquit\n";
		System.setIn(new ByteArrayInputStream(expression.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
	}
}
