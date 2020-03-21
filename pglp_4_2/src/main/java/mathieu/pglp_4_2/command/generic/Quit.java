package mathieu.pglp_4_2.command.generic;

/**
 * implémente le message d'arrêt de l'application.
 */
public class Quit implements GenericCommand {
	/**
	 * constructeur de la classe.
	 */
	public Quit() {
	}
	/**
	 * indique que l'utilisateur a quitté.
	 */
	public void apply() {
		System.out.println("Vous avez quitté");
	}

}
