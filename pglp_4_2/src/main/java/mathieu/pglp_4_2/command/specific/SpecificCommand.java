package mathieu.pglp_4_2.command.specific;

import mathieu.pglp_4_2.command.Command;

/**
 * pattern command, partie calcul.
 */
public interface SpecificCommand extends Command {
	/**
	 * appliquer la commande de calcul avec ces 2 operandes.
	 * @param operande1 opérande de gauche
	 * @param operande2 opérande de droite
	 * @return le résultat du calcul
	 * @throws Exception si le calcul échoue
	 */
	double apply(double operande1, double operande2)
			throws Exception;
}
