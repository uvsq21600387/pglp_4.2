package mathieu.pglp_4_2;

public class Division implements SpecificCommand {
	public double apply(double operande1, double operande2) throws Exception {
		if(operande2 == 0) {
			System.err.println("Division par 0 non autorisée");
			throw new Exception();
		}
		return operande1 / operande2;
	}
}
