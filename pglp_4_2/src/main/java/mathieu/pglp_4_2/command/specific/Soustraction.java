package mathieu.pglp_4_2.command.specific;

/**
 * implémente la soustraction.
 */
public class Soustraction implements SpecificCommand {
    /**
     * effectue la soustraction avec ces 2 operandes.
     * @param operande1 opérande de gauche
     * @param operande2 opérande de droite
     * @return le résultat du calcul de operande1 - operande2
     */
    public double apply(final double operande1, final double operande2) {
        return operande1 - operande2;
    }
}
