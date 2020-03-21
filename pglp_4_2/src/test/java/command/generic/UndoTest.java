package command.generic;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import mathieu.pglp_4_2.command.generic.Undo;

public class UndoTest {

	@Test
	public void testUndoReussi() {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		p.push(2.0);
		u.alertChange();
		p.push(2.0);
		u.alertChange();
		p.pop(); p.pop();
		u.alertChange();
		p.push(4.0);
		u.alertChange();
		u.apply();
		assertTrue(p.isEmpty());
	}
	
	@Test (expected = Exception.class)
	public void testUndoEchec() {
		Stack<Double> p = new Stack<Double>();
		Undo u = new Undo(p);
		u.apply();
		assertTrue(p.isEmpty());
	}
}
