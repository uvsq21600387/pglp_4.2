package mathieu.pglp_4_2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

public class CalculatriceRPNTest {
	
	InputStream stdin = System.in;
	
	@After
	public void tearDown() throws Exception {
		System.setIn(stdin);
	}
	
	@Test
	public void testReussite() throws Exception {
		String expression = "8\n4\n15\n12\n2\n+\n-\n*\n/\nquit\n";
		System.setIn(new ByteArrayInputStream(expression.getBytes()));
		CalculatriceRPN.main(null);
	}
	
	@Test (expected = Exception.class)
	public void testEchecResultat() throws Exception {
		String expression = "8\n4\n15\n12\n2\n+\n-\n*\nquit\n";
		System.setIn(new ByteArrayInputStream(expression.getBytes()));
		CalculatriceRPN.main(null);
	}
}
