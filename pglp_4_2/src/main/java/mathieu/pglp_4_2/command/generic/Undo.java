package mathieu.pglp_4_2.command.generic;

import java.util.Stack;

/**
 * implémente le retour en arrière.
 */
public class Undo implements GenericCommand {
    /**
     * pile de chaque état de la pile "pile".
     */
    private Stack<Stack<Double>> undo;
    /**
     * pile contenant les opérandes.
     */
    private Stack<Double> pile;
    /**
     * constructeur de la classe.
     * @param pileOperandes donner la pile contenant les opérandes
     */
    public Undo(final Stack<Double> pileOperandes) {
        pile = pileOperandes;
        undo = new Stack<Stack<Double>>();
    }
    /**
     * enregistre l'état courant de la pile.
     */
    public void alertChange() {
        @SuppressWarnings("unchecked")
        Stack<Double> s = (Stack<Double>) pile.clone();
        undo.push(s);
    }
    /**
     * copie le contenu du dernier état dans la pile d'opérandes.
     */
    private void copyLastStack() {
        for (double d : undo.lastElement()) {
            pile.push(d);
        }
    }
    /**
     * effectue un retour en arrière.
     * Exception levé si la pile d'état est vide.
     */
    public void apply() {
        while (!pile.isEmpty()) {
            pile.pop();
        }
        //si la pile est vide une exception est automatiquement levé
        //et traité par la fonction parent
        undo.pop();
        copyLastStack();
    }
}
