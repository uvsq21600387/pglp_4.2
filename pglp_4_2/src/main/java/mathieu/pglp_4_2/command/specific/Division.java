package mathieu.pglp_4_2.command.specific;

/**
 * implémente la division.
 */
public class Division implements SpecificCommand {
	/**
	 * effectue la division avec ces 2 operandes.
	 * @param operande1 opérande de gauche
	 * @param operande2 opérande de droite
	 * @return le résultat du calcul
	 * @throws Exception si operande2 = 0
	 */
	public double apply(final double operande1, final double operande2)
			throws Exception {
		if (operande2 == 0) {
			System.err.println("Division par 0 non autorisée");
			throw new Exception();
		}
		return operande1 / operande2;
	}
}
