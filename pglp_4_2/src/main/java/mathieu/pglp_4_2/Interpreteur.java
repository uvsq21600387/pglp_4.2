package mathieu.pglp_4_2;

import java.util.HashMap;
import java.util.Map;

import mathieu.pglp_4_2.command.generic.GenericCommand;
import mathieu.pglp_4_2.command.generic.Quit;
import mathieu.pglp_4_2.command.generic.Undo;

/**
 * interprète les commandes quit et undo.
 */
public final class Interpreteur {
	/**
	 * liste des commandes génériques.
	 */
	private Map<String, GenericCommand> commands;
	/**
	 * constructeur de la classe.
	 */
	private Interpreteur() {
		commands = new HashMap<String, GenericCommand>();
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
	 * @throws Exception si la commande n'existe pas
	 */
	public void executeCommand(final String name) throws Exception {
		if (commands.containsKey(name)) {
			try {
				commands.get(name).apply();
			} catch (Exception e) {
				System.err.println("La commande a échouée");
			}
		} else {
			throw new Exception();
		}
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
