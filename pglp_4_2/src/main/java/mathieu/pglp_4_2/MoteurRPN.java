package mathieu.pglp_4_2;

import java.util.Stack;

import mathieu.pglp_4_2.command.generic.Undo;
import mathieu.pglp_4_2.command.specific.Addition;
import mathieu.pglp_4_2.command.specific.Division;
import mathieu.pglp_4_2.command.specific.Multiplication;
import mathieu.pglp_4_2.command.specific.Soustraction;
import mathieu.pglp_4_2.command.specific.SpecificCommand;

/**
 * classe qui manipule la pile pour les calculs.
 */
public final class MoteurRPN extends Interpreteur {
    /**
     * pile contenant les opérandes.
     */
    private Stack<Double> pile;
    /**
     * pour notifier les changements s'il faut revenir en arrière.
     */
    private Undo undo;
    /**
     * constructeur de la classe.
     * @param pileOperandes donner la pile à manipuler
     * @param undoP donner le undo à utiliser pour le retour en arrière
     */
    private MoteurRPN(final Stack<Double> pileOperandes, final Undo undoP) {
        super();
        pile = pileOperandes;
        undo = undoP;
    }
    /**
     * ajoute un opérande à la pile et notifie undo du changement.
     * @param d opérande à ajouter
     */
    public void addOperande(final double d) {
        pile.push(d);
        undo.alertChange();
    }
    /**
     * ajoute une commande.
     * @param name clé de la commande
     * @param command la commande à insérer
     */
    public void addCommand(final String name,
            final SpecificCommand command) {
        this.commands.put(name, command);
    }
    /**
     * exécute la commande associé à la clé name.
     * @param name clé de la commande à exécuter
     * @return false si la commande n'a pu être achevée et vrai sinon
     * @throws Exception si la commande n'existe pas
     */
    public boolean executeCommand(final String name) throws Exception {
        if (commands.containsKey(name)) {
            if (pile.size() < 2) {
                System.err.println("nombre d'opérandes "
                        + "dans l'expression invalide");
                return false;
            }
            double operande2 = pile.pop();
            double operande1 = pile.pop();
            try {
                pile.push(((SpecificCommand) commands.get(name))
                .apply(operande1, operande2));
                undo.alertChange();
                return true;
            } catch (Exception e) {
                pile.push(operande1);
                pile.push(operande2);
                return false;
            }
        } else {
            //commande inconnu
            throw new Exception();
        }
    }
    /**
     * initialise un moteur.
     * @param pile la pile qui sera manipulé
     * @param u le Undo qui sera utilisé pour le retour en arrière
     * @return un moteur construit
     */
    public static MoteurRPN init(final Stack<Double> pile, final Undo u) {
        MoteurRPN m = new MoteurRPN(pile, u);
        m.addCommand("+", new Addition());
        m.addCommand("-", new Soustraction());
        m.addCommand("*", new Multiplication());
        m.addCommand("/", new Division());
        return m;
    }
}
