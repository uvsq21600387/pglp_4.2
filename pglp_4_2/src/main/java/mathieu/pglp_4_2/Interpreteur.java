package mathieu.pglp_4_2;

import java.util.HashMap;
import java.util.Map;

import mathieu.pglp_4_2.command.Command;
import mathieu.pglp_4_2.command.generic.GenericCommand;
import mathieu.pglp_4_2.command.generic.Quit;
import mathieu.pglp_4_2.command.generic.Undo;

/**
 * interprète les commandes quit et undo.
 */
public class Interpreteur {
    /**
     * liste des commandes génériques.
     */
    protected Map<String, Command> commands;
    /**
     * constructeur de la classe.
     */
    protected Interpreteur() {
        commands = new HashMap<String, Command>();
    }
    /**
     * ajoute une commande.
     * @param name clé de la commande
     * @param command la commande à insérer
     */
    public void addCommand(final String name,
    final GenericCommand command) {
        this.commands.put(name, command);
    }
    /**
     * exécute la commande associé à la clé name.
     * @param name clé de la commande à exécuter
     * @return execution de commande réussi
     * @throws Exception si la commande n'existe pas
     */
    public boolean executeCommand(final String name) throws Exception {
        if (commands.containsKey(name)) {
            try {
                ((GenericCommand) commands.get(name)).apply();
                return true;
            } catch (Exception e) {
                System.err.println("La commande a échouée");
            }
        } else {
            throw new Exception();
        }
        return false;
    }
    /**
     * crée un interpreteur.
     * @param u le undo à utiliser pour le retour en arrière
     * @return un interpreteur construit
     */
    public static Interpreteur init(final Undo u) {
        Interpreteur i = new Interpreteur();
        i.addCommand("undo", u);
        i.addCommand("quit", new Quit());
        return i;
    }
}
